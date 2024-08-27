package com.bank.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import com.bank.security.JwtRequestFilter;
import com.bank.services.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    private CustomUserDetailsService userDetailsService;

//     @Override
//     protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//         auth.userDetailsService(userDetailsService);
//     }

//     @Override
//     protected void configure(HttpSecurity http) throws Exception {
//         http.csrf().disable()
//             .authorizeRequests()
//             .antMatchers("/api/auth/**").permitAll()
//             .anyRequest().authenticated()
//             .and()
//             .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
//     }
// }

    public JwtRequestFilter getJwtRequestFilter() {
        return jwtRequestFilter;
    }

    public void setJwtRequestFilter(JwtRequestFilter jwtRequestFilter) {
        this.jwtRequestFilter = jwtRequestFilter;
    }

    public CustomUserDetailsService getUserDetailsService() {
        return userDetailsService;
    }

    public void setUserDetailsService(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
}