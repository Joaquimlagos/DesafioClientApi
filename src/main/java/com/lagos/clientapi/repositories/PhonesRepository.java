package com.lagos.clientapi.repositories;

import com.lagos.clientapi.entities.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhonesRepository extends JpaRepository<Phone,Long> {
}
