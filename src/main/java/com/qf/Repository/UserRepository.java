package com.qf.Repository;


import com.qf.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByid(int id);
    User findByName(String name);
}
