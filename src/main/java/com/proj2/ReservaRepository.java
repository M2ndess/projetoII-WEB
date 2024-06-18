package com.proj2;

import entity.ReservaEntity;
import org.springframework.data.repository.CrudRepository;

public interface ReservaRepository extends CrudRepository<ReservaEntity, Long> {
    ReservaEntity findReservaById(Long id);
}