package com.amadeus.petagram.pojo;

public class Mascota {

    private String nombre;
    private int nroLikes = 0;
    private int foto;
    private int id;

    public Mascota(String nombre, int nroLikes, int foto, int id) {
        this.nombre = nombre;
        this.nroLikes = nroLikes;
        this.foto = foto;
        this.id = id;
    }

    public Mascota() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNroLikes() {
        return nroLikes;
    }

    public void setNroLikes(int nroLikes) {
        this.nroLikes = nroLikes;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
