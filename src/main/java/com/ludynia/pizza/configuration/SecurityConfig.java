package com.ludynia.pizza.configuration;



import com.ludynia.pizza.model.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final BCryptPasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;









    public SecurityConfig(BCryptPasswordEncoder passwordEncoder, UserDetailsService userDetailsService) {
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
     http.authorizeRequests()
             .antMatchers("/creator","/orders")
             .access("hasRole('ROLE_USER')")
             .antMatchers("/","/**","/h2/**").access("permitAll")
             .and()
             .formLogin()
             .loginPage("/login")
             .and()
             .logout()
             .logoutSuccessUrl("/")
             .and()
             .csrf()
             .and()
             .headers()
             .frameOptions()
             .sameOrigin();
    }

    /*    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .roles("ADMIN")
                .password("{noop}password");
    }*/
}
