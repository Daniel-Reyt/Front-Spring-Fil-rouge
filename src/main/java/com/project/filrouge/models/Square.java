package com.project.filrouge.models;

import java.util.Collection;

public class Square extends Shape {
    int id;

    public Square(String name, int sides, int size, int id) {
        int squareId = setId(id);
        String squareName = setName(name);
        int squareSides = setSides(sides);
        int squareSize = setSize(size);
    }

    public Square() {

    }

    public String printSquare() {
        String squareInfo = "Bonjour je suis : " + getName() + ", j'ai : " + getSides() + " côtés, de tailles : " + getSize() + " cm, mon id est : " + getId();
        return squareInfo;
    }

    public int getId() {
        return id;
    }

    public int setId(int id) {
        this.id = id;
        return id;
    }
}
