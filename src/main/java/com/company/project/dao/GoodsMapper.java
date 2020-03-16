package com.company.project.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.company.project.model.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface GoodsMapper extends BaseMapper<Goods> {
    int updateGoodsUseCAS(Goods goods);
}
