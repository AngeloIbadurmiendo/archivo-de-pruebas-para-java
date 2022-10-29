import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.SplittableRandom;
public class App {
    public static void main(String[] args) throws Exception {
        Item item1= new Item("Peluca", 40, 3, 1, 1, 1);
        Item item2= new Item("Piedra Trueno", 50, 5, 1, 2, 0);
        Item item3= new Item("Piedra Vida",200, 10, 5, 0, 0);
        Item item4= new Item("Piedra Afilada", 120, 0, 0, 6, 0);
        Item item5= new Item("Espadas Danzantes", 250, 0, 0, 10, 0);
        Item item6= new Item("Coraza Metal", 250, 0, 0, 0, 10);
        Item item7= new Item("SuperPocion", 100, 20, 0, 0, 0);
        Item item8= new Item("Pocion", 50, 10, 0, 0, 0);
        Jugador jugador1= new Jugador("Angelo", 500, 20, 20, 5, 1, null);
        
        
        
        
        
        
        
        
        
        
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la profundidad del mapa");
        int eleccion= sc.nextInt();
        /*Nodo inicial siempre sera 0 por lo que se iniciara en el main*/
        NodoInicial comienzo=new NodoInicial(0, null);
        /*Se genera el grafo con el mapa (no lo inicie en la funcion verMapa()
        para poder usar el mismo grafo en la definicion de los nodos siguientes)*/
        SortedSet<Edge> edges = GraphGenerator.Generar(eleccion);
        /*Se genera el mapa*/
        Mapa gen_mapa= new Mapa(eleccion, comienzo, comienzo);

        gen_mapa.verMapa(edges);

        /*Aqui se puede ver cuales son los nodos a los que se pueden avanzar*/
        int idNodo= comienzo.getId();
        ArrayList<Integer> nextNodo = new ArrayList<>();
        for (Edge e : edges) {
            /*System.out.printf("%d->%d;\n", e.x, e.y);*/
            if (e.x == idNodo) {
                nextNodo.add(e.y);
            }
        }
        /*Aqui se le muestra al usuario las opciones que tiene */
        System.out.println("Puedes avanzar a:");
        for (int i = 0; i < nextNodo.size(); i++) {
            System.out.println("Encuentro "+nextNodo.get(i));
        }

        int choice=sc.nextInt();

        double random = Math.random();
        if(random<0.99){
            System.out.println("Llegaste a un Evento!\n");
            NodoEvento evento1= new NodoEvento(choice,null,"Llegaste al templo en el cielo, delante tuyo hay 2 estatuas, cada una con un destino diferente. Elige sabiamente!.","Estatua Divina del Cazador","Estatua Divina del Titan",item4,item6);
            NodoEvento evento2= new NodoEvento(choice,null,"Llegaste a la isla del Curandero Loco, debes disparar a una de las dos vasijas que tienes delante para conseguir un item curativo.","Vasija de la izquierda","Vasija de la derecha",item3,item8);
            NodoEvento evento3=new NodoEvento(choice, null, "Llegaste a la isla de la Loca de las Monedas, deberas jugar Cara o Cruz con ella para recibir una recompensa.", "Elegir cara", "Elegir Cruz", item2, item5);
            ArrayList<NodoEvento> eventos = new ArrayList<>(Arrays.asList(evento1,evento2,evento3));
            
        }
        // else if(random<0.4){
        //     System.out.println("Tienda\n");
        // }
        else{
            System.out.println("Combate\n");
        }




        /*Para la cantidad de movimientos posible en el mapa se calcula profundidad + 1 */
        /*Evento 30
         *Tienda 10
          Combate 60 
         */
        
    }
}
