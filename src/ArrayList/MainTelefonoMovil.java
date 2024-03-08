package ArrayList;

import java.util.Scanner;

public class MainTelefonoMovil {

    private static Scanner scanner = new Scanner(System.in);
    private  static TelefonoMovil miMovil= new TelefonoMovil("696763569");

    public static void imprimirMenu() {
        System.out.println("0 - Salir");
        System.out.println("1 - Imprimir contactos");
        System.out.println("2 - Añadir contacto");
        System.out.println("3 - Modificar contacto");
        System.out.println("4 - Eliminar contacto ");
        System.out.println("5 - Buscar contacto ");
        System.out.println("6 - Imprimir menú");
    }
    public static void addContacto() {
        Scanner sc = new Scanner(System.in);
        String nombre,tfno;
        System.out.println("Agrega nombre de contacto: ");
        nombre=sc.nextLine();
        System.out.println("Teléfono móvil: ");
        tfno=sc.nextLine();
        Contacto contacto=new Contacto(nombre,tfno);
        miMovil.addNewContact(contacto);
    }
    public static void modifyContacto() {
        Scanner sc = new Scanner(System.in);
        Contacto contacto;
        System.out.println("Nombre del contacto a sustituir:");
        String oldContact_name = sc.nextLine();
        contacto=miMovil.queryContact(oldContact_name);
        System.out.println("Nombre del contacto nuevo:");
        String newContact_name = sc.nextLine();
        // Si no existe entonces pedir número
        System.out.println("Número de teléfono:");
        String newTfno = sc.nextLine();
        Contacto newContact=new Contacto(newContact_name,newTfno);
        miMovil.updateContact(contacto,newContact);
    }
    public static void removeContacto() {

        Contacto contacto;
        System.out.println("Introduce el nombre del contacto a eliminar: ");
        String name = scanner.nextLine();
        contacto=miMovil.queryContact(name);
        miMovil.removeContact(contacto);
    }
    public static void buscarContacto() {

        Contacto contacto;
        System.out.println("Introduce el nombre del contacto: ");
        String name = scanner.nextLine();
        contacto=miMovil.queryContact(name);
        if (contacto!=null)
             System.out.println(contacto.toString());
        else
            System.out.println("El contacto "+name+" no existe");
    }

    public static void main(String[] args) {
        boolean continuar = true;
        int opcion = 0;
        imprimirMenu();

       do  {
            try {
                System.out.println("Elige una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();
                switch (opcion) {
                    case 0:
                        continuar = false;
                        break;
                    case 1:
                        //miMovil.printContacts();
                        miMovil.muestraContacts();
                        break;
                    case 2:
                        addContacto();
                        break;
                    case 3:
                        modifyContacto();
                        break;
                    case 4:
                        removeContacto();
                        break;
                    case 5:
                        buscarContacto();
                        break;
                    case 6:
                        imprimirMenu();
                        break;
                    default:
                        System.out.println("Opción inválida, elija opciones de 0 al 6 ");
                }
            }catch(Exception ex) {
                    System.out.println("No ha introducido un número, elija opción válida (1..6) ");
                    continuar=true;
                    scanner.next();
            }
        } while (continuar);
    }
}
