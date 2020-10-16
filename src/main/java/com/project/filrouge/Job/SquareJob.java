package com.project.filrouge.Job;

public class SquareJob {
    int width;
    int Dessin;
    double aire;
    double perimeter;
    int posX;
    int posY;

    public double setAire() {
        this.aire = getwidth() * getwidth();
        return this.aire;
    }

    public double setPerimeter() {
        this.perimeter = getwidth() * 4;
        return this.perimeter;
    }

    public int getwidth() {
        return width;
    }

    public void setwidth(int width) {
        this.width = width;
    }


    public int getId_dessin() {
        return Dessin;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
}
