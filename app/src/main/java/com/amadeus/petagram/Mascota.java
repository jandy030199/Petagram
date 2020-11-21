package com.amadeus.petagram;

public class Mascota {

    private String nombre;
    private int nroLikes;
    private int foto;

    public Mascota(String nombre, int nroLikes, int foto) {
        this.nombre = nombre;
        this.nroLikes = nroLikes;
        this.foto = foto;
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
}
