package com.galaxy.web.controller;

import com.galaxy.entity.Dept;
import com.galaxy.service.DeptService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("dept")
@PropertySource("classpath:db.properties")
public class DeptController {

    @Value("${mybatis.pageSize}")
    int pageSize;

    @Resource
    private DeptService deptService;

    @GetMapping("deptList")
    public String deptList(int pageNum, Model model){
        List<Dept> deptList = deptService.queryAllByPage(pageNum, pageSize);
        model.addAttribute("deptList", deptList);
        Map<String, Integer> countMap = deptService.queryTotalPage(pageSize);
        model.addAttribute("countMap",countMap);
        model.addAttribute("pageNum",pageNum);
        return "dept/deptList";

    }

    @GetMapping("insertPage")
    public String insertPage(){

        return "dept/deptInsert";
    }

    @PostMapping("insert")
    public String insert(Dept dept){

        //添加成功
        deptService.insert(dept);

        return "redirect:deptList?pageNum=1";
    }

}
