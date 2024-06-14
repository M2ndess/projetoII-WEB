package com.proj2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexLoggedController {

    @GetMapping("/indexLogged")
    public String showindexLogged() {
        return "indexLogged";
    }
}