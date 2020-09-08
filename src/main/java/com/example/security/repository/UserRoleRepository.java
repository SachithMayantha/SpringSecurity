package com.example.security.repository;

import com.example.security.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole,String> {
    UserRole findByRoleId(String role_id);
}
