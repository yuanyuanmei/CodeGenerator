package com.example.demo.base;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Date createTime;

    private Date updateTime;

    private Integer deleteStatus;
}
