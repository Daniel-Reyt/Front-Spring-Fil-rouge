package com.project.filrouge.models;

import javax.persistence.*;

@Entity
public class Circle extends Shape implements Calcul {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    int id;
    int rayon;
    String name;

    public Circle() {

    }

    public Circle(int id, String name, int size) {
        int circleId = setId(id);
        String circleName = setName(name);
        int circleSize = setSize(size);
    }


    public String printCircle() {
        String squareInfo = "Bonjour je suis : " + getName() + ", j'ai un rayon de : " + getSize() + " cm, mon id est : " + getId() + "<br>" +
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
        return rayon;
    }

    public int setSize(int rayon) {
        this.rayon = rayon;
        return rayon;
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
        return "Circle{" +
                "id=" + id +
                ", rayon=" + rayon +
                ", name='" + name + '\'' +
                '}';
    }


    @Override
    public double calculPeri() {
        return (3.14 * 2) * getSize();
    }

    @Override
    public double calculAire() {
        return 3.14 * (getSize() * getSize());
    }
}
