package com.company.project.service.impl;

import com.company.project.dao.GoodsMapper;
import com.company.project.model.Goods;
import com.company.project.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GoodServieImpl implements GoodService {

    @Autowired
    private GoodsMapper goodsMapper;


    @Override
    public int updateGoodsUseCas(Goods goods) {
        return goodsMapper.updateGoodsUseCAS(goods);
    }
}
