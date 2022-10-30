import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.SortedSet;
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
        int profundidad= sc.nextInt();
        /*Nodo inicial siempre sera id 0 por lo que se iniciara en el main*/
        NodoInicial nodoactual=new NodoInicial(0, null);
        /*Se genera el grafo con el mapa (no lo inicie en la funcion verMapa()
        para poder usar el mismo grafo en la definicion de los nodos siguientes)*/
        SortedSet<Edge> edges = GraphGenerator.Generar(profundidad);
        /*Se genera el mapa*/
        Mapa gen_mapa= new Mapa(profundidad, nodoactual, nodoactual);
        

        /*Aqui se puede ver cuales son los nodos a los que se pueden avanzar*/
        
        if (jugador1.GetHpActual()<=0) {
            System.out.println("Game over");
        }
        while (jugador1.GetHpActual() > 0){
            
            System.out.println("\nQue haras, "+jugador1.GetName()+"?");
            /*Menu*/
            System.out.println("--------------------------------------------------------");
            System.out.println("Menu de acciones: ");
            System.out.println("1. Ver el mapa");
            System.out.println("2. Ver estadisticas");
            System.out.println("3. Ver items aplicados");
            System.out.println("4. Avanzar al siguiente encuentro");
            System.out.println("5. RageQuitear (Cuida el mental)");
            System.out.println("--------------------------------------------------------");

            int eleccion= sc.nextInt();
            switch (eleccion){
                case 1:
                    gen_mapa.verMapa(edges);
                    System.out.println("Presiona ENTER para continuar!");
                    try{System.in.read();}
                        catch(Exception e){};
                    continue;
                case 2:
                    jugador1.verEstado();
                    System.out.println("Presiona ENTER para continuar!");
                    try{System.in.read();}
                        catch(Exception e){};
                    continue;
                case 3:
                    jugador1.verItems();
                    System.out.println("Presiona ENTER para continuar!");
                    try{System.in.read();}
                        catch(Exception e){};
                    continue;
                case 4:
                    int idNodo= nodoactual.getId();
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
                    System.out.println("A que encuentro avanzaras?");
                    int sig=sc.nextInt();
                    double random = Math.random();
                    if(random<0.99){
                        System.out.println("Llegaste a un Evento!\n");
                        NodoEvento evento1= new NodoEvento(sig,null,"Llegaste al templo en el cielo, delante tuyo hay 2 estatuas, cada una con un destino diferente. Elige sabiamente!.","Estatua Divina del Cazador","Estatua Divina del Titan",item4,item6);
                        NodoEvento evento2= new NodoEvento(sig,null,"Llegaste a la isla del Curandero Loco, debes disparar a una de las dos vasijas que tienes delante para conseguir un item curativo.","Vasija de la izquierda","Vasija de la derecha",item3,item8);
                        NodoEvento evento3=new NodoEvento(sig, null, "Llegaste a la isla de la Loca de las Monedas, deberas jugar Cara o Cruz con ella para recibir una recompensa.", "Elegir cara", "Elegir Cruz", item2, item5);
                        ArrayList<NodoEvento> eventos = new ArrayList<>(Arrays.asList(evento1,evento2,evento3));
                        Collections.shuffle(eventos);
                        NodoEvento evento_elegido= eventos.get(0);
                        evento_elegido.interactuar(jugador1);
                        gen_mapa.setNodo_actual(evento_elegido);
                        nodoactual.setId(sig);
                    }
                    // else if(random<0.4){
                    // System.out.println("Tienda\n");
                    // }
                    else{
                        System.out.println("Combate\n");
                    }
                    continue;
                case 5:
                    System.out.println("Buena Eleccion!\n");
                    break;
            }
            break;
        }

        
        
        




        /*Para la cantidad de movimientos posible en el mapa se calcula profundidad + 1 */
        /*Evento 30
         *Tienda 10
          Combate 60 
         */
        
    }
}
