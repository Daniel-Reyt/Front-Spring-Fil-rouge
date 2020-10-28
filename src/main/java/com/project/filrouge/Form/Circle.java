package com.project.filrouge.Form;

import com.project.filrouge.Job.CircleJob;

import javax.persistence.*;

@Entity
public class Circle extends Shape {
    public int rayon;

    public Circle() {

    }

    public Circle(CircleJob job) {
        this.rayon = job.getRayon();
        this.posX = job.getPosX();
        this.posY = job.getPosY();
        this.color = job.getColor();
        this.shapeType = job.getShapeType();
        this.draw = job.getDraw();
    }

    public int getRayon() {
        return rayon;
    }

    public void setRayon(int rayon) {
        this.rayon = rayon;
    }

    public int getDiameter() {
        return rayon * 2;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * getRayon();
    }

    @Override
    public double getAire() {
        return Math.PI * (getRayon() * getRayon());
    }
}
