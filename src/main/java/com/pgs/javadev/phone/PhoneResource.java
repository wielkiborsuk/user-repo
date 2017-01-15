package com.pgs.javadev.phone;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;

import org.springframework.http.HttpStatus;

import com.pgs.javadev.model.Phone;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/phone")
public class PhoneResource {

  @Autowired
  private PhoneRepository phoneRepository;

  @PostMapping
  public Phone addPhone(@RequestBody Phone phone) {
    return phoneRepository.save(phone);
  }

  @GetMapping
  public Iterable<Phone> getPhones() {
    return phoneRepository.findAll();
  }

  @GetMapping(value = "/{id}")
  public Phone getDetails(@PathVariable Long id) {
    return phoneRepository.findOne(id);
  }

  @PutMapping(value = "/{id}")
  public void updatePhone(@PathVariable Long id, @RequestBody Phone phone) {
    if (id != phone.getId()) {
      throw new IllegalStateException("Wrong id used in request and in payload.");
    }

    phoneRepository.save(phone);
  }

  @DeleteMapping(value = "/{id}")
  public void removePhone(@PathVariable Long id) {
    phoneRepository.delete(id);
  }

  @ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Bad request.")
  @ExceptionHandler(IllegalStateException.class)
  public void illegalState() {
    System.out.println("Exception handling");
  }

  @ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Phone number must be unique.")
  @ExceptionHandler(DataIntegrityViolationException.class)
  public void constraintViolation() {
    System.out.println("Exception handling");
  }
}
