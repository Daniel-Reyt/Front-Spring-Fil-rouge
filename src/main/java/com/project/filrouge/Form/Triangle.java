package com.project.filrouge.Form;

import com.project.filrouge.Job.TriangleJob;

import javax.persistence.*;

@Entity
public class Triangle extends Shape {
    int aPosX;
    int aPosY;
    int bPosX;
    int bPosY;
    int cPosX;
    int cPosY;

    public Triangle() {
    }

    public Triangle(TriangleJob job) {
        this.aPosX = job.getPointAposX();
        this.bPosX = job.getPointBposX();
        this.cPosX = job.getPointCposX();
        this.aPosY = job.getPointAposY();
        this.bPosY = job.getPointBposY();
        this.cPosY = job.getPointCposY();
        this.color = job.getColor();
        this.shapeType = job.getShapeType();
    }

    @Override
    public double getPerimeter() {
        return 0;
    }

    @Override
    public double getAire() {
        return 0;
    }

    public int getaPosX() {
        return aPosX;
    }

    public void setaPosX(int aPosX) {
        this.aPosX = aPosX;
    }

    public int getaPosY() {
        return aPosY;
    }

    public void setaPosY(int aPosY) {
        this.aPosY = aPosY;
    }

    public int getbPosX() {
        return bPosX;
    }

    public void setbPosX(int bPosX) {
        this.bPosX = bPosX;
    }

    public int getbPosY() {
        return bPosY;
    }

    public void setbPosY(int bPosY) {
        this.bPosY = bPosY;
    }

    public int getcPosX() {
        return cPosX;
    }

    public void setcPosX(int cPosX) {
        this.cPosX = cPosX;
    }

    public int getcPosY() {
        return cPosY;
    }

    public void setcPosY(int cPosY) {
        this.cPosY = cPosY;
    }
}
