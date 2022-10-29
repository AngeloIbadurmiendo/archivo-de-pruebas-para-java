import java.util.ArrayList;

public class NodoCombate extends Nodo {
    /*Atributos*/
    private Personaje enemigo;

    /*Constructor */
    public NodoCombate(int id, ArrayList<Nodo> signodos, Personaje enemigo) {
        super(id, signodos);
        this.enemigo = enemigo;
    }

    /*Setters y Getters */
    public Personaje getEnemigo() {
        return enemigo;
    }

    public void setEnemigo(Personaje enemigo) {
        this.enemigo = enemigo;
    }

    /*Metodos */
    public void interactuar(Jugador jugador){
        
    }

    @Override
    public String toString() {
        return "NodoCombate [enemigo=" + enemigo + "]";
    }
    
}
