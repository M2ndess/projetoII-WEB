package com.proj2;

import entity.PagamentoEntity;
import entity.ReservaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;

    @Autowired
    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public List<ReservaEntity> findByIdCliente(Long idCliente) {
        // Busca as reservas do cliente pelo idCliente
        List<ReservaEntity> reservas = reservaRepository.findByIdCliente(idCliente);
        return reservas;
    }

    public ReservaEntity findReservaById(Long id) {
        Optional<ReservaEntity> optionalReserva = reservaRepository.findById(id);
        if (optionalReserva.isPresent()) {
            return optionalReserva.get();
        } else {
            throw new RuntimeException("Reserva não encontrada para o ID: " + id);
        }
    }

    public ReservaEntity saveReserva(ReservaEntity reserva) {
        // Implemente validações ou lógica adicional antes de salvar
        return reservaRepository.save(reserva);
    }
}
