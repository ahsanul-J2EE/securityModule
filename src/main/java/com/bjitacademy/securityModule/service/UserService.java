package com.bjitacademy.securityModule.service;

import com.bjitacademy.securityModule.model.UserRequestModel;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService {
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    ResponseEntity<Object> register(UserRequestModel requestModel);
    ResponseEntity<Object> allUseres();
}
