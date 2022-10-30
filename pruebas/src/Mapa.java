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
    public void verMapa(SortedSet<Edge> nodo) {
        String grafo="";
        for (Edge e : nodo) {
            /*System.out.printf("%d->%d;\n", e.x, e.y);*/
            grafo+=e.x+"->"+e.y+";";
        }
        String url=String.format("Copia el siguiente link para ver el mapa: http://mxwell.github.io/draw-graph/?q=digraph{%s}",grafo);
        System.out.println(url);
    }
    public void avanzar() {
        
    }

    @Override
    public String toString() {
        return "Mapa [profundidad=" + profundidad + ", nodo_inicial=" + nodo_inicial + ", nodo_actual=" + nodo_actual
                + "]";
    }
    
}
