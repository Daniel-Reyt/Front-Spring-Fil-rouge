package com.project.filrouge.Controller;

import com.project.filrouge.Dao.ShapeDao;
import com.project.filrouge.Form.*;
import com.project.filrouge.Job.CircleJob;
import com.project.filrouge.Job.RectangleJob;
import com.project.filrouge.Job.SquareJob;
import com.project.filrouge.Job.TriangleJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShapeController {

    @Autowired
    ShapeDao shapeDao;

    @GetMapping(value = "/shapes")
    public List<Shape> getShapes(){
        return shapeDao.findAll();
    }

    @GetMapping(value = "/shape/{id}")
    public Shape getShape(@PathVariable int id){
        return shapeDao.findById(id).orElse(null);
    }

    @PostMapping(value = "/square")
    public Shape createSquare(@RequestBody SquareJob square){
        return shapeDao.save(new Square(square));
    }

    @PostMapping(value = "/rectangle")
    public Shape createRectangle(@RequestBody RectangleJob rectangle){
        return shapeDao.save(new Rectangle(rectangle));
    }
    @PostMapping(value = "/circle")
    public Shape createCircle(@RequestBody CircleJob circle){
        return shapeDao.save(new Circle(circle));
    }
    @PostMapping(value = "/triangle")
    public Shape createTriangle(@RequestBody TriangleJob triangle){
        return shapeDao.save(new Triangle(triangle));
    }

    @DeleteMapping(value = "/shapes/{id}")
    public List<Shape> deleteById(@PathVariable int id) {
        shapeDao.deleteById(id);
        return shapeDao.findAll();
    }
}
