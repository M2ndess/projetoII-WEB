package com.proj2;
import entity.PedidoItemEntity;
import org.springframework.data.repository.CrudRepository;

public interface PedidoItemRepository extends CrudRepository<PedidoItemEntity, Long> {
}