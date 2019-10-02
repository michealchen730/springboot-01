package com.sjtu.springboot.service.serviceImpl;

import com.sjtu.springboot.mapper.UserMapper;
import com.sjtu.springboot.model.User;
import com.sjtu.springboot.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    public UserServiceImpl() {
        super();
    }

    @Resource
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
    @Transactional
    public void switchAge(int inputid, int targetid) {
        User user_1=userMapper.selectByPrimaryKey(inputid);
        int age_1=user_1.getAge();
        User user_2=userMapper.selectByPrimaryKey(targetid);
        int age_2=user_2.getAge();
        user_1.setAge(age_2);
        user_2.setAge(age_1);
        userMapper.updateByPrimaryKey(user_1);
        userMapper.updateByPrimaryKey(user_2);
    }
}
