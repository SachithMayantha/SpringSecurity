package com.example.security.service;

import com.example.security.entity.Employees;
import com.example.security.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employees> getAll() {
        return employeeRepository.findAll();
    }
}
