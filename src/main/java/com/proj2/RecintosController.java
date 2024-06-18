package com.proj2;

import entity.RecintoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RecintosController {

    private final RecintosRepository recintosRepository;

    @Autowired
    public RecintosController(RecintosRepository recintosRepository) {
        this.recintosRepository = recintosRepository;
    }

    @GetMapping("/recintos")
    public String showRecintos(Model model) {
        List<RecintoEntity> recintos = recintosRepository.findAll();
        model.addAttribute("recintos", recintos);
        return "recintos";
    }
}

