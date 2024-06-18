package com.proj2;

import entity.PagamentoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PagamentoService {

    private final PagamentoRepository pagamentoRepository;

    @Autowired
    public PagamentoService(PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    public PagamentoEntity findPagamentoById(Long id) {
        Optional<PagamentoEntity> optionalPagamento = pagamentoRepository.findById(id);
        // Verifica se o pagamento foi encontrado
        if (optionalPagamento.isPresent()) {
            return optionalPagamento.get(); // Retorna o pagamento encontrado
        } else {
            // Você pode optar por lançar uma exceção ou retornar null, dependendo da lógica do seu aplicativo
            throw new RuntimeException("Pagamento não encontrado para o ID: " + id);
            // ou return null; // Retorna null se o pagamento não for encontrado
        }
    }

    public PagamentoEntity savePagamento(PagamentoEntity pagamento) {
        // Implemente validações ou lógica adicional antes de salvar
        return pagamentoRepository.save(pagamento);
    }

    // Outros métodos do serviço relacionados aos pagamentos...
}
