package com.galaxy.web.controller;

import com.galaxy.entity.TestBean;
import com.galaxy.service.TestBeanService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("testBean")
@PropertySource("classpath:db.properties")

public class TestBeanController {

    @Resource
    private TestBeanService testBeanService;

    @Value("${mybatis.pageSize}")
    int pageSize;

    @GetMapping("queryAllByPages")
    public String queryAllByPages(Model model,int current){
        List<TestBean> testBeanList = testBeanService.queryAllPages(current, pageSize);
        int totalPages = testBeanService.queryTotalPages(pageSize);
        model.addAttribute("testBeanList", testBeanList);
        model.addAttribute("current", current);
        model.addAttribute("totalPages", totalPages);
        return "list";
    }

    @GetMapping("queryById")
    public String queryById(int id, Model model){
        TestBean testBean = testBeanService.queryById(id);
        model.addAttribute("testBean", testBean);
        return "update";
    }

    @GetMapping("insertPage")
    public String insert(){
        return "insert";
    }

    @PostMapping("insert")
    public String insert(TestBean testBean){
        testBeanService.insert(testBean);
        return "redirect:queryAllByPages?current=1";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") int id){
        testBeanService.delete(id);
        return "redirect:../queryAllByPages?current=1";
    }

    @PostMapping("update")
    public String update(TestBean testBean){
        testBeanService.update(testBean);
        return "redirect:queryAllByPages?current=1";
    }

}
