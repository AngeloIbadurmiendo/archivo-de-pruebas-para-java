import java.util.ArrayList;

public class NodoJefeFinal extends Nodo {
    /*atributos*/
    private Personaje Jefe;  

    /*Constructor*/
    public NodoJefeFinal(int id, ArrayList<Nodo> signodos, Personaje jefe) {
        super(id, signodos);
        Jefe = jefe;
    }
    
    /*Getters y Setters*/
    public Personaje getJefe() {
        return Jefe;
    }
    public void setJefe(Personaje jefe) {
        Jefe = jefe;
    }
    /*metodo*/
    public void interactuar(Jugador jugador){
        
    }

}
