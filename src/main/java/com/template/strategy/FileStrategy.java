package com.template.strategy;

import com.template.model.entity.FileEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface FileStrategy {
    String SEP = "_";

    void batchUpload(MultipartFile[] fileArr);

    void batchDownload(List<FileEntity> fileList, HttpServletResponse resp);
}
