package Utilidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ConfigurationVariables {

    private static final String ARCHIVO_EMPLEADO_URL = "src/Archivos/Empleados.txt";
    private static final String ARCHIVO_ASISTENCIA_URL = "src/Archivos/Asistencias.txt";
    private static final String ARCHIVO_CAPACITACION_URL = "src/Archivos/Capacitaciones.txt";
    private static final String ARCHIVO_RETROALIMENTACIONES_URL = "src/Archivos/Retroalimentaciones.txt";

    public static String obtenerURLArchivoEmpleados() {
        return ARCHIVO_EMPLEADO_URL;
    }

    public static String obtenerURLArchivoAsistencias() {
        return ARCHIVO_ASISTENCIA_URL;
    }

    public static String obtenerURLArchivoCapacitaciones() {
        return ARCHIVO_CAPACITACION_URL;
    }

    public static String obtenerURLArchivoRetroalimentaciones() {
        return ARCHIVO_RETROALIMENTACIONES_URL;
    }

    public static void mostrarRoles() {
        System.out.println("Roles disponibles:");
        System.out.println("1. Soporte Tecnico");
        System.out.println("2. Administrador RRHH");
        System.out.println("3. Auxiliar Almacen");
        System.out.println("4. Contador");
        System.out.println("5. Promotor de Ventas");
        System.out.println("6. Especialista de Marketing");
    }

    public static String diccionarioRoles(int rol){

        switch (rol){
            case 1:
                return "SoporteTecnico";
            case 2:
                return "AdminRRHH";
            case 3:
                return "AuxAlmacen";
            case 4:
                return "Contador";
            case 5:
                return "PromotorVentas";
            case 6:
                return "EspecialistaMarketing";
            default:
                return "";
        }

    }

    public static String getDateFormatSetddMMyyyy() {

        LocalDate localDate = LocalDate.now();

        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return localDate.format(myFormatObj);

    }

}
