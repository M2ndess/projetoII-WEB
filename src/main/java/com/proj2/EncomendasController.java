package com.proj2;
import entity.EnchidoEntity;
import entity.PedidoClienteEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class EncomendasController {
    private final EncomendasRepository EncomendasRepository;

    public EncomendasController(EncomendasRepository EncomendasRepository) {
        this.EncomendasRepository = EncomendasRepository;
    }

    @GetMapping("/encomendasList")
    public String encomendasList(Model model) {
        List<PedidoClienteEntity> encomendas = (List<PedidoClienteEntity>) EncomendasRepository.findAllByIdCliente(LoginController.loggedClientID);
        model.addAttribute("encomendas", encomendas);
        return "encomendasList";
    }
    @GetMapping("/encomenda/{id}")
    public String productDetails(@PathVariable("id") Long id, Model model) {
        System.out.println(id);
        PedidoClienteEntity encomenda = EncomendasRepository.findById(id).orElse(null);
        model.addAttribute("encomenda", encomenda);
        return "encomendasDetails";
    }
}
