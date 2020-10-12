package com.project.filrouge.Form;

import com.project.filrouge.Job.SquareJob;

import javax.persistence.Entity;

@Entity
public class Square extends Shape {
    public int size;
    public double perimeter;
    public double aire;

    public Square(){}

    public Square(SquareJob job){
        this.name = job.getName();
        this.faces = 4;
        this.size = job.getSize();
        this.perimeter = getPerimeter();
        this.aire = getAire();
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
