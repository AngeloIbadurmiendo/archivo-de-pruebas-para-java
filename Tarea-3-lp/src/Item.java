import java.util.ArrayList;

public class Item {
    /*Atributos*/
    private String nombreItem;
    private int precio;
    private int recuperar_hp;
    private int aumentar_hp_total;
    private int aumentar_damage;
    private int aumentar_defensa;

    /*Constructor*/
    public Item(String nombreItem,int precio,int recuperar_hp,int aumentar_hp_total,int aumentar_damage,int aumentar_defensa){
        this.nombreItem=nombreItem;
        this.precio=precio;
        this.recuperar_hp=recuperar_hp;
        this.aumentar_hp_total=aumentar_hp_total;
        this.aumentar_damage=aumentar_damage;
        this.aumentar_defensa=aumentar_defensa;
    }
    /*Setters y Getters  (En esta pestana solo agregar getters ya que las stats de los items no son editables) */
    public String GetNombreItem(){
        return nombreItem;
    }
    public int getPrecio() {
        return precio;
    }
    public int getRecuperar_hp() {
        return recuperar_hp;
    }
    public int getAumentar_hp_total() {
        return aumentar_hp_total;
    }
    public int getAumentar_damage() {
        return aumentar_damage;
    }
    public int getAumentar_defensa() {
        return aumentar_defensa;
    }
    public void setNombreItem(String nombreItem) {
        this.nombreItem = nombreItem;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public void setRecuperar_hp(int recuperar_hp) {
        this.recuperar_hp = recuperar_hp;
    }
    public void setAumentar_hp_total(int aumentar_hp_total) {
        this.aumentar_hp_total = aumentar_hp_total;
    }
    public void setAumentar_damage(int aumentar_damage) {
        this.aumentar_damage = aumentar_damage;
    }
    public void setAumentar_defensa(int aumentar_defensa) {
        this.aumentar_defensa = aumentar_defensa;
    }


    /*metodo*/
    @Override
    public String toString(){
        return "\nItem: "+this.nombreItem+"\n"+"Precio: "+this.precio+"\n"+"Curacion: "+
                this.recuperar_hp+"\n"+"Aumento de HP maxima: "+this.aumentar_hp_total+"\n"+"Aumento de daño: "+
                this.aumentar_damage+"\n"+"Aumento de defensa: "+this.aumentar_defensa+"\n";
    }
    /*Obtiene las estadisticas actuales del jugador y le aplica las estadisticas del item, luego agrega el item a la lista
    de items aplicados del jugador */
    public void aplicar(Jugador jugador){
        int hpAct = jugador.GetHpActual();
        int hpMax = jugador.GetHpTotal();
        int dmg= jugador.GetDamage();
        int def=jugador.GetDefensa();
        hpMax += this.aumentar_hp_total;
        hpAct += this.recuperar_hp;
        if (hpAct > hpMax) {
            hpAct = hpMax;
        }
        dmg += this.aumentar_damage;
        def+= this.aumentar_defensa;
        jugador.SetHpTotal(hpMax);
        jugador.SetHpActual(hpAct);
        jugador.SetDamage(dmg);
        jugador.SetDefensa(def);

        ArrayList<Item> NuevaLista;
        NuevaLista=jugador.GetItems();
        NuevaLista.add(this);
        jugador.SetItems(NuevaLista);
        System.out.println("Item Aplicado");
    }
}
