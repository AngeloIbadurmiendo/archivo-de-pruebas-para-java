import java.util.ArrayList;
import java.util.Scanner;
import java.util.SortedSet;

public class Mapa {
    /*Atributos*/
    private int profundidad;
    private NodoInicial nodo_inicial;
    private Nodo nodo_actual;

    /*Constructor*/
    public Mapa(int profundidad, NodoInicial nodo_inicial, Nodo nodo_actual) {
        this.profundidad = profundidad;
        this.nodo_inicial = nodo_inicial;
        this.nodo_actual = nodo_actual;
    }

    /*Getters y Setters*/
    public int getProfundidad() {
        return profundidad;
    }
    public void setProfundidad(int profundidad) {
        this.profundidad = profundidad;
    }

    public NodoInicial getNodo_inicial() {
        return nodo_inicial;
    }
    public void setNodo_inicial(NodoInicial nodo_inicial) {
        this.nodo_inicial = nodo_inicial;
    }

    public Nodo getNodo_actual() {
        return nodo_actual;
    }
    public void setNodo_actual(Nodo nodo_actual) {
        this.nodo_actual = nodo_actual;
    }
    /*Metodos*/
    /*Recorre los nodos con sus posibles opciones para avanzar y los anade a una variable, esta variable es usada como formato para luego mostrar el link con el mapa al usuario*/
    public void verMapa(SortedSet<Edge> nodo) {
        String grafo="";
        for (Edge e : nodo) {
            /*System.out.printf("%d->%d;\n", e.x, e.y);*/
            grafo+=e.x+"->"+e.y+";";
        }
        String url=String.format("Copia el siguiente link para ver el mapa: http://mxwell.github.io/draw-graph/?q=digraph{%s}",grafo);
        System.out.println(url);
    }
    /*Obtiene la lista de NodosSiguientes del nodo actual, entrega las opciones disponibles al usuario y recibe la respuesta para settear como nodo actual la opcion deseada*/
    public void avanzar() {
        Nodo node=this.nodo_actual;
        ArrayList<Nodo> sigs= node.getSiguientes_nodos();
        for (int index = 0; index < sigs.size(); index++) {
            Nodo next=sigs.get(index);
            System.out.println("Puedes avanzar al encuentro "+next.getId());
        }
        Scanner sc= new Scanner(System.in);
        System.out.println("Ingrese el nodo al que le gustaria avanzar");
        int respuesta = sc.nextInt();
        for (int i = 0; i < sigs.size(); i++) {
            int ids= sigs.get(i).getId();
            if (ids == respuesta) {
                this.setNodo_actual(sigs.get(i));
            }
        }
    }

    @Override
    public String toString() {
        return "Mapa [profundidad=" + profundidad + ", nodo_inicial=" + nodo_inicial + ", nodo_actual=" + nodo_actual
                + "]";
    }
    
}
