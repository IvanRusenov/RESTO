package com.business.business.controllers;

import com.business.business.ChangeRequest;
import com.business.business.ChangeResponse;
import com.business.business.services.impls.ChangeCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ChangeCalculatorController {

    @Autowired
    private ChangeCalculatorService changeCalculatorService;

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("changeRequest", new ChangeRequest());
        model.addAttribute("currencies", new String[]{"EUR", "BGN"});
        return "calculator";
    }

    @PostMapping("/api/calculate")
    @ResponseBody
    public ChangeResponse calculate(@RequestBody ChangeRequest request) {
        return changeCalculatorService.calculateChange(request);
    }

    @PostMapping("/calculate")
    public String calculateChange(@ModelAttribute ChangeRequest request, Model model) {
        ChangeResponse response = changeCalculatorService.calculateChange(request);
        model.addAttribute("response", response);
        model.addAttribute("changeRequest", request);
        model.addAttribute("currencies", new String[]{"EUR", "BGN"});
        return "calculator";
    }
}
