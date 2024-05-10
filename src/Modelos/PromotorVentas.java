package Modelos;

public class PromotorVentas extends Empleado  {

    private String medioAtencion;

    public PromotorVentas() {
    }

    public PromotorVentas(String rol, String tipoDocumento, String numeroDocumento, String nombres, String apellidos, String estadoCivil, String direccion, String fechaNacimiento, String celular, String hijos, String fechaIngreso, String fechaSalida, Boolean habilitado, Double sueldo, String medioAtencion) {
        super(rol, tipoDocumento, numeroDocumento, nombres, apellidos, estadoCivil, direccion, fechaNacimiento, celular, hijos, fechaIngreso, fechaSalida, habilitado, sueldo);
        this.medioAtencion = medioAtencion;
    }

    public String getMedioAtencion() {
        return medioAtencion;
    }

    public void setMedioAtencion(String medioAtencion) {
        this.medioAtencion = medioAtencion;
    }

    @Override
    public String convertirTexto(String estatus) {

        if(estatus.equals("Actualizar")){
            return "PromotorVentas" + "," + getTipoDocumento() + "," + getNumeroDocumento() + "," + getNombres() + "," + getApellidos() + "," + getEstadoCivil() + "," + getDireccion() + "," + getFechaNacimiento() + "," + getCelular() + "," + getHijos() + "," + getFechaIngreso() + "," + getFechaSalida() + "," + getHabilitado() + "," + getSueldo() + "," + getMedioAtencion();
        }

        if(estatus.equals("Registrar")){
            return "PromotorVentas" + "," + getTipoDocumento() + "," + getNumeroDocumento() + "," + getNombres() + "," + getApellidos() + "," + getEstadoCivil() + "," + getDireccion() + "," + getFechaNacimiento() + "," + getCelular() + "," + getHijos() + "," + getFechaIngreso() + "," + getFechaSalida() + "," + getHabilitado() + "," + getSueldo() + "," + getMedioAtencion();
        }

        return "";

    }

    @Override
    public String mostrarEmpleado(String[] data) {

        return "Empleado{" +
                "rol='" + "Promotor de Ventas" + '\'' +
                ", tipoDocumento=" + data[1] +
                ", numeroDocumento=" + data[2] +
                ", nombres='" + data[3] + '\'' +
                ", apellidos='" + data[4] + '\'' +
                ", estadoCivil=" + data[5] +
                ", direccion='" + data[6] + '\'' +
                ", fechaNacimiento='" + data[7] + '\'' +
                ", celular=" + data[8] +
                ", hijos=" + data[9] +
                ", FechaIngreso='" + data[10] + '\'' +
                ", FechaSalida='" + data[11] + '\'' +
                ", Habilitado=" + Boolean.parseBoolean(data[12]) +
                ", sueldo=" + data[13] +
                ", medioAtencion=" + data[14] +
                '}';

    }

    @Override
    public Empleado convertirEmpleado(String[] data) {

        return new PromotorVentas(
                data[0],
                data[1],
                data[2],
                data[3],
                data[4],
                data[5],
                data[6],
                data[7],
                data[8],
                data[9],
                data[10],
                data[11],
                Boolean.parseBoolean(data[12]),
                Double.parseDouble(data[13]),
                data[14]
        );

    }

}
