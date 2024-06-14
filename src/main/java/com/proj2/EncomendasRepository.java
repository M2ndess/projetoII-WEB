package com.proj2;


import entity.PedidoClienteEntity;
import org.springframework.data.repository.CrudRepository;

public interface EncomendasRepository extends CrudRepository<PedidoClienteEntity, Long> {
    Iterable<PedidoClienteEntity> findAllByIdCliente(int id_cliente);
}