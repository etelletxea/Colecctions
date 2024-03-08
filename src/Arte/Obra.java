package Arte;

import java.util.*;

public class Obra {
    private String nombreObra;
    private String tipo;
    private int precio;
    private int ano;
    private Artista art;

    public Obra(String nombreObra, String tipo, int precio, int ano, Artista art) {
        this.nombreObra = nombreObra;
        this.tipo = tipo;
        this.precio = precio;
        this.ano = ano;
        this.art = art;
    }

    public String getNombreObra() {
        return nombreObra;
    }

    public void setNombreObra(String nombreObra) {
        this.nombreObra = nombreObra;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Artista getArt() {
        return art;
    }

    public void setArt(Artista art) {
        this.art = art;
    }
    public Obra findObra(ArrayList<Obra> obra)
    {
        Iterator<Obra> it= obra.listIterator();
        Obra obr=null;
        while (it.hasNext()){
            obr=it.next();
            if (obr.getNombreObra().equals(this.getNombreObra())) return obr;
        }
        return null;
    }
    public int addObra(ArrayList<Obra> lobra)
    {
        if(findObra(lobra)==null)
        { lobra.add(this);return 1;}
        else return (-1);
    }
    public int removeObra(ArrayList<Obra> lobra)
    {
        if(findObra(lobra)!=null)
        { lobra.remove(this);return 1;}
        else return (-1);
    }
    @Override
    public String toString() {
        return "Obra{" +
                "nombreObra='" + nombreObra + '\'' +
                ", tipo='" + tipo + '\'' +
                ", precio=" + precio +
                ", ano=" + ano +
                ", art=" + art +
                '}';
    }
}
