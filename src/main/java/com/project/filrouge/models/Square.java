package com.project.filrouge.models;

import javax.persistence.*;

@Entity
public class Square extends Shape implements Calcul {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Column(updatable = false, nullable = false)
    int id;
    int size;
    String name;

    public Square() {

    }

    public Square(int id, String name, int size) {
        int squareId = setId(id);
        String squareName = setName(name);
        int squareSize = setSize(size);
    }    @GeneratedValue


    public String printSquare() {
        String squareInfo = "Bonjour je suis : " + getName() + ", j'ai : 4 côtés, de taille : " + getSize() + " cm, mon id est : " + getId() + "<br>" +
                "mon périmètre est de : " + calculPeri() + " cm, et mon aire est de : " + calculAire() + " cm²";
        return squareInfo;
    }

    public int getId() {
        return id;
    }

    public int setId(int id) {
        this.id = id;
        return id;
    }

    public int getSize() {
        return size;
    }

    public int setSize(int size) {
        this.size = size;
        return size;
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
        return "Square{" +
                "id=" + id +
                ", size=" + size +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public double calculPeri() {
        return getSize() * 4;
    }

    @Override
    public double calculAire() {
        return getSize() * getSize();
    }
}
