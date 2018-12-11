package com.company.project.service.impl;

import com.company.project.dao.ArticleMapper;
import com.company.project.model.Article;
import com.company.project.service.ArticleService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by CodeGenerator on 2018/12/04.
 */
@Service
@Transactional
public class ArticleServiceImpl extends AbstractService<Article> implements ArticleService {
    @Resource
    private ArticleMapper articleMapper;
    @Override
    public List<Article> getAll(){return articleMapper.getAll();}
    @Override
    public List<Article> backList(Integer type){
        return articleMapper.backList(type);
    }
    @Override
    public void browse(Integer id, Integer clickNum){

         articleMapper.browse(id,clickNum);

    }
    @Override
    public Integer getPage(){
        return articleMapper.getPage();
    }
    @Override
    public List<Article> getByTitle(String title){
        return articleMapper.getByTitle(title);
    }

}
