package com.example.demo.controllers;

//import com.example.demo.persistence.model.Cargos;
import com.example.demo.persistence.repo.CargosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


public class CargosController {

}
/*****
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/fast")
public class CargosController {

   // @Qualifier("datasource2")
    @Autowired
    CargosRepository cargosRepository;

    @GetMapping("/cargos")
    public ResponseEntity<List<Cargos>> getallCargos(){
        try {
            List<Cargos> cargos = cargosRepository.findAll();
            return new ResponseEntity<>(cargos, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
****/