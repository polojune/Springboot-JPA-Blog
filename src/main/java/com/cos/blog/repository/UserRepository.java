package com.cos.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cos.blog.model.User;

//자동으로 bean으로 등록된다. 
//DAO
public interface UserRepository  extends JpaRepository<User, Integer>{
    // SELECT * FROM user WHERE username = 1?;
	Optional<User> findByUsername(String username);
}
//JPA naming 전략 
//"select * from user where username = ?1 and password = ?2" 
//User findByUsernameAndPassword(String username, String password);

// @Query (value="select * from user where username = ?1 and password = ?2" )
// User login(String username, String password);