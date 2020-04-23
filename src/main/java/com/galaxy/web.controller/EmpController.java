package com.galaxy.web.controller;

import com.galaxy.entity.Emp;
import com.galaxy.service.EmpService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("map")
public class EmpController extends BaseController{

    @Resource
    private EmpService empService;

    @GetMapping("empList")
    public String queryAllById(int pageNum, Emp emp, Model model){

        List<Emp> empList = empService.queryAllById(emp, pageNum, pageSize);
        model.addAttribute("empList", empList);

        Map<String, Integer> countMap = empService.queryTotalCount(emp, pageNum, pageSize);
        model.addAttribute("countMap", countMap);
        model.addAttribute("pageNum", pageNum);
        return "emp/empList";
    }

}
