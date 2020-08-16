package com.wimilee.userserver.controller;

import com.wimilee.userserver.pojo.User;
import com.wimilee.userserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lwm
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("{id}")
    public User queryUserById(@PathVariable("id")Long id){
        return this.userService.queryUserById(id);
    }
}
