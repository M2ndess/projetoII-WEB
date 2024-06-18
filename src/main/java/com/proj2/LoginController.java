package com.proj2;

import entity.ClienteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@SessionAttributes("user")  // Add this annotation to store user in session
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
                        Model model,
                        HttpServletRequest request) {

        ClienteEntity cliente = clienteRepository.findByUsername(username);

        if (cliente != null && cliente.getPassword().equals(password)) {
            // Login bem-sucedido
            HttpSession session = request.getSession();
            session.setAttribute("user", username);
            session.setAttribute("idCliente", cliente.getIdCliente());
            return "redirect:/home"; // Redireciona para a página após o login
        } else {
            // Login falhou
            model.addAttribute("error", "Invalid username or password");
            return "login"; // Retorna para a página de login com mensagem de erro
        }
    }

    // Optional method to check if user is logged in (assuming a user attribute)
    @GetMapping("/checkLogin")
    public String checkLogin(Model model, HttpSession session) {
        if (session.getAttribute("user") != null) {
            // User is logged in, redirect to appropriate page
            return "redirect:/home";
        } else {
            // User is not logged in, redirect to login page
            return "redirect:/login";
        }
    }
}