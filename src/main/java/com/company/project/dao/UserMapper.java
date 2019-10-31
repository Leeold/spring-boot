package com.company.project.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.company.project.model.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper extends BaseMapper<User> {

}