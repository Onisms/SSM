package com.galaxy.web.controller;

import com.galaxy.entity.Dept;
import com.galaxy.service.DeptService;
import com.sun.org.apache.xpath.internal.operations.Mod;
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
    public String deptList(int pageNum, Model model, String name){
        List<Dept> deptList = deptService.queryAllByPage(pageNum, pageSize, name);
        model.addAttribute("deptList", deptList);
        Map<String, Integer> countMap = deptService.queryTotalPage(pageSize, name);
        model.addAttribute("countMap",countMap);
        model.addAttribute("pageNum",pageNum);
        return "dept/deptList";

    }

    @GetMapping("insertPage")
    public String insertPage(){

        return "dept/deptInsert";
    }

    @PostMapping("insert")
    public String insert(Dept dept, Model model){
        deptService.insert(dept);
        if (dept.getId()>0) {
            return "redirect:deptList?pageNum=1";
        }else{
            model.addAttribute("errorMsg", "添加失败！");
            model.addAttribute("dept",dept);
            return "dept/deptInsert";
        }
    }

    @PostMapping("delete")
    public String delete(int[] ids){
        deptService.delete(ids);
        return "redirect:deptList?pageNum=1";
    }

    @GetMapping("queryById")
    public String queryById(int ids, Model model){
        Dept dept = deptService.queryById(ids);
        model.addAttribute("dept",dept);
        return "dept/deptUpdate";
    }

    @PostMapping("update")
    public String update(Dept dept, Model model){
        int count = deptService.update(dept);
        //count = 0;
        if (count > 0) {
            //修改成功
            return "redirect:deptList?pageNum=1";
        }else {
            //修改失败
            model.addAttribute("errorMsg", "修改失败！！");
            //Dept dept1 = deptService.queryById(dept.getId());
            model.addAttribute("dept", dept);
            return "dept/deptUpdate";
        }
    }

}
