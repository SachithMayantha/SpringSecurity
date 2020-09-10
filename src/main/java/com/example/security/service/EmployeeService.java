package com.example.security.service;

import com.example.security.bean.EmployeeBean;
import com.example.security.entity.Employees;
import com.example.security.entity.UserRole;
import com.example.security.repository.EmployeeRepository;
import com.example.security.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    public List<Employees> getAll() {
        return employeeRepository.findAll();
    }
    public List<UserRole> getRoles(){
        return userRoleRepository.findAll();
    }
    public Employees addEmployees(EmployeeBean empBean){
        Employees emp = new Employees();
        emp.setUsername(empBean.getUsername());
        emp.setDepartment(empBean.getDepartment());
        emp.setMobileNo(empBean.getMobile_no());
//        emp.setRoleId(empBean.getRole_id());
        return employeeRepository.save(emp);
    }
}
