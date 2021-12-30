package com.lagos.clientapi.repositories;

import com.lagos.clientapi.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
