package com.proj2;
import entity.ClienteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {
    private final ClienteRepository ClienteRepository;

    @Autowired
    public RegisterController(ClienteRepository clienteRepository) {
        this.ClienteRepository = clienteRepository;
    }

    @GetMapping("/register")
    public String showRegisterForm() {
        return "register"; // Return the registration form
    }

    @PostMapping("/register")
    public String register(@RequestParam("nome") String nome,
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
            ClienteEntity newUser = new ClienteEntity();
            newUser.setNome(nome);
            newUser.setContacto(contacto);
            newUser.setMorada(morada);
            newUser.setEmail(email);
            newUser.setNif(nif);
            newUser.setUsername(username);
            newUser.setPassword(password);
            newUser.setEstadoConta("1");
            ClienteRepository.save(newUser);
            return "redirect:/login";
        }
    }
}
