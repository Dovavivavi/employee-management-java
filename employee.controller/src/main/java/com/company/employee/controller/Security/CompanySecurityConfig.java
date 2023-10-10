package com.company.employee.controller.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class CompanySecurityConfig {

    @Bean
    public UserDetailsManager companyDetails(DataSource mariadb) {
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(mariadb);

        // query to get username
        userDetailsManager.setUsersByUsernameQuery(
                "SELECT user_id, password, active FROM Admins WHERE user_id=?"
        );

        // auth/role query
        userDetailsManager.setAuthoritiesByUsernameQuery(
                "SELECT user_id, role FROM Roles WHERE user_id=?"
        );

        return userDetailsManager;
    }

    @Bean
    public SecurityFilterChain adminsSecurityFilter(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers("/").hasRole("EMPLOYEE")
                        .requestMatchers("/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers("/managers/**").hasRole("MANAGER")
                        .requestMatchers("/admins/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(form ->
                        form
                                .loginPage("/loginPage")
                                .loginProcessingUrl("/authenticatingUser")
                                .permitAll()
                )
                .logout(logout -> logout.permitAll()
                )
                .exceptionHandling(configurer -> configurer.accessDeniedPage("/restricted")
                );
        return httpSecurity.build();
    }
}
