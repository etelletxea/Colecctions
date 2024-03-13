package mapsdemo;

import java.util.HashMap;
import java.util.Map;

public class maindemo {

        public static void main(String[] args) {
            Map<String, String> idiomas = new HashMap<>();
            idiomas.put("es", "Español");
            idiomas.put("en", "English EEUU");
            idiomas.put("ca", "English Canadá");
            idiomas.put("de", "Aleman");
            idiomas.put("fr", "Francés");
            idiomas.put("it", "Italian");

            // imprimir de forma rústica
            System.out.println(idiomas);
            // fin

            // obtengo y muestro valor de clave it
            String valor = idiomas.get("it");
            System.out.println("Valor: "+valor);
            // Compruebo si los datos existen
            // si la clave existe
            // si el valor existe
            if (idiomas.containsKey("es")) {
                System.out.println("La clave es ya existe");
            }
            if (idiomas.containsValue("Español")) {
                System.out.println("El idioma español ya existe");
            }
            //Recorremos todo el mapa
            System.out.println("Recorremos el mapa");
            for(String key: idiomas.keySet()) {
                System.out.println(key + " " + idiomas.get(key));
            }
            // otra forma
            System.out.println("Otra forma de recorrer el mapa");
            for (Map.Entry<String, String> entradaMapa: idiomas.entrySet()) {
                String clave=entradaMapa.getKey();
                String dato=entradaMapa.getValue();
                System.out.println(clave + " " + dato);
            }
            //Forma 1 de eliminar del mapa
            String eliminado = idiomas.remove("fr");

            System.out.println("Recorremos el mapa: "+"ha borrado "+eliminado);
            for(String key: idiomas.keySet()) {
                System.out.println(key + " " + idiomas.get(key));
            }

            //Forma 2 de eliminar del mapa clave,valor
            if (idiomas.remove("de", "Ingles")) {
                System.out.println("de ha sido eliminado");
            } else {
                System.out.println("No existe un par clave-valor con de-Ingles");
            }
            System.out.println("Recorremos el mapa: ");
            for(String key: idiomas.keySet()) {
                System.out.println(key + " " + idiomas.get(key));
            }
            // Reemplazamos un valor
            idiomas.replace("es", "Spain");
            for(String key: idiomas.keySet()) {
                System.out.println(key + " " + idiomas.get(key));
            }
            idiomas.replace("en", "English EEUU", "English");
            for(String key: idiomas.keySet()) {
                System.out.println(key + " " + idiomas.get(key));
            }
        }
    }

