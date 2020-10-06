package com.project.filrouge.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.project.filrouge.dao.RectangleDao;
import com.project.filrouge.models.Rectangle;
import com.project.filrouge.models.Square;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Api(description = "gestion de tout les rectangles éxistants")
@RestController
public class RectangleController {

    @Autowired
    private RectangleDao rectangleDao;

    @ApiOperation(value = "Récupère tout les rectangles éxistants dans la BDD")
    @RequestMapping(value="/Rectangle", method= RequestMethod.GET)
    public String listeSquare() {
        List<Rectangle> rectangles = rectangleDao.findAll();
        String q = "";
        for (Rectangle rectangle : rectangles) {
            q += rectangle.printRectangle() + "<br><br>" ;
        }
        return q;
    }

    @ApiOperation(value = "Récupère un rectangle éxistant dans la BDD en fonction de son ID")
    @GetMapping(value = "/Rectangle/{id}")
    public String afficherUnSquare(@PathVariable int id) {
        return rectangleDao.findById(id).toString();
    }

    @ApiOperation(value = "Ajoute un rectangle dans la BDD")
    @PostMapping(value = "/Rectangle")
    public ResponseEntity<Void> ajouterProduit(@RequestBody Rectangle rectangle) {
        Rectangle productAdded =  rectangleDao.save(rectangle);
        if (productAdded == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(productAdded.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @ApiOperation(value = "Supprime un rectangle éxistants dans la BDD en fonction de son ID")
    @DeleteMapping (value = "/Rectangle/{id}")
    public void supprimerUnSquare(@PathVariable int id) {

        rectangleDao.deleteById(id);
    }

    @ApiOperation(value = "Modifie un rectangle éxistants dans la BDD en fonction de son ID")
    @PutMapping (value = "/Rectangle")
    public void updateProduit(@RequestBody Rectangle rectangle) {

        rectangleDao.save(rectangle);
    }
}
