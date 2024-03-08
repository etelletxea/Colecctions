package LinkedList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class MainLugaresList {
    public static void main(String[] args) {

        LinkedList<String> sitios = new LinkedList<>();
        LinkedList<String> personas= new LinkedList<>();

        sitios.add("Roma");
        sitios.add("Lisboa");
        sitios.addLast("Estocolmo");
        sitios.add("Paris");
        sitios.add("Berlin");
        sitios.add("Oslo");
        sitios.addFirst("Madrid");

       // System.out.println(sitios);

        for (String lugar:sitios)
        { System.out.println(lugar);}

        System.out.println("Son "+sitios.size()+" elementos");
        printList(sitios);


        addInOrder(personas,"Luis");
        addInOrder(personas,"Bea");
        addInOrder(personas,"Ana");
        addInOrder(personas,"Maria");
        printList(personas);

        /*
        printList(sitios);
        visitarLugar(sitios);
        */

    }

    public static void printList(LinkedList<String> sitios) {
        Iterator<String> it = sitios.iterator();
        while (it.hasNext()) {
            System.out.println("Nodo: " + it.next());
        }
        System.out.println("-----");
    }
    private static boolean addInOrder(LinkedList<String> lugares, String newItem) {
        ListIterator<String> it = lugares.listIterator();
        while (it.hasNext()) {
            int comparacion = it.next().compareTo(newItem);
            if (comparacion == 0) {
                //no queremos añadir porque no queremos tener duplicados
                System.out.println("el lugar " + newItem + " ya está incluido");
                return false;
            } else if (comparacion > 0) { //newItem es más pequeño
                if (it.hasPrevious()){
                it.previous();
                it.add(newItem);
                return true;}

            }
        }
        it.add(newItem);
        return true;
    }
    public static void visitarLugar(LinkedList<String> lugares) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        ListIterator<String> it = lugares.listIterator();

        if (lugares.isEmpty()) {
            System.out.println("No hay lugares visitados");
            return;
        } else {
            System.out.println("Visitando " + it.next());
            imprimirMenu();
        }

        boolean haciaAdelante = true;
        while(continuar) {
            int opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 0:
                    System.out.println("Se acabaron las vacaciones");
                    continuar = false;
                    break;
                case 1:
                    if (!haciaAdelante) {
                        if (it.hasNext())
                            it.next();
                        haciaAdelante = true;
                    }
                    if (it.hasNext()) {
                        System.out.println("Visitando " + it.next());
                    } else {
                        System.out.println("Ya no hay más ciudades");
                        haciaAdelante = false;
                    }
                    break;
                case 2:
                    if(haciaAdelante) {
                        if (it.hasPrevious())
                            it.previous();
                        haciaAdelante = false;
                    }
                    if (it.hasPrevious()) {
                        System.out.println("Visitando " + it.previous());
                    } else {
                        System.out.println("Primera ciudad");
                        haciaAdelante = true;
                    }
                    break;
                case 3:
                    imprimirMenu();
                    break;
            }
        }
    }

    public static void imprimirMenu() {
        System.out.println("0 - Para salir\n" +
                "1 - para ir a la siguiente ciudad\n" +
                "2 - para ir a la ciudad anterior\n" +
                "3 - imprimir el menú");
    }
        /*LugaresList lugares=new LugaresList(sitios);
        lugares.addLugar("Roma");
        lugares.addLugar("Paris");
        lugares.addLugar("Amsterdam");
        lugares.addLugar("Toronto");
        lugares.addLugar("Miami");
        */
        //lugares.printList();
        /*
        public void printList(LinkedList<String> lugares) {
            Iterator<String> it= lugares.iterator();
            while (it.hasNext()){
                System.out.println("Nodo: "+it.next());
            }
            System.out.println("------");
        }

         */
    }

