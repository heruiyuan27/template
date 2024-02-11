package com.template.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.template.dao.mapper.FileMapper;
import com.template.model.entity.FileEntity;
import com.template.model.req.StringIdListReq;
import com.template.service.FileService;
import com.template.strategy.FileStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


@Slf4j
@Service
public class FileServiceImpl implements FileService {

    @Resource
    private FileStrategy fileStrategy;

    @Resource
    private FileMapper fileMapper;

    @Override
    public void batchUpload(MultipartFile[] fileArr) {
        Assert.notNull(fileArr, "上传文件数组不能为空");
        fileStrategy.batchUpload(fileArr);
    }

    @Override
    public void batchDownload(StringIdListReq req, HttpServletResponse resp) {
        Assert.notNull(req, "下载文件数组不能为空");
        List<FileEntity> fileList = new ArrayList<>();
        for (String fileId : req.getIdList()) {
            FileEntity fileEntity = fileMapper.selectOne(
                    new LambdaQueryWrapper<FileEntity>().eq(FileEntity::getFileId, fileId)
            );
            fileList.add(fileEntity);
        }
        fileStrategy.batchDownload(fileList, resp);
    }
}
