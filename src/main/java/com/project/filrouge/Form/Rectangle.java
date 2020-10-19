package com.project.filrouge.Form;

import com.project.filrouge.Job.RectangleJob;

import javax.persistence.*;

@Entity
public class Rectangle extends Shape{
    public int length;
    public int width;

    public Rectangle() {
    }

    public Rectangle(RectangleJob job){
        this.length = job.getLength();
        this.width = job.getWidth();
        this.posX = job.getPosX();
        this.posY = job.getPosY();
        this.color = job.getColor();
        this.shapeType = job.getShapeType();
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public double getPerimeter() {
        return (getLength() + getWidth()) * 2;
    }

    @Override
    public double getAire() {
        return getLength() * getWidth();
    }
}
