package com.template.strategy;

import org.springframework.web.multipart.MultipartFile;

public interface FileStrategy {

    void batchUpload(MultipartFile[] fileArr);
}
