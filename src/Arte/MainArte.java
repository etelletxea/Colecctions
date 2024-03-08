package Arte;
import java.util.*;
public class MainArte {


    public static void main(String[] args){

        Scanner es = new Scanner(System.in);

        boolean continuar = true;
        int opciones;
        String nombreArtista = " ";
        String pais = " ";
        String nombreObra = " ";
        String tipo = " ";
        int precio;
        int anyo;
        Artista artista;

        LinkedList<Artista> listadoArtistas = new LinkedList<>();
        ArrayList<Obra> listadoObras = new ArrayList<>();


        Artista art=new Artista("Leonardo da Vinci", "Italia");
        Artista art1=new Artista("Picasso", "España");
        art.addArtista(listadoArtistas);
        art1.addArtista(listadoArtistas);
        art1 = new Artista("Auguste Rodin", "Francia");
        art1.addArtista(listadoArtistas);
      //  ListarArtistas(listadoArtistas);

        art1=new Artista("Picasso", "España");
        art1.addArtista(listadoArtistas);
        art1=new Artista("Chillida", "España");
        art1.addArtista(listadoArtistas);

        art1=new Artista("Ibarrola", "España");
        art1.addArtista(listadoArtistas);
        ListarArtistas(listadoArtistas);
        Obra ob=new Obra("Salvator Mundi","Oleo sobre madera",450,1500,art);
        Obra ob1=new Obra("La Gioconda","Oleo sobre madera",870,1500,art);
        ob.addObra(listadoObras);
        ob1.addObra(listadoObras);
    //    ListarObras(listadoObras);
        Obra ob2=new Obra("La Gioconda","Oleo sobre lienzo",890,1520,art);
        ob2.addObra(listadoObras);
        ListarObras(listadoObras);
        do {
            imprimirMenuOpciones();
            System.out.println("Selecciona la opción desesada: ");
            opciones = es.nextInt();
            switch(opciones) {
                case 0:
                    continuar = false;
                    System.out.println("Has salido del programa");
                    break;
                case 1:
                    InsertarObra(listadoArtistas,listadoObras);
                    break;
               case 2:
                   InsertarArtistas(listadoArtistas,listadoObras);
                   break;
                case 3:
                    // Las obras se identifican por su título
                    BuscarObraporTitulo(listadoObras);
                    break;
                case 4:
                    BuscarObraporArtista(listadoObras);
                    break;
                case 5:
                    EliminarObra(listadoObras);
                    break;
                case 6:
                    ob=queryObraBarata(listadoObras);
                    System.out.println(ob.toString());
                    break;
                case 7:
                    ob=queryObraModerna(listadoObras);
                    System.out.println(ob.toString());
                    break;
                case 8:
                    ListarObras(listadoObras);break;
                case 9:
                    ListarArtistas(listadoArtistas);break;
                    default:;
        }

        } while (continuar);
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

    //Añade obra
    public static void InsertarObra(LinkedList<Artista> listadoArtistas,ArrayList<Obra> listadoObras)
    {   Artista artista;
        Obra ob;
        String tipo, nombreArtista;
        int precio,anyo;
        Scanner ej = new Scanner(System.in);
        System.out.println("AÑADIR OBRA: ");
        System.out.print("Nombre de la obra: ");
        String nombreObra = ej.nextLine();
        if (queryObra(nombreObra,listadoObras)==null) {
            System.out.print("Tipo: ");
            tipo = ej.nextLine();
            System.out.print("Nombre del artista que la realizó: ");
            nombreArtista = ej.nextLine();
            System.out.print("Precio (en millones): ");
            precio = ej.nextInt();
            System.out.print("Año de realización: ");
            anyo = ej.nextInt();
            artista = queryArtista(nombreArtista, listadoArtistas);
            if (artista != null) {
                // creo obra y añado
                ob = new Obra(nombreObra, tipo, precio, anyo, artista);
                ob.addObra(listadoObras);
            } else {
                System.out.println("-->Error: El artista " + nombreArtista + " no existe");
            }
        } else System.out.println("-->Error: La obra con título " + nombreObra + " ya existe");
    }

    //Añade artista
    public static void InsertarArtistas(LinkedList<Artista> listadoArtistas,ArrayList<Obra> listadoObras)
    {   String nombreArtista,pais;
        Artista artista;
        Scanner ej2 = new Scanner(System.in);
        do {
            System.out.println("AÑADIR ARTISTA: ");
            System.out.print("Nombre: ");
            nombreArtista = ej2.nextLine();
            artista=queryArtista(nombreArtista,listadoArtistas);
            if (artista!=null)
                System.out.println("Ya existe Artista con ese nombre..");}
        while (artista!=null);
        System.out.print("Nacionalidad: ");
        pais = ej2.nextLine();
        artista = new Artista(nombreArtista, pais);
        if(artista.addArtista(listadoArtistas)<0)
            System.out.println("El artista ya estaba dado de alta");
    }

    //Elimina obra
    public static void EliminarObra(ArrayList<Obra> listadoObras)
    {  String nombreObra;
        Obra ob;
        Scanner ej5 = new Scanner(System.in);
        System.out.println("ELIMINAR OBRA: ");
        System.out.print("Nombre de la obra: ");
        nombreObra = ej5.nextLine();
        ob=queryObra(nombreObra,listadoObras);
        if (ob.removeObra(listadoObras)>0)
            System.out.println("Eliminada");
        else {System.out.println("Obra no existe en la lista");}}

    public static void BuscarObraporTitulo(ArrayList<Obra>listadoObras)
    {   Obra ob;
        String nombreObra;
        Scanner ej3 = new Scanner(System.in);
        System.out.println("BUSCAR Obra por título: ");
        System.out.print("Nombre de la obra: ");
        nombreObra = ej3.nextLine();
        if ((ob=queryObra(nombreObra,listadoObras))!=null){
            System.out.println(ob.toString());
        } else System.out.println("no encontrada");

    }
    public static void BuscarObraporArtista(ArrayList<Obra>listadoObras)
    {
        String nombreArtista;
        Scanner ej4 = new Scanner(System.in);
        System.out.println("BUSCAR Obra por artista : ");
        System.out.print("Nombre del artista: ");
        nombreArtista = ej4.nextLine();
        queryObraArtista(nombreArtista,listadoObras);
    }
    public static void ListarArtistas(LinkedList<Artista> lart)
    {
        Artista art;
        ListIterator it= lart.listIterator();
        while (it.hasNext()){
            art = (Artista) it.next();
            System.out.println("Artista: "+art.getNombre()+"; País: "+art.getNacionalidad());
        }
    }
    public static void ListarObras(ArrayList<Obra> lobra)
    {
        Obra obra;
        ListIterator it= lobra.listIterator();
        while (it.hasNext()){
            obra = (Obra) it.next();
            System.out.println(obra.toString());
        }
    }
    public static Artista queryArtista(String nombreArtista,LinkedList<Artista> lart){
        Artista artista=null;
        Iterator<Artista> it= lart.iterator();
        while (it.hasNext()){
            artista=it.next();
            if (artista.getNombre().equalsIgnoreCase(nombreArtista)){
                return artista;
            }
        }
        return null;
    }
    public static Obra queryObra(String nombreObra,ArrayList<Obra> lobra){
        Obra obra=null;
        Iterator<Obra> it= lobra.iterator();
        while (it.hasNext()){
            obra=it.next();
            if (obra.getNombreObra().equalsIgnoreCase(nombreObra)){
                return obra;
            }
        }
        return null;
    }
    public static void queryObraArtista(String nombreArtista,ArrayList<Obra> lobra){
        Obra obra=null;
        Iterator<Obra> it= lobra.iterator();
        while (it.hasNext()){
            obra=it.next();
            if (obra.getArt().getNombre().equalsIgnoreCase(nombreArtista)){
               System.out.println(obra.toString());
            }
        }
    }

    public static Obra queryObraBarata(ArrayList<Obra> lobra){
        Obra obra=null;
        Obra obrabarata=null;
        int preciobarato=0;
        int i=1;
        Iterator<Obra> it= lobra.iterator();
        while (it.hasNext()){
            obra=it.next();
            if(i==1){preciobarato=obra.getPrecio();
                     obrabarata=obra;i++;}
                if(obra.getPrecio()< preciobarato){
                                preciobarato=obra.getPrecio();
                                obrabarata=obra;
                            }
            }
       return (obrabarata);
    }
    public static Obra queryObraModerna(ArrayList<Obra> lobra){
        Obra obra=null;
        Obra obramoderna=null;
        int anyo=-2000;
        int i=1;
        Iterator<Obra> it= lobra.iterator();
        while (it.hasNext()){
            obra=it.next();
            if(i==1){anyo=obra.getAno();
                obramoderna=obra;i++;}
            if(obra.getAno()> anyo){
                anyo=obra.getAno();
                obramoderna=obra;
            }
        }
        return (obramoderna);
    }
}
