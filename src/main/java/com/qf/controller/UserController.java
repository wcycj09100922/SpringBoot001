package com.qf.controller;

import com.qf.bean.User;
import com.qf.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    //查询
    @RequestMapping("/findAll")
    public List<User> findAll(){
        List<User> users = userService.findAll();
        System.out.println("1111111111111111111111111111");
        return users;
    }
    //添加用户
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public void addUser(User user){
        userService.addUser(user);
    }
    //根据id删除用户
    @RequestMapping(value = "/deleteUserById",method = RequestMethod.POST)
    public String deleteUserById(@RequestBody User  user){
        int id=user.getId();
        System.out.println(id);
        System.out.println(user+"..................");
        String s = userService.deleteUserById(id);

        return s;
    }
    //根据id修改用户
    @RequestMapping(value = "/updateUserById",method = RequestMethod.POST)
    public void updateUserById(@RequestBody User user){
        userService.updateUserById(user);
    }
    //根据id查询用户
    @RequestMapping(value = "findAllUserById",method = RequestMethod.POST)
    public User findAllUserById(@RequestBody User user){
        Integer id = user.getId();
        User users = userService.findByid(id);
        System.out.println(users);
        return users;
    }
    //根据name查询用户
    @RequestMapping("/login")
    public int login(@RequestBody User user){
        String name = user.getName();
        String password = user.getPassword();
        User users = userService.findByName(name);
        if (users==null){
            return 1;
        }else if (users.getName().equals(name)&&users.getPassword().equals(password)){
            return 0;
        }
        return 1;
    }
}
