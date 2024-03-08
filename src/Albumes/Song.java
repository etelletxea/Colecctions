package Albumes;

public class Song {
    private String titulo;
    private double duracion;

    Song(String titulo, double duracion) {
        this.titulo = titulo;
        this.duracion = duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getDuracion() {
        return duracion;
    }

    @Override
    public String toString() {
        return "titulo: " + titulo +
                " duracion: " + duracion;
    }
}
