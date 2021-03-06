package com.pgs.javadev.user;

import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.pgs.javadev.exception.NotFoundException;
import com.pgs.javadev.model.User;
import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {
      return userRepository.save(user);
    }

    public Iterable<User> getAllUsers() {
      return userRepository.findAll();
    }

    public User getDetails(Long id) {
      return userRepository.findOne(id);
    }

    public User updateUser(Long id, User user) {
      user.setId(id);
      return userRepository.save(user);
    }

    public User deleteUser(Long id) {
      User deleted = userRepository.findOne(id);
      userRepository.delete(id);
      return deleted;
    }
}
