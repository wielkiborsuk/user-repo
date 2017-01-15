package com.pgs.javadev.user;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.DataIntegrityViolationException;

import org.springframework.http.HttpStatus;

import com.pgs.javadev.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserEndpoint {

  @Autowired
  private UserService userService;

  @PostMapping
  public User addUser(@Valid @RequestBody User user) {
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
  public User updateUser(@PathVariable Long id, @Valid @RequestBody User user) {
    if (id != user.getId()) {
      throw new IllegalStateException("Wrong id used in request and in payload.");
    }

    return userService.updateUser(id, user);
  }

  @DeleteMapping(value = "/{id}")
  public User removeUser(@PathVariable Long id) {
    return userService.deleteUser(id);
  }

  @ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Bad request.")
  @ExceptionHandler(IllegalStateException.class)
  public void illegalState() {
    System.out.println("Exception handling");
  }

  // to można ulepszać na różne sposoby - sprawdzając która kolumna spowodowała błąd można dać użytkownikowi więcej informacji.
  @ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Unique constraint violation")
  @ExceptionHandler(DataIntegrityViolationException.class)
  public void constraintViolation() {
    System.out.println("Exception handling");
  }
}
