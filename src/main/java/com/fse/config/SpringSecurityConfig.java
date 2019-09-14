package com.fse.config;

import com.fse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
*/

@Configuration
public class SpringSecurityConfig //extends WebSecurityConfigurerAdapter
{

    /*@Autowired
    private AccessDeniedHandler accessDeniedHandler;*/

    @Autowired
    private UserService userService;

    // roles admin allow to access /admin/**
    // roles user allow to access /user/**
    // custom 403 access denied handler
   /* @Override
    protected void configure(HttpSecurity http) throws Exception {



       *//* http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/home", "/about").permitAll()
                .antMatchers("/admin/**").hasAnyRole("ADMIN")
                .antMatchers("/user/**").hasAnyRole("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler);*//*

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/home", "/about").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll().and().exceptionHandling().accessDeniedHandler(accessDeniedHandler);
                *//*.invalidateHttpSession(true)
                .clearAuthentication(true)*//*
               // .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
               // .logoutSuccessUrl("/login?logout")
                //.permitAll();

    }*/


   /* @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService()
        auth.inMemoryAuthentication()
                .withUser("user").password("password").roles("USER")
                .and()
                .withUser("admin").password("password").roles("ADMIN");
    }*/

    /*@Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
       // auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }*/

    /*@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }*/

   /* @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }*/

}
