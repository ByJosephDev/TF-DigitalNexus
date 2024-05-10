package Modelos;

public class Capacitacion {

    private int doc;
    private String categoria;
    private String area;
    private String nombre;
    private String descripcion;
    private String fechaInicio;
    private String fechaFin;

    public Capacitacion() {
    }

    public Capacitacion(int doc, String categoria, String area, String nombre,
                                String descripcion, String fechaInicio, String fechaFin) {
        this.doc = doc;
        this.categoria = categoria;
        this.area = area;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public int getDoc() {
        return doc;
    }

    public void setDoc(int doc) {
        this.doc = doc;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public String toSave() {
        return "" + doc +
                "," + categoria +
                "," + area +
                "," + nombre +
                "," + descripcion +
                "," + fechaInicio +
                "," + fechaFin + '\n';
    }

    public Capacitacion toParseCapacitaciones(String s){
        Capacitacion lCapacitaciones = new Capacitacion();
        if (!(s.isEmpty())) {
            String dt[] = s.split(",");
            lCapacitaciones.setDoc(dt[0].isEmpty() ? 0 : Integer.parseInt(dt[0]));
            lCapacitaciones.setCategoria(dt[1].isEmpty() ? "" : (dt[1]).toString());
            lCapacitaciones.setArea(dt[2].isEmpty() ? "" : dt[2].toString());
            lCapacitaciones.setNombre(dt[3].isEmpty() ? "" : (dt[3]).toString());
            lCapacitaciones.setDescripcion(dt[4].isEmpty() ? "" : dt[4].toString());
            lCapacitaciones.setFechaInicio(dt[5].isEmpty() ? "" : dt[5].toString());
            lCapacitaciones.setFechaFin(dt[6].isEmpty() ? "" : dt[6].toString());
        }
        return lCapacitaciones;
    }

    @Override
    public String toString() {
        return "Capacitaciones {" +
                "doc=" + doc +
                ", categoria='" + categoria + '\'' +
                ", area='" + area + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaInicio='" + fechaInicio + '\'' +
                ", fechaFin='" + fechaFin + '\'' +
                '}';
    }

}
