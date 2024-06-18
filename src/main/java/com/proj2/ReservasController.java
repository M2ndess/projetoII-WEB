package com.proj2;

import entity.RecintoEntity;
import entity.ReservaEntity;
import entity.ClienteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ReservasController {

    private final RecintosRepository recintosRepository;
    private final ReservaService reservaService;
    private final ClienteRepository clienteRepository;

    @Autowired
    public ReservasController(RecintosRepository recintosRepository, ReservaService reservaService, ClienteRepository clienteRepository) {
        this.recintosRepository = recintosRepository;
        this.reservaService = reservaService;
        this.clienteRepository = clienteRepository;
    }

    @GetMapping("/reservas")
    public String showRecintos(Model model, HttpSession session) {
        // Verifica se há um usuário logado
        String username = (String) session.getAttribute("user");
        if (username != null) {
            // Busca o cliente pelo nome de usuário
            ClienteEntity cliente = clienteRepository.findByUsername(username);
            if (cliente != null) {
                // Convertendo Integer para Long
                Long idClienteLong = cliente.getIdCliente().longValue();

                // Busca as reservas do cliente logado
                List<ReservaEntity> reservas = reservaService.findByIdCliente(idClienteLong);
                model.addAttribute("reservas", reservas);
            }
        }

        return "reservas";
    }
}