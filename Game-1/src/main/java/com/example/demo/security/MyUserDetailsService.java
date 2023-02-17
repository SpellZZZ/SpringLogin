package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDataRepo;
import com.example.demo.model.UserData;

@Service
public class MyUserDetailsService implements UserDetailsService{

    @Autowired
    private UserDataRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserData user = userRepo.findByuserName(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new MyUserPrincipal(user);
    }
    
    
    


    
    
    
    
    
    
    
	
	
}
