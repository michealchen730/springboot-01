package com.sjtu.springboot.service.serviceImpl;

import com.sjtu.springboot.mapper.UserMapper;
import com.sjtu.springboot.model.User;
import com.sjtu.springboot.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    public UserServiceImpl() {
        super();
    }

    UserMapper userMapper;

    @Override
    public User getUserById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> getAllUser() {
        return userMapper.selectAll();
    }

    @Override
    public void switchAge(int inputid, int targetid) {

    }
}
