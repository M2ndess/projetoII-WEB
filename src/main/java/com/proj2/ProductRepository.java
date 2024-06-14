package com.proj2;
import entity.EnchidoEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<EnchidoEntity, Long> {
}