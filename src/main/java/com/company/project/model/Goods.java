package com.company.project.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("goods")
public class Goods implements Serializable {
    private Integer id;
    private Integer status;
    private String name;
    private Integer version;
}
