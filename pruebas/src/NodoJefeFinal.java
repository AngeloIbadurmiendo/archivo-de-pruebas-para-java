import java.util.ArrayList;
import java.util.Random;

public class NodoJefeFinal extends Nodo {
    /*atributos*/
    private Personaje jefe;  

    /*Constructor*/
    public NodoJefeFinal(int id, ArrayList<Nodo> signodos, Personaje jefe) {
        super(id, signodos);
        this.jefe = jefe;
    }
    
    /*Getters y Setters*/
    public Personaje getJefe() {
        return jefe;
    }
    public void setJefe(Personaje jefe) {
        this.jefe = jefe;
    }
    
    @Override
    public String toString() {
        return "NodoJefeFinal [jefe=" + jefe + "]";
    }

    /*metodo*/
    public void interactuar(Jugador jugador){
        System.out.println("Comienza el combate contra "+jefe.GetName()+"\n");
        Random rndm = new Random();
        while (jugador.GetHpActual() > 0 && jefe.GetHpActual() > 0) {
            int num = rndm.nextInt(1,3);
            if (num==1) {
                jugador.combate(jefe);
            } else {
                jefe.combate(jugador);
            }
            System.out.println("Actualizacion de combate:");
            System.out.println("Vida restante del jefe "+jefe.GetHpActual());
            System.out.println("Vida restante de "+jugador.GetName()+" "+jugador.GetHpActual());
        if (jefe.GetHpActual() <= 0) {
            System.out.println("Felicidades, derrotaste al jefe y ganaste el juego");
        }
        }
    }
}
