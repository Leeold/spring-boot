package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.Article;
import com.company.project.model.Back;

import java.util.List;

public interface ArticleMapper extends Mapper<Article> {
    List<Article> backList(Integer type);
    List<Article> frontList();
}