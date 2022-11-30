
package taquilla_banco;

public class Cliente {
    String nombre;
    String apellido;
    int n_solicitudes;
    String[] solicitud;
    boolean prioridad;

    public Cliente(String nom, String apell, int n_soli, String[] soli, Boolean priori) {
        this.nombre = nom;
        this.apellido = apell;
        this.n_solicitudes = n_soli;
        this.solicitud = soli;
        this.prioridad = priori;

    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getN_solicitudes() {
        return n_solicitudes;
    }

    public String[] getSolicitud() {
        return solicitud;
    }

    public boolean isPrioridad() {
        return prioridad;
    }
}
