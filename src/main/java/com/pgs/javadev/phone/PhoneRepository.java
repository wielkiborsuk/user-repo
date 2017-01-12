package com.pgs.javadev.phone;

import org.springframework.data.repository.CrudRepository;

import com.pgs.javadev.model.Phone;

public interface PhoneRepository extends CrudRepository<Phone, Long> {
}
