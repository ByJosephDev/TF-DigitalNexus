package Modelos;

public class Desempenio {

    private int doc;
    private int notaGerente;
    private int notaEmpleado;
    private String area;
    private String descripcionGerente;
    private String descripcionEmpleado;
    private String fecha;

    public Desempenio() {
    }
    public Desempenio(int doc, int notaGerente, int notaEmpleado, String area, String descripcionGerente, String descripcionEmpleado, String fecha) {
        this.doc = doc;
        this.notaGerente = notaGerente;
        this.notaEmpleado = notaEmpleado;
        this.area = area;
        this.descripcionGerente = descripcionGerente;
        this.descripcionEmpleado = descripcionEmpleado;
        this.fecha = fecha;
    }

    public int getDoc() {
        return doc;
    }

    public void setDoc(int doc) {
        this.doc = doc;
    }

    public int getNotaGerente() {
        return notaGerente;
    }

    public void setNotaGerente(int notaGerente) {
        this.notaGerente = notaGerente;
    }

    public int getNotaEmpleado() {
        return notaEmpleado;
    }

    public void setNotaEmpleado(int notaEmpleado) {
        this.notaEmpleado = notaEmpleado;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDescripcionGerente() {
        return descripcionGerente;
    }

    public void setDescripcionGerente(String descripcionGerente) {
        this.descripcionGerente = descripcionGerente;
    }

    public String getDescripcionEmpleado() {
        return descripcionEmpleado;
    }

    public void setDescripcionEmpleado(String descripcionEmpleado) {
        this.descripcionEmpleado = descripcionEmpleado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String toSave() {
        return  "" + doc +
                "," + notaGerente +
                "," + notaEmpleado +
                "," + area +
                "," + descripcionGerente +
                "," + descripcionEmpleado +
                "," + fecha + '\n';
    }

    public Desempenio toParseDesempenioEntity(String s){
        Desempenio lDesempenio = new Desempenio();
        if (!(s.isEmpty())) {
            String dt[] = s.split(",");
            lDesempenio.setDoc(dt[0].isEmpty() ? 0 : Integer.parseInt(dt[0]));
            lDesempenio.setNotaGerente(dt[1].isEmpty() ? 0 : Integer.parseInt(dt[1]));
            lDesempenio.setNotaEmpleado(dt[2].isEmpty() ? 0 : Integer.parseInt(dt[2]));
            lDesempenio.setArea(dt[3].isEmpty() ? "" : dt[3].toString());
            lDesempenio.setDescripcionGerente(dt[4].isEmpty() ? "" : dt[4].toString());
            lDesempenio.setDescripcionEmpleado(dt[5].isEmpty() ? "" : dt[5].toString());
            lDesempenio.setFecha(dt[6].isEmpty() ? "" : dt[6].toString());
        }
        return lDesempenio;
    }

    @Override
    public String toString() {
        return "Desempenio {" +
                "doc=" + doc +
                ", notaGerente=" + notaGerente +
                ", notaEmpleado=" + notaEmpleado +
                ", area='" + area + '\'' +
                ", descripcionGerente='" + descripcionGerente + '\'' +
                ", descripcionEmpleado='" + descripcionEmpleado + '\'' +
                ", fecha='" + fecha + '\'' +
                '}';
    }

}
