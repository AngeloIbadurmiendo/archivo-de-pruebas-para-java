import java.util.ArrayList;

public class NodoInicial extends Nodo {
    /*constructor*/
    public NodoInicial(int id, ArrayList<Nodo> signodos) {
        super(id, signodos);
    }
    /*metodo*/
    /*Muestra una descripcion del juego y lo que se puede encontrar en las distintas etapas de este */
    public void interactuar(Jugador jugador){
        System.out.println("\nBienvenido a JavaQuest, "+jugador.GetName());
        System.out.println("Este juego consiste en una serie de encuentros donde cada uno de ellos implica una prueba distinta");
        System.out.println("Tienes 4 posibilidades de encuentros: ");
        System.out.println("1. Combate: Cada vez que llegues a un encuentro de tipo Combate tendras que luchar por tu vida contra una serie de enemigos, cada uno con estadisticas diferentes y recompensas distintas.");
        System.out.println("2. Tienda: Cada vez que llegues a un encuentro de tipo Tienda tendras una lista de items que puedes comprar, cada item tendra distinto precio y estadisticas para ofrecer.");
        System.out.println("3. Evento: Cada vez que llegues a un encuentro de tipo Evento te encontraras con una pequeña descripcion, alternativas y recompensas al azar.");
        System.out.println("4. Jefe Final: Este corresponde a un nodo de tipo combate aunque te encontraras con un enemigo mucho mas poderoso que los vistos anteriormente, si logras derrotarlo te habras pasado el juego.");
        System.out.println("Ahora que sabes todo lo que puedes encontrar en JavaQuest, te reto a salir de la zona de confort y enfrentarte a los desafios que esperan por ti.");
        System.out.println("Mucha Suerte!\n");
        System.out.println("Presiona ENTER para continuar!");
                    try{System.in.read();}
                        catch(Exception e){};
    }
}
