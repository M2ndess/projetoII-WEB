package com.proj2;

import entity.ReservaEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ReservaRepository extends CrudRepository<ReservaEntity, Long> {
    ReservaEntity findReservaById(Long id);

    List<ReservaEntity> findByIdCliente(Long idCliente);
}