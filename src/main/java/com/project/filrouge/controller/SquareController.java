package com.project.filrouge.controller;

import com.project.filrouge.dao.SquareDao;
import com.project.filrouge.models.Square;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import springfox.documentation.spring.web.json.Json;

import java.net.URI;
import java.util.List;

@Api(description = "gestion de tout les carrés éxistants")
@RestController
public class SquareController {

    @Autowired
    private SquareDao squareDao;

    @ApiOperation(value = "Récupère tout les carrés éxistants dans la BDD")
    @RequestMapping(value="/Square", method= RequestMethod.GET)
    public String listeSquare() {
       Iterable<Square> squares = squareDao.findAll();
       String q = "";
        for (Square square : squares) {
            q += square.printSquare() + "<br><br>" ;
        }
        return q;
    }

    @ApiOperation(value = "Récupère un carrés éxistant dans la BDD en fonction de son ID")
    @GetMapping(value = "/Square/{id}")
    public String afficherUnSquare(@PathVariable int id) {
        return squareDao.findById(id).toString();
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
    @DeleteMapping (value = "/Square")
    public void supprimerUnSquare(@RequestBody Square square) {
        int id = square.getId();
       squareDao.deleteById(id);
    }

    @ApiOperation(value = "Modifie un carrés éxistants dans la BDD en fonction de son ID")
    @PutMapping (value = "/Square")
    public void updateProduit(@RequestBody Square square) {

        squareDao.save(square);
    }


}




