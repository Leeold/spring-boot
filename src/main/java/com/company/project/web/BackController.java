package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.Back;
import com.company.project.service.BackService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* Created by CodeGenerator on 2018/11/26.
*/
@RestController
@RequestMapping("/api/back")
public class BackController {
    @Resource
    private BackService backService;

    @PostMapping("/add")
    public Result add(Back back) {
        backService.save(back);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        backService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Back back) {
        backService.update(back);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Back back = backService.findById(id);
        return ResultGenerator.genSuccessResult(back);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Back> list = backService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
    @GetMapping("/getAll")
    public Map<String,Object> getAll(){
        Map<String,Object> json =new HashMap<>();
        List<Back> back = backService.getAll();
        json.put("list",back);
        return json;
    }
}
