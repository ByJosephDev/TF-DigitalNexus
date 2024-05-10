import Modelos.AdministradorRRHH;
import Modelos.Capacitacion;
import Modelos.Empleado;
import Servicios.AsistenciaServicio;
import Servicios.CapacitacionServicio;
import Servicios.DesempenioServicio;
import Servicios.EmpleadoServicio;
import Utilidades.ConfigurationVariables;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static Empleado adminRRHHEntity;
    private static final EmpleadoServicio empleadoApp = new EmpleadoServicio();
    private static final AsistenciaServicio asistenciaApp = new AsistenciaServicio();
    private static final CapacitacionServicio capacitacionApp = new CapacitacionServicio();
    private static final DesempenioServicio desempenioApp = new DesempenioServicio();

    private static boolean estaFuncionando = true;

    public static void main(String[] args){

        try{

            String numeroDocumento = "";

            System.out.println("Bienvenido al Sistema de RRHH Nexus");
            System.out.println("-----------------------------------");

            while(estaFuncionando){

                System.out.println("Ingrese con su identificación:");

                numeroDocumento = scanner.next();

                adminRRHHEntity = empleadoApp.obtenerAdminPorDocumento(numeroDocumento);

                if(adminRRHHEntity != null) {

                    mostrarMenu();

                }else{

                    System.out.println("No se encontro al empleado, vuelve intentarlo.");

                }


            }

            System.out.println("Gracias por usar el sistema");

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }

    public static void mostrarMenu(){

        int numeroOpcion = 0;

        while (numeroOpcion >= 0) {

            System.out.println("Bienvenido " + adminRRHHEntity.getNombres() + " " + adminRRHHEntity.getApellidos());
            System.out.println("-------------------------------------------");
            System.out.println("1. Empleados");
            System.out.println("2. Asistencia");
            System.out.println("3. Capacitaciones");
            System.out.println("4. Desempeño");
            System.out.println("5. Salir");

            numeroOpcion = scanner.nextInt();

            switch (numeroOpcion) {
                case 1:
                    menuEmpleados();
                    break;
                case 2:
                    mostrarAsistencia();
                    break;
                case 3:
                    mostrarCapacitaciones();
                    break;
                case 4:
                    mostrarDesempenio();
                    break;
                case 5:
                    break;
                case 6:
                    estaFuncionando = false;
                    numeroOpcion = -1;
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }

        }

    }

    public static void menuEmpleados(){

        try {

            int numeroOpcion = 0;

            while (numeroOpcion >= 0) {

                System.out.println("--------------------- Menu de empleados ----------------------");

                System.out.println("1. Mostrar Empleados");
                System.out.println("2. Mostrar Empleados por Roles");
                System.out.println("3. Registrar Empleado");
                System.out.println("4. Buscar Empleado");
                System.out.println("5. Actualizar Empleado");
                System.out.println("6. Eliminar Empleado");
                System.out.println("7. Salir");

                numeroOpcion = scanner.nextInt();

                switch (numeroOpcion) {
                    case 1:
                        empleadoApp.mostrarEmpleados();
                        break;
                    case 2:

                        empleadoApp.mostrarEmpleadosPorRoles();

                        break;

                    case 3:
                        empleadoApp.registrarEmpleado();
                        break;
                    case 4:
                        empleadoApp.obtenerEmpleadoPorDocumento();
                        break;
                    case 5:

                        empleadoApp.actualizarEmpleado();
                        break;
                    case 6:
                        empleadoApp.eliminarEmpleado();
                        break;
                    case 7:
                        numeroOpcion = -1;
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }

            }

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }

    public static void mostrarAsistencia(){

        asistenciaApp.main();

    }

    public static void mostrarCapacitaciones(){

        capacitacionApp.main();

    }

    public static void mostrarDesempenio(){

        desempenioApp.main();

    }

}