package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.Article;
import com.company.project.service.ArticleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* Created by CodeGenerator on 2018/12/04.
*/
@RestController
@RequestMapping("/api/article")
public class ArticleController {
    @Resource
    private ArticleService articleService;

    @PostMapping("/add")
    public Result add(Article article) {
        articleService.save(article);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        articleService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Article article) {
        articleService.update(article);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Article article = articleService.findById(id);
        return ResultGenerator.genSuccessResult(article);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "5") Integer size) {
        PageHelper.startPage(page, size);
        List<Article> list = articleService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 请求所有文章列表接口
     * @param page
     * @param size
     * @return
     */
    @PostMapping("/getAll")
    public Result getAll(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "6") Integer size){

        PageHelper.startPage(page, size);
        List<Article> list = articleService.getAll();
        PageInfo pageInfo = new PageInfo(list);
//        Map<String,Object> json =new HashMap<>();
//        Integer count = articleService.getPage();
//        json.put("list",list);
//        json.put("totalSize",count);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
    @PostMapping("/back/list")
    public Result backList(@RequestParam Integer type,@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "6") Integer size){
        PageHelper.startPage(page, size);
        List<Article> back = articleService.backList(type);
        PageInfo pageInfo = new PageInfo(back);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 统计浏览次数接口
     * @param id
     * @param clickNum
     * @return
     */
    @PostMapping("/browse")
    public Result browse(@RequestParam() Integer id, @RequestParam(defaultValue = "0") Integer clickNum){
        clickNum++;
        articleService.browse(id,clickNum);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 通过标题搜索接口
     * @param title
     * @return
     */
    @PostMapping("/getByTitle")
    public Result getByTitle(@RequestParam("title") String title){
        List<Article> list = articleService.getByTitle(title);
        return ResultGenerator.genSuccessResult(list);
    }
}
