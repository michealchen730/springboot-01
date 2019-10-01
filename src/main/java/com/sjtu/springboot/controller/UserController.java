package com.sjtu.springboot.controller;

import com.sjtu.springboot.mapper.UserMapper;
import com.sjtu.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id){
        return userMapper.selectByPrimaryKey(id);
    }

    @GetMapping("/user/all")
    public ModelAndView selectAll(){
        List<User> list=userMapper.selectAll();
        return new ModelAndView("showAllUser","list",list);
    }


}
