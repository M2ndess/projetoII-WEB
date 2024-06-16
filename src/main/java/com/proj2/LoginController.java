package com.proj2;

import entity.ClienteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final ClienteRepository clienteRepository;

    @Autowired
    public LoginController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // Supondo que você tenha uma view chamada "login"
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model) {

        ClienteEntity cliente = clienteRepository.findByUsername(username);
        System.out.println("teste");

        if (cliente != null && cliente.getPassword().equals(password)) {
            // Login bem-sucedido
            model.addAttribute("username", username);
            return "redirect:/home"; // Redireciona para a página após o login
        } else {
            // Login falhou
            model.addAttribute("error", "Invalid username or password");
            return "login"; // Retorna para a página de login com mensagem de erro
        }
    }
}
