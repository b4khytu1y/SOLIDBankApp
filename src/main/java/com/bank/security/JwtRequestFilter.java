package com.bank.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.bank.services.CustomUserDetailsService;

public class JwtRequestFilter extends UsernamePasswordAuthenticationFilter {

    @Autowired JwtUtil jwtUtil;

    @Autowired CustomUserDetailsService userDetailsService;
}
