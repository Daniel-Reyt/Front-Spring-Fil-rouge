package com.project.filrouge.controller;

import com.project.filrouge.models.Circle;

import com.project.filrouge.dao.CircleDao;
import com.project.filrouge.models.Square;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public String listeSquare() {
        List<Circle> circles = circleDao.findAll();
        String q = "";
        for (Circle circle : circles) {
            q += circle.printCircle() + "<br><br>" ;
        }
        return q;
    }

    @ApiOperation(value = "Récupère un cercle éxistant dans la BDD en fonction de son ID")
    @GetMapping(value = "/Circle/{id}")
    public String afficherUnSquare(@PathVariable int id) {
        return circleDao.findById(id).toString();
    }

    @ApiOperation(value = "Ajoute un cercle dans la BDD")
    @PostMapping(value = "/Circle")
    public ResponseEntity<Void> ajouterProduit(@RequestBody Circle circle) {
        Circle circle1 =  circleDao.save(circle);
        if (circle1 == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(circle1.getId())
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
