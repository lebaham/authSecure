package com.authentification.spring.angular.auth.angular.security.services;

import com.authentification.spring.angular.auth.angular.model.User;
import com.authentification.spring.angular.auth.angular.repository.UserRepository;
import com.sun.security.auth.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(
                ()  -> new UsernameNotFoundException("User Not Found with -> username or email : "+ username)
        );

        return UserPrinciple.build(user);

    }
}
