package com.example.demo.sec;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
 
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	CustomizeAuthenticationSuccessHandler customizeAuthenticationSuccessHandler;
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/","/home").permitAll()
                .antMatchers("/admin").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
            .formLogin().successHandler(customizeAuthenticationSuccessHandler)
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();
        http.exceptionHandling().accessDeniedPage("/403");
    }
 
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	
    	auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery
    	("select username as principal, password as credentials, active from users where username=?")
    	.authoritiesByUsernameQuery("select username as principal, roles as role from users_roles where username=?")
    	.rolePrefix("ROLE_");
    	
    	/*
        auth
            .inMemoryAuthentication()
                .withUser("user").password("user").roles("USER")
                .and()
        		.withUser("admin").password("admin").roles("ADMIN");
        		
        		*/
    }
}