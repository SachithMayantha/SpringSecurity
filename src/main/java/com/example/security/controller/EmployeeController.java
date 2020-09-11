package com.example.security.controller;

import com.example.security.bean.EmployeeBean;
import com.example.security.bean.UserRoleBean;
import com.example.security.entity.Employees;
import com.example.security.entity.UserRole;
import com.example.security.service.EmployeeService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/list")
    public String getAll(Model model1, Model model2) {
        List<Employees> employees = employeeService.getAll();
        List<EmployeeBean> list = new ArrayList<>();
        List<UserRoleBean> list2 = new ArrayList<>();
        List<UserRole> roleList = employeeService.getRoles();

        int size1 = employees.size();
        for (int i = 0; i < size1; i++) {
            EmployeeBean employeeBean = new EmployeeBean();
            employeeBean.setId(employees.get(i).getId().toString());
            employeeBean.setUsername(employees.get(i).getUsername());
            employeeBean.setDepartment(employees.get(i).getDepartment());
            employeeBean.setMobile_no(employees.get(i).getMobileNo());

            list.add(employeeBean);
            model1.addAttribute("list", list);
        }
        int size2 = roleList.size();
        for (int j = 0; j < size2; j++) {
            UserRoleBean userRoleBean = new UserRoleBean();
            userRoleBean.setRole_id(roleList.get(j).getRoleId());
            userRoleBean.setRole_name(roleList.get(j).getRoleName());
            list2.add(userRoleBean);
            model2.addAttribute("roleList", list2);
        }
        return "listEmp";
    }

    @PostMapping("/add")
    public RedirectView addEmp(EmployeeBean empBean) {
        System.out.println("Add Employee Controller");
        employeeService.addEmployees(empBean);
        return new RedirectView("/employee/list");
    }

    @PostMapping("/update/{id}")
    public RedirectView updateEmp(@RequestParam("id") Long id) {
        System.out.println("get Employee Controller");
        return new RedirectView("/employee/list");
    }
    @GetMapping("/getEmployee")
    public @ResponseBody
    String getEmployee(@RequestParam Long id) {
        System.out.println("getEmployee method called - "+id);
        String json = "";

        try {
            if (id != null) {
                EmployeeBean emp = employeeService.getEmployees(id);

                if (emp != null) {
                    ObjectMapper objectMapper = new ObjectMapper();
                    json = objectMapper.writeValueAsString(emp);
                } else {
                    json = "Could not find data requested";
                }
            } else {
                json = "Empty user role code";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }
    @PostMapping("/delete")
    public RedirectView deleteEmp(@RequestParam String id){
        System.out.println("Employee Delete Controller");
        Long i = Long.parseLong(id);
        employeeService.deleteEmployee(i);
        return new RedirectView("/employee/list");
    }
}
