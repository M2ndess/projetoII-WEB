package com.proj2;
import entity.EnchidoEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<EnchidoEntity> getAllProducts() {
        return (List<EnchidoEntity>) productRepository.findAll();
    }

    public EnchidoEntity getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
