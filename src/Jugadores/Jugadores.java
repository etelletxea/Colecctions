package Jugadores;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Jugadores {

    private String nombre;
    private String tipoPersonaje;

    private String herramienta1, herramienta2, herramienta3;
    private int vida;

    public Jugadores(String nombre, String tipoPersonaje, String herramienta1, String herramienta2, String herramienta3, int vida) {
        this.nombre = nombre;
        this.tipoPersonaje = tipoPersonaje;
        this.herramienta1 = herramienta1;
        this.herramienta2 = herramienta2;
        this.herramienta3 = herramienta3;
        this.vida = vida;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipoPersonaje() {
        return tipoPersonaje;
    }

    public String getHerramienta1() {
        return herramienta1;
    }

    public String getHerramienta2() {
        return herramienta2;
    }

    public String getHerramienta3() {
        return herramienta3;
    }

    public int getVida() {
        return vida;
    }

    @Override
    public String toString() {
        return nombre + " - " + tipoPersonaje + " - " + herramienta1 + ", " + herramienta2 + ", " + herramienta3 + " - " + vida;
    }
}

class MainJugadores {

    static ArrayList<Jugadores> listaJugadores = new ArrayList<>();

    public static void main(String[] args) {

        listaJugadores.add(new Jugadores("Sergio", "Inventor", "Fórmula", "Microoscopio", "Microorganismo", 90));
        listaJugadores.add(new Jugadores("Mara", "Guerrera", "Hacha", "Escudo", "Unicornio", 80));
        listaJugadores.add(new Jugadores("Miquel", "Rastreador", "Lupa", "Escoba", "Dragón", 85));
        listaJugadores.add(new Jugadores("Claudia", "Maga", "Varita", "Libro", "Gata", 110));
        listaJugadores.add(new Jugadores("Carlos", "Sabio", "Varita", "Conjuro", "Búho", 95));
        listaJugadores.add(new Jugadores("Alexia", "Exploradora", "Látigo", "Semillas", "Yegua", 100));

        // ------------------------------------------------------------------------------- //

        Scanner escaner = new Scanner(System.in);

        int personaje;
        int armaPrincipal;
        int armaSecundaria;
        int mascota;
        String nombreAvatar = " ";
        //------------------------//
        String clasePersPrin = " ";
        String armaP = " ";
        String armaS = " ";
        String mascotaPrin = "";
        //-----------------------//
        boolean seguir = false;
        boolean avanzar = true;
        boolean volverJugar = true;

        do {

            do {
                System.out.println("=================================");
                System.out.println("BIENVENIDO AL JUEGO DE ROL DE D&D");
                System.out.println("=================================");

                do {
                    System.out.println("Seleccione la clase para su personaje inicial: ");
                    System.out.println("0 - Inventor");
                    System.out.println("1 - Guerrera");
                    System.out.println("2 - Rastreador");
                    System.out.println("3 - Maga");
                    System.out.println("4 - Sabio");
                    System.out.println("5 - Exploradora");
                    System.out.println("---------------------------------");
                    System.out.print("Elección: ");
                    personaje = escaner.nextInt();

                    if (personaje >= 0 && personaje <= 5) {
                        String[] clasePersonajePrincipal = {"Inventor", "Guerrera", "Rastreador", "Maga", "Sabio", "Exploradora"};
                        clasePersPrin = clasePersonajePrincipal[personaje];
                        seguir = false;
                    } else {
                        System.out.println("Opción introducida no válida. Intente introducir una opción válida:");
                        System.out.println(" ");
                        seguir = true;
                    }
                } while (seguir);

                System.out.println(" ");
                System.out.println("A continuación, seleccione sus 3 objetos para la aventura:");

                do {
                    System.out.println("Arma principal: ");
                    System.out.println("0 - Fórmula");
                    System.out.println("1 - Hacha");
                    System.out.println("2 - Lupa");
                    System.out.println("3 - Varita");
                    System.out.println("4 - Látigo");
                    System.out.println(" -------------------------------- ");
                    System.out.print("Elección: ");
                    armaPrincipal = escaner.nextInt();

                    if (armaPrincipal >= 0 && armaPrincipal <= 4) {
                        String[] armaPrin = {"Fórmula", "Hacha", "Lupa", "Varita", "Látigo"};
                        armaP = armaPrin[armaPrincipal];
                        seguir = false;
                    } else {
                        System.out.println("Opción introducida no válida. Intente introducir una opción válida:");
                        System.out.println(" ");
                        seguir = true;
                    }
                } while (seguir);

                System.out.println(" ");

                do {
                    System.out.println("Arma secundaria: ");
                    System.out.println("0 - Microoscopio");
                    System.out.println("1 - Escudo");
                    System.out.println("2 - Escoba");
                    System.out.println("3 - Libro");
                    System.out.println("4 - Semillas");
                    System.out.println(" -------------------------------- ");
                    System.out.print("Elección: ");
                    armaSecundaria = escaner.nextInt();

                    if (armaSecundaria >= 0 && armaSecundaria <= 4) {
                        String[] armaSec = {"Microoscopio", "Escudo", "Escoba", "Libro", "Semillas"};
                        armaS = armaSec[armaSecundaria];
                        seguir = false;
                    } else {
                        System.out.println("Opción introducida no válida. Intente introducir una opción válida:");
                        System.out.println(" ");
                        seguir = true;
                    }
                } while (seguir);

                System.out.println(" ");

                do {
                    System.out.println("Mascota o acompañante: ");
                    System.out.println("0 - Microorganismo");
                    System.out.println("1 - Yegua");
                    System.out.println("2 - Dragón");
                    System.out.println("3 - Gato");
                    System.out.println("4 - Búho");
                    System.out.println(" -------------------------------- ");
                    System.out.print("Elección: ");
                    mascota = escaner.nextInt();

                    if (mascota >= 0 && mascota <= 4) {
                        String[] mascotaPersPrin = {"Microorganismo", "Yegua", "Dragón", "Gato", "Búho"};
                        mascotaPrin = mascotaPersPrin[mascota];
                        seguir = false;
                    } else {
                        System.out.println("Opción introducida no válida. Intente introducir una opción válida:");
                        System.out.println(" ");
                        seguir = true;
                    }
                } while (seguir);

                System.out.println(" ");
                System.out.print("Introduzca su nombre de aventurero: ");
                nombreAvatar = escaner.next();

                System.out.println(" ");
                System.out.println("Perfecto. Ha finalizado su creación de personaje. Ya está preparado para comenzar su aventura.");
                avanzar = false;

            } while (avanzar);

            boolean continuar = true;
            Random random = new Random();
            int vidaJugadorInicial = random.nextInt(21) + 80;
            int opcionesMenu;


            do {

                System.out.println(" ");
                System.out.println("Menú de opciones para empezar a jugar: ");
                System.out.println("1 - Imprimima sus datos de aventurero (ficha de personaje)");
                System.out.println("2 - Jugar");
                System.out.println("3 - Salir");
                opcionesMenu = escaner.nextInt();

                if (opcionesMenu >= 1 && opcionesMenu <= 3) {

                    switch (opcionesMenu) {

                        case 1:
                            System.out.println("Ficha de personaje principal: " + nombreAvatar + " - " + clasePersPrin + " - " + armaP + ", " + armaS + ", " + mascotaPrin + " - " + vidaJugadorInicial);
                            break;

                        case 2:
                            System.out.println("A continuación luchará contra: ");
                            // JUGADOR ALEATORIO //
                            Random randomJugador = new Random();
                            int jugador = randomJugador.nextInt(5) + 1;
                            System.out.println(listaJugadores.get(jugador).toString());
                            System.out.println(" ");
                            // -------------------- //

                            // HERRAMIENTAS/ARMAS DE JUGADOR PRINCIPAL:
                            Random valorTiradas = new Random();
                            int armaPValor1 = valorTiradas.nextInt(4) + 1;
                            int armaPValor2 = valorTiradas.nextInt(4) + 1;
                            System.out.println("--------- RONDA 1 ----------");
                            System.out.println("Arma Principal (Jugador Inicial) - Valor: " + armaPValor1);
                            System.out.println("Arma Principal (Jugador 1) - Valor: " + armaPValor2);
                            System.out.println(" ");

                            if (armaPValor1 > armaPValor2) {
                                System.out.println("Jugador Inicial gana la primera ronda.");
                                System.out.println("Juagador 1 pierde su arma principal - " + listaJugadores.get(jugador).getHerramienta1());
                                System.out.println(" ");
                                System.out.println("(Jugador Inicial: 1 - Jugador 1: 0)");

                                int armaSValor1 = valorTiradas.nextInt(4) + 1;
                                int armaSValor2 = valorTiradas.nextInt(4) + 1;
                                System.out.println("--------- RONDA 2 ----------");
                                System.out.println("Arma Secundaria (Jugador Inicial) - Valor: " + armaSValor1);
                                System.out.println("Arma Secundaria (Jugador 1) - Valor: " + armaSValor2);
                                System.out.println(" ");

                                if (armaSValor1 > armaSValor2) {
                                    System.out.println("Jugador Inicial gana la segunda ronda.");
                                    System.out.println("Juagador 1 pierde su arma secundaria - " + listaJugadores.get(jugador).getHerramienta2());
                                    System.out.println(" ");
                                    System.out.println("(Jugador Inicial: 2 - Jugador 1: 0)");
                                    System.out.println(" ");
                                    System.out.println("<------ GANA EL JUGADOR INICIAL ------>");
                                    System.out.println(" ");

                                    // SUMAR +10 DE VIDA AL GANADOR
                                    vidaJugadorInicial = vidaJugadorInicial + 10;
                                    System.out.println("Vida Actual del Jugador Inicial: " + vidaJugadorInicial);

                                } else {
                                    System.out.println("Jugador 1 gana la segunda ronda.");
                                    System.out.println("Juagador Inicial pierde su arma secundaria - " + armaS);
                                    System.out.println(" ");
                                    System.out.println("(Jugador Inicial: 1 - Jugador 1: 1)");
                                    System.out.println(" ");

                                    int monturaValor1 = valorTiradas.nextInt(4) + 1;
                                    int monturaValor2 = valorTiradas.nextInt(4) + 1;
                                    System.out.println("--------- RONDA 3 ----------");
                                    System.out.println("Acompañante (Jugador Inicial) - Valor: " + monturaValor1);
                                    System.out.println("Acompañante (Jugador 1) - Valor: " + monturaValor2);
                                    System.out.println(" ");

                                    if (monturaValor1 > monturaValor2) {
                                        System.out.println("Jugador Inicial gana la tercera ronda.");
                                        System.out.println("Jugador 1 pierde su acompañante - " + listaJugadores.get(jugador).getHerramienta3());
                                        System.out.println(" ");
                                        System.out.println("(Jugador Inicial: 2 - Jugador 1: 1)");
                                        System.out.println(" ");
                                        System.out.println("<------ GANA EL JUGADOR INICIAL ------>");
                                        System.out.println(" ");

                                        // SUMAR +10 DE VIDA AL GANADOR
                                        vidaJugadorInicial = vidaJugadorInicial + 10;
                                        System.out.println("Vida Actual del Jugador Inicial: " + vidaJugadorInicial);

                                    } else {
                                        System.out.println("Jugador 1 gana la tercera ronda.");
                                        System.out.println("Jugador Incial pierde su acompañante - " + mascotaPrin);
                                        System.out.println(" ");
                                        System.out.println("(Jugador Inicial: 1 - Jugador 1: 2)");
                                        System.out.println(" ");
                                        System.out.println("<------ GANA EL JUGADOR 1 ------>");
                                        System.out.println(" ");

                                        // SUMAR +10 DE VIDA AL GANADOR
                                        int vidaJugador1 = listaJugadores.get(jugador).getVida();
                                        vidaJugador1 = vidaJugador1 + 10;
                                        System.out.println("Vida Actual del Jugador 1: " + vidaJugador1);

                                    }

                                }

                            } else {
                                System.out.println("Jugador 1 gana la primera ronda.");
                                System.out.println("Juagador Inicial pierde su arma principal - " + armaP);
                                System.out.println(" ");
                                System.out.println("(Jugador Inicial: 0 - Jugador 1: 1)");
                                System.out.println(" ");

                                int armaSValor1 = valorTiradas.nextInt(4) + 1;
                                int armaSValor2 = valorTiradas.nextInt(4) + 1;
                                System.out.println("--------- RONDA 2 ----------");
                                System.out.println("Arma Secundaria (Jugador Inicial) - Valor: " + armaSValor1);
                                System.out.println("Arma Secundaria (Jugador 1) - Valor: " + armaSValor2);
                                System.out.println(" ");

                                if (armaSValor1 > armaSValor2) {
                                    System.out.println("Jugador Inicial gana la segunda ronda.");
                                    System.out.println("Juagador 1 pierde su arma secundaria - " + listaJugadores.get(jugador).getHerramienta2());
                                    System.out.println(" ");
                                    System.out.println("(Jugador Inicial: 1 - Jugador 1: 1)");
                                    System.out.println(" ");

                                    int monturaValor1 = valorTiradas.nextInt(4) + 1;
                                    int monturaValor2 = valorTiradas.nextInt(4) + 1;
                                    System.out.println("--------- RONDA 3 ----------");
                                    System.out.println("Acompañante (Jugador Inicial) - Valor: " + monturaValor1);
                                    System.out.println("Acompañante (Jugador 1) - Valor: " + monturaValor2);
                                    System.out.println(" ");

                                    if (monturaValor1 > monturaValor2) {
                                        System.out.println("Jugador Inicial gana la tercera ronda.");
                                        System.out.println("Juagador 1 pierde su acompañante - " + listaJugadores.get(jugador).getHerramienta3());
                                        System.out.println(" ");
                                        System.out.println("(Jugador Inicial: 2 - Jugador 1: 1)");
                                        System.out.println(" ");
                                        System.out.println("------ GANA EL JUGADOR INICIAL ------");
                                        System.out.println(" ");

                                        // SUMAR +10 DE VIDA AL GANADOR
                                        vidaJugadorInicial = vidaJugadorInicial + 10;
                                        System.out.println("Vida Actual del Jugador Inicial: " + vidaJugadorInicial);

                                    } else {
                                        System.out.println("Jugador 1 gana la tercera ronda.");
                                        System.out.println("Juagador Incicial pierde su acompañante - " + mascotaPrin);
                                        System.out.println(" ");
                                        System.out.println("(Jugador Inicial: 1 - Jugador 1: 2)");
                                        System.out.println(" ");
                                        System.out.println("------ GANA EL JUGADOR 1 ------");
                                        System.out.println(" ");

                                        // SUMAR +10 DE VIDA AL GANADOR
                                        int vidaJugador1 = listaJugadores.get(jugador).getVida();
                                        vidaJugador1 = vidaJugador1 + 10;
                                        System.out.println("Vida Actual del Jugador 1: " + vidaJugador1);

                                    }

                                } else {
                                    System.out.println("Jugador 1 gana la segunda ronda.");
                                    System.out.println("Juagador Inicial pierde su arma secundaria - " + armaS);
                                    System.out.println(" ");
                                    System.out.println("(Jugador Inicial: 0 - Jugador 1: 2)");
                                    System.out.println(" ");
                                    System.out.println("------ GANA EL JUGADOR 1 ------");
                                    System.out.println(" ");

                                    // SUMAR +10 DE VIDA AL GANADOR
                                    int vidaJugador1 = listaJugadores.get(jugador).getVida();
                                    vidaJugador1 = vidaJugador1 + 10;
                                    System.out.println("Vida Actual del Jugador 1: " + vidaJugador1);
                                }

                                break;

                            }

                        case 3:
                            continuar = false;
                            volverJugar = false;
                            System.out.println("Has salido del programa de rol de D&D. Espero que hayas disfrutado.");
                            break;


                    }

                } else {
                    System.out.println("Ha seleccionado una opción del menú no válida");
                }

            } while (continuar);

        } while (volverJugar);

    }


}
