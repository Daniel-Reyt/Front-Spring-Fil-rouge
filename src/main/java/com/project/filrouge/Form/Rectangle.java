package com.project.filrouge.Form;

import com.project.filrouge.Job.RectangleJob;

import javax.persistence.*;

@Entity
public class Rectangle extends Shape{
    public int length;
    public int width;
    public double perimeter;
    public double aire;

    public Rectangle() {
    }

    public Rectangle(RectangleJob job){
        this.length = job.getLength();
        this.width = job.getWidth();
        this.perimeter = getPerimeter();
        this.aire = getAire();
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
