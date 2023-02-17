package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.example.demo.dao.UserDataRepo;
import com.example.demo.model.UserData;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

	@Autowired
	UserDataRepo repo;
 

    @Bean
    public PasswordEncoder getBcryptPasswordEncoder() {

        return new BCryptPasswordEncoder();

    }

 

    
    @Bean
    public void get() {
    	
    	PasswordEncoder pe = getBcryptPasswordEncoder();
    	
    	
    	if(repo.findByuserName("Jan") == null)
    	{
        	UserData user1 = new UserData();
        	user1.setUserName("Jan");
        	user1.setPassword(pe.encode("123"));
        			

        	repo.save(user1);
    		
    	}
    	
    	
    	if(repo.findByuserName("123") == null)
    	{
        	UserData user1 = new UserData();
        	user1.setUserName("123");
        	user1.setPassword(pe.encode("123"));

        	repo.save(user1);
    		
    	}

    	
    	
    }
    

 

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {


        http.csrf()
        .disable()
        .authorizeRequests((autz) -> autz
                .requestMatchers("/main").authenticated()
        )
        .formLogin((formLogin) -> formLogin.permitAll())
        .logout().permitAll();
        return http.build();

    }

}