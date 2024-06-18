package com.proj2;

import entity.RecintoEntity;
import entity.ReservaEntity;
import entity.ClienteEntity;
import entity.PagamentoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Optional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Instant;
import java.time.ZoneId;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ReservaController {

    private final RecintosRepository recintosRepository;
    private final PagamentoService pagamentoService;
    private final ReservaService reservaService; // Injetando o serviço de reserva

    @Autowired
    public ReservaController(RecintosRepository recintosRepository, PagamentoService pagamentoService, ReservaService reservaService) {
        this.recintosRepository = recintosRepository;
        this.pagamentoService = pagamentoService;
        this.reservaService = reservaService;
    }

    @RequestMapping("/reserva")
    public String showRegisterForm(@RequestParam("id") Long recintoId, Model model) {
        Optional<RecintoEntity> recintoOptional = recintosRepository.findById(recintoId);

        if (recintoOptional.isPresent()) {
            RecintoEntity recinto = recintoOptional.get();
            model.addAttribute("recinto", recinto);
        } else {
            return "error"; // Example: return "error" if recintoId is not found
        }

        return "reserva"; // Retorna a visualização do formulário de reserva com o recinto encontrado
    }

    @PostMapping("/reserva")
    public String registerReserva(@RequestParam("id") Long recintoId,
                                  @RequestParam("data") LocalDate data,
                                  @RequestParam("hora_inicio") LocalTime horaInicio,
                                  @RequestParam("hora_fim") LocalTime horaFim,
                                  @RequestParam("metodo_pagamento") String metodoPagamento,
                                  Model model,
                                  HttpSession session) {

        // Obtém o idCliente da sessão
        Integer idCliente = (Integer) session.getAttribute("idCliente");
        if (idCliente == null) {
            // Se idCliente não está na sessão, talvez você queira redirecionar para o login
            return "redirect:/login";
        }

        // Busca o recinto pelo ID
        Optional<RecintoEntity> recintoOptional = recintosRepository.findById(recintoId);

        if (recintoOptional.isEmpty()) {
            return "error"; // Example: return "error" if recintoId is not found
        }

        RecintoEntity recinto = recintoOptional.get();

        // Converter LocalDate e LocalTime para Instant
        Instant instantData = data.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        Instant instantHoraInicio = horaInicio.atDate(data).atZone(ZoneId.systemDefault()).toInstant();
        Instant instantHoraFim = horaFim.atDate(data).atZone(ZoneId.systemDefault()).toInstant();

        // Calcular a duração da reserva em horas
        long duracaoEmHoras = horaInicio.until(horaFim, java.time.temporal.ChronoUnit.HOURS);

        // Calcular o preço da reserva
        BigDecimal precoTotal = recinto.getPrecoHora().multiply(BigDecimal.valueOf(duracaoEmHoras));

        // Criar entidade de pagamento
        PagamentoEntity pagamento = new PagamentoEntity();
        pagamento.setValorTotal(precoTotal);
        pagamento.setMetodoPagamento(metodoPagamento);

        // Salvar o pagamento e obter o ID
        pagamentoService.savePagamento(pagamento);
        Long idPagamento = pagamento.getId();

        // Adicionar ao model para a página de confirmação
        model.addAttribute("recinto", recinto);
        model.addAttribute("data", instantData);
        model.addAttribute("horaInicio", instantHoraInicio);
        model.addAttribute("horaFim", instantHoraFim);
        model.addAttribute("precoTotal", precoTotal);

        // Criar e salvar a entidade de reserva
        ReservaEntity reserva = new ReservaEntity();
        reserva.setIdRecinto(recinto.getId().intValue()); // Convertendo Long para Integer
        reserva.setDataReserva(instantData);
        reserva.setHoraInicio(instantHoraInicio);
        reserva.setHoraFim(instantHoraFim);
        reserva.setIdCliente(idCliente);
        reserva.setIdPagamento(idPagamento); // Configura o ID do pagamento na reserva

        reserva.setEstadoReserva("Confirmada");

        reservaService.saveReserva(reserva);

        // Adicionar atributo de sucesso para exibir o pop-up
        model.addAttribute("reservaRegistada", true);

        // Retornar para a página reserva
        return "/reservas";
    }
}
