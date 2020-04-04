package com.hrp.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author hrp
 * 2020/3/20 16:59
 */
@Data
@TableName("log")
public class Log implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Date visitTime;
    private String username;
    private String ip;
    private String uri;
    private String method;
    private Long executionTime;
    private String exceptionName;
    private String exceptionMessage;
}
