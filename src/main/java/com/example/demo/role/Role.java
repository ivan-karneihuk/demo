package com.example.demo.role;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority 
{
    USER, ADMIN, MODER;

    @Override
    public String getAuthority() 
    {
        return name();
    }
}
