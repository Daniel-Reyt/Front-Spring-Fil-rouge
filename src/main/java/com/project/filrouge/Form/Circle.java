package com.project.filrouge.Form;

import com.project.filrouge.Job.CircleJob;

import javax.persistence.*;

@Entity
public class Circle extends Shape {
    public int rayon;
    public int diameter;

    public Circle() {
    }

    public Circle(CircleJob job) {
        this.rayon = job.getRayon();
        this.diameter = getDiameter();
        this.posX = job.getPosX();
        this.posY = job.getPosY();
        this.color = job.getColor();
        this.shapeType = job.getShapeType();
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

    public void setDiameter(int diameter) {
        this.diameter = getRayon() * 2;
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
