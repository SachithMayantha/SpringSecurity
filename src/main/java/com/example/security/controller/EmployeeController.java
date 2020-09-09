package com.example.security.controller;

import com.example.security.bean.EmployeeBean;
import com.example.security.entity.Employees;
import com.example.security.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/list")
    public String getAll(Model model) {
        List<Employees> employees = employeeService.getAll();
        List<EmployeeBean> list = new ArrayList<>();

        int size = employees.size();
        for (int i = 0; i < size; i++) {
            EmployeeBean employeeBean = new EmployeeBean();
            employeeBean.setId(employees.get(i).getId().toString());
            employeeBean.setUsername(employees.get(i).getUsername());
            employeeBean.setDepartment(employees.get(i).getDepartment());
            employeeBean.setMobile_no(employees.get(i).getMobileNo());
            System.out.println(employeeBean);
            list.add(employeeBean);
            model.addAttribute("list", list);
        }
        return "listEmp";
    }
}
