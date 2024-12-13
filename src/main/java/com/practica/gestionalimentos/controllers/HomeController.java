package com.practica.gestionalimentos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index.html"; // Nombre de la vista (index.html o index.jsp en /resources/templates o /static).
    }
}
