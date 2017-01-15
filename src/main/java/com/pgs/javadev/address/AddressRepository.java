package com.pgs.javadev.address;

import org.springframework.data.repository.CrudRepository;

import com.pgs.javadev.model.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
