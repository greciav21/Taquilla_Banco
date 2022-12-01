package taquilla_banco;

import java.io.IOException;

public class Pila {
    NodoA top;

    public boolean estaVacia() {
        return top == null;
    }

    void push(NodoA clt) {
        if (this.top == null) {
            this.top = clt;
        } else {
            NodoA topAux = this.top;
            this.top = clt;
            this.top.Down = topAux;
        }
    }

    NodoA pop() {
        if (this.estaVacia()) {
            System.out.println("La pila esta vacia");
            return null;
        } else {
            NodoA aux = this.top;
            this.top = this.top.Down;
            return aux;
        }
    }

    NodoA peek() {
        if (this.estaVacia()) {
            System.out.println("La pila esta vacia");
            return null;
        } else {
            return new NodoA(top.Cliente);
        }
    }

    void ImprimirDesapilar(String direccion) throws IOException {
        if (!estaVacia()) {
            String s = pop().Cliente.getDat();

            while (!estaVacia()) {
                s += "\n" + pop().Cliente.getDat();
            }
            Archivo.EscribirArchivo(s, direccion);
        }
    }
}