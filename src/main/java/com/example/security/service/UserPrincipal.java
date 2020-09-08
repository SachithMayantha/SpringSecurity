package com.example.security.service;

import com.example.security.entity.Employees;
import com.example.security.entity.UserRole;
import com.example.security.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserPrincipal extends Employees implements UserDetails {

    @Autowired
    UserRoleRepository userRoleRepository;

    private Employees employees;
    private UserRole userRole;

    public UserPrincipal(Employees employees) {
        super();
        System.out.println("UserPrincipal constructor -- UserPrincipal");
        this.employees = employees;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        System.out.println("GrantedAuthority--UserPrincipal");
        UserRole role = employees.getRoleId();
        return Collections.singleton(new SimpleGrantedAuthority(role.getRoleName()));
    }

    @Override
    public String getPassword() {
        return employees.getPassword();
    }

    @Override
    public String getUsername() {
        System.out.println(employees.getUsername());
        return employees.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
