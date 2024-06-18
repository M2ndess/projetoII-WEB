package com.proj2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactosController {

    @GetMapping("/contactos")
    public String mostrarPaginaContactos() {
        return "contactos";
    }
}
