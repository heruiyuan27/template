package com.template.service;

import com.template.model.req.StringIdListReq;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

public interface FileService {

    void batchUpload(MultipartFile[] fileArr);

    void batchDownload(StringIdListReq req, HttpServletResponse resp);
}
