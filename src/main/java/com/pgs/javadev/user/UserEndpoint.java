package com.pgs.javadev.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import com.pgs.javadev.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserEndpoint {

    @Autowired
    private UserService userService;

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping
    public Iterable<User> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/{id}")
    public User getDetails(@PathVariable Long id) {
        return userService.getDetails(id);
    }

    @PutMapping(value = "/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping(value = "/{id}")
    public User updateUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }

    @RequestMapping(value = "/hit", method = RequestMethod.GET)
    public User hitMeBabyOneMoreTime() {
        throw new IllegalStateException("Hit me baby one more time");
    }

    @ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="You cannot hit people")
    @ExceptionHandler(IllegalStateException.class)
    public void illegalState() {
        System.out.println("Exception handling");
    }

}
