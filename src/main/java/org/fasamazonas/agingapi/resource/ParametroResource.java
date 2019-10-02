package org.fasamazonas.agingapi.resource;

import org.fasamazonas.agingapi.model.Parametro;
import org.fasamazonas.agingapi.service.ParametroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/parametros")
public class ParametroResource {


    @Autowired
    private ParametroService parametroService;



    @GetMapping
    public Parametro findAll(){
        return parametroService.findParametro();
    }

}
