package Albumes;

import java.util.*;


public class MainList {

    private static ArrayList<Album> album_arr = new ArrayList<>(); // PRIVATE STATIC
    private static LinkedList<Album> albums = new LinkedList<>();

    // ^ NON STATIC FIELD ALBUMS CAN NOT BE REFERENCE FROM A STATIC CONTEX

    public static void main(String[] args) {


// ADDING SONGS
        Album albumA = new Album("Sailing to Philadelphia", "Mark Knopfler");
        albumA.addSong("What it is", 4);
        albumA.addSong("Sailing to Philadelphia", 5);
        albumA.addSong("Who is your baby now", 4);

        album_arr.add(albumA);
        Album albumB = new Album("The best of vargas blues band", "Vargas blues band");
        albumB.addSong("El alma", 3);
        albumB.addSong("Luna", 10);
        albumB.addSong("Illegally", 4);

        album_arr.add(albumB);
        Album albumC = new Album("Brothers in arms", "Dire Straits");
        albumC.addSong("So far away for me", 2);
        albumC.addSong("Money for nothing", 3);
        albumC.addSong("Walk of life", 2);
        //albums.add(albumC);
        album_arr.add(albumC);

        // implementarlo si fuera ArrayList printListAlbum(albums);
        albumA.printAlbum();
        albumB.printAlbum();
        //printEverything(albums);
        printEverythingArrayList(album_arr);

        LinkedList<Song> playlist = new LinkedList<Song>();

        album_arr.get(0).addToPlaylist("What it is", playlist);
        album_arr.get(0).addToPlaylist(2, playlist);
        album_arr.get(1).addToPlaylist(2, playlist);
        printListPlaylist(playlist);
        play(playlist);

    }
// Muestro todos los Albums contenidos en la lista doblemente enlazada con iterator
    public static void printEverything(LinkedList<Album> linkedList) {
        System.out.println("=============================");
        //      System.out.println("List of song in album: " + albumName);
        Album currentAlbum;
        Iterator<Album> i = linkedList.iterator(); // Se podría hacer for (int i = 0; i < linkedList.size(); i++ )
        int j = 0;
        while (i.hasNext()) {
            j++;
            currentAlbum = i.next();
            //El siguiente ejemplo se recorre un ArrayList con iterator
            System.out.println(j + " Album: " + currentAlbum.getNombre());
            System.out.println(j + " Artista/s: " + currentAlbum.getArtista());
            currentAlbum.getSongsFromInside();

        }
    }

    public static void printEverythingArrayList(ArrayList<Album> arrList) {
        System.out.println("=============================");
        Album currentAlbum;
        Iterator<Album> i = arrList.iterator(); // podría hacerse (int i = 0; i < linkedList.size(); i++ )
        int j = 0;
        while (i.hasNext()) {
            j++;
            currentAlbum = i.next();
            System.out.println(j + " Album: " + currentAlbum.getNombre());
            System.out.println(j + " Artista/s: " + currentAlbum.getArtista());
            currentAlbum.getSongsFromInside();

        }
    }

    public static void printListPlaylist(LinkedList<Song> playlist) {
        System.out.println("============ playlist =================");
        Iterator<Song> i = playlist.iterator(); // coś jak for (int i = 0; i < playlist.size(); i++ )
        int j = 0;
        while (i.hasNext()) {

            j++;
            Song currentSong = i.next();
            System.out.println(j + ": " + currentSong.getTitulo());
        }
        System.out.println("=============================");

    }

    private static void printMenu() {
        System.out.println("Menú de opciones:\nelige opción");
        System.out.println("0 - Salir\n" +
                "1 - Reproducir siguiente canción\n" +
                "2 - Reproducir anterior canción\n" +
                "3 - Repetir canción actual\n" +
                "4 - Mostrar canciones en la lista de reproducción\n" +
                "5 - Presentar menú.\n" +
                "6 - Eliminar canción actual de la Lista");
    }

    public static void play(LinkedList<Song> playlist) {

        Scanner scanner = new Scanner(System.in);
        boolean forward = true;
        boolean esFin = false;
        Song current_song;
        ListIterator<Song> listIterator = playlist.listIterator();
        if (playlist.size() == 0) {
            System.out.println("NO hay canciones en la lista de reproducción");
            return;
        } else {
            printMenu();
        }

        while (!esFin) {
            try {
                int opcion = scanner.nextInt();
                scanner.nextLine();
                switch (opcion) {
                    case 0:
                        System.out.println("Fin de la lista de reproducción");
                        esFin = true;
                        break;

                    case 1: // Reproducir siguiente canción
                        if (!forward) { // el sentido iba hacia atrás , luego hay que avanzar el puntero al segundo nodo sentido forward
                            if (listIterator.hasNext()) {
                                listIterator.next();
                            }
                            forward = true;
                        }
                        if (listIterator.hasNext()) {
                            System.out.println("Reproduciendo ahora " + listIterator.next().toString());
                        } else {
                            System.out.println("Hemos alcanzado el fin de la PlayList");
                            forward = false;
                        }
                        break;
                    case 2:  // Reproducir canción anterior
                        if (forward) { // el sentido iba hacia adelante,hay que retroceder el puntero al segundo nodo sentido previous
                            if (listIterator.hasPrevious()) {
                                listIterator.previous();
                            }
                            forward = false;
                        }
                        if (listIterator.hasPrevious()) {
                            System.out.println("Reproduciendo " + listIterator.previous().toString());
                        } else {  // Estamos al principio de la lista
                            System.out.println("Estamos en el comienzo de la Lista");
                            forward = true;
                        }
                        break;
                    case 3: // REPLAY Canción actual
                        if (forward) {
                            if (listIterator.hasPrevious()) {
                                System.out.println("Ahora reproduciendo " + listIterator.previous().toString());
                                forward = false;
                            } else {
                                System.out.println("Estamos al comienzo de la lista");
                            }
                        } else {
                            if (listIterator.hasNext()) {
                                System.out.println("Ahora reproduciendo " + listIterator.next().toString());
                                forward = true;
                            } else {
                                System.out.println("Hemos alcanzado el final de la lista");
                            }
                        }
                        break;
                    case 4:
                        printListPlaylist(playlist);
                        break;
                    case 5:
                        printMenu();
                        break;
                    case 6:
                        if (playlist.size() > 0) {
                            listIterator.remove();
                            if (listIterator.hasNext()) {
                                System.out.println("Now playing " + listIterator.next());
                            } else if (listIterator.hasPrevious()) {
                                System.out.println("Now playing " + listIterator.previous());
                            }
                        }
                        break;
                    default:
                        System.out.println("Opción invalida");
                } //switch
            } catch (Exception ex){
                System.out.println("No ha introducido un número, elija opción válida (1..6) ");
                scanner.next();
            }
        } //while
    }//play

}




