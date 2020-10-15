package com.project.filrouge.Form;

import javax.persistence.*;
import java.util.List;

@Entity
public abstract class Shape {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    Integer id;

    String name;
    int faces;

    int dessin;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFaces() {
        return faces;
    }

    public void setFaces(int faces) {
        this.faces = faces;
    }
    public abstract double getPerimeter();
    public abstract double getAire();

    public int getDessin() {
        return dessin;
    }

    public void setDessin(int dessin) {
        this.dessin = dessin;
    }
}
