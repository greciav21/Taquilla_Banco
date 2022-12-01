package taquilla_banco;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Taquilla_Banco {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String Finalizar;
        String Opción;
        do {
            LocalDate fecha = LocalDate.parse(Archivo.LeerArchivo("fecha.in"));
            LocalTime InicioTaquilla = LocalTime.of(8, 0);
            LocalTime CierreTaquilla = LocalTime.of(15, 30);
            LocalTime AtenciónClientes = InicioTaquilla;

            Cola Clientes = new Cola();
            Cola ClientesPendientes = new Cola();
            Archivo A = new Archivo();
            Pila ClientesAtendidos = new Pila();

            ClientesPendientes.EncolarClientes("ClientesPendientes.in");
            A.EliminarArchivo("ClientesPendientes.in");
            Clientes.EncolarClientes("Clientes.in");

            System.out.println("\t * * * TAQUILLA BANESCO * * * ");
            System.out.println("");
            System.out.print("Hoy es: " + fecha + ". Son las [" + InicioTaquilla + "], Opciones: \n\n"
                    + "a : Para Iniciar Proceso:\n" + "b : Para Finalizar Proceso:\n\n");

            System.out.print("[Opción]---------> ");
            Opción = sc.nextLine();

            switch (Opción) {
                case "a":
                    int Catendidos = 0;
                    Cliente C = null;
                    while (!Clientes.estaVacia() && AtenciónClientes.isBefore(CierreTaquilla)) {
                        if (!ClientesPendientes.estaVacia()) {
                            System.out.println("");
                            if (Catendidos > 3) {
                                ClientesPendientes.DesencolarPrioridad();
                                Catendidos = 0;
                            }
                            C = ClientesPendientes.Desencolar().clt;
                            Catendidos++;

                        } else if (!Clientes.estaVacia() && ClientesPendientes.estaVacia()) {
                            System.out.println("");
                            if (Catendidos > 3) {
                                Clientes.DesencolarPrioridad();
                                Catendidos = 0;
                            }
                            C = Clientes.Desencolar().clt;
                            Catendidos++;
                        }
                        if (C != null) {
                            System.out.print("\t A las [" + AtenciónClientes + "] Hora" + " --> " + "Se atiende a: " + C.getNombre() + " " + C.getApellido());
                            for (String i : C.getSolicitudArray()) {

                                switch (i) {
                                    case "retiro":
                                        AtenciónClientes = AtenciónClientes.plusMinutes(4);
                                        break;
                                    case "deposito":
                                        AtenciónClientes = AtenciónClientes.plusMinutes(3);
                                        break;
                                    case "consulta/movimientos":
                                        AtenciónClientes = AtenciónClientes.plusMinutes(1);
                                        AtenciónClientes = AtenciónClientes.plusSeconds(30);
                                        break;
                                    case "actualizacion/libreta":
                                        AtenciónClientes = AtenciónClientes.plusMinutes(5);
                                        break;
                                    case "pago/Servicios":
                                        AtenciónClientes = AtenciónClientes.plusMinutes(2);
                                        break;
                                }
                            }
                            System.out.println(" --> Realizó: " + C.getSolicitud());
                            ClientesAtendidos.push(new NodoA(C));
                        }
                    }
                    break;
                case "b":
                    break;
                default:
                    System.out.println("opcion no valida");
                    break;
            }
            if (!Clientes.estaVacia()) {
                Clientes.ImprimirDesencolar("ClientesPendientes.in");
                System.out.println("No Se Pudo Atender A Todos Los Clientes.");
            }
            if (!ClientesAtendidos.estaVacia()) {
                ClientesAtendidos.ImprimirDesapilar(" Taquilla " + fecha.toString() + " ");
            }
            fecha = fecha.plusDays(1);
            Archivo.EscribirArchivo(fecha.toString(), "fecha.in");
            System.out.println("");
            
            System.out.print("¿Cerrar el Proceso Bancario? s / n: ---> ");
            Finalizar = sc.nextLine();
          
            if (Finalizar.equals("n")) {
                System.out.println("Siguiente Día, Procesando Clientes.");
                System.out.println("");
            }
        } while (!Finalizar.equalsIgnoreCase("s"));
    }
}