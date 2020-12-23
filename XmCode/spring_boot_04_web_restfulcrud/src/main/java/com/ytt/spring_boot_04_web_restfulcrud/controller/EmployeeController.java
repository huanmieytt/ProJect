package com.ytt.spring_boot_04_web_restfulcrud.controller;

import com.ytt.spring_boot_04_web_restfulcrud.dao.EmployeeDao;
import com.ytt.spring_boot_04_web_restfulcrud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    //查询所有员工返回列表界面
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> emps = employeeDao.getAll();
        //将获取得到的信息放到请求域中
        model.addAttribute("emps",emps);

        //默认加载到 /templates/emp 路径下的list.html
        return "emp/list";
    }
}
