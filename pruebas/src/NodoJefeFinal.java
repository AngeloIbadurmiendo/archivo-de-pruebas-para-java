import java.util.ArrayList;

public class NodoJefeFinal extends Nodo {
    /*atributos*/
    private Personaje jefe;  

    /*Constructor*/
    public NodoJefeFinal(int id, ArrayList<Nodo> signodos, Personaje jefe) {
        super(id, signodos);
        this.jefe = jefe;
    }
    
    /*Getters y Setters*/
    public Personaje getJefe() {
        return jefe;
    }
    public void setJefe(Personaje jefe) {
        this.jefe = jefe;
    }
    
    @Override
    public String toString() {
        return "NodoJefeFinal [jefe=" + jefe + "]";
    }

    /*metodo*/
    public void interactuar(Jugador jugador){
        
    }

}
