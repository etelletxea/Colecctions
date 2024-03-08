package Arte;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Artista {
    private String nombre;
    private String nacionalidad;

    public Artista(String nombre, String nacionalidad) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }


    public Artista findArtista(LinkedList<Artista> lart)
    {   Artista artista=null;
        Iterator<Artista> it= lart.listIterator();
        while (it.hasNext()){
            artista=it.next();
            if (artista.getNombre().equals(this.getNombre()))
                return artista;
        }
        return null;
    }
    public int addArtista(LinkedList<Artista> lart)
    {
        if(findArtista(lart) ==null)
        {lart.add(this); return 1;}
        else return (-1);
    }
    @Override
    public String toString() {
        return nombre + ", " + nacionalidad;
    }


}
