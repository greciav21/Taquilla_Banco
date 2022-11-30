
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
            }
            return datos;
        }
        return null;
    }

    void EliminarArchivos(String direccion) {
        File f = new File(direccion);
        if (f.exists()) {
            f.delete();
        }
    }

    static void EscribirArchivos(String ruta, String datos) throws IOException {
        FileWriter archivo = null;
        PrintWriter escribir = null;

        try {
            archivo = new FileWriter(ruta);
            escribir = new PrintWriter(archivo);

            escribir.println(datos);

        } catch (IOException excep) {
            System.out.println("Error en los Archivos" + excep.getMessage());
        }
    }
}
