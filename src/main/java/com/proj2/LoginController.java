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
    private final ClienteRepository ClienteRepository;
    private String loggedClient;
    public static Integer loggedClientID;

    @Autowired
    public LoginController(ClienteRepository clienteRepository) {
        this.ClienteRepository = clienteRepository;
    }

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }
    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model) {
        ClienteEntity cliente = ClienteRepository.findByUsername(username);
        if (cliente != null && cliente.getPassword().equals(password)) {
            loggedClient= cliente.getUsername();
            loggedClientID=cliente.getIdCliente();
            return "redirect:/indexLogged";
        } else {
            // Login failed
            model.addAttribute("error", "Invalid username or password");
            return "error";
        }
    }



    @GetMapping("/settings")
    public String showSettingsForm() {
        return "settings";
    }

    @PostMapping("/settings")
    public String settings(@RequestParam("nome") String nome,
                           @RequestParam("contacto") String contacto,
                           @RequestParam("morada") String morada,
                           @RequestParam("email") String email,
                           @RequestParam("nif") String nif,
                           @RequestParam("username") String username,
                           @RequestParam("password") String password,
                           Model model) {
        ClienteEntity existingUser = ClienteRepository.findByUsername(username);
        ClienteEntity existingUserEmail = ClienteRepository.findByEmail(email);
        if (existingUser != null || existingUserEmail != null) {
            model.addAttribute("error", "Username or Email already exists");
            return "error";
        } else {
            ClienteEntity currentClient = ClienteRepository.findByUsername(loggedClient);
            if (!nome.isEmpty()) {
                currentClient.setNome(nome);
            }
            if (!contacto.isEmpty()) {
                currentClient.setContacto(contacto);
            }
            if (!morada.isEmpty()) {
                currentClient.setMorada(morada);
            }
            if (!email.isEmpty()) {
                currentClient.setEmail(email);
            }
            if (!nif.isEmpty()) {
                currentClient.setNif(nif);
            }
            if (!username.isEmpty()) {
                currentClient.setUsername(username);
            }
            if (!password.isEmpty()) {
                currentClient.setPassword(password);
            }
            ClienteRepository.save(currentClient);
            return "redirect:/indexLogged";
        }
    }
}