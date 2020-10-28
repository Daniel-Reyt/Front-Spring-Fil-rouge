package com.project.filrouge.draw;

import com.project.filrouge.Dao.DrawDao;
import com.project.filrouge.Dao.ShapeDao;
import com.project.filrouge.Form.Shape;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "gestion de tous les dessins éxistants")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DrawController {
    @Autowired
    DrawDao drawDao;

    @Autowired
    ShapeDao shapeDao;

    @GetMapping(value = "/draw")
    public List<Draw> getAllDraw() {
        return drawDao.findAll();
    }

    @GetMapping(value = "/draw/{id}")
    public Draw getDrawById(@PathVariable int id) {
        return drawDao.findById(id).orElse(null);
    }

    @PostMapping(value = "/draw")
    public List<Draw> addDraw(@RequestBody DrawJob drawJob) {
        drawDao.save(new Draw(drawJob));
        return drawDao.findAll();
    }

    @DeleteMapping(value = "/draw")
    public List<Draw> deleteAllDraw() {
        drawDao.deleteAll();
        return drawDao.findAll();
    }

    @DeleteMapping(value = "/draw/shapeDraw_id")
    public List<Draw> deleteDrawById(@RequestBody int draw) {
        drawDao.deleteById(draw);
        return drawDao.findAll();
    }

    @GetMapping(value = "/draw/shapeDraw_id")
    public List<Shape> getShapeByDrawId(@RequestHeader int draw) {
       System.out.println(drawDao.findById(draw).get().shapes);
        return drawDao.findById(draw).get().shapes;
    }
}
