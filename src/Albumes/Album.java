package Albumes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Album {
    private String nombre;
    private String artista;
    private ArrayList<Song> canciones;

    Album(String name, String artist) {
        nombre = name;
        artista = artist;
        canciones = new ArrayList<Song>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getArtista() {
        return artista;
    }

    public boolean addSong(String titulo, double duracion) {
        boolean add_ok = true;
        Song cancion = findsong(titulo);
        if (cancion == null) {
            cancion = new Song(titulo, duracion);
            canciones.add(cancion);
        } else {
            add_ok = false;
        }
        return add_ok;
    }

    private Song findsong(String titulo) {
        Song cancion = null;
        String nombre;
        for (int i = 0; i < canciones.size(); i++) {
            nombre = canciones.get(i).getTitulo();
            if (nombre.equals(titulo)) {
                cancion = canciones.get(i);
            }
        }
        return cancion;
    }

    // Ejemplo de recorrido de una ArrayList con iterator
    public void getSongsFromInside() {
        Iterator<Song> canc = canciones.iterator();
        while (canc.hasNext()) {
            System.out.println("    " + canc.next().getTitulo());
        }
    }

    public void printAlbum() {
        int i = 0;
        System.out.println("Nombre Album: " + getNombre());
        System.out.println("Artista: " + getArtista());

        for (i = 0; i < canciones.size(); i++) {
            System.out.println("Título: " + canciones.get(i).getTitulo());
            System.out.println("Duracion: " + canciones.get(i).getDuracion());
        }
        System.out.println("=============================");
    }

    public boolean addToPlaylist(int trackNumber, LinkedList<Song> playlist) {
        int index = trackNumber - 1;
        if ((index > 0) && (index <= this.canciones.size())) {

            playlist.add(this.canciones.get(index));
            return true;
        }
        System.out.println("Este album no contiene este número de pista: " + trackNumber);
        return false;
    }

    //LinkedList<Song> playlist
    public boolean addToPlaylist(String songTittle, LinkedList<Song> playlist) {
        Song checkedSong = findsong(songTittle);
        if (checkedSong != null) {
            playlist.add(checkedSong);
            System.out.println("Canción " + songTittle + " añadida a la  playlist");
            return true;
        }
        System.out.println("Can not find song");
        return false;
    }

}

