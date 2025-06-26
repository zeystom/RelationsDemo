package com.example.demo.config;

import com.example.demo.entity.Credentials;
import com.example.demo.repositories.CredentialsRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@EnableWebSecurity
@Configuration
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(CredentialsRepository credentialsRepository){
        return username ->{
            Credentials credentials= credentialsRepository.findByUserName(username)
                    .orElseThrow(() -> new UsernameNotFoundException(username));
            return User.builder().username(username).password(credentials.getPassword()).roles(credentials.getRole().getName()
                    .replace("Role_", "")).build();
        };
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
     httpSecurity.csrf(AbstractHttpConfigurer::disable)
             .authorizeRequests(auth -> auth
                     .requestMatchers("/auth/register", "/v3/api/docs/**","swagger-ui/**")
                     .permitAll()
                     .requestMatchers("/user/**")
                     .hasRole("USER")).httpBasic(Customizer.withDefaults()).formLogin(Customizer.withDefaults());
     return httpSecurity.build();
    }
}
