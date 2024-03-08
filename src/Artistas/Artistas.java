package Artistas;

import java.util.*;

public class Artistas {

    private String nombre;
    private String nacionalidad;

    public Artistas(String nombre, String nacionalidad) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    @Override
    public String toString() {
        return nombre + ", " + nacionalidad;
    }

}

class Obras extends Artistas {
    private String nombreObra;
    private String tipo;
    private int precio;
    private int ano;

    public static ArrayList<Artistas> listadoArtistas = new ArrayList<>();

    public Obras(String nombre, String nacionalidad, String nombreObra, String tipo, int precio, int ano) {
        super(nombre, nacionalidad);
        this.nombreObra = nombreObra;
        this.tipo = tipo;
        this.precio = precio;
        this.ano = ano;
        listadoArtistas = new ArrayList<>();
    }

    public String getNombreObra() {
        return nombreObra;
    }

    public String getTipo() {
        return tipo;
    }

    public int getPrecio() {
        return precio;
    }

    public int getAno() {
        return ano;
    }

    @Override
    public String toString() {
        return nombreObra + ", " + tipo + ", " + precio + ", " + ano + ", " + getNombre();
    }

    //BUSCAR ARTISTA POR OBJETO ARTISTA
    public static int findArtista(Artistas encuentraArtista) {
        return listadoArtistas.indexOf(encuentraArtista);
    }

    //BUSCAR ARTISTA POR NOMBRE
    public static int findArtista(String encuentraArtista) {
        for (int i = 0; i < listadoArtistas.size(); i++) {
            if (listadoArtistas.get(i).getNombre().equalsIgnoreCase(encuentraArtista)) {
                return i;
            }
        }
        return -1;
    }

    //IMPRIMIR LISTA DE ARTISTAS
    public static void printArtistas() {
        for (int i = 0; i < listadoArtistas.size(); i++) {
            System.out.println(listadoArtistas.get(i).toString());
        }
    }

}

class MainObras {

    static ArrayList<Obras> listadoObras = new ArrayList<>();

    //BUSCAR OBRA POR OBJETO OBRA -> SE USA PARA LLAMARSE EN EL MÉTODO DE ELIMINAR UNA OBRA DE LA LISTA
    public static int findObra(Obras encuentraObra) {
        return listadoObras.indexOf(encuentraObra);
    }

    //BUSCAR OBRA POR NOMBRE DE OBRA
    public static int findObra(String encuentraObra) {
        for (int i = 0; i < listadoObras.size(); i++) {
            if (listadoObras.get(i).getNombreObra().equalsIgnoreCase(encuentraObra)) {
                return i;
            }
        }
        return -1;
    }

    //ELIMINAR OBRA DE LA LISTA DE OBRAS
    public static boolean removeObra(Obras obra) {
        if (findObra(obra) >= 0) {
            listadoObras.remove(obra);
            return true;
        } else {
            return false;
        }
    }

    //ENCONTRAR OBRA MÁS BARATA
    public static Obras obraMasBarata(ArrayList<Obras> listadoObras) {
        Obras obraMasBarata = listadoObras.get(0);
        for (int i = 0; i < listadoObras.size(); i++) {
            Obras obraActual = listadoObras.get(i);
            if (obraActual.getPrecio() < obraMasBarata.getPrecio()) {
                obraMasBarata = obraActual;
            }
        }
        return obraMasBarata;
    }

    //ENCONTRAR OBRA MÁS MODERNA

    public static Obras obraMasModerna(ArrayList<Obras> listadoObras) {
        Obras obraMasModerna = listadoObras.get(0);
        for (int i = 0; i < listadoObras.size(); i++) {
            Obras obraActual = listadoObras.get(i);
            if (obraActual.getAno() > obraMasModerna.getAno()) {
                obraMasModerna = obraActual;
            }
        }
        return obraMasModerna;
    }

    //IMPRIMIR MENÚ DE OPCIONES
    public static void imprimirMenuOpciones() {

        System.out.println(" ");
        System.out.println("LISTADO OBRAS: ");
        System.out.println(" 1 - Añadir obra");
        System.out.println(" 2 - Añadir artista");
        System.out.println(" 3 - Buscar obra por nombre");
        System.out.println(" 4 - Buscar obras por artista");
        System.out.println(" 5 - Eliminar obra");
        System.out.println(" 6 - Encontrar obra más barata");
        System.out.println(" 7 - Encontrar obra más moderna");
        System.out.println(" 8 - Mostrar listado obras");
        System.out.println(" 9 - Mostrar listado artistas");
        System.out.println(" 0 - SALIR");
        System.out.println("----------------------------------");

    }

