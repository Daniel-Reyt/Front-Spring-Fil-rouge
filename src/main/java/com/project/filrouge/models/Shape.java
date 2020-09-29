package com.project.filrouge.models;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


public class Shape {
    int sides;
    String name;

    public int getSides() {
        return sides;
    }

    public String getName() {
        return name;
    }

    public int setSides(int sides) {
        this.sides = sides;
        return sides;
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }

}
