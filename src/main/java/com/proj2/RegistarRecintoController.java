package com.proj2;

import entity.RecintoEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
public class RegistarRecintoController {

    private final RecintosRepository recintosRepository;

    public RegistarRecintoController(RecintosRepository recintosRepository) {
        this.recintosRepository = recintosRepository;
    }

    @RequestMapping("/registoRecinto")
    public String showRegisterForm() {
        return "registar_recinto2"; // Retorna a visualização do formulário de registo
    }

    @PostMapping("/registoRecinto")
    public String registerRecinto(@RequestParam("nome") String nome,
                                  @RequestParam("morada") String morada,
                                  @RequestParam("horario") String horario_funcionamento,
                                  @RequestParam("info_extra") String infoExtra,
                                  @RequestParam("preco") BigDecimal precoHora,
                                  Model model) {

        // Verifica se já existe um recinto com o mesmo nome
        RecintoEntity existingRecinto = recintosRepository.findByNome(nome);

        if (existingRecinto != null) {
            model.addAttribute("error", "Recinto já existe");
            return "error"; // Mostra a página de erro
        } else {
            // Cria uma nova entidade de recinto e salva no repositório
            RecintoEntity newRecinto = new RecintoEntity();
            newRecinto.setNome(nome);
            newRecinto.setMorada(morada);
            newRecinto.setHorarioFuncionamento(horario_funcionamento);
            newRecinto.setInfoExtra(infoExtra);
            newRecinto.setPrecoHora(precoHora);

            recintosRepository.save(newRecinto);

            return "redirect:/recintos";
        }
    }
}
