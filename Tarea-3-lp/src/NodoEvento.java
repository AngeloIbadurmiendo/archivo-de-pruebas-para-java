import java.util.ArrayList;
import java.util.Scanner;

public class NodoEvento extends Nodo{

    /*atributos*/
    private String descripcion;
    private String alternativa1;
    private String alternativa2;
    private Item resultado1;
    private Item resultado2;


    /*Constructors*/
    public NodoEvento(int id, ArrayList<Nodo> signodos, String descripcion, String alternativa1, String alternativa2,
            Item resultado1, Item resultado2) {
        super(id, signodos);
        this.descripcion = descripcion;
        this.alternativa1 = alternativa1;
        this.alternativa2 = alternativa2;
        this.resultado1 = resultado1;
        this.resultado2 = resultado2;
    }


    /*Getters y Setters*/
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAlternativa1() {
        return alternativa1;
    }
    public void setAlternativa1(String alternativa1) {
        this.alternativa1 = alternativa1;
    }

    public String getAlternativa2() {
        return alternativa2;
    }
    public void setAlternativa2(String alternativa2) {
        this.alternativa2 = alternativa2;
    }

    public Item getResultado1() {
        return resultado1;
    }
    public void setResultado1(Item resultado1) {
        this.resultado1 = resultado1;
    }

    public Item getResultado2() {
        return resultado2;
    }
    public void setResultado2(Item resultado2) {
        this.resultado2 = resultado2;
    }
    /*metodos*/
    /*Muestra una descripcion del evento y sus alternativas, cuando el jugador elige una de las alternativas
     * le aplica el item correspondiente*/
    public void interactuar(Jugador jugador){
       System.out.println("Descripcion: " + descripcion + "\nAlternativa1: " + alternativa1 + "\nAlternativa2: "
       + alternativa2);
       Scanner sc=new Scanner(System.in);
       int eleccion=sc.nextInt();

       if (eleccion==1){
        resultado1.aplicar(jugador);
        System.out.println("Se te aplico el Item "+resultado1.GetNombreItem());
       }
       else if(eleccion==2){
        resultado2.aplicar(jugador);
        System.out.println("Se te aplico el Item "+resultado2.GetNombreItem());
       }
    }


    @Override
    public String toString() {
        return "NodoEvento [descripcion=" + descripcion + ", alternativa1=" + alternativa1 + ", alternativa2="
                + alternativa2 + ", resultado1=" + resultado1 + ", resultado2=" + resultado2 + "]";
    }
    
}
