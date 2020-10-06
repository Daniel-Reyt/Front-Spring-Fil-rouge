package com.project.filrouge.models;

import javax.persistence.*;

@Entity
public class Triangle extends Shape {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    int id;
    int sizeA;
    int sizeB;
    int sizeC;
    String name;

    public Triangle() {

    }

    public Triangle(int id, String name, int sizeA, int sizeB, int sizeC) {
        int rectangleId = setId(id);
        String rectangleName = setName(name);
        int TriSizeA = setSizeA(sizeA);
        int TriSizeB = setSizeB(sizeB);
        int TriSizeC = setSizeC(sizeC);
    }


    public String printTriangle() {
        String squareInfo = "Bonjour je suis : " + getName() + ", j'ai : 3 côtés, mon côté A est de : " + getSizeA() + " cm, mon côté B est de : " + getSizeB() + " cm, mon côté C est de : " + getSizeC() + " cm, mon id est : " + getId() + "<br>";
        return squareInfo;
    }

    public int getId() {
        return id;
    }

    public int setId(int id) {
        this.id = id;
        return id;
    }

    public int getSizeA() {
        return sizeA;
    }
    public int getSizeB() {
        return sizeB;
    }
    public int getSizeC() {
        return sizeC;
    }
    public int setSizeA(int sizeA) {
        this.sizeA = sizeA;
        return sizeA;
    }
    public int setSizeB(int sizeB) {
        this.sizeB = sizeB;
        return sizeB;
    }
    public int setSizeC(int sizeC) {
        this.sizeC = sizeC;
        return sizeC;
    }

    public String getName() {
        return name;
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "id=" + id +
                ", sizeA=" + sizeA +
                ", sizeB=" + sizeB +
                ", sizeC=" + sizeC +
                ", name='" + name + '\'' +
                '}';
    }
}
