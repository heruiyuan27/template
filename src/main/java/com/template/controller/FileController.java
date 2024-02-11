package com.template.controller;

import com.template.common.resp.CommonResponse;
import com.template.model.req.StringIdListReq;
import com.template.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
@RequestMapping("file")
public class FileController {

    @Resource
    private FileService fileService;

    @PostMapping(value = "/batchUpload")
    public CommonResponse batchUpload(MultipartFile[] fileArr) {
        fileService.batchUpload(fileArr);
        return CommonResponse.success();
    }

    @PostMapping(value = "/batchDownload")
    public CommonResponse batchDownload(@RequestBody StringIdListReq req, HttpServletResponse resp) {
        fileService.batchDownload(req, resp);
        return CommonResponse.success();
    }
}
