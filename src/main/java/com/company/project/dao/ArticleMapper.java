package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.Article;

import java.util.List;

public interface ArticleMapper extends Mapper<Article> {
    List<Article> getAll();
    List<Article> backList(Integer type);
    void browse(Integer id,Integer clickNum);
    Integer getPage();
    List<Article> getByTitle(String title);
}