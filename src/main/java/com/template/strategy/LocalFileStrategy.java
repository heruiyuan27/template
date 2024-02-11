package com.template.strategy;

import com.template.common.exception.BusinessException;
import com.template.common.resp.ResultEnum;
import com.template.common.utils.ZipUtil;
import com.template.dao.mapper.FileMapper;
import com.template.model.entity.FileEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Component
@Slf4j
@ConditionalOnProperty(value = "file.mode", havingValue = "local")
public class LocalFileStrategy implements FileStrategy {

    @Value("${file.local.save}")
    public String SAVE_DIR;

    @Value("${file.local.cache}")
    public String CACHE_DIR;

    @Resource
    private FileMapper fileMapper;

    @Override
    public void batchUpload(MultipartFile[] fileArr) {
        File saveDir = new File(SAVE_DIR);
        if (!saveDir.exists()) {
            boolean mkdirsSuccess = saveDir.mkdirs();
            if (!mkdirsSuccess) {
                log.error("文件存储路径{}构建失败", SAVE_DIR);
                throw new BusinessException(ResultEnum.MKDIRS_SAVEDIR_ERROR, SAVE_DIR);
            }
        }

        for (MultipartFile file : fileArr) {
            UUID uuid = UUID.randomUUID();
            String originalFileName = file.getOriginalFilename();
            String fileSaveName = uuid + SEP + originalFileName;
            File targetFile = new File(SAVE_DIR + File.separator + fileSaveName);
            try {
                file.transferTo(targetFile);
                fileMapper.insert(FileEntity.builder()
                        .fileId(uuid.toString())
                        .fileName(originalFileName)
                        .fileSize(file.getSize())
                        .build());
                log.info("保存文件{}到{}成功", fileSaveName, SAVE_DIR);
            } catch (IOException e) {
                log.error("保存文件{}到{}失败", fileSaveName, SAVE_DIR);
            }
        }
    }

    @Override
    public void batchDownload(List<FileEntity> fileList, HttpServletResponse resp) {
        // 指定时间戳文件夹和压缩文件名
        long timestamp = new Date().getTime();
        String srcFolder = CACHE_DIR + File.separator + timestamp;
        File srcFolderFile = new File(srcFolder);
        String targetZip = CACHE_DIR + File.separator + timestamp + ".zip";
        File targetZipFile = new File(targetZip);
        if (!srcFolderFile.mkdirs()) {
            log.error("下载文件缓存路径{}构建失败", CACHE_DIR);
            throw new BusinessException(ResultEnum.MKDIRS_CACHEDIR_ERROR, CACHE_DIR);
        }

        try {
            // 将文件复制到时间戳文件夹
            List<String> filePathList = new ArrayList<>();
            for (FileEntity file : fileList) {
                String saveName = file.getFileId() + SEP + file.getFileName();
                String savePath = SAVE_DIR + File.separator + saveName;
                filePathList.add(savePath);
                try (InputStream is = Files.newInputStream(Paths.get(savePath));
                     OutputStream os = Files.newOutputStream(Paths.get(srcFolder + File.separator + saveName))) {
                    IOUtils.copy(is, os);
                    os.flush();
                }
            }
            // 压缩文件
            ZipUtil.zipFiles(filePathList, targetZip);
            // http输出
            try (InputStream is = Files.newInputStream(Paths.get(targetZip));
                 OutputStream os = resp.getOutputStream()) {
                resp.setHeader("Content-Disposition", "attachment;filename=" + timestamp + ".zip");
                IOUtils.copy(is, os);
                os.flush();
            }
        } catch (IOException e) {
            log.error("下载失败");
            throw new BusinessException(ResultEnum.BATCH_DOWNLOAD_ERROR);
        } finally {
            try {
                FileUtils.forceDelete(srcFolderFile);
                FileUtils.forceDelete(targetZipFile);
            } catch (IOException e) {
                log.error("清理失败");
            }
        }
    }
}
