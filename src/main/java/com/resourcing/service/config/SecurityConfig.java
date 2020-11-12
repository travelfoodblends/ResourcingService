package com.resourcing.service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// Create 2 users for demo
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}p@ssw0rd4Us3r").roles("USER")
                .and()
                .withUser("admin").password("{noop}p@ssw0rd4@dm1n").roles("ADMIN");

    }

    // Secure the endpoints with HTTP Basic authentication
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                //HTTP Basic authentication
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/resourcingService/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/resourcingService/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/resourcingService/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/resourcingService/**").hasRole("ADMIN")
                .and()
                .csrf().disable()
                .formLogin().disable();
    }

}
