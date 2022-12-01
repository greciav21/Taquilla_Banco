package taquilla_banco;

public class Nodo {
    Cliente clt;
    Nodo sig;

    Nodo(Cliente clt) {
        this.clt = clt;
    }
}

    class NodoA {
        Cliente Cliente;
        NodoA Down;

    public NodoA(Cliente clt) {
        this.Cliente = clt;
    }
}