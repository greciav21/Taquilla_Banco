
package taquilla_banco;


public class Nodo {
    Cliente clt;
    boolean prioridad;
    Nodo sig;
    Nodo(Cliente clt){
        this.clt = clt;
        this.prioridad = false;
    }
    
    Nodo(Cliente clt, boolean prioridad){
        this.clt = clt;
        this. prioridad = true;
    }
    
}


 class NodoA {
    String Clientes;
    NodoA Down;
    public NodoA (String Clt){
        this.Clientes= Clt;
    }
}

