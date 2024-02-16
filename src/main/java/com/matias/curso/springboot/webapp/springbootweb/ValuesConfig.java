package com.matias.curso.springboot.webapp.springbootweb;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
// con esta anotacion podemos incorporar vario archivos properties en nuestra
@PropertySources({
	@PropertySource( value = "classpath:values.properties", encoding = "UTF-8") // encoding es para caracteres especiales
})
// esta clase se crea con el fin de no ensuciar nuentra clase principal con otras anotaciones
public class ValuesConfig {

}
