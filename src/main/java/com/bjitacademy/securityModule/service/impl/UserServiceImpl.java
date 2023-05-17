package com.bjitacademy.securityModule.service.impl;

import com.bjitacademy.securityModule.entity.UserEntity;
import com.bjitacademy.securityModule.model.UserRequestModel;
import com.bjitacademy.securityModule.model.UserResponseModel;
import com.bjitacademy.securityModule.repository.UserRepository;
import com.bjitacademy.securityModule.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        return null;
    }

    @Override
    public ResponseEntity<Object> register(UserRequestModel requestModel) {
        UserEntity userEntity = UserEntity.builder()
                .email(requestModel.getEmail())
                .userName(requestModel.getUserName())
                .firstName(requestModel.getFirstName())
                .lastName(requestModel.getLastName())
                .password(requestModel.getPassword())
                .build();
        UserEntity savedUserEntity = userRepository.save(userEntity);

        UserResponseModel responseModel = UserResponseModel.builder()
                .userName(requestModel.getUserName())
                .email(requestModel.getEmail())
                .firstName(requestModel.getFirstName())
                .build();

        return new ResponseEntity<>(responseModel, HttpStatus.CREATED);
    }


    @Override
    public ResponseEntity<Object> allUseres() {
        List<UserEntity> users = userRepository.findAll();


        List<UserResponseModel> responseModels = users.stream()
                .map(user -> UserResponseModel.builder()
                        .userName(user.getUserName())
                        .email(user.getEmail())
                        .firstName(user.getFirstName())
                        .build())
                .collect(Collectors.toList());

        return new ResponseEntity<>(responseModels, HttpStatus.OK);
    }

}
