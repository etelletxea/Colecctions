package colecciones_set;/*package colecciones_set;

import java.util.HashSet;
import java.util.Set;

public class CuerpoCeleste { public enum TipoCuerpoCeleste{ESTRELLA,PLANETA,PLANETA_ENANO,LUNA,COMETA,ASTEROIDE}
    private String nombre;
    private double periodoOrbital;
    private TipoCuerpoCeleste tipoCuerpo;
    private Set <CuerpoCeleste> SetCC;

    CuerpoCeleste(){
        nombre="";
        periodoOrbital=0.0;
        tipoCuerpo=null;
    }
    CuerpoCeleste(String nombre,double periodoOrbital,TipoCuerpoCeleste tipoCuerpo)
    {
        this.nombre=nombre;
        this.periodoOrbital=periodoOrbital;
        this.tipoCuerpo=tipoCuerpo;
        this.SetCC= new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPeriodoOrbital() {
        return periodoOrbital;
    }

    public void setPeriodoOrbital(double periodoOrbital) {
        this.periodoOrbital = periodoOrbital;
    }

    public TipoCuerpoCeleste getTipoCuerpo() {
        return tipoCuerpo;
    }

    public void setTipoCuerpo(TipoCuerpoCeleste tipoCuerpo) {
        this.tipoCuerpo = tipoCuerpo;
    }

    public Set<CuerpoCeleste> getSetCC() {
        return SetCC;
    }
    public boolean addSatelite(CuerpoCeleste cc){
        this.SetCC.add(cc);
        // habría que comprobar que lo añade bien.
        return true;
    }

    @Override
    public String toString() {
        return "CuerpoCeleste{" +
                "nombre='" + nombre + '\'' +
                ", periodoOrbital=" + periodoOrbital +
                ", tipoCuerpo=" + tipoCuerpo +
                ", SetCC=" + SetCC +
                '}';
    }
}
*/