package taquilla_banco;

import java.io.IOException;

public class Cola {

    Nodo front;
    Nodo rear;

    boolean estaVacia() {
        return front == null;
    }

    public void Encolar(Nodo clt) {
        if (this.estaVacia()) {
            front = rear = clt;
        } else {
            rear.sig = clt;
            rear = rear.sig;
        }
    }

    public Nodo Desencolar() {
        if (this.estaVacia()) {
            System.out.println("No hay nadie en la cola");

            return null;
        } else {
            Nodo aux = front;
            front = this.front.sig;
            aux.sig = null;
            return aux;
        }
    }

    public void EncolarClientes(String fuente) throws IOException {
        if (Archivo.LeerArchivo(fuente) != null) {
            String[] Clientes = Archivo.LeerArchivo(fuente).split("\n");

            String[] Datos;
            String[] Solicitudes;
            for (String i : Clientes) {
                Datos = i.split(" ");
                Solicitudes = Datos[3].split(",");
                Encolar(new Nodo(new Cliente(Datos[0], Datos[1], Datos[2].equalsIgnoreCase("si"), Solicitudes)));
            }
        }
    }

    public void ImprimirDesencolar(String direccion) throws IOException {
        String s = Desencolar().clt.getInfo();
        while (!estaVacia()) {
            s += "\n" + Desencolar().clt.getInfo();
        }
        Archivo.EscribirArchivo(s, direccion);
    }

    void DesencolarPrioridad() {
        if (this.front != null) {
            Nodo aux = this.front;
            while (aux.sig != null) {
                if (aux.sig.clt.getPrioridad()) {
                    Nodo aux2 = aux.sig;
                    aux.sig = aux.sig.sig;
                    aux2.sig = this.front;
                    this.front = aux2;
                    break;
                }
                if (aux.sig != null) {
                    aux = aux.sig;
                }
            }
        }
    }
}