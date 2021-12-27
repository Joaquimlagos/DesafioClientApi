package com.lagos.clientapi.repositories;

import com.lagos.clientapi.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
