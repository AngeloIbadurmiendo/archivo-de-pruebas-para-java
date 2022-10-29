import java.util.ArrayList;


public class Jugador extends Personaje {
    /*Atributo*/
    private ArrayList<Item> items_aplicados;

    /*Constructor*/
    public Jugador(String nombre, int dinero, int hp_actual, int hp_total, int damage, int defensa,
            ArrayList<Item> items_aplicados) {
        super(nombre, dinero, hp_actual, hp_total, damage, defensa);
        this.items_aplicados =new ArrayList<>();
    }

    /*Getters y Setters*/
    public ArrayList<Item> GetItems(){
        return items_aplicados;
    }
    public void SetItems(ArrayList<Item> newItemsAplicados){
        this.items_aplicados=newItemsAplicados;
    }
    /*Metodos*/
    public void verEstado(){
        String nombrepj=super.GetName();
        int dinero=super.GetDinero();
        int hp_actual=super.GetHpActual();
        int hp_total=super.GetHpTotal();
        int damage=super.GetDamage();
        int defensa=super.GetDefensa();
        System.out.println("\nPersonaje: "+nombrepj);
        System.out.println("Dinero: "+dinero);
        System.out.println("Vida Total: "+hp_total);
        System.out.println("Vida Actual: "+hp_actual);
        System.out.println("Daño: "+damage);
        System.out.println("Armadura: "+defensa+"\n");
    }
    public void verItems(){
        if(this.items_aplicados.isEmpty() == false){
            System.out.println(items_aplicados+"\n");
        }else{
            System.out.println("No cuentas con items aplicados actualmente");
        }
    }

}
