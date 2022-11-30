
package taquilla_banco;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;


public class Taquilla_Banco {

    static Scanner scr = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        
        
        
        String Finalizar;
        String Opción;
        do {
            LocalDate fecha = LocalDate.of(2022, 11, 30);
            LocalTime iniciotaquilla = LocalTime.of(8, 0);
            LocalTime cierretaquilla = LocalTime.of(3, 30);
            LocalTime AtencionCliente = iniciotaquilla;

            Cola ClientesPendientes = new Cola();
            Cola Clientes = new Cola();
            Pila ClientesAtendidos = new Pila();
            Archivo a = new Archivo();

            //ClientesPendientes.EncolarClientes("ClientesPendientes.in");
            a.EliminarArchivos("ClientesPendientes");
           // Clientes.EncolarClientes("Clientes.in");

            System.out.println("\tTaquilla Banesco");
            System.out.println();
            System.out.println("");
            System.out.println(" " + fecha + " " + iniciotaquilla + "Elegir Opción: \n");
            System.out.println("A --> Atender Clientes.\n");
            System.out.println("B --> Finalizar Proceso.\n");

            Opción = scr.nextLine();

            switch (Opción) {
                case "1":
                    int clientesatendidos = 0;
                    Cliente c = null;
                    while (!Clientes.estaVacia() && AtencionCliente.isBefore(cierretaquilla)) {
                        if (!ClientesPendientes.estaVacia()) {
                            System.out.println("");
                            if (clientesatendidos > 3) {
                                ClientesPendientes.Desencolar_prioridad();
                                clientesatendidos = 0;
                            }
                            c = ClientesPendientes.Desencolar().clt;
                            clientesatendidos++;
                        }
                        if (c != null) {
                            System.out.println("A la Hora" + AtencionCliente + "Se Atendió a" + c.getNombre() + c.getApellido());
                            for (String i : c.getSolicitud()) {
                                switch (i) {
                                    case "Consulta Movimientos":
                                        AtencionCliente = AtencionCliente.plusMinutes(1);
                                        AtencionCliente = AtencionCliente.plusSeconds(30);
                                        break;
                                    case "Pago Servicios":
                                        AtencionCliente = AtencionCliente.plusMinutes(2);
                                        break;
                                    case "Depósito":
                                        AtencionCliente = AtencionCliente.plusMinutes(3);
                                        break;
                                    case "Retito":
                                        AtencionCliente = AtencionCliente.plusMinutes(4);
                                        break;
                                    case "Actualización Libreta":
                                        AtencionCliente = AtencionCliente.plusMinutes(5);
                                        break;
                                }
                            }
                            System.out.println("Realizó: " + c.getSolicitud());
                            //ClientesAtendidos.push(new NodoA(c));
                        }
                    }
                    break;
                case "2":
                    break;
                default:
                    System.out.println("Solicitud no Valida");
                    break;
            }
            if (!Clientes.estaVacia()) {
                //Clientes.MostrarCola("ClientesPendientes.in");
                System.out.println("No Se Pudo Atender A Todos Los Clientes.");
            }
            /*if (!ClientesAtendidos.estaVacia()) {
                ClientesAtendidos.popImprimir("Taquilla " + fecha.toString() + ".log");
            }
            fecha = fecha.plusDays(1);
            Archivo.EscribirArchivos(fecha.toString(), "LocalDate.of(2022, 11, 30)");

            System.out.println("");
            System.out.println("Cerrar Proceso Bancario S / N: ");
            Finalizar = scr.nextLine();

            if (Finalizar.equals("N")) {
                System.out.println("Pasar Al Siguiente Día");
                System.out.println("");
            }
        } while (!Finalizar.equalsIgnoreCase("S"));
    }*/

    
}