    public static void main(String[] args) {

        Scanner es = new Scanner(System.in);

        boolean continuar = true;
        int opciones;
        String nombre = " ";
        String nacionalidad = " ";
        String nombreObra = " ";
        String tipo = " ";
        int precio;
        int ano;

        try {
            do {

                imprimirMenuOpciones();
                System.out.println("Selecciona la opción desesada: ");
                opciones = es.nextInt();

                if (opciones >= 0 && opciones <= 9) {
                    switch (opciones) {

                        case 1:
                            Scanner ej = new Scanner(System.in);
                            System.out.println("AÑADIR OBRA: ");
                            System.out.print("Nombre del artista que la realizó: ");
                            nombre = ej.nextLine();
                            System.out.print("Nombre de la obra: ");
                            nombreObra = ej.nextLine();
                            System.out.print("Tipo: ");
                            tipo = ej.nextLine();
                            System.out.print("Precio (en millones): ");
                            precio = ej.nextInt();
                            System.out.print("Año de realización: ");
                            ano = ej.nextInt();

                            if (findObra(nombre) >= 0) {
                                System.out.println("Error, no se puede agregar esta obra porque ya está incluido dentro de nuestra lista");
                            } else {
                                listadoObras.add(new Obras(nombre, nacionalidad, nombreObra, tipo, precio, ano));
                                System.out.println("Obra: '" + nombreObra + "', de tipo '" + tipo + "' con precio '" + precio + " millones' y año de realización '" + ano + "' del artísta '" + nombre + "' se ha agregado con éxito al listado de obras.");
                            }
                            break;

                        case 2:
                            Scanner ej2 = new Scanner(System.in);
                            System.out.println("AÑADIR ARTISTA: ");
                            System.out.print("Nombre: ");
                            nombre = ej2.nextLine();
                            System.out.print("Nacionalidad: ");
                            nacionalidad = ej2.nextLine();

                            if (Obras.findArtista(nombre) >= 0) {
                                System.out.println("Error, no se puede agregar este artísta porque ya está incluido dentro de nuestra lista");
                            } else {
                                Obras.listadoArtistas.add(new Artistas(nombre, nacionalidad));
                                System.out.println("Artista: " + nombre + ", de nacionalidad " + nacionalidad + " se ha agregado con éxito al listado de artistas.");
                            }
                            break;

                        case 3:
                            Scanner ej3 = new Scanner(System.in);
                            System.out.println("BUSCAR OBRA POR NOMBRE: ");
                            System.out.print("Introduce el nombre de la obra que desea buscar: ");
                            nombreObra = ej3.nextLine();

                            if (findObra(nombreObra) >= 0) {
                                System.out.println(listadoObras.get(findObra(nombreObra)));
                            } else {
                                System.out.println("No se ha podído encontrar una obra con ese nombre. Por favor inténtelo de nuevo.");
                            }
                            break;

                        case 4:
                            Scanner ej4 = new Scanner(System.in);
                            System.out.println("BUSCAR OBRA POR ARTISTA: ");
                            System.out.print("Introduce el nombre del artista para buscar sus obras: ");
                            nombre = ej4.nextLine();

                            for (int i = 0; i < listadoObras.size(); i++) {
                                if (listadoObras.get(i).getNombre().equalsIgnoreCase(nombre)) {
                                    System.out.println(listadoObras.get(i).toString());
                                }
                            }
                            break;

                        case 5:
                            Scanner ej5 = new Scanner(System.in);
                            System.out.println("ELIMINAR OBRA: ");
                            System.out.print("Introduce el nombre de la obra que desea eliminar: ");
                            nombreObra = ej5.nextLine();

                            if (findObra(nombreObra) >= 0) {
                                removeObra(listadoObras.get(findObra(nombreObra)));
                                System.out.println("Se ha eliminado con éxito la obra con nombre: " + nombreObra);
                            } else {
                                System.out.println("El nombre de la obra introducida no exíste, intentelo de nuevo.");
                            }

                            break;

                        case 6:
                            System.out.println("ENCONTRAR OBRA MÁS BARATA: ");
                            System.out.println(obraMasBarata(listadoObras));
                            break;

                        case 7:
                            System.out.println("ENCONTRAR OBRA MÁS MODERNA: ");
                            System.out.println(obraMasModerna(listadoObras));
                            break;

                        case 8:
                            System.out.println("LISTADO DE OBRAS: ");
                            if (listadoObras.isEmpty()) {
                                System.out.println("La lista de obras está vacía actualmente.");
                            }
                            for (int i = 0; i < listadoObras.size(); i++) {
                                System.out.println(listadoObras.get(i).toString());
                            }
                            break;

                        case 9:
                            System.out.println("LISTADO DE ARTISTAS: ");
                            if (Obras.listadoArtistas.isEmpty()) {
                                System.out.println("La lista de artistas está vacía actualmente.");
                            }
                            Obras.printArtistas();
                            break;

                        case 0:
                            continuar = false;
                            System.out.println("Has salido del programa");
                            break;

                    }
                }


            } while (continuar);
        } catch (InputMismatchException e) {
            System.out.println("Error. Opción del menú introducido no válido");
        }

    }

}
