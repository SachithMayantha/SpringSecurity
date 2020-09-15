package com.example.security.service;

import com.example.security.entity.Employees;
import com.example.security.entity.UserRole;
import com.example.security.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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
        List<GrantedAuthority> authorities = new ArrayList<>();
        System.out.println("GrantedAuthority--UserPrincipal");
        UserRole role = employees.getRoleId();
        authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        System.out.println(new SimpleGrantedAuthority(role.getRoleName()));
        return authorities;
    }

    @Override
    public String getPassword()
    {
        System.out.println("User Pricipal "+employees.getPassword());
        return employees.getPassword();
    }

    @Override
    public String getUsername() {
        System.out.println("User Pricipal "+employees.getUsername());
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
