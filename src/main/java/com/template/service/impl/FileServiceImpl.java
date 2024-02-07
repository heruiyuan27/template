package com.template.service.impl;

import com.template.service.FileService;
import com.template.strategy.FileStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;


@Slf4j
@Service
public class FileServiceImpl implements FileService {

    @Resource
    private FileStrategy fileStrategy;

    @Override
    public void batchUpload(MultipartFile[] fileArr) {
        Assert.notNull(fileArr, "上传文件数组不能为空");
        fileStrategy.batchUpload(fileArr);
    }
}
