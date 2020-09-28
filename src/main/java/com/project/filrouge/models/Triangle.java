package com.project.filrouge.models;

public class Triangle extends Shape{
    int id;
    int sides;
    int sizeA;
    int sizeB;
    int sizeC;

    public Triangle(String name, int sizeA, int sizeB, int sizeC, int sides, int id) {

        int triangleId = setId(id);
        String triangleName = setName(name);
        int triangleSizeA = setSizeA(sizeA);
        int triangleSizeB = setSizeB(sizeB);
        int triangleSizeC = setSizeC(sizeC);
        int triangleSides = setSides(sides);
    }

    public Triangle() {

    }

    public String printTriangle() {
        String triangleInfo = "Bonjour je suis : " + getName() + ", j'ai : " + getSides() + " côtés, mon côté A mesure : " + getSizeA() + " cm, mon côté B mesure : " + getSizeB() + " cm, mon côté C mesure : " + getSizeC() + " cm, mon id est : " + getId();
        return triangleInfo;
    }

    public int getSizeA() {
        return sizeA;
    }

    public int setSizeA(int sizeA) {
        this.sizeA = sizeA;
        return sizeA;
    }

    public int getSizeB() {
        return sizeB;
    }

    public int setSizeB(int sizeB) {
        this.sizeB = sizeB;
        return sizeB;
    }

    public int getSizeC() {
        return sizeC;
    }

    public int setSizeC(int sizeC) {
        this.sizeC = sizeC;
        return sizeC;
    }

    public int getId() {
        return id;
    }

    public int setId(int id) {
        this.id = id;
        return id;
    }

    public int getSides() {
        return sides;
    }

    public int setSides(int sides) {
        this.sides = sides;
        return sides;
    }

}
