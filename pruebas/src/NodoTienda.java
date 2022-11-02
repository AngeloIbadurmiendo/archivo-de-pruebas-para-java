import java.util.ArrayList;
import java.util.Scanner;




public class NodoTienda extends Nodo {
    /*atributo*/
    private ArrayList<Item> inventario;

    public NodoTienda(int id, ArrayList<Nodo> signodos, ArrayList<Item> inventario) {
        super(id, signodos);
        this.inventario = new ArrayList<>();
    }

    /*Getters y Setters */
    public ArrayList<Item> getInventario() {
        return inventario;
    }
    public void setInventario(ArrayList<Item> inventario) {
        this.inventario = inventario;
    }
    

    @Override
    public String toString() {
        return "NodoTienda [inventario=" + inventario + "]";
    }

    /*metodos*/
    public void interactuar(Jugador jugador){
        System.out.println("Bienvenido a la tienda de JavaQuest.");
        System.out.println("Aqui encontraras items que pueden ser muy utiles para tu aventura.");
        System.out.println("El inventario de la tienda es el siguiente: ");
        for (int i = 0; i < this.inventario.size(); i++) {
            System.out.println("Item "+(i+1));
            System.out.println(this.inventario.get(i));
        }
        System.out.println("Ingresa 5 si no quieres comprar nada");
        Scanner sc = new Scanner(System.in);
        Boolean flag = false;
        while (!flag) {
            int money=jugador.GetDinero();
            System.out.println("Actualmente tienes "+money);
            System.out.println("Que compraras?.");
            int respuesta= sc.nextInt();
            if (respuesta==5 || jugador.GetDinero() <= 0) {
                flag=true;
                System.out.println("Has salido de la tienda");
                break;
            }
            Item selectedItem= inventario.get((respuesta-1));
            if (selectedItem.getPrecio() > jugador.GetDinero()) {
                System.out.println("No tienes dinero suficiente para comprar este item");
                continue;
            }else{
                this.comprar((respuesta-1), jugador);
                continue;
            }
        }


        // while (jugador.GetDinero() > 0 && respuesta != 5) {
        //     Item selectedItem= inventario.get((respuesta-1));
        //     if (selectedItem.getPrecio() > jugador.GetDinero()) {
        //         System.out.println("No tienes dinero suficiente para comprar este item");
        //     }else{
        //         this.comprar((respuesta-1), jugador);
        //     }
        // }

    }
    public void comprar(Integer eleccion,Jugador player){
        ArrayList<Item> shop_opt=this.inventario;
        Item compra=shop_opt.get(eleccion);
        int op=player.GetDinero() - compra.getPrecio();
        player.SetDinero(op);
        compra.aplicar(player);
    }
}
