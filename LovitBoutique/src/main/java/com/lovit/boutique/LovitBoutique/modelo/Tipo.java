package com.lovit.boutique.LovitBoutique.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tipo {

    @Id
    @Column(name = "id_tipo")
    private Integer id;

    private String titulo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Tipo(Integer id, String titulo) {
        super();
        this.id = id;
        this.titulo = titulo;
    }

    public Tipo() {
        super();
    }

    public Tipo(String titulo) {
        super();
        this.titulo = titulo;
    }

    public Tipo(Integer id) {
        super();
        this.id = id;
    }


}
