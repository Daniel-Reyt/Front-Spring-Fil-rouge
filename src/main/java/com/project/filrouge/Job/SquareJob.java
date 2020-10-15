package com.project.filrouge.Job;

public class SquareJob {
    String name;
    int size;
    int Dessin;
    double aire;
    double perimeter;

    public double setAire() {
        this.aire = getSize() * getSize();
        return this.aire;
    }

    public double setPerimeter() {
        this.perimeter = getSize() * 4;
        return this.perimeter;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId_dessin() {
        return Dessin;
    }
}
