package Modelos;

public class Asistencia {

    private int doc;
    private String tipo;
    private String fecha;
    private int nota;
    private String comentarioGerente;
    private String comentarioEmpleado;
    private String fechaInicio;
    private String fechaFin;

    public Asistencia() {
    }

    public Asistencia(int doc, String tipo, String fecha, int nota, String comentarioGerente, String comentarioEmpleado, String fechaInicio, String fechaFin) {
        this.doc = doc;
        this.tipo = tipo;
        this.fecha = fecha;
        this.nota = nota;
        this.comentarioGerente = comentarioGerente;
        this.comentarioEmpleado = comentarioEmpleado;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public int getDoc() {
        return doc;
    }

    public void setDoc(int doc) {
        this.doc = doc;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getComentarioGerente() {
        return comentarioGerente;
    }

    public void setComentarioGerente(String comentarioGerente) {
        this.comentarioGerente = comentarioGerente;
    }

    public String getComentarioEmpleado() {
        return comentarioEmpleado;
    }

    public void setComentarioEmpleado(String comentarioEmpleado) {
        this.comentarioEmpleado = comentarioEmpleado;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String toSaved() {
        return  "" + doc +
                "," + tipo +
                "," + fecha +
                "," + nota +
                "," + comentarioGerente +
                "," + comentarioEmpleado +
                "," + fechaInicio +
                "," + fechaFin + '\n' ;
    }

    public Asistencia toParseAsistecia(String s){

        Asistencia a = new Asistencia();
        if (!(s.isEmpty())) {
            String dt[] = s.split(",");
            a.setDoc(dt[0].isEmpty() ? 0 : Integer.parseInt(dt[0]));
            a.setTipo(dt[1].isEmpty() ? "" : dt[1].toString());
            a.setFecha(dt[2].isEmpty() ? "" : dt[2].toString());
            a.setNota(dt[3].isEmpty() ? 0 : Integer.parseInt(dt[3]));
            a.setComentarioGerente(dt[4].isEmpty() ? "" : dt[4].toString());
            a.setComentarioEmpleado(dt[5].isEmpty() ? "" : dt[5].toString());
            a.setFechaInicio(dt[6].isEmpty() ? "" : dt[6].toString());
            a.setFechaFin(dt[7].isEmpty() ? "" : dt[7].toString());
        }
        return a;
    }

    @Override
    public String toString() {
        return "Asistencia {" +
                "doc=" + doc +
                ", tipo='" + tipo + '\'' +
                ", fecha='" + fecha + '\'' +
                ", nota=" + nota +
                ", comentarioGerente='" + comentarioGerente + '\'' +
                ", comentarioEmpleado='" + comentarioEmpleado + '\'' +
                ", fechaInicio='" + fechaInicio + '\'' +
                ", fechaFin='" + fechaFin + '\'' +
                '}';
    }

}
