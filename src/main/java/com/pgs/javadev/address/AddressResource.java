package com.pgs.javadev.address;

import com.pgs.javadev.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressResource {

  @Autowired
  private AddressRepository addressRepository;

  @PostMapping
  public Address addAddress(@RequestBody Address address) {
    return addressRepository.save(address);
  }

  @GetMapping
  public Iterable<Address> getAddresses() {
    return addressRepository.findAll();
  }

  @GetMapping(value = "/{id}")
  public Address getDetails(@PathVariable Long id) {
    return addressRepository.findOne(id);
  }

  @PutMapping(value = "/{id}")
  public void updateAddress(@PathVariable Long id, @RequestBody Address address) {
    if (id != address.getId()) {
      throw new IllegalStateException("Wrong id used in request and in payload.");
    }

    addressRepository.save(address);
  }

  @DeleteMapping(value = "/{id}")
  public void removeAddress(@PathVariable Long id) {
    addressRepository.delete(id);
  }

  @ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Bad request.")
  @ExceptionHandler(IllegalStateException.class)
  public void illegalState() {
    System.out.println("Exception handling");
  }
}
