package com.matias.curso.springboot.webapp.springbootweb.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matias.curso.springboot.webapp.springbootweb.models.User;

// me convierte los metodos handler en Rest, es decir, que convierte los datos en Resto (JSON, XML)
@RestController
@RequestMapping("/api")
public class UserRestController {

    // cualquier clase POJO puede ser convertida en JSON, cualquier dato serealizable (user, factura, venta, etc)
    @GetMapping("/details2")
    public Map details(){

        User user = new User("Matias", "Navio");

        Map<String, Object> body = new HashMap<>();

        body.put("title", "Hola Mundo Spring App");
        body.put("user", user);

        return body;
    }
}
