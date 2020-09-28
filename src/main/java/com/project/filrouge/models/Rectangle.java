package com.project.filrouge.models;

public class Rectangle extends Shape{

    int sizeLong;
    int sizeLarg;
    int id;

    public Rectangle(String name, int sides, int sizeLong, int sizeLarg, int id) {
        int rectangleId = setId(id);
        String recName = setName(name);
        int recSides = setSides(sides);
        int recLong = setSizeLong(sizeLong);
        int recLarg = setSizeLarg(sizeLarg);
    }

    public Rectangle() {

    }

    public String printRectangle() {
        String rectangleInfo = "Bonjour je suis : " + getName() + ", j'ai : " + getSides() + " côtés, de longeur : " + getSizeLong() + " cm, et de largeur : " + getSizeLarg() + " cm, mon id est : " + getId();
        return rectangleInfo;
    }

    public int getSizeLong() {
        return sizeLong;
    }

    public int setSizeLong(int sizeLong) {
        this.sizeLong = sizeLong;
        return sizeLong;
    }

    public int getSizeLarg() {
        return sizeLarg;
    }

    public int setSizeLarg(int sizeLarg) {
        this.sizeLarg = sizeLarg;
        return sizeLarg;
    }

    public int getId() {
        return id;
    }

    public int setId(int id) {
        this.id = id;
        return id;
    }

}
