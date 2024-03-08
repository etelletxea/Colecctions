package ArrayList;

public class Contacto {
    private String name;
    private String phoneNumber;

    public Contacto(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public static Contacto createContact(String name,String phoneNumber)
    {
        Contacto contact;
        contact=new Contacto(name, phoneNumber);
        return contact;
    }

    @Override
    public String toString() {
        return "Contacto{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
