package Maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainMaps {
    private static Map<String, Integer> ubicaciones= new HashMap<>();

    public static void main(String[] args) {

     Ubicacion ubicacion,ubicacion1,ubicacion2,ubicacion3,ubicacion4,ubicacion5,lugar;
     ArrayList<Ubicacion> lugares=new ArrayList<>();
     String opcion;
     int idubi=1;
     Scanner scanner=new Scanner(System.in);
     ubicacion=new Ubicacion(0,"Sentado en la clase de programación",ubicaciones);
     ubicacion1=new Ubicacion(1,"En la cima de la montaña",ubicaciones);
     ubicacion2=new Ubicacion(2,"Bañandote en la playa",ubicaciones);
     ubicacion3=new Ubicacion(3,"Demtro de un edificio muy alto",ubicaciones);
     ubicacion4=new Ubicacion(4,"De pie en un puente",ubicaciones);
     ubicacion5=new Ubicacion(5,"Estás en un bosque",ubicaciones);
     // ubicación 1
     ubicacion1.addExit("N",5);
     ubicacion1.addExit("O",2);
     ubicacion1.addExit("E",3);
     ubicacion1.addExit("S",4);
     ubicacion1.addExit("Q",0);
     //ubicacion 2
        ubicacion2.addExit("N",5);
        ubicacion2.addExit("Q",0);
     //ubicacion 3
        ubicacion3.addExit("O",1);
        ubicacion3.addExit("Q",0);
        // ubicación 4
        ubicacion4.addExit("Q",0);
        ubicacion4.addExit("N",1);
        ubicacion4.addExit("O",2);
        // ubicacion 5
        ubicacion5.addExit("Q",0);
        ubicacion5.addExit("S",1);
        ubicacion5.addExit("O",2);

        lugares.add(ubicacion);
        lugares.add(ubicacion1);
        lugares.add(ubicacion2);
        lugares.add(ubicacion3);
        lugares.add(ubicacion4);
        lugares.add(ubicacion5);

        do{
            lugar=findUbicacion(idubi,lugares);
            //Mejorar presentación y realizar un try catch para controlar excepciones

            do
            {  System.out.println(lugar.toString());
                //lugar.MostrarSalidas(lugares);
               System.out.println("INPUT - ");
               opcion=scanner.nextLine();
               idubi=lugar.irAubicacion(opcion);
            if (idubi==-1)
               System.out.println("Salida no válida");}
            while (idubi==-1);
        }while (idubi!=0);

        //Muestro salida
        lugar=findUbicacion(idubi,lugares);
        System.out.println(lugar.toString());
        //lugar.MostrarSalidas(lugares);
    }

    public static void MostrarUbicacion(int id,ArrayList<Ubicacion> lugares)
    {   String clave;
        Integer valor;
        System.out.println("Estás en "+id+" - "+lugares.get(id).getDescripcion());
        System.out.println("Posibles salidas");
        for (Map.Entry<String, Integer> entradaMapa: lugares.get(id).getExits().entrySet()) {
            clave=entradaMapa.getKey();
            valor=entradaMapa.getValue();
            System.out.print(clave + " " );
        }
        System.out.print("\n");
    }
    public static Ubicacion findUbicacion(int id,ArrayList<Ubicacion> lugares)
    {
        if (lugares.isEmpty() || (id>=lugares.size() || id<0))
            return null;
        else {
            return lugares.get(id);
        }
    }
}
