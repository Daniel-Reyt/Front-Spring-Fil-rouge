package com.project.filrouge.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.project.filrouge.dao.CircleDao;
import com.project.filrouge.dao.TriangleDao;
import com.project.filrouge.models.Circle;
import com.project.filrouge.models.Triangle;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Api(description = "gestion de tout les triangles éxistants")
@RestController
public class TriangleController {

    @Autowired
    private TriangleDao triangleDao;

    @ApiOperation(value = "Récupère tout les triangles éxistants dans la BDD")
    @RequestMapping(value="/Triangle", method= RequestMethod.GET)
    public String listeSquare() {
        List<Triangle> triangles = triangleDao.findAll();

        return triangles.toString();
    }

    @ApiOperation(value = "Récupère un triangle éxistant dans la BDD en fonction de son ID")
    @GetMapping(value = "/Triangle/{id}")
    public String afficherUnSquare(@PathVariable int id) {
        return triangleDao.findById(id).toString();
    }

    @ApiOperation(value = "Ajoute un triangle dans la BDD")
    @PostMapping(value = "/Triangle")
    public ResponseEntity<Void> ajouterProduit(@RequestBody Triangle triangle) {
        Triangle productAdded =  triangleDao.save(triangle);
        if (productAdded == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(productAdded.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @ApiOperation(value = "Supprime un triangle éxistants dans la BDD en fonction de son ID")
    @DeleteMapping (value = "/Triangle/{id}")
    public void supprimerUnSquare(@PathVariable int id) {

        triangleDao.deleteById(id);
    }

    @ApiOperation(value = "Modifie un triangle éxistants dans la BDD en fonction de son ID")
    @PutMapping (value = "/Triangle")
    public void updateProduit(@RequestBody Triangle triangle) {

        triangleDao.save(triangle);
    }
}
