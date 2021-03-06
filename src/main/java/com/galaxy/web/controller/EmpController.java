package com.galaxy.web.controller;

import com.galaxy.entity.Dept;
import com.galaxy.entity.Emp;
import com.galaxy.service.DeptService;
import com.galaxy.service.EmpService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("emp")
public class EmpController extends BaseController {

    @Resource
    private EmpService empService;

    @Resource
    private DeptService deptService;

    @GetMapping("empList")
    public String queryAllById(int pageNum, Emp emp, Model model) {

        List<Emp> empList = empService.queryAllById(emp, pageNum, pageSize);
        model.addAttribute("empList", empList);

        Map<String, Integer> countMap = empService.queryTotalCount(emp, pageNum, pageSize);
        model.addAttribute("countMap", countMap);
        model.addAttribute("pageNum", pageNum);
        return "emp/empList";
    }

    @PostMapping("delete")
    public String delete(int[] ids) {
        empService.delete(ids);
        return "redirect:empList?pageNum=1";
    }

    @GetMapping("insertPage")
    public String insertPage(Model model) {

        //将所有的部门全部查出来，回显到页面，供客户选择
        List<Dept> deptList = queryAllDept();
        model.addAttribute("deptList", deptList);
        return "emp/empInsert";
    }

    @PostMapping("insert")
    public String insert(Emp emp, Model model) {

        empService.insert(emp);
        if (emp.getId() > 0) {
            return "redirect:empList?pageNum=1";
        } else {
            model.addAttribute("errorMsg", "添加失败");
            List<Dept> deptList = queryAllDept();
            model.addAttribute("deptList", deptList);
            model.addAttribute("emp", emp);
            return "emp/empInsert";
        }
    }

    @GetMapping("queryById")
    public String queryById(int[] ids, Model model) {

        for (int id : ids) {
            Emp emp = empService.queryById(id);
            model.addAttribute("emp", emp);
            List<Dept> deptList = queryAllDept();
            model.addAttribute("deptList", deptList);
        }
        return "emp/empUpdate";
    }

    @PostMapping("update")
    public String update(Emp emp, Model model) {
        int count = empService.update(emp);
        if (count > 0) {
            return "redirect:empList?pageNum=1";
        } else {
            model.addAttribute("errorMsg","修改失败");
            Emp empUpdate = empService.queryById(emp.getId());
            model.addAttribute("emp", empUpdate);
            List<Dept> deptList = queryAllDept();
            model.addAttribute("deptList", deptList);
            return "emp/empUpdate";
        }
    }


    private List<Dept> queryAllDept() {
        //查出数据总条数
        Integer totalCount = deptService.queryTotalPage(pageSize, "").get("totalCount");
        //只要一页，吧pageSize设置和总条数相等
        return deptService.queryAllByPage(1, totalCount, "");
    }

}
