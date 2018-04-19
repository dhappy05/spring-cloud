package com.ding.provider.user.controller;

import com.ding.provider.user.entity.User;
import com.ding.provider.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")//本注解表示该该方法接爱一get请求
    public User findById(@PathVariable Long id){
        Optional<User> user = this.userRepository.findById(id);
        return user.get();
    }

}
