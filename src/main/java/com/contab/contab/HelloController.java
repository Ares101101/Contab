package com.contab.contab;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import javax.swing.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class HelloController {

    @FXML
    private static MenuItem ventasForm;
    @FXML
    private Label buscador;
    @FXML
    private Button close;
    @FXML
    private AnchorPane scenePane;
    Stage stage;
    private double xOffset = 0;
    private double yOffset = 0;

    public static boolean contieneSaltoDeLinea(String texto) {
        return texto.contains("\n");
    }
    public static String ordenarFecha(String fecha){
        String fechaOrdenado = fecha.substring(8,10) +"/"+ fecha.substring(5,7)+"/"+ fecha.substring(0,4);
        return fechaOrdenado;
    }
    public static String comprobante ( Row fila){
        String ceros = "0000";
        String total = ceros + String.valueOf( fila.getRowNum()-3);
        return total.substring( total.length()-4, total.length());
    }
    public static void fechaV(ArrayList<ArrayList<String>> arrayLists, Sheet hoja){

        for (int i = 1; i < arrayLists.size(); i++) {
            Row formato1 = hoja.createRow(0);
            Row formato2 = hoja.createRow(1);
            Row formato3 = hoja.createRow(2);
            List<String> formats1 = new ArrayList<>();
            formats1.add("VENTAS");
            formats1.add("SubDiario");
            formats1.add("Comprobante");
            formats1.add("Moneda");
            formats1.add("Fecha de emisión de comprobante de pago");
            formats1.add("Fecha de vencimiento o fecha de pago");
            formats1.add("Tipo de documento");
            formats1.add("Serie o Nro Maq Regist de documento");
            formats1.add("Número de documento");
            formats1.add("Tipo de documento de identidad");
            formats1.add("Número de documento de identidad");
            formats1.add("Apellidos y Nombres, denominación o razón social del proveedor");
            formats1.add("Valor facturado de la exportación");
            formats1.add("Base imponible de la operación gravada");
            formats1.add("Importe total de la operación Exonerada");
            formats1.add("Importe total de la operación Inafecta");
            formats1.add("ISC");
            formats1.add("IGV Y/O IPM");
            formats1.add("ICBPER");
            formats1.add("Otros tributos");
            formats1.add("Importe total");
            formats1.add("Tipo de Conversión");
            formats1.add("Tipo de cambio");
            formats1.add("Referencia del comprobante de pago que se modifica Fecha");
            formats1.add("Referencia del comprobante de pago que se modifica Tipo");
            formats1.add("Referencia del comprobante de pago que se modifica Serie");
            formats1.add("Referencia del comprobante de pago que se modifica Numero");
            formats1.add("Cuenta contable por cobrar");
            formats1.add("Cuenta contable de ingresos");
            formats1.add("Area");
            formats1.add("Centro de Costo");
            formats1.add("Anexo de Referencia");
            for (int j = 0; j <32; j++) {
                Cell cell = formato1.createCell(j);
                cell.setCellValue(formats1.get(j));
            }
            List<String> formats2 = new ArrayList<>();
            formats2.add("Restricciones");
            formats2.add("Ver T.G. 02");
            formats2.add("Los dos primeros dígitos son el mes y los otros 4 siguientes un correlativo (MM0001)");
            formats2.add("Ver T.G. 03");
            formats2.add("Solo Fecha");
            formats2.add("Solo Fecha");
            formats2.add("Ver T.G.56 Clave 'DOC'");
            formats2.add("");
            formats2.add("");
            formats2.add("Sólo 0, 1, 4, 6, 7 y A");
            formats2.add("Ingresar solo anexos.");
            formats2.add("Glosa");
            formats2.add("Sólo números");
            formats2.add("Sólo números");
            formats2.add("Sólo números");
            formats2.add("Sólo números");
            formats2.add("Sólo números");
            formats2.add("Sólo números");
            formats2.add("Sólo números");
            formats2.add("Sólo números");
            formats2.add("Sólo números");
            formats2.add("Solo: 'C'= Especial, 'M'=Compra, 'V'=Venta");
            formats2.add("Llenar solo si el tipo de cambio es 'C'");
            formats2.add("Fecha documento");
            formats2.add("Tipo de documento");
            formats2.add("Serie de documento");
            formats2.add("Número de documento");
            formats2.add("T.G. 56 Mantenimiento en parámetros de ventas.");
            formats2.add("T.G. 56 Mantenimiento en parámetros de ventas.");
            formats2.add("Si Cuenta Contable tiene habilitado la área, ver T.G. 26");
            formats2.add("Si Cuenta Contable tiene habilitado C. Costo, Ver T.G. 05");
            formats2.add("Ingresar solo anexos.");
            for (int j = 0; j <32; j++) {
                Cell cell = formato2.createCell(j);
                cell.setCellValue(formats2.get(j));
            }
            List<String> formats = new ArrayList<>();
            formats.add("Tamaño/Formato");
            formats.add("2 Caracteres");
            formats.add("6 Caracteres");
            formats.add("2 Caracteres");
            formats.add("dd/mm/aaaa");
            formats.add("dd/mm/aaaa");
            formats.add("2 Caracteres");
            formats.add("20 Caracteres");
            formats.add("20 Caracteres");
            formats.add("1 Caracter");
            formats.add("20 Caracteres");
            formats.add("40 Caracteres");
            formats.add("2 decimales");
            formats.add("2 decimales");
            formats.add("2 decimales");
            formats.add("2 decimales");
            formats.add("2 decimales");
            formats.add("2 decimales");
            formats.add("2 decimales");
            formats.add("2 decimales");
            formats.add("2 decimales");
            formats.add("1 Caracter");
            formats.add("3 decimales");
            formats.add("dd/mm/aaaa");
            formats.add("2 caracteres");
            formats.add("10 caracteres");
            formats.add("20 caracteres");
            formats.add("12 caracteres");
            formats.add("12 caracteres");
            formats.add("3 caracteres");
            formats.add("6 caracteres");
            formats.add("6 caracteres");
            for (int j = 0; j <32; j++) {
                Cell cell = formato3.createCell(j);
                cell.setCellValue(formats.get(j));
            }
            Row fila = hoja.createRow(i+2);

            for (int j = 0; j <arrayLists.get(i).size() ; j++) {
                Cell celda = fila.createCell(j);
                int numcel = j-4;
                if(celda.getColumnIndex() == 1){
                    celda.setCellValue("05");
                }if(celda.getColumnIndex() == 2){
                    celda.setCellValue(arrayLists.get(i).get(0).substring(5,7) + comprobante(fila));
                }if(celda.getColumnIndex() == 3){
                    String cache = arrayLists.get(i).get(22).substring(0,3);
                    if(cache.equals("PEN")){
                        celda.setCellValue("MN");
                    }else {
                        celda.setCellValue("US");
                    }
                }if(celda.getColumnIndex() == 4){
                    String fecha = arrayLists.get(i).get(0);
                    celda.setCellValue(ordenarFecha(fecha));
                }if(celda.getColumnIndex() == 6){
                    String cache = arrayLists.get(i).get(2).substring(0,2);
                    if(cache.equals("01")){
                        celda.setCellValue("FT");
                    }if (cache.equals("03")){
                        celda.setCellValue("BV");
                    }if(cache.equals("07")){
                        celda.setCellValue("NC");
                    }else if(cache.equals("08")){
                        celda.setCellValue("ND");
                    }
                }if(celda.getColumnIndex() == 7){
                    celda.setCellValue(arrayLists.get(i).get(3));
                }if(celda.getColumnIndex() == 8){
                    celda.setCellValue(arrayLists.get(i).get(4));
                }if(celda.getColumnIndex() == 9){
                    celda.setCellValue(arrayLists.get(i).get(6));
                }if(celda.getColumnIndex() == 10){
                    celda.setCellValue(arrayLists.get(i).get(7));
                }if(celda.getColumnIndex() == 11){
                    celda.setCellValue(arrayLists.get(i).get(8)+" "+arrayLists.get(i).get(3)+" "+arrayLists.get(i).get(4));
                }if(celda.getColumnIndex() == 12){
                    String cache = arrayLists.get(i).get(10);
                    if(cache.equals("0")){
                        celda.setCellValue(arrayLists.get(i).get(9));
                    }else{
                        celda.setCellValue("");
                    }
                }if(celda.getColumnIndex() == 13){
                    celda.setCellValue(arrayLists.get(i).get(10));
                }if(celda.getColumnIndex() == 14){
                    String cache = arrayLists.get(i).get(14);
                    if(cache.equals("0")){
                        celda.setCellValue("");
                    }else{
                        celda.setCellValue(arrayLists.get(i).get(14));
                    }
                }if(celda.getColumnIndex() == 15){
                    String cache = arrayLists.get(i).get(15);
                    if(cache.equals("0")){
                        celda.setCellValue("");
                    }else{
                        celda.setCellValue(arrayLists.get(i).get(15));
                    }
                }if(celda.getColumnIndex() == 16){
                    String cache = arrayLists.get(i).get(16);
                    if(cache.equals("0")){
                        celda.setCellValue("");
                    }else{
                        celda.setCellValue(arrayLists.get(i).get(16));
                    }
                }if(celda.getColumnIndex() == 17){
                    celda.setCellValue(arrayLists.get(i).get(12));
                }if(celda.getColumnIndex() == 18){
                    String cache = arrayLists.get(i).get(19);
                    if(cache.equals("0")){
                        celda.setCellValue("");
                    }else{
                        celda.setCellValue(arrayLists.get(i).get(19));
                    }
                }if(celda.getColumnIndex() == 19){
                    String cache = arrayLists.get(i).get(20);
                    if(cache.equals("0")){
                        celda.setCellValue("");
                    }else{
                        celda.setCellValue(arrayLists.get(i).get(20));
                    }
                }if(celda.getColumnIndex() == 20){
                    celda.setCellValue(arrayLists.get(i).get(21));
                }if(celda.getColumnIndex() == 21){
                    celda.setCellValue("M");
                }if(celda.getColumnIndex() == 23){
                    celda.setCellValue(arrayLists.get(i).get(24));
                }if(celda.getColumnIndex() == 24){
                    if (arrayLists.get(i).get(25).length()>0){
                        String cache = arrayLists.get(i).get(25).substring(0,2);
                        if(cache.equals("01")){
                            celda.setCellValue("FT");
                        }if (cache.equals("03")){
                            celda.setCellValue("BV");
                        }if(cache.equals("07")){
                            celda.setCellValue("NC");
                        }else if(cache.equals("08")){
                            celda.setCellValue("ND");
                        }}else{
                        celda.setCellValue("");
                    }

                }if(celda.getColumnIndex() == 25){
                    celda.setCellValue(arrayLists.get(i).get(26));
                }if(celda.getColumnIndex() == 26){
                    celda.setCellValue(arrayLists.get(i).get(27));
                }if(celda.getColumnIndex() == 27){
                    celda.setCellValue(121201);
                }if(celda.getColumnIndex() == 28){
                    celda.setCellValue(701111);
                }

                /*else if ( celda.getColumnIndex() > 3 && numcel<=arrayLists.get(i).size()) {
                    celda.setCellValue(arrayLists.get(i).get(numcel));
                }*/
            }
        }
    }
    public static void excelGenet(ArrayList<ArrayList<String>> arrayLists) {
        //CREA ARCHIVO LIBRO
        Workbook libro = new XSSFWorkbook();
        //CREA HOJA
        Sheet hoja = libro.createSheet("ventas");

        fechaV(arrayLists,hoja);

        try{
            OutputStream output = new FileOutputStream("ArchivoExcel.xlsx");
            libro.write(output);
        }catch (Exception e){
            e.printStackTrace();
        };



        String filePath = "ArchivoExcel.xlsx"; // Reemplaza con la ruta correcta
        try {
            File file = new File(filePath);
            if (file.exists()) {
                Desktop.getDesktop().open(file);
            } else {
                System.out.println("El archivo no existe: " + filePath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    protected void ventasFor() throws IOException {
        FXMLLoader subWindowLoader = new FXMLLoader(getClass().getResource("subventana.fxml"));
        AnchorPane subWindowRoot = subWindowLoader.load();
        Scene subWindowScene = new Scene(subWindowRoot);
        Stage subWindowStage = new Stage();
        subWindowStage.initStyle(StageStyle.TRANSPARENT);
        subWindowStage.setScene(subWindowScene);
        subWindowStage.show();

    }
    @FXML
    protected void closeButtom (){
        stage = (Stage) scenePane.getScene().getWindow();
        System.out.println("cerro perfectamente");
        stage.close();
    }
    @FXML
    protected void buscar(){
        JFileChooser fileChooser = new JFileChooser();
        int response = fileChooser.showOpenDialog(null);
        if (response == JFileChooser.APPROVE_OPTION){
            File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            buscador.setText(String.valueOf(file));
        }
    }
    @FXML
    protected void generarVentas(){
        System.out.println(buscador.getText());


        try {
            InputStream fichero = new FileInputStream(String.valueOf(buscador.getText()));
            BufferedInputStream ficheroBuffered = new BufferedInputStream(fichero);
            try {
                int dato = ficheroBuffered.read();
                int i = 0;
                String cache = "";
                ArrayList<ArrayList<String>> DatosBidimensional = new ArrayList<>();
                DatosBidimensional.add(new ArrayList<>());

                while (dato != -1){
                    if ( (char) dato != '|' )  {
                        cache += String.valueOf((char) dato);
                        dato = ficheroBuffered.read();
                    } else {
                        if (contieneSaltoDeLinea(cache)){
                            String[] lineas = cache.split("\n");
                            DatosBidimensional.add(new ArrayList<>());
                            DatosBidimensional.get(i).add(lineas[0]);
                            i++;
                            DatosBidimensional.get(i).add(lineas[1]);
                            cache = "";
                            dato = ficheroBuffered.read();
                        }else {
                            DatosBidimensional.get(i).add(cache);
                            cache = "";
                            dato = ficheroBuffered.read();
                        }
                    }
                }
                DatosBidimensional.get(DatosBidimensional.size()-1).add(cache);
                for (int e = 0; e < DatosBidimensional.size(); e++) {
                    System.out.println(DatosBidimensional.get(e));
                }
                excelGenet(DatosBidimensional);

            }catch (IOException e){
                System.out.println("no puede leer el fichero"+ e.getMessage());
            }
        }catch (FileNotFoundException e){
            System.out.println( e.getMessage());
        }
    }
}