package colecciones_set;/*
package colecciones_set;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    static Map<String, CuerpoCeleste> sistemaSolar = new HashMap<>();
    static Set<CuerpoCeleste> planetas = new HashSet<>();
    static Set<CuerpoCeleste> planetas2=new HashSet<>();
    public static void main(String[] args){
        Planeta p1,p2,p3,p4,p5,p6,p7,p8,p9;
        PlanetaEnano p10;
        Luna l1,l2,l3,l4,l5,l6,l7;
        Set <CuerpoCeleste> SetL;
        Set<CuerpoCeleste> SetL1= new HashSet<>();
        p1 = new Planeta("Mercurio",88, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        p2 = new Planeta("Venus",225, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        p3 = new Planeta("Tierra",365, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        p4 = new Planeta("Marte",687, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        p5 = new Planeta("Jupiter",4332, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        p6 = new Planeta("Saturno",10759, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        p7 = new Planeta("Urano",30660, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        p8 = new Planeta("Neptuno",165,CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        p9 = new Planeta("Pluton",248, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        p10 = new PlanetaEnano("Pluton",884,CuerpoCeleste.TipoCuerpoCeleste.PLANETA_ENANO);
        sistemaSolar.put("Mercurio",p1);
        planetas.add(p1);
        sistemaSolar.put("Venus",p2);
        planetas.add(p2);
        sistemaSolar.put("Tierra",p3);
        planetas.add(p3);
        sistemaSolar.put("Marte",p4);
        planetas.add(p4);
        sistemaSolar.put("Jupiter",p5);
        planetas.add(p5);
        sistemaSolar.put("Saturno",p6);
        planetas.add(p6);
        sistemaSolar.put("Urano",p7);
        planetas.add(p7);
        sistemaSolar.put("Neptuno",p8);
        planetas.add(p8);
        sistemaSolar.put("Pluton",p9);
        planetas.add(p9);
        planetas.add(p10);
        planetas2.add(p10);
        l1= new Luna("Luna",27,CuerpoCeleste.TipoCuerpoCeleste.LUNA);
        sistemaSolar.put("Luna",l1);
        p3.addSatelite(l1);
        l2= new Luna("Deimos",1.3,CuerpoCeleste.TipoCuerpoCeleste.LUNA);
        l3= new Luna("Phobos",0.3,CuerpoCeleste.TipoCuerpoCeleste.LUNA);
        sistemaSolar.put("Deimos",l2);
        sistemaSolar.put("Phobos",l3);
        p4.addSatelite(l2);
        p4.addSatelite(l3);
        l4 =new Luna("Io",1.8,CuerpoCeleste.TipoCuerpoCeleste.LUNA);
        l5 =new Luna("Europa",3.5,CuerpoCeleste.TipoCuerpoCeleste.LUNA);
        l6 =new Luna("Ganymede",7.1,CuerpoCeleste.TipoCuerpoCeleste.LUNA);
        l7 =new Luna("Callisto",16.7,CuerpoCeleste.TipoCuerpoCeleste.LUNA);
        sistemaSolar.put("Io",l4);
        sistemaSolar.put("Europa",l5);
        sistemaSolar.put("Ganymede",l6);
        sistemaSolar.put("Callisto",l7);
        p5.addSatelite(l4);
        p5.addSatelite(l5);
        p5.addSatelite(l6);
        p5.addSatelite(l7);
        for(CuerpoCeleste c1: planetas){
            System.out.println("Planeta: "+c1.getNombre());
        }
        CuerpoCeleste cmarte = sistemaSolar.get("Marte");
        System.out.println("-------------------------------"+cmarte.getNombre());
        System.out.println("Lunas de: "+cmarte.getNombre());
        SetL= cmarte.getSetCC();
        for(CuerpoCeleste l20: SetL){
            System.out.println("Luna: "+l20.getNombre());
        }
        System.out.println("-------------------------------");

        for(CuerpoCeleste c1: planetas){
            System.out.println(c1.toString()+c1.getNombre());
            SetL=c1.getSetCC();
            SetL1.addAll(SetL);
        }
        System.out.println("----------- UNIÓN de Satélites -----------------");
        for(CuerpoCeleste l20: SetL1){
            System.out.println("Satélites: "+l20.getNombre());
        }
        System.out.println("----------- INTERSECCIÓN de Satélites -----------------");
        SetL.clear();
        SetL1.clear();
        for(CuerpoCeleste c1: planetas){
            System.out.println(c1.toString()+c1.getNombre());
            SetL=c1.getSetCC();
            SetL1.retainAll(SetL);
        }
        if (SetL1.isEmpty()) {  System.out.println("La intersección es vacía");}
        else {
        for(CuerpoCeleste l20: SetL1){
            System.out.println("Satélites: "+l20.getNombre());
        }
        }
    }
}
*/