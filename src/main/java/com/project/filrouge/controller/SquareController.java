package com.project.filrouge.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.project.filrouge.dao.SquareDao;
import com.project.filrouge.models.Square;
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

@Api(description = "gestion de toutes les carrés éxistants")
@RestController
public class SquareController {

    @Autowired
    private SquareDao squareDao;

    @ApiOperation(value = "Récupère tout les carrés éxistants dans la BDD")
    @RequestMapping(value="/Square", method= RequestMethod.GET)
    public List<Square> listeSquare() {
       Iterable<Square> squares = squareDao.findAll();

        SimpleBeanPropertyFilter monFiltre = SimpleBeanPropertyFilter.serializeAllExcept("size");

        FilterProvider listDeNosFiltres = new SimpleFilterProvider().addFilter("monFiltreDynamique", monFiltre);

        MappingJacksonValue produitsFiltres = new MappingJacksonValue(squares);

        produitsFiltres.setFilters(listDeNosFiltres);

        return squareDao.findAll();
    }

    @ApiOperation(value = "Récupère un carrés éxistant dans la BDD en fonction de son ID")
    @GetMapping(value = "/Square/{id}")
    public Square afficherUnSquare(@PathVariable int id) {
        return squareDao.findById(id);
    }

    @ApiOperation(value = "Ajoute un carré dans la BDD")
    @PostMapping(value = "/Square")
    public ResponseEntity<Void> ajouterProduit(@RequestBody Square square) {
        Square productAdded =  squareDao.save(square);
        if (productAdded == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(productAdded.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @ApiOperation(value = "Supprime un carré éxistants dans la BDD en fonction de son ID")
    @DeleteMapping (value = "/Square/{id}")
    public void supprimerUnSquare(@PathVariable int id) {

       squareDao.deleteById(id);
    }

    @ApiOperation(value = "Modifie un carrés éxistants dans la BDD en fonction de son ID")
    @PutMapping (value = "/Square")
    public void updateProduit(@RequestBody Square square) {

        squareDao.save(square);
    }
}




