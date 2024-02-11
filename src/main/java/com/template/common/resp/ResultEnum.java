package com.template.common.resp;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum ResultEnum implements BaseResult {

    SUCCESS(0, "success"),
    ERROR(4000, "fail"),
    MKDIRS_SAVEDIR_ERROR(4001, "上传文件存储路径{}构建失败"),
    MKDIRS_CACHEDIR_ERROR(4001, "下载文件缓存路径{}构建失败"),
    BATCH_DOWNLOAD_ERROR(4002, "批量下载失败");

    private int code;
    private String msg;

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }

}

