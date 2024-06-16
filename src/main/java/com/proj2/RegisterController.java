package com.proj2;

import entity.ClienteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterController {
    private final ClienteRepository clienteRepository;

    @Autowired
    public RegisterController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping("/registo")
    public String showRegisterForm() {
        return "registo"; // Return the registration form view
    }

    @PostMapping("/registo")
    public String register(@RequestParam("nome") String nome,
                           @RequestParam("email") String email,
                           @RequestParam("password") String password,
                           @RequestParam("nif") String nif,
                           @RequestParam("username") String username,
                           @RequestParam("contacto") String contacto, // Added contacto parameter
                           Model model) {
        // Check if username or email already exists
        ClienteEntity existingUser = clienteRepository.findByUsername(username);
        ClienteEntity existingUserEmail = clienteRepository.findByEmail(email);

        if (existingUser != null || existingUserEmail != null) {
            model.addAttribute("error", "Username or Email already exists");
            return "error"; // Show error page
        } else {
            // Create new user entity and save to repository
            ClienteEntity newUser = new ClienteEntity();
            newUser.setNome(nome);
            newUser.setEmail(email);
            newUser.setNif(nif);
            newUser.setUsername(username);
            newUser.setPassword(password);
            newUser.setTelefone(contacto); // Added setting contacto
            newUser.setEstadoConta("1"); // Assuming "1" means active account
            clienteRepository.save(newUser);

            return "redirect:/login"; // Redirect to login page after successful registration
        }
    }
}
