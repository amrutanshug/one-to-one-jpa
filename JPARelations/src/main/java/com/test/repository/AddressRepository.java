package com.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
