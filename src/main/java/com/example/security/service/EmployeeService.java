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
import java.util.Optional;

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

    public Employees updateEmp(EmployeeBean employeeBean){
        Optional<Employees> employees = employeeRepository.findById(Long.parseLong(employeeBean.getId()));
        List<UserRole> userRole = userRoleRepository.findByRoleId(employeeBean.getRole_id());
        Employees employees1 = employees.get();
        employees1.setUsername(employeeBean.getUsername());
        employees1.setMobileNo(employeeBean.getMobile_no());
        employees1.setDepartment(employeeBean.getDepartment());
        try {
            employees1.setRoleId(userRole.get(0));
        }catch (Exception e){
            employees1.setRoleId(employees1.getRoleId());
        }
        System.out.println(employeeBean.getRole_id());
        return employeeRepository.save(employees1);
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
//        System.out.println(id.get);
        employeeRepository.deleteById(id);
    }
}
