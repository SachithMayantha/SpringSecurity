package com.example.security.service;

import com.example.security.entity.Employees;
import com.example.security.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("loadUserByUsername--MyUserDetailsService");
        Optional<Employees> employees = employeeRepo.findByUsername(username);

        if (employees == null)
            throw new UsernameNotFoundException("User 404");
        return employees.map(UserPrincipal::new).get();
    }


}
