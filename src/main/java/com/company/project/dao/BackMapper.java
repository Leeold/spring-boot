package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.Back;

import java.util.List;


public interface BackMapper extends Mapper<Back> {
    List<Back> getAll();
}