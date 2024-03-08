package colecciones_set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Ejemplos {
    public static void main(String[] args) {
        Set<String> setA = new HashSet();
        Set<Integer> setB = new HashSet();
        setA.add("Elemento 1");
        setA.add("Elemento 2");
        setA.add("Elemento 3");
        Iterator<String> iterator = setA.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println("Elemento: " + element);
        }
        System.out.println("Tamaño del setA: " + setA.size());
        setB.add(1);
        setB.add(2);
        setB.add(4);
        setB.add(3);
        for (Integer num : setB) {
            System.out.println("Elemento: " + num);
        }
        System.out.println("Tamaño del setB: " + setB.size());
    }
}
