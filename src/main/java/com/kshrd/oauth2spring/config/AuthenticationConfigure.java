package com.kshrd.oauth2spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class AuthenticationConfigure extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            
                    auth.inMemoryAuthentication()
                    .withUser("user").password("{noop}user").roles("USER").and()
                    .withUser("admin").password("{noop}admin").roles("ADMIN");
    }

    @Bean
   @Override
   public AuthenticationManager authenticationManagerBean() throws Exception {
       return super.authenticationManagerBean();
   }

}