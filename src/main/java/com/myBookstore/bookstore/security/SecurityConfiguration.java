package com.myBookstore.bookstore.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfiguration {

    private static final String[] AUTH_ANYONE = {
            "/",
            "/books",
            "/books/genre/*",
            "/showRegistration",
            "/new/customer"
    };



    private static final String[] AUTH_CUSTOMER = {
            "/requests/new", "/requests/cancel"
    };

    private static final String[] AUTH_ADMIN = {
            "/requests/**", "books/**"
    };




    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                                configurer
                                        .requestMatchers("books/genre/all").hasAnyRole("ADMIN", "EMPLOYEE")
                                        .requestMatchers(AUTH_ANYONE).permitAll()
                                        .requestMatchers(AUTH_CUSTOMER).hasAnyRole("ADMIN", "EMPLOYEE", "CUSTOMER")
                                        .requestMatchers(AUTH_ADMIN).hasAnyRole("ADMIN", "EMPLOYEE")
                                        .anyRequest().authenticated()

                ).formLogin(form ->
                        form
                                .loginPage("/showMyLoginPage")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll()
                ).logout(logout -> logout.permitAll())
                .exceptionHandling(configurer ->
                        configurer.accessDeniedPage("/access-denied"));
        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



    // .requestMatchers("/**").permitAll()
//                        .requestMatchers("", "/", "/index.html?continue").permitAll()
//                        .requestMatchers("/books", "/books/", "/books/genre/**").permitAll()
//                        .requestMatchers("/books/all", "/books/genre/all/**", "/books/newAddPage",
//                                "/books/update", "/books/save", "/books/inventory-update").hasAnyRole("EMPLOYEE", "ADMIN")
//                        .requestMatchers("/requests/new", "/requests/cancel", "/requests/all",
//                                "/requests/approve", "/requests/status/**", "/requests/**").hasAnyRole("EMPLOYEE", "ADMIN", "CUSTOMER")
//


//                        .requestMatchers("").permitAll()
//                        .requestMatchers("/").permitAll()
//                        .requestMatchers("/books").permitAll()
//                        .requestMatchers("/books/").permitAll()
//                        .requestMatchers("/books/genre/**").permitAll()

//                        .requestMatchers("/index.html?continue").hasAnyRole("EMPLOYEE", "ADMIN", "CUSTOMER")
//
//
//
//                        .requestMatchers("/books/all").hasAnyRole("EMPLOYEE", "ADMIN")
//                        .requestMatchers("/books/genre/all/**").hasAnyRole("EMPLOYEE", "ADMIN")
//                        .requestMatchers("/books/newAddPage").hasAnyRole("EMPLOYEE", "ADMIN")
//                        .requestMatchers("/books/update").hasAnyRole("EMPLOYEE", "ADMIN")
//                        .requestMatchers("/books/save").hasAnyRole("EMPLOYEE", "ADMIN")
//                        .requestMatchers("/books/inventory-update").hasAnyRole("EMPLOYEE", "ADMIN")
//                        .requestMatchers("/requests/new").hasAnyRole("EMPLOYEE", "ADMIN", "CUSTOMER")
//                        .requestMatchers("/requests/cancel").hasAnyRole("EMPLOYEE", "ADMIN", "CUSTOMER")
//                        .requestMatchers("/requests/all").hasAnyRole("EMPLOYEE", "ADMIN")
//                        .requestMatchers("/requests/approve").hasAnyRole("EMPLOYEE", "ADMIN")
//                        .requestMatchers("/requests/status/**").hasAnyRole("EMPLOYEE", "ADMIN")
//                        .requestMatchers("/requests/**").hasAnyRole("EMPLOYEE", "ADMIN")

}
