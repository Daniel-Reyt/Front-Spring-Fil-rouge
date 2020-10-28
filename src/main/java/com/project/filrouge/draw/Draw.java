package com.project.filrouge.draw;

import com.project.filrouge.Form.Shape;

import javax.persistence.*;

@Entity
public class Draw {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String name;

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
}
