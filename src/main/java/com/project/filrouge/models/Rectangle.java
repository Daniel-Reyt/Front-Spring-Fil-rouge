package com.project.filrouge.models;

import javax.persistence.*;

@Entity
public class Rectangle extends Shape {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    int id;
    int longeur;
    int largeur;
    String name;

    public Rectangle() {

    }

    public Rectangle(int id, String name, int longeur, int largeur) {
        int rectangleId = setId(id);
        String rectangleName = setName(name);
        int rectangleLongeur = setLongeur(longeur);
        int rectangleLargeur = setLargeur(largeur);
    }    @GeneratedValue


    public String printRectangle() {
        String squareInfo = "Bonjour je suis : " + getName() + ", j'ai : 4 côtés, de longeur : " + getLongeur() + " cm, et de largeur : " + getLargeur()+ " cm, mon id est : " + getId();
        return squareInfo;
    }

    public int getId() {
        return id;
    }

    public int setId(int id) {
        this.id = id;
        return id;
    }

    public int getLongeur() {
        return longeur;
    }
    public int getLargeur() {
        return largeur;
    }
    public int setLongeur(int longeur) {
        this.longeur = longeur;
        return longeur;
    }
    public int setLargeur(int largeur) {
        this.largeur = largeur;
        return largeur;
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
        return "Rectangle{" +
                "id=" + id +
                ", longeur=" + longeur +
                ", largeur=" + largeur +
                ", name='" + name + '\'' +
                '}';
    }
}
