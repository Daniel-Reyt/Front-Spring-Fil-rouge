package com.project.filrouge.Controller;

import com.project.filrouge.Dao.DrawDao;
import com.project.filrouge.Dao.ShapeDao;
import com.project.filrouge.Form.*;
import com.project.filrouge.Job.CircleJob;
import com.project.filrouge.Job.RectangleJob;
import com.project.filrouge.Job.SquareJob;
import com.project.filrouge.Job.TriangleJob;
import com.project.filrouge.draw.Draw;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Api(description = "gestion de tout les formes éxistants")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ShapeController {

    @Autowired
    ShapeDao shapeDao;

    @Autowired
    DrawDao drawDao;

    @ApiOperation(value = "Récupère la page de vérification a partir de l'API")
    @GetMapping(value = "/")
    public ModelAndView getIndex(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @ApiOperation(value = "Récupère la page du canvas a partir de l'API")
    @GetMapping(value = "/canvas")
    public ModelAndView getCanvas(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("canvas");
        return modelAndView;
    }

    @ApiOperation(value = "Récupère tout les formes éxistants dans la BDD")
    @GetMapping(value = "/shapes")
    public List<Shape> getShapes(){
        return shapeDao.findAll();
    }

    @ApiOperation(value = "Récupère tout une forme éxistant en fonction de son id")
    @GetMapping(value = "/shape/{id}")
    public Shape getShapeById(@PathVariable int id){
        return shapeDao.findById(id).orElse(null);
    }

    @ApiOperation(value = "Ajoute un carré dans la BDD")
    @PostMapping(value = "/square")
    public Shape createSquare(@RequestBody SquareJob square){
        Square s = new Square(square);
        shapeDao.save(s);
        Draw d = drawDao.findById(square.getDraw()).get();
        d.getShapes().add(s);
        return shapeDao.save(new Square(square));
    }

    @ApiOperation(value = "Ajoute un rectangle dans la BDD")
    @PostMapping(value = "/rectangle")
    public Shape createRectangle(@RequestBody RectangleJob rectangle){
        return shapeDao.save(new Rectangle(rectangle));
    }

    @ApiOperation(value = "Ajoute un cercle dans la BDD")
    @PostMapping(value = "/circle")
    public Shape createCircle(@RequestBody CircleJob circle){
        return shapeDao.save(new Circle(circle));
    }

    @ApiOperation(value = "Ajoute un triangle dans la BDD")
    @PostMapping(value = "/triangle")
    public Shape createTriangle(@RequestBody TriangleJob triangle){
        return shapeDao.save(new Triangle(triangle));
    }


    @ApiOperation(value = "Supprime une forme dans la BDD en fonction de son id")
    @DeleteMapping(value = "/shapes/{id}")
    public List<Shape> deleteById(@PathVariable int id) {
        shapeDao.deleteById(id);
        return shapeDao.findAll();
    }

    @ApiOperation(value = "Supprime toutes les formes dans la BDD, a n'utiliser qu'en cas d'éxtrème urgence !")
    @DeleteMapping(value = "/shapes")
    public void deleteAllShape() {
        shapeDao.deleteAll();
    }
}
