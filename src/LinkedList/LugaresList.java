package LinkedList;

import java.util.Iterator;
import java.util.LinkedList;

public class LugaresList {
    private LinkedList<String> lugares;

    public LugaresList(LinkedList<String> lugares) {
        this.lugares = lugares;
    }

    public void addLugar(String item)
    { lugares.add(item);}

    public void printList(LinkedList<String> lugares) {
        Iterator<String> it= lugares.iterator();
        while (it.hasNext()){
            System.out.println("Nodo: "+it.next());
        }
        System.out.println("------");
    }

}
