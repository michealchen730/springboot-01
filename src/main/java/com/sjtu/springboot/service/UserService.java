package com.sjtu.springboot.service;

import com.sjtu.springboot.model.User;

import java.util.List;

public interface UserService {
    public User getUserById(int id);

    public List<User> getAllUser();

    public void switchAge(int inputid,int targetid);
}
