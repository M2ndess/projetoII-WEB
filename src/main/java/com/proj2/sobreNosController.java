package com.proj2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class sobreNosController {

    @GetMapping("/sobre-nos")
    public String mostrarPaginaContactos() {
        return "sobre-nos";
    }
}
