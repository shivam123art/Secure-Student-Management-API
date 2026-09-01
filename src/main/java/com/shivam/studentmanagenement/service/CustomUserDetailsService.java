package com.shivam.studentmanagenement.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.shivam.studentmanagenement.repository.AppUserRepository;
import com.shivam.studentmanagenement.model.AppUser;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = repository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("user not found"));
    return org.springframework.security.core.userdetails.User
    .withUsername(appUser.getUsername())
    .password(appUser.getPassword())
    .roles(appUser.getRole())
    .build();
    }
    @Autowired
private AppUserRepository repository;

}
