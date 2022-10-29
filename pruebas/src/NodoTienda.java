import java.util.ArrayList;




public class NodoTienda extends Nodo {
    /*atributo*/
    private ArrayList<Item> inventario;

    public NodoTienda(int id, ArrayList<Nodo> signodos, ArrayList<Item> inventario) {
        super(id, signodos);
        this.inventario = inventario;
    }

    /*Getters y Setters */
    public ArrayList<Item> getInventario() {
        return inventario;
    }
    public void setInventario(ArrayList<Item> inventario) {
        this.inventario = inventario;
    }

    /*metodos*/
    public void interactuar(Jugador jugador){
        
    }
    public void comprar(int eleccion){
        
    }
}
