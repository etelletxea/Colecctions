package ArrayList;

import java.util.ArrayList;
import java.util.Iterator;

public class TelefonoMovil {
    private String myNumber;
    private ArrayList<Contacto> myContacts;

    public TelefonoMovil(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    // Devuelve indice si existe o -1 si no existe
    private int findContact(Contacto contact) {
        int index = this.myContacts.indexOf(contact);
        return index;
    }

    // Devuelve indice si existe o -1 si no existe
    private int findContact(String nombre) {
        int valor = -1;
        for (int i = 0; i < this.myContacts.size(); i++)
            if (this.myContacts.get(i).getName().equals(nombre)) {
                valor = i;
                return (valor);
            }
        return (valor);
    }

    // Devuelve true si el contacto no existe y se puede añadir a la lista
    // Devuelve false si el contacto ya existe y no se puede añadir
    public boolean addNewContact(Contacto contact) {
        int i=findContact(contact);
        if (i==-1)
        {this.myContacts.add(contact);return true;}
        else return false;
    }
    // Devuelve true si el contacto existe y se puede eliminar de la lista
    // Devuelve false si el contacto no existe
    public boolean removeContact(Contacto contact) {
        int i=findContact(contact);
        if (i>=0)
        {this.myContacts.remove(contact);return true;}
        else return false;
    }
    // Se actualiza el antiguo contacto por uno nuevo
    // siempre y cuando no exista el contacto
    public boolean updateContact(Contacto oldcontact,Contacto newcontact) {
        int i=findContact(newcontact);
        if (i>=0)
          {return false;}
        else {
            int j = findContact(oldcontact);
            if (j >= 0) {
                this.myContacts.set(j, newcontact);
                return (true);
            } else return false;
        }
    }
//Devuelve el contacto y nulo en caso contrario
    public Contacto queryContact(String nombre) {
        int i = findContact(nombre);
        if (i >= 0) {
            return (this.myContacts.get(i));
        } else return (null);
    }
//Imprime contactos
    public void printContacts()
    {
        int j;
        for (int i=0;i<this.myContacts.size();i++){
            j=i+1;
            System.out.println(j+". "+this.myContacts.get(i).getName()+" -->"+this.myContacts.get(i).getPhoneNumber());
        }
    }
    // En lugar de indices para recorrer utiliza iterator
    public void muestraContacts(){
        Iterator<Contacto> it_contact=myContacts.iterator();
        Contacto cont;
        int i=1;
        while(it_contact.hasNext()){
            cont=it_contact.next();
            System.out.println(i+". "+cont.getName()+" --> "+cont.getPhoneNumber());
            i++;
        }
    }
}
