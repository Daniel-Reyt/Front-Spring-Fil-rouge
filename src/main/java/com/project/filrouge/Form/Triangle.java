package com.project.filrouge.Form;

import com.project.filrouge.Job.TriangleJob;

import javax.persistence.*;

@Entity
public class Triangle extends Shape {

    //TODO all calc aire and pertimeter for triangle rectangle
    public int sizeA;
    public int sizeB;
    public int sizeC;

    public Triangle() {
    }

    public Triangle(TriangleJob job) {
        this.sizeA = job.getSizeA();
        this.sizeB = job.getSizeB();
        this.sizeC = job.getSizeC();
        this.color = job.getColor();
        this.shapeType = job.getShapeType();
    }

    @Override
    public double getPerimeter() {
        return getSizeA() + getSizeB() + getSizeC();
    }

    @Override
    public double getAire() {
        return getSizeB() * getSizeA();
    }

    public int getSizeA() {
        return sizeA;
    }

    public void setSizeA(int sizeA) {
        this.sizeA = sizeA;
    }

    public int getSizeB() {
        return sizeB;
    }

    public void setSizeB(int sizeB) {
        this.sizeB = sizeB;
    }

    public int getSizeC() {
        return sizeC;
    }

    public void setSizeC(int sizeC) {
        this.sizeC = sizeC;
    }
}
