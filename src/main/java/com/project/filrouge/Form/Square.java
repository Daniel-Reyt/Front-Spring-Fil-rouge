package com.project.filrouge.Form;

import com.project.filrouge.Job.SquareJob;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
public class Square extends Shape {
    public int width;
    public double perimeter;
    public double aire;
    int dessin;

    public Square(){}

    public Square(SquareJob job){
        this.width = job.getwidth();
        this.perimeter = job.setPerimeter();
        this.aire = job.setAire();
        this.dessin = job.getId_dessin();
        this.posX = job.getPosX();
        this.posY = job.getPosY();
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int size) {
        this.width = size;
    }

    @Override
    public double getPerimeter() {
        return getWidth() * 4;
    }

    @Override
    public double getAire() {
        return getWidth() * getWidth();
    }
}
