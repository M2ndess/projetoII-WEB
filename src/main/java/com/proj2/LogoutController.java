package com.proj2;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // Invalida a sessão
        session.invalidate();
        return "redirect:/home";
    }
}
