package com.proj2;

import entity.ErrorReportEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ErrorReportController {
    private final ErrorReportRepository ErrorReportRepository;
    @Autowired
    public ErrorReportController(ErrorReportRepository ErrorReportRepository) {
        this.ErrorReportRepository = ErrorReportRepository;
    }
    @GetMapping("/errorReport")
    public String showErrorReport() {
        return "errorReport";
    }

    @PostMapping("/errorReport")
    public String register(@RequestParam("typeofError") String errorType,
                           @RequestParam("message") String description,
                           Model model) {
        ErrorReportEntity newReport = new ErrorReportEntity();
        newReport.setErrorType(errorType);
        newReport.setDescription(description);
        ErrorReportRepository.save(newReport);
        return "redirect:/index";
    }
}
