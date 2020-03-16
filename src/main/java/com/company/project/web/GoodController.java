package com.company.project.web;


import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.Goods;
import com.company.project.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GoodController {
       @Autowired GoodService goodService;
       @PostMapping(value = "/update/status")
       public Result updateStatus(){
              Goods goods = new Goods();
              goods.setId(1);
              goods.setStatus(2);
              goods.setVersion(1);
              int i = goodService.updateGoodsUseCas(goods);
              return ResultGenerator.genSuccessResult(i);
       }
}
