package com.wimilee.userserver.service;

import com.wimilee.userserver.mapper.UserMapper;
import com.wimilee.userserver.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lwm
 */
@Service
public class UserService {


    @Autowired
    private UserMapper userMapper;

    public User queryUserById(Long id) {
        return this.userMapper.selectByPrimaryKey(id);
    }
}
