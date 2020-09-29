package com.project.filrouge.controller;

import com.project.filrouge.exceptions.NoShapeByIdException;
import com.project.filrouge.models.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class ShapeController {
    private String Infos;
    private String Info1;
    private String Info2;


    @GetMapping(value = "shape")
    public String afficherUnSquare() {
        List<Square> listeSquare = new ArrayList<>();
        List<Circle> listeCircle = new ArrayList<>();
        List<Triangle> listeTriangle = new ArrayList<>();
        List<Rectangle> listeRectangle = new ArrayList<>();

        Square square1 = new Square("carré 1", 4, 25, 0);
        listeSquare.add(square1);
        Square square2 = new Square("carré 2", 4, 40, 1);
        listeSquare.add(square2);

        Circle cir1 = new Circle("cercle 1", 60, 0);
        listeCircle.add(cir1);
        Circle cir2 = new Circle("cercle 1", 80, 1);
        listeCircle.add(cir2);

        Triangle tri1 = new Triangle("triangle 1", 15, 20, 25, 3, 0);
        listeTriangle.add(tri1);
        Triangle tri2 = new Triangle("triangle 1", 15, 40, 30, 3, 1);
        listeTriangle.add(tri2);

        Rectangle rec1 = new Rectangle("rectangle 1", 4, 20, 10, 0);
        listeRectangle.add(rec1);
        Rectangle rec2 = new Rectangle("rectangle 1", 4, 30, 50, 1);
        listeRectangle.add(rec2);

        Info1 = listeSquare.get(0).printSquare() + "<br>" + listeCircle.get(0).printCircle() + "<br>" + listeRectangle.get(0).printRectangle() + "<br>" + listeTriangle.get(0).printTriangle();
        Info2 = listeSquare.get(1).printSquare() + "<br>" + listeCircle.get(1).printCircle() + "<br>" + listeRectangle.get(1).printRectangle() + "<br>" + listeTriangle.get(1).printTriangle();
        Infos = this.Info1 + "<br><br>" + this.Info2;
        if (this.Infos == null) {
            throw new NoShapeByIdException("pas de formes trouvés");
        } else {
            return Infos;
        }
    }

}
