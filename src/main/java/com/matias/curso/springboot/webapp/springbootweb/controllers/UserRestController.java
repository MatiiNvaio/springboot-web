package com.matias.curso.springboot.webapp.springbootweb.controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matias.curso.springboot.webapp.springbootweb.models.User;
import com.matias.curso.springboot.webapp.springbootweb.models.dto.UserDto;

// me convierte los metodos handler en Rest, es decir, que convierte los datos en Resto (JSON, XML)
@RestController
@RequestMapping("/api")
public class UserRestController {

    // cualquier clase POJO puede ser convertida en JSON, cualquier dato serealizable (user, factura, venta, etc)
    @GetMapping("/details-map")
    public Map<String, Object> detailsMap(){

        User user = new User("Matias", "Navio");

        Map<String, Object> body = new HashMap<>();

        body.put("title", "Hola Mundo Spring App");
        body.put("user", user);

        return body;
    }

    @GetMapping("/details-dto")
    public UserDto detailsDto(){

        User user = new User("Matias", "Navio");

        UserDto userDto = new UserDto();
        userDto.setUser(user);
        userDto.setTitle("Hola Mundo Spring App");

        return userDto;
    }

    @GetMapping("/list-details")
    public Map<String, Object> userList(){

        List<User> usuarios = Arrays.asList(
            new User("Matias", "Navio"),
            new User("Martin", "Cairo"),
            new User("Rodrigo", "Perez")
        );

        Map<String, Object> body = new HashMap<>();

        body.put("title", "Hola, esto es una lista de usuarios");
        body.put("users", usuarios);

        return body;
    }
}
 