package com.qf.service.impl;

import com.qf.Repository.UserRepository;
import com.qf.bean.User;
import com.qf.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public String deleteUserById(int id) {
       try {
           userRepository.deleteById(id);
           return "success";
       }catch (Exception e){
           System.out.println(e.getMessage());
       }
       return "fail";
    }

    @Override
    public void updateUserById(User user) {
        userRepository.saveAndFlush(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByid(int id) {
        User userById = userRepository.findByid(id);
        return userById;
    }

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name);
    }
}
