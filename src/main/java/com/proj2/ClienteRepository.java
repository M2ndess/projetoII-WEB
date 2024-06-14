package com.proj2;

import entity.ClienteEntity;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<ClienteEntity, Long> {
    ClienteEntity findByUsername(String username);
    ClienteEntity findByEmail(String email);
}