package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.Front;
import com.company.project.service.FrontService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* Created by CodeGenerator on 2018/11/26.
*/
@RestController
@RequestMapping("/api/front")
public class FrontController {
    @Resource
    private FrontService frontService;

    @PostMapping("/add")
    public Result add(Front front) {
        frontService.save(front);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        frontService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Front front) {
        frontService.update(front);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Front front = frontService.findById(id);
        return ResultGenerator.genSuccessResult(front);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Front> list = frontService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
