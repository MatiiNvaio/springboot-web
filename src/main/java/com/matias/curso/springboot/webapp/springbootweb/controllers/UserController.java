package com.matias.curso.springboot.webapp.springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.matias.curso.springboot.webapp.springbootweb.models.User;


@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model){

        User user = new User("Matias", "Navio");

        // model se usa para enviar datos a la vista, mediante un atributo y un valor
        model.addAttribute("title", "Hola Mundo, esto es una APIRest");
        // de esta forma pasamos el objeto usuario a la vista y pueden acceder a sus metodos get para mostrarlos
        model.addAttribute("usuario", user);
        return "details";
    }
}
