package com.project.filrouge.controller;

import com.project.filrouge.models.Circle;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.project.filrouge.dao.CircleDao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Api(description = "gestion de tout les cercle éxistants")
@RestController
public class CircleController {

    @Autowired
    private CircleDao circleDao;

    @ApiOperation(value = "Récupère tout les cercles éxistants dans la BDD")
    @RequestMapping(value="/Circle", method= RequestMethod.GET)
    public List<Circle> listeSquare() {
        List<Circle> circles = circleDao.findAll();

        SimpleBeanPropertyFilter monFiltre = SimpleBeanPropertyFilter.serializeAllExcept("size");

        FilterProvider listDeNosFiltres = new SimpleFilterProvider().addFilter("monFiltreDynamique", monFiltre);

        MappingJacksonValue produitsFiltres = new MappingJacksonValue(circles);

        produitsFiltres.setFilters(listDeNosFiltres);

        return circleDao.findAll();
    }

    @ApiOperation(value = "Récupère un cercle éxistant dans la BDD en fonction de son ID")
    @GetMapping(value = "/Circle/{id}")
    public Circle afficherUnSquare(@PathVariable int id) {
        return circleDao.findById(id);
    }

    @ApiOperation(value = "Ajoute un cercle dans la BDD")
    @PostMapping(value = "/Circle")
    public ResponseEntity<Void> ajouterProduit(@RequestBody Circle circle) {
        Circle productAdded =  circleDao.save(circle);
        if (productAdded == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(productAdded.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @ApiOperation(value = "Supprime un cercle éxistants dans la BDD en fonction de son ID")
    @DeleteMapping (value = "/Circle/{id}")
    public void supprimerUnSquare(@PathVariable int id) {

        circleDao.deleteById(id);
    }

    @ApiOperation(value = "Modifie un cercle éxistants dans la BDD en fonction de son ID")
    @PutMapping (value = "/Circle")
    public void updateProduit(@RequestBody Circle circle) {

        circleDao.save(circle);
    }
}