package taquilla_banco;

class Cliente {

    String nombre;
    String apellido;
    String[] solicitud;
    boolean prioridad;

    public Cliente(String nom, String apell, boolean priori, String[] soli) {
        this.nombre = nom;
        this.apellido = apell;
        this.prioridad = priori;
        this.solicitud = soli;
    }

    public String getInfo() {
        String a;
        if (prioridad) {
            a = "Sí";
        } else {
            a = "No";
        }
        return nombre + " " + apellido + " " + a + " " + getSolicitud();
    }

    public String getDat() {
        String a;
        if (prioridad) {
            a = "Sí";
        } else {
            a = "No";
        }
        return nombre + " " + apellido + " | Prioridad: " + a + " | Solicitudes: " + getSolicitud();
    }

    public String getSolicitud() {
        String c = "";
        for (String i : solicitud) {
            c += i + ",";
        }
        return c;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public boolean getPrioridad() {
        return prioridad;
    }

    public String[] getSolicitudArray() {
        return solicitud;
    }
}