package Modelos;

public class AdministradorRRHH extends Empleado{

    private boolean estatusAplicacion;

    public AdministradorRRHH() {
    }

    public AdministradorRRHH(String rol, String tipoDocumento, String numeroDocumento, String nombres, String apellidos, String estadoCivil, String direccion, String fechaNacimiento, String celular, String hijos, String fechaIngreso, String fechaSalida, boolean habilitado, double sueldo, boolean estatusAplicacion) {
        super(rol, tipoDocumento, numeroDocumento, nombres, apellidos, estadoCivil, direccion, fechaNacimiento, celular, hijos, fechaIngreso, fechaSalida, habilitado, sueldo);
        this.estatusAplicacion = estatusAplicacion;
    }

    public boolean getEstatusAplicacion() {
        return estatusAplicacion;
    }

    public void setEstatusAplicacion(boolean estatusAplicacion) {
        this.estatusAplicacion = estatusAplicacion;
    }

    @Override
    public String convertirTexto(String estatus) {

        if(estatus.equals("Actualizar")){
            return "AdministradorRRHH" + "," + getTipoDocumento() + "," + getNumeroDocumento() + "," + getNombres() + "," + getApellidos() + "," + getEstadoCivil() + "," + getDireccion() + "," + getFechaNacimiento() + "," + getCelular() + "," + getHijos() + "," + getFechaIngreso() + "," + getFechaSalida() + "," + getHabilitado() + "," + getSueldo() + "," + getEstatusAplicacion();
        }

        if(estatus.equals("Registrar")){
            return "AdministradorRRHH" + "," + getTipoDocumento() + "," + getNumeroDocumento() + "," + getNombres() + "," + getApellidos() + "," + getEstadoCivil() + "," + getDireccion() + "," + getFechaNacimiento() + "," + getCelular() + "," + getHijos() + "," + getFechaIngreso() + "," + getFechaSalida() + "," + getHabilitado() + "," + getSueldo() + "," + getEstatusAplicacion();
        }

        return "";

    }

    @Override
    public String mostrarEmpleado(String[] data) {

        return "Empleado{" +
                "rol='" + "Administrador de RRHH" + '\'' +
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
                ", estatusAplicacion=" + Boolean.parseBoolean(data[14]) +
                '}';

    }

    @Override
    public Empleado convertirEmpleado(String[] data) {

        return new AdministradorRRHH(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8], data[9], data[10], data[11], Boolean.parseBoolean(data[12]), Double.parseDouble(data[13]), Boolean.parseBoolean(data[14]));

    }


}
