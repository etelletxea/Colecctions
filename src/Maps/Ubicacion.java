package Maps;

import java.util.HashMap;
import java.util.Map;

public class Ubicacion {
    int id;
    String descripcion;
    Map<String,Integer> exits;

    public Ubicacion(int id, String descripcion, Map<String, Integer> exits) {
        this.id = id;
        this.descripcion = descripcion;
        this.exits = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Map<String, Integer> getExits() {
        return exits;
    }

    public void setExits(Map<String, Integer> exits) {
        this.exits = exits;
    }

    public void addExit(String direccion, Integer idUbicacion){
        this.exits.put(direccion,idUbicacion);
    }

   public int irAubicacion(String direccion)
   {
       String clave;
       int valor=-1;
       for (Map.Entry<String, Integer> entradaMapa: this.getExits().entrySet()) {
           clave = entradaMapa.getKey();
           if (clave.equalsIgnoreCase(direccion))
               valor = entradaMapa.getValue();
       }
       return valor;
   };

    @Override
    public String toString() {
        return "Ubicacion{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", exits=" + exits +
                '}';
    }
}
