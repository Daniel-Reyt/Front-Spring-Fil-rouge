package com.project.filrouge.controller;

import com.project.filrouge.exceptions.NoShapeByIdException;
import com.project.filrouge.models.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@Api(description = "gestion de toutes les formes éxistantes")
@RestController
public class ShapeController {
    private String Page;
    private String Info1;
    private String Info2;

    List<Square> listeSquare = new ArrayList<>();
    List<Circle> listeCircle = new ArrayList<>();
    List<Triangle> listeTriangle = new ArrayList<>();
    List<Rectangle> listeRectangle = new ArrayList<>();

    Square square1 = new Square("carré 1", 4, 25, 0);
    Square square2 = new Square("carré 2", 4, 40, 1);

    Circle cir1 = new Circle("cercle 1", 60, 0);
    Circle cir2 = new Circle("cercle 2", 80, 1);

    Triangle tri1 = new Triangle("triangle 1", 15, 20, 25, 3, 0);
    Triangle tri2 = new Triangle("triangle 2", 15, 40, 30, 3, 1);

    Rectangle rec1 = new Rectangle("rectangle 1", 4, 20, 10, 0);
    Rectangle rec2 = new Rectangle("rectangle 2", 4, 30, 50, 1);

    @GetMapping(value = "shape")
    @ApiOperation(value = "récupére toute les formes")
    public String afficherLesShapes() {
        listeSquare.add(square1);
        listeSquare.add(square2);

        listeCircle.add(cir1);
        listeCircle.add(cir2);

        listeTriangle.add(tri1);
        listeTriangle.add(tri2);

        listeRectangle.add(rec1);
        listeRectangle.add(rec2);


        Info1 = listeSquare.get(0).printSquare() + "<br>" + listeCircle.get(0).printCircle() + "<br>" + listeRectangle.get(0).printRectangle() + "<br>" + listeTriangle.get(0).printTriangle();
        Info2 = listeSquare.get(1).printSquare() + "<br>" + listeCircle.get(1).printCircle() + "<br>" + listeRectangle.get(1).printRectangle() + "<br>" + listeTriangle.get(1).printTriangle();
        Page = "<h1> Heyyyyyy </h1> <br>"+this.Info1 + "<br><br>" + this.Info2;
        if (this.Info1 == null || this.Info2 == null) {
            throw new NoShapeByIdException("pas de formes trouvés");
        } else {
            return Page;
        }
    }

    @GetMapping(value = "shape/square")
    @ApiOperation(value = "récupére tout les carrés et les affiches")
    public String afficherLesSquares() {
        listeSquare.add(square1);
        listeSquare.add(square2);

        Info1 = listeSquare.get(0).printSquare() + "<br>" + listeSquare.get(1).printSquare();
        Page = "<h1> Heyyyyyy voici tout les squares</h1> <br>"+this.Info1;
        if (this.Info1 == null) {
            throw new NoShapeByIdException("pas de formes trouvés");
        } else {
            return Page;
        }
    }

    @GetMapping(value = "shape/rectangle")
    @ApiOperation(value = "récupére tout les rectangles et les affiches")
    public String afficherLesRectangles() {

        listeRectangle.add(rec1);
        listeRectangle.add(rec2);

        Info1 = listeRectangle.get(0).printRectangle() + "<br>" + listeRectangle.get(1).printRectangle();
        Page = "<h1> Heyyyyyy voici tout les rectangles</h1> <br>"+this.Info1;
        if (this.Info1 == null) {
            throw new NoShapeByIdException("pas de formes trouvés");
        } else {
            return Page;
        }
    }

    @GetMapping(value = "shape/circle")
    @ApiOperation(value = "récupére tout les cercles et les affiches")
    public String afficherLesCircle() {

        listeCircle.add(cir1);
        listeCircle.add(cir2);

        Info1 = listeCircle.get(0).printCircle() + "<br>" + listeCircle.get(1).printCircle();
        Page = "<h1> Heyyyyyy voici tout les circles</h1> <br>"+this.Info1;
        if (this.Info1 == null) {
            throw new NoShapeByIdException("pas de formes trouvés");
        } else {
            return Page;
        }
    }

    @GetMapping(value = "shape/triangle")
    @ApiOperation(value = "récupére tout les triangles et les affiches")
    public String afficherLesTriangle() {

        listeTriangle.add(tri1);
        listeTriangle.add(tri2);

        Info1 = listeTriangle.get(0).printTriangle() + "<br>" + listeTriangle.get(1).printTriangle();
        Page = "<h1> Heyyyyyy voici tout les circles</h1> <br>"+this.Info1;
        if (this.Info1 == null) {
            throw new NoShapeByIdException("pas de formes trouvés");
        } else {
            return Page;
        }
    }

}
