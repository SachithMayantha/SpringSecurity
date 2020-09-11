package com.example.security.service;

import com.example.security.bean.EmployeeBean;
import com.example.security.entity.Employees;
import com.example.security.entity.UserRole;
import com.example.security.repository.EmployeeRepository;
import com.example.security.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }


    public List<Employees> getAll() {
        return employeeRepository.findAll();
    }

    public List<UserRole> getRoles() {
        return userRoleRepository.findAll();
    }

    public Employees addEmployees(EmployeeBean empBean) {
        UserRole roleid = userRoleRepository.getOne(empBean.getRole_id());
        System.out.println("Add Employee Service");
        Employees emp = new Employees();
        emp.setUsername(empBean.getUsername().trim());
        emp.setDepartment(empBean.getDepartment());
        if (!empBean.getMobile_no().isEmpty()) {
            emp.setMobileNo(empBean.getMobile_no());
        } else {
            emp.setMobileNo("---");
        }
        emp.setPassword(encoder().encode(empBean.getPassword()));
        emp.setRoleId(roleid);
        return employeeRepository.save(emp);
    }

    public EmployeeBean getEmployees(Long id) {
        System.out.println("get Employee Service");
        Employees employees = employeeRepository.findById(id).get();
        EmployeeBean obj = new EmployeeBean();
        UserRole ob = employees.getRoleId();

        obj.setId(employees.getId().toString());
        obj.setUsername(employees.getUsername());
        obj.setDepartment(employees.getDepartment());
        obj.setMobile_no(employees.getMobileNo());
        obj.setRole_id(ob.getRoleName());
        return obj;
    }

    public void deleteEmployee(Long id) {
        System.out.println("Employee Delete Service");
        employeeRepository.deleteById(id);
    }
}
