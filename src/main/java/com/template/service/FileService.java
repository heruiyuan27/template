package com.template.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    void batchUpload(MultipartFile[] fileArr);
}
