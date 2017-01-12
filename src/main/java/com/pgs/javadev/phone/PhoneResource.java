package com.pgs.javadev.phone;

import java.util.List;

import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;

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
    phoneRepository.save(phone);
  }

  @DeleteMapping(value = "/{id}")
  public void removePhone(@PathVariable Long id) {
    phoneRepository.delete(id);
  }
}
