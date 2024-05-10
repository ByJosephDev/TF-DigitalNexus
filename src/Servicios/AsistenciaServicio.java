package Servicios;

import Modelos.Asistencia;
import Modelos.Empleado;
import Utilidades.ConectarArchivo;
import Utilidades.ConfigurationVariables;
import Utilidades.TipoAsistencia;

import java.util.*;

public class AsistenciaServicio {

    List<String> datos = new ArrayList<>();
    ConectarArchivo archivo = new ConectarArchivo();
    Asistencia entity = new Asistencia();
    private Scanner s = new Scanner(System.in);

    public void main()  {

        try {

            int opt = 0;

            System.out.println("------------------ cargando menu Asistencia -------------------");
            System.out.println("| 1. Registro de Asistencia                                    |");
            System.out.println("| 2. Consultar de Asistencia                                   |");
            System.out.println("| 3. Registro de Licencia                                      |");
            System.out.println("| 4. Consulta de Licencias                                     |");
            System.out.println("| 5. Consulta de Licencia por Documento                        |");
            System.out.println("| 6. Registro de Vacaciones                                    |");
            System.out.println("| 7. Consulta de Vacaciones                                    |");
            System.out.println("| 8. Consulta de Vacacione por Documento                       |");
            System.out.println("| 9. Salir                                                     |");
            opt = s.nextInt();

            switch (opt) {
                case 1:
                    saveAsistencia();
                    break;
                case 2:
                    getAsistencia();
                    break;
                case 3:
                    saveLicencia();
                    break;
                case 4:
                    getLicencias();
                    break;
                case 5:
                    getLicencia();
                    break;
                case 6:
                    saveVacaciones();
                    break;
                case 7:
                    getVacaciones();
                    break;
                case 8:
                    getVacacionesByDoc();
                    break;
                default:
                    break;
            }

        }catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
    public void saveAsistencia() {

        try{

            System.out.println("------------------ Registro de Asistencia -------------------");

            System.out.println("| Ingrese Numero Documento                                    |");
            int doc = s.nextInt();

            String date = ConfigurationVariables.getDateFormatSetddMMyyyy();

            Asistencia asistencia = new Asistencia(doc,
                    TipoAsistencia.ASISTIO.toString(),
                    date,
                    0,
                    "N/A",
                    "N/A",
                    "N/A",
                    "N/A");

            archivo.escribirArchivo(ConfigurationVariables.obtenerURLArchivoAsistencias(), asistencia.toSaved());

            System.out.println("Asistencia registrada con exito");

        }catch (Exception ex) {

            System.out.println(ex.getMessage());

        }

    }

    public void getAsistencia()  {

        try {

            System.out.println("------------------ Consulta de Asistencia -------------------");

            System.out.println("| Ingrese Numero Documento                                    |");
            int doc = s.nextInt();


            cargarAsistencias();
            Asistencia a = new Asistencia();
            for (String stgr: datos) {
                Asistencia aLocal;
                aLocal = a.toParseAsistecia(stgr);
                if (aLocal.getDoc()==doc && aLocal.getTipo().equals(TipoAsistencia.ASISTIO.toString())) {
                    System.out.println(stgr);
                }
            }

        }catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void saveLicencia()  {

        try{

            String comentarioGerente ;
            String fechaInicio ;
            String fechaFin;

            System.out.println("------------------ Registro de Licencia -------------------");

            System.out.println("| Ingrese Numero Documento                                    |");
            int doc = s.nextInt();
            s.nextLine();

            System.out.println("-------------- Ingrese Fecha de inicio (dd/MM/yyyy) ---------------");
            fechaInicio = s.nextLine();

            System.out.println("--------------- Ingrese Fecha de Fin (dd/MM/yyyy) -----------------");

            fechaFin = s.nextLine();

            System.out.println("------------------- Ingrese alguna descripcion --------------------");
            comentarioGerente = s.nextLine();

            String date = ConfigurationVariables.getDateFormatSetddMMyyyy();
            Asistencia asistencia = new Asistencia(doc,
                    TipoAsistencia.LICENCIA.toString(),
                    date,
                    0,
                    comentarioGerente,
                    "N/A",
                    fechaInicio,
                    fechaFin);
            archivo.escribirArchivo(ConfigurationVariables.obtenerURLArchivoAsistencias(),asistencia.toSaved());

            System.out.println("Licencia registrada con exito");

        }catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void getLicencias()  {

        try {

            System.out.println("------------------ Consulta de Licencias -------------------");

            cargarAsistencias();

            Asistencia a = new Asistencia();
            for (String stgr: datos) {
                Asistencia aLocal = new Asistencia();
                aLocal = a.toParseAsistecia(stgr);
                if (aLocal.getTipo().equals(TipoAsistencia.LICENCIA.toString())) {
                    System.out.println(stgr);
                }
            }

        }catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
    public void getLicencia()  {

        try {

            System.out.println("------------------ Consulta de Licencia -------------------");

            System.out.println("| Ingrese Numero Documento                                    |");

            int doc = s.nextInt();

            cargarAsistencias();

            Asistencia a = new Asistencia();

            for (String stgr: datos) {

                Asistencia aLocal;

                aLocal = a.toParseAsistecia(stgr);

                if (aLocal.getDoc()==doc && aLocal.getTipo().equals(TipoAsistencia.LICENCIA.toString())) {

                    System.out.println(stgr);

                }

            }

        }catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void saveVacaciones()  {

        try {

            String comentarioGerente;
            String fechaInicio;
            String fechaFin;

            System.out.println("------------------ Registro de Vacaciones -------------------");

            System.out.println("| Ingrese Numero Documento                                    |");
            int doc = s.nextInt();
            s.nextLine();

            System.out.println("-------------- Ingrese Fecha de inicio (dd/MM/yyyy) ---------------");
            fechaInicio = s.nextLine();
            System.out.println("--------------- Ingrese Fecha de Fin (dd/MM/yyyy) -----------------");
            fechaFin = s.nextLine();
            System.out.println("------------------- Ingrese alguna descripcion --------------------");
            comentarioGerente = s.nextLine();
            String date = ConfigurationVariables.getDateFormatSetddMMyyyy();
            Asistencia asistencia = new Asistencia(doc,
                    TipoAsistencia.VACACIONES.toString(),
                    date,
                    0,
                    comentarioGerente,
                    "N/A",
                    fechaInicio,
                    fechaFin);

            archivo.escribirArchivo(ConfigurationVariables.obtenerURLArchivoAsistencias(), asistencia.toSaved());

            System.out.println("Vacaciones registradas con exito");

        }catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void getVacaciones()  {

        try {

            System.out.println("------------------ Consulta de Vacaciones -------------------");

            cargarAsistencias();

            Asistencia a = new Asistencia();

            for (String stgr: datos) {

                Asistencia aLocal = new Asistencia();

                aLocal = a.toParseAsistecia(stgr);

                if (aLocal.getTipo().equals(TipoAsistencia.VACACIONES.toString())) {

                    System.out.println(stgr);

                }

            }

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }
    public void getVacacionesByDoc(){

        try {

            System.out.println("------------------ Consulta de Vacaciones por documento-------------------");

            System.out.println("| Ingrese Numero Documento                                    |");
            int doc = s.nextInt();

            cargarAsistencias();
            Asistencia a = new Asistencia();
            for (String stgr: datos) {
                Asistencia aLocal;
                aLocal = a.toParseAsistecia(stgr);
                if (aLocal.getDoc()==doc && aLocal.getTipo().equals(TipoAsistencia.VACACIONES.toString())) {
                    System.out.println(stgr);
                }
            }

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }

    public void cargarAsistencias() {

        try{

            datos = archivo.leerArchivo(ConfigurationVariables.obtenerURLArchivoAsistencias());

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }

}
