package com.example.studentmanagementbackend.Config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.*;

import com.example.studentmanagementbackend.Model.Role;
import com.example.studentmanagementbackend.Model.Role.RoleName;
import com.example.studentmanagementbackend.Repository.RoleRepository;

import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .formLogin().disable()
                .httpBasic().disable()
                .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll()
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    //  @Bean
    // public CommandLineRunner seedRoles(RoleRepository roleRepository) {
    //     return args -> {
    //         if (roleRepository.count() == 0) {
    //             Role admin = new Role();
    //             admin.setName(RoleName.ADMIN);
    //             admin.setDescription("Administrator");

    //             Role teacher = new Role();
    //             teacher.setName(RoleName.TEACHER);
    //             teacher.setDescription("Teacher");

    //             Role student = new Role();
    //             student.setName(RoleName.STUDENT);
    //             student.setDescription("Student");

    //             roleRepository.save(admin);
    //             roleRepository.save(teacher);
    //             roleRepository.save(student);

    //             System.out.println("Seeded roles: ADMIN, TEACHER, STUDENT");
    //         }
    //     };
    // }
}
