package com.ding.provider.user.controller;

import com.ding.provider.user.entity.User;
import com.ding.provider.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;

@Slf4j
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")//本注解表示该该方法接爱一get请求
    public User findById(@PathVariable Long id){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            UserDetails user = (UserDetails) principal;
            Collection<? extends GrantedAuthority> collection = user.getAuthorities();
            for (GrantedAuthority c : collection) {
                // 打印当前登录用户的信息
                log.info("当前用户是{}，角色是{}", user.getUsername(), c.getAuthority());
            }
        } else {
            // do other things
        }
        Optional<User> findOne = this.userRepository.findById(id);
        return findOne.get();
    }

}
