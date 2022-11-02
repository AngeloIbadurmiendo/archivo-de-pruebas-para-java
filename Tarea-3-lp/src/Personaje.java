public class Personaje {

    /*Atributos*/
    private String nombre;
    private int dinero;
    private int hp_actual;
    private int hp_total;
    private int damage;
    private int defensa;


    /*Constructor*/
    public Personaje(String nombre, int dinero, int hp_actual, int hp_total, int damage, int defensa) {
        this.nombre = nombre;
        this.dinero = dinero;
        this.hp_actual = hp_actual;
        this.hp_total = hp_total;
        this.damage = damage;
        this.defensa = defensa;
    }


    /*Setters y Getters*/
    public String GetName(){
        return nombre;
    }
    public void SetName(String NewNombre){
        this.nombre=NewNombre;
    }

    public int GetDinero(){
        return dinero;
    }
    public void SetDinero(int NewDinero){
        this.dinero = NewDinero;
    }

    public int GetHpActual(){
        return hp_actual;
    }
    public void SetHpActual(int NewHpActual){
        this.hp_actual=NewHpActual;
    }

    public int GetHpTotal(){
        return hp_total;
    }
    public void SetHpTotal(int NewHpTotal){
        this.hp_total=NewHpTotal;
    }

    public int GetDamage(){
        return damage;
    }
    public void SetDamage(int NewDamage){
        this.damage=NewDamage;
    }

    public int GetDefensa(){
        return defensa;
    }
    public void SetDefensa(int NewDefensa){
        this.defensa=NewDefensa;
    }
    

    @Override
    public String toString() {
        return "Personaje [nombre=" + nombre + ", dinero=" + dinero + ", hp_actual=" + hp_actual + ", hp_total="
                + hp_total + ", damage=" + damage + ", defensa=" + defensa + "]";
    }


    /*Metodos*/
    /*Obtiene algunas estadisticas del contrincante y realiza el calculo de la nueva vida del contrincante.
    calculo = vidaContrincante - (danoAtacante - defensaContrincante)
    (personaje.combate(contrincante) -> personaje ataca contrincante)
    finalmente settea los valores correspondientes a la ronda de ataque*/

    public void combate(Personaje contrincante) {
        int vidaContrincante=contrincante.GetHpActual();
        int dmgAtacante=this.damage;
        int defensaContrincante=contrincante.GetDefensa();
        int newHPE= vidaContrincante-(dmgAtacante-defensaContrincante);
        if (dmgAtacante-defensaContrincante <=0) {
            contrincante.SetHpActual(vidaContrincante);
        }else{
            contrincante.SetHpActual(newHPE);
        }
    }
}
