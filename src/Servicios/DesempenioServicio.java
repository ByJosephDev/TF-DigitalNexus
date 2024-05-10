package Servicios;

import Modelos.Desempenio;
import Utilidades.Area;
import Utilidades.ConectarArchivo;
import Utilidades.ConfigurationVariables;

import java.util.*;

public class DesempenioServicio {

    Scanner s = new Scanner(System.in);
    ConectarArchivo archivo = new ConectarArchivo();
    Desempenio entity = new Desempenio();

    List<String> datos = new ArrayList<>();

    public void main() {

        try {

            int opt = 0;
            System.out.println("| Desempenio Servicio                                        |");
            System.out.println("| 1. Registrar Feedback                                      |");
            System.out.println("| 2. Consultar Feedback por Area                             |");
            System.out.println("| 3. Consultar Feedback by Documento                         |");
            System.out.println("| 4. Eliminar Feedback by Documento                          |");

            opt = s.nextInt();

            switch (opt){
                case 1:
                    System.out.println("| Ingrese Numero Documento                        |");
                    saveFeedback(s.nextInt());
                    break;
                case 2:
                    System.out.println("| Ingrese el Area                                        |");
                    System.out.println("| 1. Venta                                               |");
                    System.out.println("| 2. Marketing                                           |");
                    System.out.println("| 3. Soporte                                             |");
                    System.out.println("| 4. Administración                                      |");
                    System.out.println("| 5. Finanzas                                            |");
                    System.out.println("| 6. Almacen                                             |");
                    getFeedbackForArea(s.nextInt());
                    break;
                case 3:
                    System.out.println("| Ingrese Numero Documento                        |");
                    getFeedbackForDocument(s.nextInt());
                    break;
                case 4:
                    System.out.println("| Ingrese Numero Documento                        |");
                    deleteFeedbackForDocument(s.nextInt());
                    break;
                default:
                    break;
            }

        }catch (Exception e) {
            System.out.println("Error al ejecutar DesempenioServicio");
        }

    }

    public void saveFeedback(int doc)  {

        try {

            Desempenio d = new Desempenio();

            int area = 0;

            d.setDoc(doc);

            System.out.println("| Ingrese Nota Gerente                                   |");
            d.setNotaGerente(s.nextInt());
            System.out.println("| Ingrese Nota Empleado                                  |");
            d.setNotaEmpleado(s.nextInt());
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
                    d.setArea(Area.VENTA.toString());
                    break;
                case 2:
                    d.setArea(Area.MARKETING.toString());
                    break;
                case 3:
                    d.setArea(Area.SOPORTE.toString());
                    break;
                case 4:
                    d.setArea(Area.ADMINISTRACION.toString());
                    break;
                case 5:
                    d.setArea(Area.FINANZAS.toString());
                    break;
                case 6:
                    d.setArea(Area.ALMACEN.toString());
                    break;
                default :
                    break;
            }
            System.out.println("| Ingrese Descripcion de Gerente                          |");
            d.setDescripcionGerente(s.nextLine());
            System.out.println("| Ingrese Descripcion de Empleado                         |");
            d.setDescripcionEmpleado(s.nextLine());
            d.setFecha(ConfigurationVariables.getDateFormatSetddMMyyyy());

            archivo.escribirArchivo(ConfigurationVariables.obtenerURLArchivoRetroalimentaciones(),d.toSave());

            System.out.println("Desempenio Registrado Correctamente");

        }catch (Exception e) {
            System.out.println("Error al guardar Feedback");
        }

    }

    public void getFeedbackForArea(int a) {

        try {

            cargarRetroalimentacion();
            Desempenio d = new Desempenio();
            String lArea = "";
            switch (a){
                case 1:
                    lArea = Area.VENTA.toString();
                    break;
                case 2:
                    lArea = Area.MARKETING.toString();
                    break;
                case 3:
                    lArea = Area.SOPORTE.toString();
                    break;
                case 4:
                    lArea = Area.ADMINISTRACION.toString();
                    break;
                case 5:
                    lArea = Area.FINANZAS.toString();
                    break;
                case 6:
                    lArea = Area.ALMACEN.toString();
                    break;
                default :
                    break;
            }
            for (String stgr: datos) {

                Desempenio aLocal;

                aLocal = d.toParseDesempenioEntity(stgr);

                if (aLocal.getArea().equals(lArea)) {
                    System.out.println(stgr);
                }

            }

        }catch (Exception e) {
            System.out.println("Error al obtener Feedback");
        }

    }

    public void getFeedbackForDocument(int doc){

        try {

            cargarRetroalimentacion();

            Desempenio d = new Desempenio();
            for (String stgr: datos) {
                Desempenio aLocal;
                aLocal = d.toParseDesempenioEntity(stgr);
                if (aLocal.getDoc()==doc) {
                    System.out.println(stgr);
                }
            }

        }catch (Exception e) {
            System.out.println("Error al obtener Feedback");
        }

    }

    public void deleteFeedbackForDocument(int doc) {

        try {

            cargarRetroalimentacion();

            Map<Integer,String> mapLocal = parseDatatoMap();

            mapLocal.remove(doc);

            archivo.flushFile(ConfigurationVariables.obtenerURLArchivoRetroalimentaciones());

            for (String a: mapLocal.values()) {

                Desempenio localEntity = new Desempenio();

                entity = localEntity.toParseDesempenioEntity(a);

                archivo.escribirArchivo(ConfigurationVariables.obtenerURLArchivoRetroalimentaciones(),entity.toSave());

            }

        }catch (Exception e) {
            System.out.println("Error al obtener Feedback");
        }

    }

    public Map<Integer,String> parseDatatoMap() {

        Map<Integer,String> dataMap = new HashMap<>();

        try {

            for (String s: datos) {
                Desempenio localEntity = new Desempenio();
                entity = localEntity.toParseDesempenioEntity(s);
                dataMap.put(entity.getDoc(),s);
            }

        }catch (Exception e) {
            System.out.println("Error al obtener Feedback");
        }

        return dataMap;


    }

    public void cargarRetroalimentacion() {

        try {

            datos = archivo.leerArchivo(ConfigurationVariables.obtenerURLArchivoRetroalimentaciones());

        }catch (Exception e) {
            System.out.println("Error al obtener Feedback");
        }

    }

}
