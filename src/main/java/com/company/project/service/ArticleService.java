package com.company.project.service;
import com.company.project.model.Article;
import com.company.project.core.Service;

import java.util.List;


/**
 * Created by CodeGenerator on 2018/12/04.
 */
public interface ArticleService extends Service<Article> {
    List<Article> getAll();
    List<Article> backList(Integer type);
    void browse (Integer id,Integer clickNum);
    Integer getPage();
}
