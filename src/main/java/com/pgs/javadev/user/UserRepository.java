package com.pgs.javadev.user;

import org.springframework.data.repository.CrudRepository;

import com.pgs.javadev.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
