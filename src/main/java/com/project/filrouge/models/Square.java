package com.project.filrouge.models;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Square extends Shape {
    int id;

    int size;

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

    private int getSize() {
        return size;
    }

    public int getId() {
        return id;
    }

    public int setId(int id) {
        this.id = id;
        return id;
    }
    public int setSize(int size) {
        this.size = size;
        return size;
    }
}
