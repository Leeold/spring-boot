package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.dao.UserMapper;
import com.company.project.model.User;
import com.company.project.service.UserService;
import com.company.project.utils.RedisTool;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
* Created by CodeGenerator on 2018/11/26.
*/
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RedisTool redisTool;
    @PostMapping("/list")
    public Result list() {
        List<User> list = userService.selectList();
        try {
            redisTool.sSet("key3","李东齐");
            Set<Object> result = redisTool.sGet("key3");
            for (Object r:result) {
                System.out.println(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultGenerator.genSuccessResult(list);
    }
}
