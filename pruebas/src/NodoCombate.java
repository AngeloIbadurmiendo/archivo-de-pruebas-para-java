import java.util.ArrayList;
import java.util.Random;

public class NodoCombate extends Nodo {
    /*Atributos*/
    private Personaje enemigo;

    /*Constructor */
    public NodoCombate(int id, ArrayList<Nodo> signodos, Personaje enemigo) {
        super(id, signodos);
        this.enemigo = enemigo;
    }

    /*Setters y Getters */
    public Personaje getEnemigo() {
        return enemigo;
    }

    public void setEnemigo(Personaje enemigo) {
        this.enemigo = enemigo;
    }

    /*Metodos */
    public void interactuar(Jugador jugador){
        System.out.println("Comienza el combate contra "+enemigo.GetName()+"\n");
        Random rndm = new Random();
        while (jugador.GetHpActual() > 0 && enemigo.GetHpActual() > 0) {
            int num = rndm.nextInt(1,2);
            if (num==1) {
                jugador.combate(enemigo);
            } else {
                enemigo.combate(jugador);
            }
            System.out.println("Actualizacion de combate:");
            System.out.println("Vida restante del enemigo "+enemigo.GetHpActual());
            System.out.println("Vida restante de "+jugador.GetName()+" "+jugador.GetHpActual());
        }
    }

    @Override
    public String toString() {
        return "NodoCombate [enemigo=" + enemigo + "]";
    }
    
}
