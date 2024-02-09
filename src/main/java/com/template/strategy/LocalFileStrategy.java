package com.template.strategy;

import com.template.common.exception.BusinessException;
import com.template.common.resp.ResultEnum;
import com.template.dao.mapper.FileMapper;
import com.template.model.entity.FileEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Component
@Slf4j
@ConditionalOnProperty(value = "file.mode", havingValue = "local")
public class LocalFileStrategy implements FileStrategy {

    @Value("${file.local.save}")
    public String SAVE_DIR;

    @Value("${file.local.save}")
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
            String fileSaveName = uuid + "_" + originalFileName;
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
}
