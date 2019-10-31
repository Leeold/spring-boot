package com.company.project.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@TableName("user")//@TableName中的值对应着表名
@AllArgsConstructor
public class User {
    public static final Long serialVersionUID = 1L;
    private Integer id;

    private String name;

    private String age;

    private String address;

    private String created_time;

    private String updated_time;
}