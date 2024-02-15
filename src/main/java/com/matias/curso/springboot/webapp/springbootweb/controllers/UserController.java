package com.matias.curso.springboot.webapp.springbootweb.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.matias.curso.springboot.webapp.springbootweb.models.User;


@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model){

        User user = new User("Matias", "Navio", "matias@gmail.com");
        user.setEmail("matias@gmail.com");

        // model se usa para enviar datos a la vista, mediante un atributo y un valor
        model.addAttribute("title", "Hola Mundo, esto es una APIRest");
        // de esta forma pasamos el objeto usuario a la vista y pueden acceder a sus metodos get para mostrarlos
        model.addAttribute("usuario", user);
        return "details";
    }

    // gracias a @ModelAttribute el metodo list queda muy limpio
    @GetMapping("/list")
    public String userList(Model model){
        model.addAttribute("title", "Hola Mundo, lista de usuarios con for en thymeleaf");

        return "list";
    }

    // con esta anotacion podemos pasar los objetos a la vista y reutilizarlos, que no esten dentro de un metodo especifico
    @ModelAttribute("usuarios")
    public List<User> userModel(){

        return Arrays.asList(
            new User("Matias", "Navio"),
            new User("Juan", "Vargas", "juan@gmail.com"),
            new User("Mariano", "Acensio", "mariano@gmail.com")

        );
    }
}
