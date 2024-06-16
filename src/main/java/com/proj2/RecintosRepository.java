package com.proj2;

import entity.ClienteEntity;
import entity.RecintoEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface RecintosRepository extends CrudRepository<RecintoEntity, Long> {

    // Método para listar todos os recintos
    List<RecintoEntity> findAll();
    RecintoEntity findByNome(String nome);
}
