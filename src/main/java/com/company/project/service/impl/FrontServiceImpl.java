package com.company.project.service.impl;

import com.company.project.dao.FrontMapper;
import com.company.project.model.Front;
import com.company.project.service.FrontService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/11/26.
 */
@Service
@Transactional
public class FrontServiceImpl extends AbstractService<Front> implements FrontService {
    @Resource
    private FrontMapper frontMapper;

}
