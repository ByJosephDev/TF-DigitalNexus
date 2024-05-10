package Utilidades;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConectarArchivo {

    public List<String> leerArchivo(String url)  {

        List<String> data = new ArrayList<>();

        try {

            File archivo = new File(url);
            Scanner scanner = new Scanner(archivo);
            while (scanner.hasNextLine()) {
                data.add(scanner.nextLine());
            }
            scanner.close();

        } catch (Exception ex) {

            System.out.println(ex.getMessage());

        }

        return data;

    }

    public void escribirArchivo(String url,String datos){

        try {

            FileWriter archivo = new FileWriter(url,true);
            archivo.write(datos);
            archivo.close();

        }catch (Exception ex){

            System.out.println(ex.getMessage());

        }

    }

    public void actualizarArchivo(String url, List<String> datos) {

        try {

            FileWriter archivo = new FileWriter(url);
            BufferedWriter bw = new BufferedWriter(archivo);
            for (String dato : datos) {
                bw.write(dato);
                bw.newLine();
            }
            bw.close();
            archivo.close();

        } catch (Exception ex) {

            System.out.println(ex.getMessage());

        }

    }

    public void flushFile(String urn) {

        try {

            FileWriter file = new FileWriter(urn);
            file.flush();
            file.close();

        }catch (Exception ex){

            System.out.println(ex.getMessage());

        }

    }

    public void writeListFile(String urn,List<String> dataIn){

        try {

            FileWriter file = new FileWriter(urn);
            BufferedWriter bw = new BufferedWriter(file);
            for (String in: dataIn) {
                bw.write(in);
                bw.newLine();
            }
            bw.close();
            file.close();

        }catch (Exception ex){

            System.out.println(ex.getMessage());

        }

    }

}
