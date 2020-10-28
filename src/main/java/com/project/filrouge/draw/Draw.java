package com.project.filrouge.draw;

import com.project.filrouge.Form.Shape;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Draw {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String name;

    @OneToMany
    public List<Shape> shapes = new ArrayList<>();

    public Draw() {

    }

    public Draw(DrawJob job) {
        this.name = job.getName();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Shape> getShapes() {
        return shapes;
    }

    public void setShapes(List<Shape> shapes) {
        this.shapes = shapes;
    }
}
