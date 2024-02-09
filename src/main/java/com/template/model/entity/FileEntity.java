package com.template.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author hry
 * @since 2024-02-09 10:18:08
 */
@Getter
@Setter
@Builder
@TableName("file")
@Schema(name = "File", description = "")
public class FileEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("file_id")
    private String fileId;

    @TableField("file_name")
    private String fileName;

    @TableField("file_size")
    private Long fileSize;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;
}
