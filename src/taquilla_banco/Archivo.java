package taquilla_banco;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Archivo {

    static String LeerArchivo(String direccion) throws IOException {
        File f = new File(direccion);
        if (f.exists()) {
            BufferedReader br = new BufferedReader(new FileReader(direccion));
            String s;
            s = br.readLine();
            String datos = s;
            while ((s = br.readLine()) != null) {
                datos += "\n" + s;//imprimir linea mas salto de linea
            }
            return datos;
        }
        return null;
    }

    void EliminarArchivo(String direccion) {
        File f = new File(direccion);
        if (f.exists()) {
            f.delete();
        }
    }

    static void EscribirArchivo(String dato, String direccion) throws IOException {
        FileWriter archivo = null;
        PrintWriter escribir = null;
        try {
            archivo = new FileWriter(direccion);
            escribir = new PrintWriter(archivo);
            escribir.println(dato);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            archivo.close();
        }
    }
}