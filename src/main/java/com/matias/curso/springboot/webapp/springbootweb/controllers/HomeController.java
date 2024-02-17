package com.matias.curso.springboot.webapp.springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/", "", "/home"})
    public String index(){

        // redirije a la ruta especificada y la cambia en el navegador
        return "redirect:/list";
        // no cambia la ruta, si no que se queda en la ruta base pero muestra lo que devuelve el metodo
        // return "forward:/list";
    }
}
