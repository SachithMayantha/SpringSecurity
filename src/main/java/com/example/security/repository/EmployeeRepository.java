package com.example.security.repository;

import com.example.security.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employees, Long>{
    Optional<Employees> findByUsername(String username);
}
