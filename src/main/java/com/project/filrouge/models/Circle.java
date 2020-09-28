package com.project.filrouge.models;

public class Circle extends Shape {
    int rayon;
    int id;

    public Circle(String name, int rayon, int id) {
        int CircleId = setId(id);
        String circleName = setName(name);
        int circleRayoon = setRayon(rayon);
    }

    public Circle() {

    }

    public String printCircle() {
        String circleInfo = "Bonjour je suis : " + getName() + ", mon rayon est de : " + getRayon() + " cm, mon id est : " + getId();
        return circleInfo;
    }

    public int getRayon() {
        return rayon;
    }

    public int setRayon(int rayon) {
        this.rayon = rayon;
        return rayon;
    }

    public int getId() {
        return id;
    }

    public int setId(int id) {
        this.id = id;
        return id;
    }

}
