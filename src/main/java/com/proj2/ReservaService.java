package com.proj2;

import entity.PagamentoEntity;
import entity.ReservaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;

    @Autowired
    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public ReservaEntity findReservaById(Long id) {
        Optional<ReservaEntity> optionalReserva = reservaRepository.findById(id);
        // Verifica se a reserva foi encontrada
        if (optionalReserva.isPresent()) {
            return optionalReserva.get(); // Retorna a reserva encontrada
        } else {
            // Você pode optar por lançar uma exceção ou retornar null, dependendo da lógica do seu aplicativo
            throw new RuntimeException("Reserva não encontrada para o ID: " + id);
            // ou return null; // Retorna null se a reserva não for encontrada
        }
    }

    public ReservaEntity saveReserva(ReservaEntity reserva) {
        // Implemente validações ou lógica adicional antes de salvar
        return reservaRepository.save(reserva);
    }
}
