package com.project.filrouge.Form;

import javax.persistence.*;
import java.util.List;

@Entity
public abstract class Shape {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    Integer id;

    int dessin;

    int posX;
    int posY;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public abstract double getPerimeter();
    public abstract double getAire();

    public int getDessin() {
        return dessin;
    }

    public void setDessin(int dessin) {
        this.dessin = dessin;
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
