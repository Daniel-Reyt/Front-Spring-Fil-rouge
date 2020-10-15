package com.project.filrouge.Form;

import com.project.filrouge.Job.SquareJob;

import javax.persistence.Entity;

@Entity
public class Square extends Shape {
    public int size;
    public double perimeter;
    public double aire;
    int dessin;

    public Square(){}

    public Square(SquareJob job){
        this.name = job.getName();
        this.faces = 4;
        this.size = job.getSize();
        this.perimeter = job.setPerimeter();
        this.aire = job.setAire();
        this.dessin = job.getId_dessin();
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public double getPerimeter() {
        return getSize() * 4;
    }

    @Override
    public double getAire() {
        return getSize() * getSize();
    }
}
