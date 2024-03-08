package vuelos;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class MainVuelos {
    static Scanner escaner = new Scanner(System.in);
    static boolean error = false;
    static ArrayList<vuelos> listado = new ArrayList<>();

    public static void main(String[] args) {

        listado.add(new vuelos("2020-01", "Valencia", "Menorca", "15-08", "turista"));
        listado.add(new vuelos("2020-02", "Valencia", "Tenerife", "20-08", "turista"));
        listado.add(new vuelos("2020-03", "París", "Valencia", "15-08", "primera"));
        listado.add(new vuelos("2020-04", "Atenas", "Valencia", "20-08", "primera"));

        boolean continuar = true;
        int opciones;
        String valor = "";
        String clave = "";
        String numero = "";
        String origen = "";
        String destino = "";
        String dia = "";
        String clase = "";
        Scanner es = new Scanner(System.in);

        try {
            do {

                imprimirMenuOpciones();
                System.out.println("Dame la opción: ");
                opciones = escaner.nextInt();

                if (opciones >= 0 && opciones <= 5) {
                    switch (opciones) {

                        case 0:
                            continuar = false;
                            System.out.println("Has salido del programa de vuelos del aeropuerto de Valencia");
                            break;

                        case 1:
                            if (listado.isEmpty()) {
                                System.out.println("La lista de vuelos está vacía");
                            } else {
                                for (vuelos vuelo : listado) {
                                    System.out.println(vuelo.toString());
                                }
                            }
                            break;

                        case 2:
                            System.out.println("BUSCAR POR Nª DE VUELO:");
                            System.out.print("Número de vuelo: ");
                            valor = es.next().toLowerCase(Locale.ROOT);

                            if (queryVuelos(valor, listado) == null) {
                                System.out.println("El número de vuelo " + valor + " no existe.");
                            } else {
                                findVuelos2(valor, listado);
                            }
                            break;

                        case 3:
                            System.out.println("BUSCAR POR CLAVE:");
                            System.out.print("Clave: ");
                            clave = es.nextLine().toLowerCase(Locale.ROOT);
                            System.out.print("Valor: ");
                            valor = es.nextLine().toLowerCase(Locale.ROOT);

                            switch (clave) {

                                case "numero":
                                    for (int i = 0; i < listado.size(); i++) {
                                        if (listado.get(i).getNumeroVuelo().toLowerCase().equals(valor)) {
                                            System.out.println(listado.get(i));
                                        }
                                    }
                                    break;

                                case "origen":
                                    for (int i = 0; i < listado.size(); i++) {
                                        if (listado.get(i).getOrigenVuelo().toLowerCase().equals(valor)) {
                                            System.out.println(listado.get(i));
                                        }
                                    }
                                    break;

                                case "destino":
                                    for (int i = 0; i < listado.size(); i++) {
                                        if (listado.get(i).getDestinoVuelo().toLowerCase().equals(valor)) {
                                            System.out.println(listado.get(i));
                                        }
                                    }
                                    break;

                                case "dia":
                                    for (int i = 0; i < listado.size(); i++) {
                                        if (listado.get(i).getDiaVuelo().toLowerCase().equals(valor)) {
                                            System.out.println(listado.get(i));
                                        }
                                    }

                                    break;

                                case "clase":
                                    for (int i = 0; i < listado.size(); i++) {
                                        if (listado.get(i).getClaseVuelo().toLowerCase().equals(valor)) {
                                            System.out.println(listado.get(i));
                                        }
                                    }
                                    break;

                            }
                        case 4:
                            System.out.println("AÑADIR NUEVO VUELO:");
                            System.out.print("Número: ");
                            numero = es.next().toLowerCase(Locale.ROOT);
                            System.out.print("Origen: ");
                            origen = es.next().toLowerCase(Locale.ROOT);
                            System.out.print("Destino: ");
                            destino = es.next().toLowerCase(Locale.ROOT);
                            System.out.print("Día: ");
                            dia = es.next().toLowerCase(Locale.ROOT);
                            System.out.print("Clase: ");
                            clase = es.next().toLowerCase(Locale.ROOT);
                            listado.add(new vuelos(numero, origen, destino, dia, clase));
                            System.out.println("Vuelo: número: " + numero + " ,origen: " + origen + ", destino: " + destino + ", día: " + dia + ", clase: " + clase + " se ha añadido con éxito a la lista.");

                            break;

                        case 5:
                            System.out.println("BORRAR VUELO: ");
                            System.out.println("Introduzca número de vuelo: ");
                            valor = es.next().toLowerCase(Locale.ROOT);

                            if (queryVuelos(valor, listado) != null) {
                                removeVuelos(queryVuelos(valor, listado));
                                System.out.println("Vuelo nª " + valor + " ha sido eliminado.");
                            } else {
                                System.out.println("El nª de vuelo introducido no existe, por lo tanto no se ha podído eliminar.");
                            }

                            break;

                    }
                }


            } while (continuar);
        } catch (InputMismatchException e) {
            System.out.println("Error. Opción del menú introducido no válido");
        }

    }

    public static void imprimirMenuOpciones() {

        System.out.println(" ");
        System.out.println("=================================");
        System.out.println("VUELOS DEL AEROPUERTO DE VALENCIA");
        System.out.println("=================================");
        System.out.println(" 1 - Imprimir todos los vuelos");
        System.out.println(" 2 - Buscar un número de vuelo");
        System.out.println(" 3 - Buscar vuelo por clave");
        System.out.println(" 4 - Añadir vuelo nuevo");
        System.out.println(" 5 - Borrar vuelo por número");
        System.out.println(" 0 - SALIR");
        System.out.println("----------------------------------");

    }

    public static int findVuelos(vuelos vuelo) {
        return listado.indexOf(vuelo);
    }

    public static int findVuelos(String valor, ArrayList<vuelos> listado) {

        for (int i = 0; i < listado.size(); i++) {
            if (listado.get(i).getNumeroVuelo().toLowerCase().equals(valor)) {
                return i;
            }
        }
        return -1;
    }

    public static void findVuelos2(String valor, ArrayList<vuelos> listado) {

        for (int i = 0; i < listado.size(); i++) {
            if (listado.get(i).getNumeroVuelo().toLowerCase().equals(valor)) {
                System.out.println(listado.get(i));
            }
        }
    }


    public static vuelos queryVuelos(String numeroVuelo, ArrayList<vuelos> listado) {
        int indice = findVuelos(numeroVuelo, listado);
        if (indice >= 0) {
            return listado.get(indice);
        } else {
            return null;
        }
    }

    public static boolean removeVuelos(vuelos vuelo) {
        if (findVuelos(vuelo) >= 0) {
            listado.remove(vuelo);
            return true;
        } else {
            return false;
        }
    }


}
