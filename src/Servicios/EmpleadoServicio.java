package Servicios;

import Modelos.*;
import Utilidades.ConectarArchivo;
import Utilidades.ConfigurationVariables;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmpleadoServicio {

    Scanner scanner = new Scanner(System.in);
    ConectarArchivo archivo = new ConectarArchivo();
    List<String> datos = new ArrayList<>();

    public EmpleadoServicio() {

        cargarDatos();

    }

    public void cargarDatos() {

        try {

            datos = archivo.leerArchivo(ConfigurationVariables.obtenerURLArchivoEmpleados());

        } catch (Exception ex) {

            System.out.println("Error al cargar archivo de empleados");

        }

    }

    public void actualizarEmpleado() {

        try {

            Empleado empleado = obtenerEmpleadoPorDocumento();

            if (empleado == null) {
                System.out.println("Empleado no encontrado");
                return;
            }
            ;

            System.out.println("----------------- Ingrese Datos de Empleado ------------------");
            System.out.println("Ingrese -1 para no modificar");

            ConfigurationVariables.mostrarRoles();

            int rol = scanner.nextInt();

            if (rol >= 0) empleado.setRol(ConfigurationVariables.diccionarioRoles(rol));

            scanner.nextLine();

            System.out.println("Ingresar Nombres");

            String nombres = scanner.nextLine();

            if (!nombres.equals("-1")) empleado.setNombres(nombres);

            System.out.println("Ingresar Apellidos");

            String apellidos = scanner.nextLine();

            if (!apellidos.equals("-1")) empleado.setApellidos(apellidos);

            System.out.println("Ingrese Estado Civil");

            String estadoCivil = scanner.nextLine();

            if (!estadoCivil.equals("-1")) empleado.setEstadoCivil(estadoCivil);

            System.out.println("Ingrese Direccion");

            String direccion = scanner.nextLine();

            if (!direccion.equals("-1")) empleado.setDireccion(direccion);

            System.out.println("Fecha de Nacimiento dd/MM/aaaa");

            String fechaNacimiento = scanner.nextLine();

            if (!fechaNacimiento.equals("-1")) empleado.setFechaNacimiento(fechaNacimiento);

            System.out.println("Ingrese numero de celular");

            String celular = scanner.nextLine();

            if (!celular.equals("-1")) empleado.setCelular(celular);

            System.out.println("Ingrese numero de Hijos");

            String hijos = scanner.nextLine();

            if (!hijos.equals("-1")) empleado.setHijos(hijos);

            System.out.println("Fecha de Ingreso dd/MM/aaaa");

            String fechaIngreso = scanner.nextLine();

            if (!fechaIngreso.equals("-1")) empleado.setFechaIngreso(fechaIngreso);

            System.out.println("Fecha de Salida dd/MM/aaaa");

            String fechaSalida = scanner.nextLine();

            if (!fechaSalida.equals("-1")) empleado.setFechaSalida(fechaSalida);

            System.out.println("¿Habilitado? (true/false)");

            String habilitado = scanner.nextLine();

            if (!habilitado.equals("-1")) empleado.setHabilitado(Boolean.parseBoolean(habilitado));

            System.out.println("Ingrese Sueldo");

            Double sueldo = scanner.nextDouble();

            if (sueldo != -1) empleado.setSueldo(sueldo);

            scanner.nextLine();

            switch (rol) {

                case 1:

                    System.out.println("Ingrese Especialidad");

                    String especialidad = scanner.nextLine();

                    if (!especialidad.equals("-1")) ((SoporteTecnico) empleado).setEspecialidad(especialidad);

                    break;

                case 2:

                    System.out.println("Ingrese Estatus Aplicacion (true/false)");

                    String estatusAplicacion = scanner.nextLine();

                    if (!estatusAplicacion.equals("-1"))
                        ((AdministradorRRHH) empleado).setEstatusAplicacion(Boolean.parseBoolean(estatusAplicacion));

                    break;

                case 3:

                    System.out.println("Ingrese sí maneja montacarga (true/false)");

                    String manejaMontacargas = scanner.nextLine();

                    if (!manejaMontacargas.equals("-1"))
                        ((AuxiliarAlmacen) empleado).setManejaMontacargas(Boolean.parseBoolean(manejaMontacargas));
                    break;

                case 4:

                    System.out.println("Ingrese especialización en un Software");

                    String especializacionSoftware = scanner.nextLine();

                    if (!especializacionSoftware.equals("-1"))
                        ((Contador) empleado).setEspecializacionSoftware(especializacionSoftware);
                    break;
                case 5:
                    System.out.println("Domina el idioma inglés (true/false)");

                    String dominaIngles = scanner.nextLine();

                    if (!dominaIngles.equals("-1"))
                        ((EspecialistaMarketing) empleado).setIdiomaIngles(Boolean.parseBoolean(dominaIngles));
                    break;

                case 6:
                    System.out.println("Ingrese el medio de atención");

                    String medioAtencion = scanner.nextLine();

                    if (!medioAtencion.equals("-1"))
                        ((PromotorVentas) empleado).setMedioAtencion(medioAtencion);
                    break;

            }

            List<String> nuevaListaDatos = new ArrayList<>();

            for (String str : datos) {

                String[] parts = str.split(",");

                if (parts[2].equals(empleado.getNumeroDocumento())) {

                    str = empleado.convertirTexto("Actualizar");

                }

                nuevaListaDatos.add(str);

            }

            archivo.actualizarArchivo(ConfigurationVariables.obtenerURLArchivoEmpleados(), nuevaListaDatos);

            System.out.println("Empleado actualizado correctamente");
            cargarDatos();
            System.out.println("----------------- Fin Actualización de Empleado ------------------");


        } catch (Exception ex) {

            System.out.println("Error al actualizar archivo de empleados");

        }

    }

    public void eliminarEmpleado() {

        System.out.println("Ingrese el número de documento del empleado");

        String documento = scanner.next();

        List<String> nuevaListaDatos = new ArrayList<>();

        boolean encontrado = false;

        for (String str : datos) {

            String[] parts = str.split(",");

            if (!parts[2].equals(documento)) {

                nuevaListaDatos.add(str);

            }else{
                encontrado = true;
                break;
            }

        }

        if (!encontrado) {
            System.out.println("Empleado no encontrado");
            return;
        }

        archivo.actualizarArchivo(ConfigurationVariables.obtenerURLArchivoEmpleados(), nuevaListaDatos);

        System.out.println("Empleado eliminado correctamente");

        cargarDatos();
    }

    public void registrarEmpleado() {

        try {

            Empleado empleadoEntity = null;

            System.out.println("----------------- Ingrese Datos de Empleado ------------------");

            ConfigurationVariables.mostrarRoles();

            int rol = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Ingrese Tipo Documento");

            String tipoDocumento = scanner.nextLine();

            System.out.println("Ingresar Numero Documento");

            String numeroDocumento = scanner.nextLine();

            System.out.println("Ingresar Nombres");

            String nombres = scanner.nextLine();

            System.out.println("Ingresar Apellidos");

            String apellidos = scanner.nextLine();

            System.out.println("Ingrese Estado Civil");

            String estadoCivil = scanner.nextLine();

            System.out.println("Ingrese Direccion");

            String direccion = scanner.nextLine();

            System.out.println("Fecha de Nacimiento dd/MM/aaaa");

            String fechaNacimiento = scanner.nextLine();

            System.out.println("Ingrese numero de celular");

            String celular = scanner.nextLine();

            System.out.println("Ingrese numero de Hijos");

            String hijos = scanner.nextLine();

            System.out.println("Fecha de Ingreso dd/MM/aaaa");

            String fechaIngreso = scanner.nextLine();

            System.out.println("Fecha de Salida dd/MM/aaaa");

            String fechaSalida = scanner.nextLine();

            System.out.println("Ingrese Sueldo");

            Double sueldo = scanner.nextDouble();
            scanner.nextLine();

            switch (rol) {

                case 1:

                    System.out.println("Ingrese Especialidad");

                    String especialidad = scanner.nextLine();

                    empleadoEntity = new SoporteTecnico("SoporteTecnico", tipoDocumento, numeroDocumento, nombres, apellidos, estadoCivil, direccion, fechaNacimiento, celular, hijos, fechaIngreso, fechaSalida, true, sueldo, especialidad);

                    break;
                case 2:

                    System.out.println("Ingrese Estatus Aplicacion (true/false)");

                    empleadoEntity = new AdministradorRRHH("AdminRRHH", tipoDocumento, numeroDocumento, nombres, apellidos, estadoCivil, direccion, fechaNacimiento, celular, hijos, fechaIngreso, fechaSalida, true, sueldo, true);

                    break;

                case 3:

                        System.out.println("Ingrese sí maneja montacarga (true/false)");

                        String manejaMontacargas = scanner.nextLine();

                        empleadoEntity = new AuxiliarAlmacen("AuxiliarAlmacen", tipoDocumento, numeroDocumento, nombres, apellidos, estadoCivil, direccion, fechaNacimiento, celular, hijos, fechaIngreso, fechaSalida, true, sueldo, Boolean.parseBoolean(manejaMontacargas));

                        break;

                case 4:

                    System.out.println("Ingrese especialización en un Software");

                    String especializacionSoftware = scanner.nextLine();

                    empleadoEntity = new Contador("Contador", tipoDocumento, numeroDocumento, nombres, apellidos, estadoCivil, direccion, fechaNacimiento, celular, hijos, fechaIngreso, fechaSalida, true, sueldo, especializacionSoftware);

                    break;

                case 5:

                    System.out.println("Domina el idioma inglés (true/false)");

                    String dominaIngles = scanner.nextLine();

                    empleadoEntity = new EspecialistaMarketing("EspecialistaMarketing", tipoDocumento, numeroDocumento, nombres, apellidos, estadoCivil, direccion, fechaNacimiento, celular, hijos, fechaIngreso, fechaSalida, true, sueldo, Boolean.parseBoolean(dominaIngles));

                    break;

                case 6:

                    System.out.println("Ingrese el medio de atención");

                    String medioAtencion = scanner.nextLine();

                    empleadoEntity = new PromotorVentas("PromotorVentas", tipoDocumento, numeroDocumento, nombres, apellidos, estadoCivil, direccion, fechaNacimiento, celular, hijos, fechaIngreso, fechaSalida, true, sueldo, medioAtencion);

                    break;

                default:
                    System.out.println("Rol por defecto Administrador");
                    empleadoEntity = new AdministradorRRHH("AdminRRHH", tipoDocumento, numeroDocumento, nombres, apellidos, estadoCivil, direccion, fechaNacimiento, celular, hijos, fechaIngreso, fechaSalida, true, sueldo, true);
                    break;
            }

            archivo.escribirArchivo(ConfigurationVariables.obtenerURLArchivoEmpleados(), empleadoEntity.convertirTexto("Registrar"));

            System.out.println("Empleado registrado correctamente");
            cargarDatos();
            System.out.println("----------------- Fin Registro de Empleado ------------------");

        } catch (Exception ex) {

            System.out.println("Error al registrar empleado");

        }

    }

    public void mostrarEmpleadosPorRoles() {

        ConfigurationVariables.mostrarRoles();

        int rolId = scanner.nextInt();

        String rol = ConfigurationVariables.diccionarioRoles(rolId);

        System.out.println("----------------- Empleados Registrados ------------------");

        for (String str : datos) {

            String[] parts = str.split(",");

            if (parts[0].equals(rol)) {

                switch (parts[0]) {

                    case "SoporteTecnico":

                        SoporteTecnico soporteTecnicoEntity = new SoporteTecnico();
                        System.out.println(soporteTecnicoEntity.mostrarEmpleado(parts));

                        break;

                    case "AdminRRHH":
                        AdministradorRRHH adminRRHHEntity = new AdministradorRRHH();
                        System.out.println(adminRRHHEntity.mostrarEmpleado(parts));
                        break;

                    case "AuxAlmacen":
                        AuxiliarAlmacen auxiliarAlmacenEntity = new AuxiliarAlmacen();
                        System.out.println(auxiliarAlmacenEntity.mostrarEmpleado(parts));
                        break;

                    case "Contador":
                        Contador contadorEntity = new Contador();
                        System.out.println(contadorEntity.mostrarEmpleado(parts));
                        break;

                    case "PromotorVentas":

                        PromotorVentas promotorVentasEntity = new PromotorVentas();
                        System.out.println(promotorVentasEntity.mostrarEmpleado(parts));
                        break;

                    case "EspecialistaMarketing":

                        EspecialistaMarketing especialistaMarketingEntity = new EspecialistaMarketing();
                        System.out.println(especialistaMarketingEntity.mostrarEmpleado(parts));
                        break;
                }

            }

        }

        System.out.println("----------------- Fin Empleados Registrados ------------------");

    }

    public void mostrarEmpleados() {

        System.out.println("----------------- Empleados Registrados ------------------");

        for (String str : datos) {

            String[] parts = str.split(",");

            switch (parts[0]) {

                case "SoporteTecnico":

                    SoporteTecnico soporteTecnicoEntity = new SoporteTecnico();
                    System.out.println(soporteTecnicoEntity.mostrarEmpleado(parts));

                    break;

                case "AdminRRHH":
                    AdministradorRRHH adminRRHHEntity = new AdministradorRRHH();
                    System.out.println(adminRRHHEntity.mostrarEmpleado(parts));
                    break;

                case "AuxAlmacen":
                    AuxiliarAlmacen auxiliarAlmacenEntity = new AuxiliarAlmacen();
                    System.out.println(auxiliarAlmacenEntity.mostrarEmpleado(parts));
                    break;

                case "Contador":
                    Contador contadorEntity = new Contador();
                    System.out.println(contadorEntity.mostrarEmpleado(parts));
                    break;

                case "PromotorVentas":

                    PromotorVentas promotorVentasEntity = new PromotorVentas();
                    System.out.println(promotorVentasEntity.mostrarEmpleado(parts));
                    break;

                case "EspecialistaMarketing":

                    EspecialistaMarketing especialistaMarketingEntity = new EspecialistaMarketing();
                    System.out.println(especialistaMarketingEntity.mostrarEmpleado(parts));
                    break;

            }

        }

        System.out.println("----------------- Fin Empleados Registrados ------------------");

    }

    public Empleado obtenerEmpleadoPorDocumento(String documento) {

        Empleado empleado = null;

        for (String str : datos) {

            String[] parts = str.split(",");

            if (parts[2].equals(documento)) {

                switch (parts[0]) {

                    case "SoporteTecnico":

                        SoporteTecnico soporteTecnicoEntity = new SoporteTecnico();
                        System.out.println(soporteTecnicoEntity.mostrarEmpleado(parts));

                        break;

                    case "AdminRRHH":
                        AdministradorRRHH adminRRHHEntity = new AdministradorRRHH();
                        System.out.println(adminRRHHEntity.mostrarEmpleado(parts));
                        break;

                    case "AuxAlmacen":
                        AuxiliarAlmacen auxiliarAlmacenEntity = new AuxiliarAlmacen();
                        System.out.println(auxiliarAlmacenEntity.mostrarEmpleado(parts));
                        break;

                    case "Contador":
                        Contador contadorEntity = new Contador();
                        System.out.println(contadorEntity.mostrarEmpleado(parts));
                        break;

                    case "PromotorVentas":

                        PromotorVentas promotorVentasEntity = new PromotorVentas();
                        System.out.println(promotorVentasEntity.mostrarEmpleado(parts));
                        break;

                    case "EspecialistaMarketing":

                        EspecialistaMarketing especialistaMarketingEntity = new EspecialistaMarketing();
                        System.out.println(especialistaMarketingEntity.mostrarEmpleado(parts));
                        break;

                }

            }

        }

        System.out.println("Empleado no encontrado");

        return empleado;

    }

    public Empleado obtenerEmpleadoPorDocumento() {

        System.out.println("Ingrese el número de documento del empleado");

        String documento = scanner.next();

        Empleado empleado = null;

        for (String str : datos) {

            String[] parts = str.split(",");

            if (parts[2].equals(documento)) {

                switch (parts[0]) {

                    case "SoporteTecnico":

                        empleado = new SoporteTecnico();

                        return empleado.convertirEmpleado(parts);

                    case "AdminRRHH":

                        empleado = new AdministradorRRHH();

                        return empleado.convertirEmpleado(parts);

                    case "AuxAlmacen":

                        empleado = new AuxiliarAlmacen();

                        return empleado.convertirEmpleado(parts);

                    case "Contador":

                        empleado = new Contador();

                        return empleado.convertirEmpleado(parts);

                    case "PromotorVentas":

                        empleado = new PromotorVentas();

                        return empleado.convertirEmpleado(parts);

                    case "EspecialistaMarketing":

                        empleado = new EspecialistaMarketing();

                        return empleado.convertirEmpleado(parts);

                }

            }

        }

        if (empleado == null) System.out.println("Empleado no encontrado");

        return empleado;

    }

    public Empleado obtenerAdminPorDocumento(String documento) {

        for (String str : datos) {

            String[] parts = str.split(",");

            if (parts[0].equals("AdminRRHH") && parts[2].equals(documento) && parts[14].equals("true")) {

                AdministradorRRHH adminRRHHEntity = new AdministradorRRHH();

                return adminRRHHEntity.convertirEmpleado(parts);

            }

        }

        return null;
    }

}
