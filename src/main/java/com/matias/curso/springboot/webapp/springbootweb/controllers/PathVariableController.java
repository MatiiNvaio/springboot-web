package com.matias.curso.springboot.webapp.springbootweb.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matias.curso.springboot.webapp.springbootweb.models.User;
import com.matias.curso.springboot.webapp.springbootweb.models.dto.ParamDto;

@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    // con @Values traemos datos del application.properties que estan marcados con un identificador
    @Value("${config.username}")
    private String username;
    @Value("${config.message}")
    private String message;
    @Value("${config.listOfValues}")
    private String[] listOfValues;
    @Value("${config.code}")
    private Integer code;

    // con @PathVariable pasamos un dato por la ruta URL pero de manera mas amigable /api/var/baz/Matias por ejemplo
    @GetMapping("/baz/{message}")
    public ParamDto baz(@PathVariable String message){

        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    } 

    @GetMapping("/mix/{product}/{id}")
    public Map<String, Object> mix(@PathVariable String product, @PathVariable Long id){

        Map<String, Object> json = new HashMap<>();
        json.put("product", product);
        json.put("id", id);
        return json;
    }

    // los metodos POST se usan para enviar datos, y no suelen tener una ruta especifica, en esta caso si como ejemplo
    // hay que tener si o si un constructor vacio, para que este se poble
    @PostMapping("/create")
    public User crear(@RequestBody User user){
        // aqui dentro se hace algo con el usuario que recibimos 

        return user;
    }

    @GetMapping("/values")
    public Map<String, Object> values(){

        Map<String, Object> json = new HashMap<>();
        json.put("username", username);
        json.put("code", code);
        json.put("listOfValues", listOfValues);
        json.put("message", message);

        return json;
    }
}
