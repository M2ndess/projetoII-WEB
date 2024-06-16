package com.proj2;

import entity.RecintoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RecintosService {

    private final RecintosRepository recintoRepository;

    @Autowired
    public RecintosService(RecintosRepository recintoRepository) {
        this.recintoRepository = recintoRepository;
    }

    public List<RecintoEntity> findAllRecintos() {
        return recintoRepository.findAll();
    }

    public RecintoEntity findRecintoById(Long id) {
        return recintoRepository.findById(id).orElse(null);
    }

    public RecintoEntity saveRecinto(RecintoEntity recinto) {
        return recintoRepository.save(recinto);
    }

    public void deleteRecinto(Long id) {
        recintoRepository.deleteById(id);
    }
}
