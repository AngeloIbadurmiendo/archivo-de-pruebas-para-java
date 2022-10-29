import java.util.ArrayList;

public abstract class Nodo {
    /*Atributos*/
    private int id;
    private ArrayList<Nodo> siguientes_nodos;

    /*constructors */
    public Nodo(int id, ArrayList<Nodo> siguientes_nodos) {
        this.id = id;
        this.siguientes_nodos = new ArrayList<>();
    }

    /*Getters y Setters */
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Nodo> getSiguientes_nodos() {
        return siguientes_nodos;
    }
    public void setSiguientes_nodos(ArrayList<Nodo> siguientes_nodos) {
        this.siguientes_nodos = siguientes_nodos;
    }

    /*metodos*/
    public abstract void interactuar(Jugador jugador);

    public void agregarNodo(Nodo nodo){
        
    }

    @Override
    public String toString() {
        return "Nodo [id=" + id + ", siguientes_nodos=" + siguientes_nodos + "]";
    }
    
}

