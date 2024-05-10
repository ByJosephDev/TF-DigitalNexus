package Servicios;

import Modelos.Capacitacion;
import Modelos.Desempenio;
import Utilidades.Area;
import Utilidades.CategoriaCapacitacion;
import Utilidades.ConectarArchivo;
import Utilidades.ConfigurationVariables;

import java.util.*;

public class CapacitacionServicio {

    ConectarArchivo archivo = new ConectarArchivo();
    Scanner s = new Scanner(System.in);
    List<String> datos = new ArrayList<>();

    Capacitacion entity = new Capacitacion();

    public void main()  {

        try {

            int opt;

            System.out.println("| 1. Registrar Capacitaciones                                |");
            System.out.println("| 2. Consultar Capacitaciones                                |");
            System.out.println("| 3. Consultar Capacitaciones por Documento                  |");
            opt = s.nextInt();

            switch (opt){
                case 1:
                    System.out.println("| Ingrese Numero Documento                        |");
                    saveCapacitacion(s.nextInt());
                    break;
                case 2:
                    getCapacitaciones();
                    break;
                case 3:
                    System.out.println("| Ingrese Numero Documento                        |");
                    getCapacitacionByDocument(s.nextInt());
                    break;
                default:
                    break;
            }

        }catch (Exception e) {
            System.out.println("Error al ejecutar CapacitacionServicio");
        }

    }

    public void saveCapacitacion(int doc){

        try {

            int area = 0;
            int categoria = 0;
            Capacitacion c = new Capacitacion();

            c.setDoc(doc);

            System.out.println("| Ingrese Categoria                           |");
            System.out.println("| 1. Junior                                   |");
            System.out.println("| 2. Middle                                   |");
            System.out.println("| 3. Senior                                   |");

            categoria = s.nextInt();
            switch (categoria){
                case 1:
                    c.setCategoria(CategoriaCapacitacion.JUNIOR.toString());
                    break;
                case 2:
                    c.setCategoria(CategoriaCapacitacion.MIDDLE.toString());
                    break;
                case 3:
                    c.setCategoria(CategoriaCapacitacion.SENIOR.toString());
                    break;
                default :
                    break;
            }
            System.out.println("| Ingrese el Area                                        |");
            System.out.println("| 1. Venta                                               |");
            System.out.println("| 2. Marketing                                           |");
            System.out.println("| 3. Soporte                                             |");
            System.out.println("| 4. Administración                                      |");
            System.out.println("| 5. Finanzas                                            |");
            System.out.println("| 6. Almacen                                             |");
            area = s.nextInt();
            switch (area){
                case 1:
                    c.setArea(Area.VENTA.toString());
                    break;
                case 2:
                    c.setArea(Area.MARKETING.toString());
                    break;
                case 3:
                    c.setArea(Area.SOPORTE.toString());
                    break;
                case 4:
                    c.setArea(Area.ADMINISTRACION.toString());
                    break;
                case 5:
                    c.setArea(Area.FINANZAS.toString());
                    break;
                case 6:
                    c.setArea(Area.ALMACEN.toString());
                    break;
                default :
                    break;
            }
            s.nextLine();
            System.out.println("| Ingrese Nombre                                  |");
            c.setNombre(s.nextLine());
            System.out.println("| Ingrese Descripcion                             |");
            c.setDescripcion(s.nextLine());
            System.out.println("| Ingrese Fecha Inicio                            |");
            c.setFechaInicio(s.nextLine());
            System.out.println("| Ingrese Fecha Fin                               |");
            c.setFechaFin(s.nextLine());

            archivo.escribirArchivo(ConfigurationVariables.obtenerURLArchivoCapacitaciones(),c.toSave());

            System.out.println("Capacitacion registrado correctamente");

        }catch (Exception e) {
            System.out.println("Error al guardar Capacitacion");
        }

    }

    public void getCapacitaciones() {

        try {
            cargarCapacitaciones();

            for (String stgr: datos) {
                System.out.println(stgr);
            }

        }catch (Exception e) {
            System.out.println("Error al obtener Capacitaciones");
        }

    }
    public void getCapacitacionByDocument(int doc) {

        try {

            cargarCapacitaciones();

            Capacitacion c = new Capacitacion();
            for (String stgr: datos) {
                Capacitacion localCapa;
                localCapa = c.toParseCapacitaciones(stgr);
                if(localCapa.getDoc() == doc) {
                    System.out.println(stgr);
                }
            }

        }catch (Exception e) {
            System.out.println("Error al obtener Capacitacion por Documento");
        }

    }


    public void cargarCapacitaciones()  {

        try {

            datos = archivo.leerArchivo(ConfigurationVariables.obtenerURLArchivoCapacitaciones());

        }catch (Exception e) {
            System.out.println("Error al cargar Capacitaciones");
        }

    }

}
