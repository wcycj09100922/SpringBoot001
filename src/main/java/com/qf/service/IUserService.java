package com.qf.service;

import com.qf.bean.User;

import java.util.List;

public interface IUserService {
    //增加
    void addUser(User user);
    //根据id删除
    String deleteUserById(int id);
    //修改
    void updateUserById(User user);
    //查询
    List<User> findAll();
    //根据id查询用户
    User findByid(int id);
    //根据名字查询用户
    User findByName(String name);


}
