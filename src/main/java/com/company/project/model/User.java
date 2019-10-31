package com.company.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Data
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