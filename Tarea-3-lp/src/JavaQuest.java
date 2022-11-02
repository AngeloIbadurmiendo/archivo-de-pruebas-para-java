import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
public class JavaQuest {
    public static void main(String[] args) throws Exception {
        Item item1= new Item("Peluca", 40, 3, 1, 1, 1);
        Item item2= new Item("Piedra Trueno", 50, 5, 1, 2, 0);
        Item item3= new Item("Piedra Vida",200, 10, 5, 0, 0);
        Item item4= new Item("Piedra Afilada", 120, 0, 0, 6, 0);
        Item item5= new Item("Espadas Danzantes", 250, 0, 0, 10, 0);
        Item item6= new Item("Coraza Metal", 250, 0, 0, 0, 10);
        Item item7= new Item("SuperPocion", 100, 20, 0, 0, 0);
        Item item8= new Item("Pocion", 50, 10, 0, 0, 0);
        ArrayList<Item> items_tienda= new ArrayList<>(Arrays.asList(item1,item2,item3,item4,item5,item6,item7,item8));
        Jugador jugador1= new Jugador("Angelo", 500, 20, 20, 5, 1, null);
        Personaje jefe = new Personaje("Gahlran", 0, 60, 60, 10, 0);
        //NodoEvento evento1= new NodoEvento(-1,null,"Llegaste al templo en el cielo, delante tuyo hay 2 estatuas, cada una con un destino diferente. Elige sabiamente!.","Estatua Divina del Cazador","Estatua Divina del Titan",item4,item6);
        //NodoEvento evento2= new NodoEvento(-1,null,"Llegaste a la isla del Curandero Loco, debes disparar a una de las dos vasijas que tienes delante para conseguir un item curativo.","Vasija de la izquierda","Vasija de la derecha",item3,item8);
        //NodoEvento evento3=new NodoEvento(-1, null, "Llegaste a la isla de la Loca de las Monedas, deberas jugar Cara o Cruz con ella para recibir una recompensa.", "Elegir cara", "Elegir Cruz", item2, item5);
        //ArrayList<NodoEvento> eventos= new ArrayList<>(Arrays.asList(evento1,evento2,evento3));
        ArrayList<String> descripciones = new ArrayList<>(Arrays.asList("Llegaste al templo en el cielo, delante tuyo hay 2 estatuas, cada una con un destino diferente. Elige sabiamente!.","Llegaste a la isla del Curandero Loco, debes disparar a una de las dos vasijas que tienes delante para conseguir un item curativo.","Llegaste a la isla de la Loca de las Monedas, deberas jugar Cara o Cruz con ella para recibir una recompensa."));
        ArrayList<String> alternativas = new ArrayList<>(Arrays.asList("Estatua Divina del Cazador","Estatua Divina del Titan","Vasija de la izquierda","Vasija de la derecha","Elegir cara","Elegir Cruz"));
        Personaje enemy1= new Personaje("Slime", 0, 5, 5, 2, 1);
        Personaje enemy2= new Personaje("Creeper", 0, 10, 10, 5, 2);
        Personaje enemy3= new Personaje("Slingshot", 0, 8, 8, 5, 4);
        Personaje enemy4= new Personaje("Ghost", 0, 2, 2, 3, 1);
        Personaje enemy5= new Personaje("Hunter", 0, 10, 10, 6, 5);
        ArrayList<Personaje> enemigos = new ArrayList<>(Arrays.asList(enemy1,enemy2,enemy3,enemy4,enemy5));

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la profundidad del mapa");
        int profundidad= sc.nextInt();
        /*Nodo inicial siempre sera id 0 por lo que se iniciara en el main*/
        NodoInicial nodoinicial=new NodoInicial(0, null);
        Nodo nodoactual=nodoinicial;
        /*Se genera el grafo con el mapa (no lo inicie en la funcion verMapa()
        para poder usar el mismo grafo en la definicion de los nodos siguientes)*/
        SortedSet<Edge> edges = GraphGenerator.Generar(profundidad);
        /*Se genera el mapa*/
        Mapa gen_mapa= new Mapa(profundidad, nodoinicial, nodoactual);
        

        /*Se crea una lista con los nodos disponibles en el mapa sin agregar el nodo 0 que corresponderia al nodo inicial*/
        Set<Integer> nodos = new HashSet<>();
        for (Edge e : edges) {
            /*System.out.printf("%d->%d;\n", e.x, e.y);*/
            nodos.add(e.y);
        }
        ArrayList<Integer> encuentros=new ArrayList<>(nodos);

        /*Se identifica el ultimo nodo y se genera el jefe final con el id correspondiente al ultimo nodo del mapa*/
        int index = encuentros.size()-1;
        NodoJefeFinal nodo_boss = new NodoJefeFinal(encuentros.get(index), null, jefe);
        encuentros.remove(index);


        /*Generando todos los encuentros del mapa con las probabilidades correspondientes*/
        ArrayList<Nodo> allEncounters= new ArrayList<>();
        for (int i = 1; i <= encuentros.size(); i++) {
            double random = Math.random();
            /*Se elige uno de los 3 eventos disponibles, se crea el nodo y se agrega a la lista*/
            if(random<0.3){//Evento
                Random rndm=new Random();
                int num=rndm.nextInt(0,3);
                switch (num) {
                    case 0:
                        NodoEvento event = new NodoEvento(i, null, descripciones.get(0), alternativas.get(0), alternativas.get(1), item4, item6);
                        allEncounters.add(event);
                        break;
                    case 1:
                        NodoEvento event1 = new NodoEvento(i,null,descripciones.get(1),alternativas.get(2),alternativas.get(3),item3,item8);
                        allEncounters.add(event1);
                        break;
                    case 2:
                        NodoEvento event2 = new NodoEvento(i,null,alternativas.get(2),alternativas.get(4),alternativas.get(5),item2,item5);
                        allEncounters.add(event2);
                        break;
                }       
            }
            /*Cada tienda tendra un maximo de 4 items (pueden ser menos en caso de que se repita a la hora de la seleccion de items para cada tienda) */
            else if(random<0.4){//Tienda
                Set<Item> itemsSinRepetir = new HashSet<>();
                for (int cont = 0; cont < 4; cont++) {
                    Random rndm=new Random();
                    int num=rndm.nextInt(0,8);
                    Item tienda=items_tienda.get(num);
                    itemsSinRepetir.add(tienda);
                }
                ArrayList<Item> items_rndm= new ArrayList<>(itemsSinRepetir);
                NodoTienda encuentro_tienda= new NodoTienda(i,null,null);
                encuentro_tienda.setInventario(items_rndm);
                allEncounters.add(encuentro_tienda);
            }
            /*Se elige un enemigo de la lista de enemigos y se crea el nodo combate, posterior a eso se agrega el nodo a la lista */
            else{//Combate
                Random rndm=new Random();
                int num=rndm.nextInt(0,5);
                Personaje enemy=enemigos.get(num);
                NodoCombate combat = new NodoCombate(i, null, enemy);
                allEncounters.add(combat);
            }
        }
        /*Generar todas las listas de nodos posibles a los cuales se puede ir a partir de un nodo actual*/
        allEncounters.add(nodo_boss);
        allEncounters.add(0,nodoinicial);
        for (int t = 0; t < allEncounters.size(); t++) {
            Nodo NodoAct=allEncounters.get(t);
            int idNodo= NodoAct.getId();
            for (Edge e : edges) {
                if (e.x == idNodo) {
                    NodoAct.agregarNodo(allEncounters.get(e.y));
                }
            }
        }

        /*--------------------------------------------------------------------------------------------------------------------------------------------------------- */


        /*Comienza el juego interactuando con el nodo incial donde se da una pequena introduccion al juego*/
        allEncounters.get(0).interactuar(jugador1);
        /*Menu de interaccion para las opciones del usuario donde cada iteracion se verifica la vida del usuario para ver si continua el juego o no*/
        boolean flag=false;
        while (!flag){
            if (jugador1.GetHpActual() <= 0) {
                flag=true;
                System.out.println("\nJuego Terminado");
                break;
            }
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
                    gen_mapa.avanzar();
                    Nodo actualNode= gen_mapa.getNodo_actual();
                    actualNode.interactuar(jugador1);
                    continue;
                case 5:
                    System.out.println("Buena Eleccion!\n");
                    System.exit(0);
            }
        }
        
        if (jugador1.GetHpActual()<=0) {
            System.out.println("\nHas perdido");
        }
    }
}



















