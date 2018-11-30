package com.company.project.service.impl;

import com.company.project.dao.BackMapper;
import com.company.project.model.Back;
import com.company.project.service.BackService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by CodeGenerator on 2018/11/26.
 */
@Service
@Transactional
public class BackServiceImpl extends AbstractService<Back> implements BackService {
    @Resource
    private BackMapper backMapper;

    @Override
    public List<Back> getAll(){
        return backMapper.getAll();
    }



}
