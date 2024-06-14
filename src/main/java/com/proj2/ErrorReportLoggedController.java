package com.proj2;

import entity.ClienteEntity;
import entity.ErrorReportEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ErrorReportLoggedController {

    private final ErrorReportRepository ErrorReportRepository;
    @Autowired
    public ErrorReportLoggedController(ErrorReportRepository ErrorReportRepository) {
        this.ErrorReportRepository = ErrorReportRepository;
    }
    @GetMapping("/errorReportLogged")
    public String showErrorReportLogged() {
        return "errorReportLogged";
    }

    @PostMapping("/errorReportLogged")
    public String register(@RequestParam("typeofError") String errorType,
                           @RequestParam("message") String description,
                           Model model) {
        ErrorReportEntity newReport = new ErrorReportEntity();
        newReport.setErrorType(errorType);
        newReport.setDescription(description);
        ErrorReportRepository.save(newReport);
        return "redirect:/indexLogged";
    }
}