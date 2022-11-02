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
    
    /*Solo declaracion*/
    public abstract void interactuar(Jugador jugador);

    /*Agrega un nodo a la lista de NodosSiguientes */
    public void agregarNodo(Nodo nodo){
        this.siguientes_nodos.add(nodo);
    }

    @Override
    public String toString() {
        return "Nodo [id=" + id + ", siguientes_nodos=" + siguientes_nodos + "]";
    }
    
}

