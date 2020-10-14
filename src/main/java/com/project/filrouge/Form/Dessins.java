package com.project.filrouge.Form;

import javax.persistence.*;
import java.sql.DatabaseMetaData;
import java.util.List;

@Entity
public abstract class Dessins {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(table = "Shape")
    private int id_dessin;

    private String nameDessin;

    public Dessins() {
    }

    public Dessins(int id_dessin, String nameDessin) {
        this.id_dessin = id_dessin;
        this.nameDessin = setNameDessin(nameDessin);
    }

    public String setNameDessin(String nameDessin) {
        this.nameDessin = nameDessin;
        return nameDessin;
    }
}
