package com.project.filrouge.models;

import com.project.filrouge.dao.CircleDao;
import com.project.filrouge.dao.RectangleDao;
import com.project.filrouge.dao.SquareDao;
import com.project.filrouge.dao.TriangleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DessinCollection {
    private List<Shape> listeDeDessin = new ArrayList<>();

    @Autowired
    private SquareDao squareDao;
    @Autowired
    private RectangleDao rectangleDao;
    @Autowired
    private CircleDao circleDao;
    @Autowired
    private TriangleDao triangleDao;

    @GetMapping("calculTotal")
    public String calculTotalPeri() {
        String q = "";
        q += "<h1> périmètre total = " + calculPeriSquare() + calculPeriRectangle() + calculPeriTriangle() + calculPeriCircle() + " cm </h1" + "<br>" +
                "<h1> Aire totale = " + calculAireSquare() + calculAireRectangle() + calculAireTriangle() + calculAireCircle() + " cm² </h1";
        return q;
    }

    public int calculPeriSquare() {
        List<Square> squares = squareDao.findAll();
        int result = 0;
        for (Square square : squares) {
            result = square.getSize() * 4;
        }
        return result;
    }

    public int calculPeriRectangle() {
        List<Rectangle> rectangles = rectangleDao.findAll();
        int result = 0;
        for (Rectangle rectangle : rectangles) {
            result = rectangle.getLargeur() + rectangle.getLongeur() * 2;
        }
        return result;
    }

    public int calculPeriTriangle() {
        List<Triangle> triangles = triangleDao.findAll();
        int result = 0;
        for (Triangle triangle : triangles) {
            result = triangle.getSizeA() * triangle.getSizeB() + triangle.getSizeC();
        }
        return result;
    }

    public double calculPeriCircle() {
        List<Circle> circles = circleDao.findAll();
        double result = 0;
        for (Circle circle : circles) {
            result = circle.getSize() * 6.283;
        }
        return result;
    }
    public int calculAireSquare() {
        List<Square> squares = squareDao.findAll();
        int result = 0;
        for (Square square : squares) {
            result = square.getSize() * square.getSize();
        }
        return result;
    }

    public int calculAireRectangle() {
        List<Rectangle> rectangles = rectangleDao.findAll();
        int result = 0;
        for (Rectangle rectangle : rectangles) {
            result = rectangle.getLargeur() + rectangle.getLongeur();
        }
        return result;
    }

    public int calculAireTriangle() {
        List<Triangle> triangles = triangleDao.findAll();
        int result = 0;
        for (Triangle triangle : triangles) {
            result = triangle.getSizeA() * triangle.getSizeB() / 2;
        }
        return result;
    }

    public double calculAireCircle() {
        List<Circle> circles = circleDao.findAll();
        double result = 0;
        for (Circle circle : circles) {
            result = 3.14 * (circle.getSize() * circle.getSize());
        }
        return result;
    }

}
