package com.matias.curso.springboot.webapp.springbootweb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.matias.curso.springboot.webapp.springbootweb.models.dto.ParamDto;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/params")
public class RequestParamController {

    // este metodo recibe un mensaje de tipo String, y con @RequestParam lo convierte y devuelve en JSON
    // el mensaje se envia por URL con la ruta /api/params/foo?message=Hola y se converte en JSON 
    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false, defaultValue = "Mensaje por defecto") String message){

        ParamDto param = new ParamDto();
        param.setMessage(message);
        
        return param;
    }

    // de esta manera podemos pasar mas de una parametro por la URL
    @GetMapping("/bar")
    public ParamDto bar(@RequestParam(required =  false) String text,
                        @RequestParam(required = false) Integer code){

        ParamDto params = new ParamDto();
        params.setMessage(text);
        params.setCode(code);

        return params;
    }

    // forma de obtener datos de la respuesta HTTP con el objeto HttpServletRequest, y el metodo getParameter
    @GetMapping("/request")
    public ParamDto request(HttpServletRequest request){

        Integer code = 0; 
        // con esto validamos que code sea si o si Integer, y si no devuelve un 0   
        try{
            code = Integer.parseInt(request.getParameter("code"));
        }catch(NumberFormatException e){
        }
        ParamDto params = new ParamDto();
        params.setCode(code);
        params.setMessage(request.getParameter("message"));
        
        return params;
    }
}
