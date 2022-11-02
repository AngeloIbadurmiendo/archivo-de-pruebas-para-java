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
    /*Realiza una copia del enemigo a luchar, entrega la vida principal de cada uno y luego comienza el combate de 
    tal forma que hay un 50% de probabilidad de atacar o de recibir un ataque. Tambien entrega la vida actual de 
    cada uno (Jugador y enemigo) luego de cada turno/ataque.*/
    public void interactuar(Jugador jugador){
        System.out.println("Comienza el combate contra "+enemigo.GetName()+"\n");
        Random rndm = new Random();
        Personaje enemigo_temporal= new Personaje(enemigo.GetName(), enemigo.GetDinero(), enemigo.GetHpActual(),enemigo.GetHpTotal(),enemigo.GetDamage(),enemigo.GetDefensa());
        System.out.println("Vida inicial del enemigo "+enemigo.GetHpActual());
        System.out.println("Vida inicial de "+jugador.GetName()+" "+jugador.GetHpActual());
        while ((jugador.GetHpActual() > 0) && (enemigo_temporal.GetHpActual() > 0)) {
            int num = rndm.nextInt(1,3);
            if (num==1) {
                jugador.combate(enemigo_temporal);
            }else{
                enemigo_temporal.combate(jugador);
            }
            System.out.println("Actualizacion de combate:");
            System.out.println("Vida restante del enemigo "+enemigo_temporal.GetHpActual());
            System.out.println("Vida restante de "+jugador.GetName()+" "+jugador.GetHpActual());
        }
    }

    @Override
    public String toString() {
        return "NodoCombate [enemigo=" + enemigo + "]";
    }
    
}
