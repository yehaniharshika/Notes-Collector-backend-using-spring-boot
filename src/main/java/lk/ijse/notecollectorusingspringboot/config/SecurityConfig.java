package lk.ijse.notecollectorusingspringboot.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.AuthorizeHttpRequestsDsl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    //ena hema request ekakma authenticate karanwa-check karala balanwa mehema kenekta enna puluwanda kiyala
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
       http.csrf(AbstractHttpConfigurer::disable)
               .authorizeHttpRequests()
               .anyRequest().authenticated()
               .and()
               .httpBasic();
           return http.build();
    };

    //api config karana user kenek(username,password) return karanna puluwan memagin
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        //create principle User
        UserDetails principleUser = User.withDefaultPasswordEncoder()
                .username("yehani")
                .password("1234")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(principleUser);
    }



}
