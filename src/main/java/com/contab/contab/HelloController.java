package com.contab.contab;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.lang.*;

public class HelloController {
    @FXML
    private Button closeBo;
    @FXML
    private static MenuItem ventasForm;
    @FXML
    private Label buscador;
    @FXML
    private Button close;
    @FXML
    private AnchorPane scenePane;
    @FXML
    private Label glosaDeproveedores;

    Stage stage;
    private double xOffset = 0;
    private double yOffset = 0;
    @FXML
    private void maximizarVentana(){
       /* stage = (Stage) PanelCenter.getScene().getWindow();
        if(stage.isMaximized()){
            stage.setMaximized(false);
        }else{
            stage.setMaximized(true);
            Rectangle screenBounds = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0].getDefaultConfiguration().getBounds();
            Insets screenInsets = Toolkit.getDefaultToolkit().getScreenInsets(GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration());

            double usableScreenHeight = screenBounds.getHeight() - (screenInsets.top + screenInsets.bottom);
            System.out.println( usableScreenHeight);
            stage.setHeight(usableScreenHeight);
        };*/
    }
    @FXML
    private void minimizarVentana(){
        stage = (Stage) PanelCenter.getScene().getWindow();
        System.out.println("minimizo");
        stage.setIconified(true);
    };

    public static boolean contieneSaltoDeLinea(String texto) {
        return texto.contains("\n");
    }
    public static String ordenarFecha(String fecha){
        String fechaOrdenado = fecha.substring(8,10) +"/"+ fecha.substring(5,7)+"/"+ fecha.substring(0,4);
        return fechaOrdenado;
    }
    public static String comprobante ( Row fila){
        String ceros = "0000";
        String total = ceros + String.valueOf( fila.getRowNum()-2);
        return total.substring( total.length()-4, total.length());
    }
    public static void fechaV(ArrayList<ArrayList<String>> arrayLists, Sheet hoja){

        for (int i = 1; i < arrayLists.size(); i++) {
            Row formato1 = hoja.createRow(0);
            Row formato2 = hoja.createRow(1);
            Row formato3 = hoja.createRow(2);
            List<String> formats1 = new ArrayList<>();
            formats1.add("COMPRAS");
            formats1.add("SubDiario");
            formats1.add("Comprobante");
            formats1.add("Fecha de comprobante");
            formats1.add("Fecha de documento");
            formats1.add("Fecha de vencimiento o fecha de pago");
            formats1.add("Tipo de Documento");
            formats1.add("Número de Documento");
            formats1.add("Tipo de documento de identidad");
            formats1.add("Número de documento de identidad");
            formats1.add("Apellidos y Nombres, denominación o razón social del proveedor");
            formats1.add("Moneda");
            formats1.add("Base imponible");
            formats1.add("IGV");
            formats1.add("ICBPER");
            formats1.add("Valor de las adquisiciones no gravadas");
            formats1.add("ISC");
            formats1.add("Otros tributos y cargos");
            formats1.add("Importe total");
            formats1.add("Número de constancia de depósito de detracción");
            formats1.add("Fecha de emisión de constancia de depósito de detracción");
            formats1.add("Importe detracción");
            formats1.add("Código detracción");
            formats1.add("Tipo de Conversión");
            formats1.add("Tipo de cambio");
            formats1.add("Referencia del comprobante de pago que se modifica Fecha");
            formats1.add("Referencia del comprobante de pago que se modifica Tipo");
            formats1.add("Referencia del comprobante de pago que se modifica Serie");
            formats1.add("Referencia del comprobante de pago que se modifica Numero");
            formats1.add("Número de cuenta contable por pagar");
            formats1.add("Número de cuenta contable de costo o gasto");
            formats1.add("Centro de costo");
            formats1.add("Anexo de referencia");
            formats1.add("Tasa IGV");

            for (int j = 0; j <formats1.size(); j++) {
                Cell cell = formato1.createCell(j);
                cell.setCellValue(formats1.get(j));
            }
            List<String> formats2 = new ArrayList<>();
            formats2.add("Restricciones");
            formats2.add("Ver T.G. 02");
            formats2.add("Los dos primeros dígitos son el mes y los otros 4 siguientes un correlativo (MM0001)");
            formats2.add("Solo Fecha");
            formats2.add("Solo Fecha");
            formats2.add("Solo Fecha");
            formats2.add("Ver T.G.06 y T.G.53");
            formats2.add("Serie-Número");
            formats2.add("Sólo 0, 1, 4, 6, 7 y A");
            formats2.add("Ingresar solo anexos.");
            formats2.add("Glosa");
            formats2.add("Sólo 'MN' Y 'US'");
            formats2.add("Sólo números");
            formats2.add("Sólo números");
            formats2.add("Sólo números");
            formats2.add("Sólo números");
            formats2.add("Sólo números");
            formats2.add("Sólo números");
            formats2.add("Sólo números");
            formats2.add("");
            formats2.add("Solo Fecha");
            formats2.add("Sólo números");
            formats2.add("");
            formats2.add("Solo: 'C'= Especial, 'M'=Compra, 'V'=Venta");
            formats2.add("Sólo números. Llenar solo si el tipo de cambio es 'C'");
            formats2.add("Fecha documento. Llenar solo cuando el tipo de documento es nota de crédito o débito.");
            formats2.add("Tipo de documento. Llenar solo cuando el tipo de documento es nota de crédito o débito.");
            formats2.add("Serie de documento. Llenar solo cuando el tipo de documento es nota de crédito o débito.");
            formats2.add("Número de documento. Llenar solo cuando el tipo de documento es nota de crédito o débito.");
            formats2.add("T.G. 53 Mantenimiento en parámetros de compras.");
            formats2.add("Ingresar una cuenta de gasto o costo del plan de cuentas y que no sea título.");
            formats2.add("Si Cuenta Contable tiene habilitado C. Costo, Ver T.G. 05");
            formats2.add("Ingresar solo anexos.");
            formats2.add("Obligatorio para comprobantes de compras, valores validos 0,10,18.");

            for (int j = 0; j <formats2.size(); j++) {
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
            formats.add("8 caracteres");
            formats.add("8 caracteres");
            formats.add("6 caracteres");
            formats.add("20 caracteres");
            formats.add("Numérico");

            for (int j = 0; j <formats.size(); j++) {
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
    public static void comprasV(ArrayList<ArrayList<String>> arrayLists, Sheet hoja){

        for (int i = 1; i < arrayLists.size(); i++) {
            Row formato1 = hoja.createRow(0);
            Row formato2 = hoja.createRow(1);
            Row formato3 = hoja.createRow(2);
            List<String> formats1 = new ArrayList<>();
            formats1.add("COMPRAS");
            formats1.add("SubDiario");
            formats1.add("Comprobante");
            formats1.add("Fecha de comprobante");
            formats1.add("Fecha de documento");
            formats1.add("Fecha de vencimiento o fecha de pago");
            formats1.add("Tipo de Documento");
            formats1.add("Número de Documento");
            formats1.add("Tipo de documento de identidad");
            formats1.add("Número de documento de identidad");
            formats1.add("Apellidos y Nombres, denominación o razón social del proveedor");
            formats1.add("Moneda");
            formats1.add("Base imponible");
            formats1.add("IGV");
            formats1.add("ICBPER");
            formats1.add("Valor de las adquisiciones no gravadas");
            formats1.add("ISC");
            formats1.add("Otros tributos y cargos");
            formats1.add("Importe total");
            formats1.add("Número de constancia de depósito de detracción");
            formats1.add("Fecha de emisión de constancia de depósito de detracción");
            formats1.add("Importe detracción");
            formats1.add("Código detracción");
            formats1.add("Tipo de Conversión");
            formats1.add("Tipo de cambio");
            formats1.add("Referencia del comprobante de pago que se modifica Fecha");
            formats1.add("Referencia del comprobante de pago que se modifica Tipo");
            formats1.add("Referencia del comprobante de pago que se modifica Serie");
            formats1.add("Referencia del comprobante de pago que se modifica Numero");
            formats1.add("Número de cuenta contable por pagar");
            formats1.add("Número de cuenta contable de costo o gasto");
            formats1.add("Centro de costo");
            formats1.add("Anexo de referencia");
            formats1.add("Tasa IGV");

            for (int j = 0; j <formats1.size(); j++) {
                Cell cell = formato1.createCell(j);
                cell.setCellValue(formats1.get(j));
            }
            List<String> formats2 = new ArrayList<>();
            formats2.add("Restricciones");
            formats2.add("Ver T.G. 02");
            formats2.add("Los dos primeros dígitos son el mes y los otros 4 siguientes un correlativo (MM0001)");
            formats2.add("Solo Fecha");
            formats2.add("Solo Fecha");
            formats2.add("Solo Fecha");
            formats2.add("Ver T.G.06 y T.G.53");
            formats2.add("Serie-Número");
            formats2.add("Sólo 0, 1, 4, 6, 7 y A");
            formats2.add("Ingresar solo anexos.");
            formats2.add("Glosa");
            formats2.add("Sólo 'MN' Y 'US'");
            formats2.add("Sólo números");
            formats2.add("Sólo números");
            formats2.add("Sólo números");
            formats2.add("Sólo números");
            formats2.add("Sólo números");
            formats2.add("Sólo números");
            formats2.add("Sólo números");
            formats2.add("");
            formats2.add("Solo Fecha");
            formats2.add("Sólo números");
            formats2.add("");
            formats2.add("Solo: 'C'= Especial, 'M'=Compra, 'V'=Venta");
            formats2.add("Sólo números. Llenar solo si el tipo de cambio es 'C'");
            formats2.add("Fecha documento. Llenar solo cuando el tipo de documento es nota de crédito o débito.");
            formats2.add("Tipo de documento. Llenar solo cuando el tipo de documento es nota de crédito o débito.");
            formats2.add("Serie de documento. Llenar solo cuando el tipo de documento es nota de crédito o débito.");
            formats2.add("Número de documento. Llenar solo cuando el tipo de documento es nota de crédito o débito.");
            formats2.add("T.G. 53 Mantenimiento en parámetros de compras.");
            formats2.add("Ingresar una cuenta de gasto o costo del plan de cuentas y que no sea título.");
            formats2.add("Si Cuenta Contable tiene habilitado C. Costo, Ver T.G. 05");
            formats2.add("Ingresar solo anexos.");
            formats2.add("Obligatorio para comprobantes de compras, valores validos 0,10,18.");


            for (int j = 0; j <formats2.size(); j++) {
                Cell cell = formato2.createCell(j);
                cell.setCellValue(formats2.get(j));
                System.out.println(cell);
            }
            List<String> formats = new ArrayList<>();
            formats.add("Tamaño/Formato");
            formats.add("2 Caracteres");
            formats.add("6 Caracteres");
            formats.add("dd/mm/aaaa");
            formats.add("dd/mm/aaaa");
            formats.add("dd/mm/aaaa");
            formats.add("2 Caracteres");
            formats.add("20 Caracteres");
            formats.add("1 Caracter");
            formats.add("20 Caracteres");
            formats.add("40 Caracteres");
            formats.add("2 Caracteres");
            formats.add("2 decimales");
            formats.add("2 decimales");
            formats.add("2 decimales");
            formats.add("2 decimales");
            formats.add("2 decimales");
            formats.add("2 decimales");
            formats.add("2 decimales");
            formats.add("12 caracteres");
            formats.add("dd/mm/aaaa");
            formats.add("2 decimales");
            formats.add("5 Caracteres");
            formats.add("1 Caracter");
            formats.add("3 decimales");
            formats.add("dd/mm/aaaa");
            formats.add("2 caracteres");
            formats.add("10 caracteres");
            formats.add("20 caracteres");
            formats.add("8 caracteres");
            formats.add("8 caracteres");
            formats.add("6 caracteres");
            formats.add("20 caracteres");
            formats.add("Numérico");

            for (int j = 0; j <formats.size(); j++) {
                Cell cell = formato3.createCell(j);
                cell.setCellValue(formats.get(j));
            }
            Row fila = hoja.createRow(i+2);

            for (int j = 0; j <arrayLists.get(i).size() ; j++) {
                Cell celda = fila.createCell(j);
                int numcel = j-4;
                if(celda.getColumnIndex() == 1){
                    celda.setCellValue("11");
                }if(celda.getColumnIndex() == 2){
                    celda.setCellValue(arrayLists.get(i).get(4).substring(3,5) + comprobante(fila));
                }if(celda.getColumnIndex() == 3){
                    /*String cache = arrayLists.get(i).get(22).substring(0,3);
                    if(cache.equals("PEN")){
                        celda.setCellValue("MN");
                    }else {
                        celda.setCellValue("US");
                    }*/
                    celda.setCellValue(arrayLists.get(i).get(4));
                }if(celda.getColumnIndex() == 4){
                    /*String fecha = arrayLists.get(i).get(0);
                    celda.setCellValue(ordenarFecha(fecha));*/
                    celda.setCellValue(arrayLists.get(i).get(4));
                }if(celda.getColumnIndex() == 5){
                    celda.setCellValue(arrayLists.get(i).get(5));
                }
                if(celda.getColumnIndex() == 6){
                    String cache = arrayLists.get(i).get(6).substring(0,2);
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
                    celda.setCellValue(arrayLists.get(i).get(7)+"-"+arrayLists.get(i).get(9));
                }if(celda.getColumnIndex() == 8){
                    celda.setCellValue(arrayLists.get(i).get(11));
                }if(celda.getColumnIndex() == 9){
                    celda.setCellValue(arrayLists.get(i).get(12));
                }if(celda.getColumnIndex() == 10){
                    celda.setCellValue(arrayLists.get(i).get(13));
                }if(celda.getColumnIndex() == 11){
                    //celda.setCellValue(arrayLists.get(i).get(8)+" "+arrayLists.get(i).get(3)+" "+arrayLists.get(i).get(4));
                    String cache = arrayLists.get(i).get(25).substring(0,3);
                    if(cache.equals("PEN")){
                        celda.setCellValue("MN");
                    }else {
                        celda.setCellValue("US");
                    }
                }if(celda.getColumnIndex() == 12){
                    String cache = arrayLists.get(i).get(14);
                    if(cache.equals("0")){
                        celda.setCellValue("");
                    }else{
                        celda.setCellValue(arrayLists.get(i).get(14));
                    }
                }if(celda.getColumnIndex() == 13){
                    String cache = arrayLists.get(i).get(15);
                    if(cache.equals("0")){
                        celda.setCellValue("");
                    }else{
                        celda.setCellValue(arrayLists.get(i).get(15));
                    }

                }if(celda.getColumnIndex() == 14){
                    String cache = arrayLists.get(i).get(22);
                    if(cache.equals("0")){
                        celda.setCellValue("");
                    }else{
                        celda.setCellValue(arrayLists.get(i).get(22));
                    }
                }if(celda.getColumnIndex() == 15){
                    String cache = arrayLists.get(i).get(20);
                    if(cache.equals("0")){
                        celda.setCellValue("");
                    }else{
                        celda.setCellValue(arrayLists.get(i).get(20));
                    }
                }if(celda.getColumnIndex() == 16){
                    String cache = arrayLists.get(i).get(21);
                    if(cache.equals("0")){
                        celda.setCellValue("");
                    }else{
                        celda.setCellValue(arrayLists.get(i).get(21));
                    }
                }if(celda.getColumnIndex() == 17){
                    String cache = arrayLists.get(i).get(23);
                    if(cache.equals("0")){
                        celda.setCellValue("");
                    }else{
                        celda.setCellValue(arrayLists.get(i).get(23));
                    }
                }if(celda.getColumnIndex() == 18){
                    String cache = arrayLists.get(i).get(24);
                    if(cache.equals("0")){
                        celda.setCellValue("");
                    }else{
                        celda.setCellValue(cache);
                    }
                }if(celda.getColumnIndex() == 19||celda.getColumnIndex() == 20||celda.getColumnIndex() == 21||celda.getColumnIndex() == 22 ){
                        celda.setCellValue("");
                }if(celda.getColumnIndex() == 23){
                    String cache = arrayLists.get(i).get(6).substring(0,2);
                    if(cache.equals("01")){
                        celda.setCellValue("V");
                    }if(cache.equals("07")){
                        celda.setCellValue("C");
                    }
                }if(celda.getColumnIndex() == 24){
                    celda.setCellValue("");
                }if(celda.getColumnIndex() == 25){
                    String cache = arrayLists.get(i).get(27);
                    if(cache.equals("0")){
                        celda.setCellValue("");
                    }else{
                        celda.setCellValue( arrayLists.get(i).get(27));
                    }
                }if(celda.getColumnIndex() == 26){
                    String cache = arrayLists.get(i).get(28);
                    if(cache.equals("0")){
                        celda.setCellValue("");
                    }else{
                        if(cache.equals("01")){
                            celda.setCellValue("FT");
                        }if(cache.equals("07")){
                            celda.setCellValue("NC");
                        }
                    }

                }if(celda.getColumnIndex() == 27){
                    String cache = arrayLists.get(i).get(29);
                    if(cache.equals("0")){
                        celda.setCellValue("");
                    }else{
                        celda.setCellValue(cache);
                    }
                }if(celda.getColumnIndex() == 28){
                    String cache = arrayLists.get(i).get(31);
                    if(cache.equals("0")){
                        celda.setCellValue("");
                    }else{
                        celda.setCellValue(cache);
                    }
                }if(celda.getColumnIndex() == 29){
                    String cache = arrayLists.get(i).get(25).substring(0,3);
                    if(cache.equals("PEN")){
                        celda.setCellValue("421201");
                    }else {
                        celda.setCellValue("421202");
                    }
                }if(celda.getColumnIndex() == 30){
                    String cache = arrayLists.get(i).get(arrayLists.get(i).size()-2);
                    if(cache.equals("0")){
                        celda.setCellValue("");
                    }else{
                        celda.setCellValue(cache);
                    }
                }if(celda.getColumnIndex() == 31){
                    String cache = arrayLists.get(i).get(arrayLists.get(i).size()-1);
                    if(cache.equals("0")){
                        celda.setCellValue("");
                    }else{
                        celda.setCellValue(cache);
                    }
                }if(celda.getColumnIndex() == 33){
                    String cache = arrayLists.get(i).get(15);
                    String base =  arrayLists.get(i).get(14);
                    if(Math.ceil(Double.parseDouble(cache)) == ( Math.ceil(Double.parseDouble(base)*0.18))){
                        celda.setCellValue(18);
                    }else {
                        celda.setCellValue(10);
                    }
                }

            }
        }

    }
    public static void excelGenetCompras(ArrayList<ArrayList<String>> arrayLists) {
        //CREA ARCHIVO LIBRO
        Workbook libro = new XSSFWorkbook();
        //CREA HOJA
        Sheet hoja = libro.createSheet("ventas");

        comprasV(arrayLists,hoja);

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
    private BorderPane  PanelCenter;
    @FXML
    protected void closeButtom(Event event) throws IOException {
        System.out.println(PanelCenter);
    }
    @FXML
    protected void ventasFor(Event event) throws IOException {
        URL url = getClass().getResource("subventana.fxml");
        BorderPane view = FXMLLoader.load(url);
        System.out.println(PanelCenter);
        PanelCenter.setLeft(null);
        PanelCenter.setLeft(view);
        System.out.println(PanelCenter);
    }
    @FXML
    protected void comprasFor(Event event) throws IOException {
        URL url = getClass().getResource("Compras.fxml");
        BorderPane view = FXMLLoader.load(url);
        System.out.println(PanelCenter);
        PanelCenter.setLeft(null);
        PanelCenter.setLeft(view);
        System.out.println(PanelCenter);
    }
    @FXML
    protected void closeB(){
        stage = (Stage) PanelCenter.getScene().getWindow();
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
    ArrayList<ArrayList<String>> DatosBidimensionalComp = new ArrayList<>();
    @FXML
    protected void generarCompras(){
        System.out.println(buscador.getText());
        excelGenetCompras(DatosBidimensionalComp);
        DatosBidimensionalComp.clear();
        number = 1;
    }
    double x , y ;
    public void drangged(javafx.scene.input.MouseEvent event) {
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        if(!stage.isMaximized()){
            stage.setX(event.getScreenX()-x);
            stage.setY(event.getScreenY()-y);
        };
    }

    public void pressed(javafx.scene.input.MouseEvent mouseEvent) {
        x = mouseEvent.getSceneX();
        y = mouseEvent.getSceneY();
    }
    @FXML
    public void cuentaGeneral(ActionEvent actionEvent) {
        glosaDeproveedores.setStyle("-fx-background-color: transparent");
        glosaDeproveedores.setStyle("-fx-text-fill:transparent");
        DatosBidimensionalComp.clear();
        try {
            InputStream fichero = new FileInputStream(String.valueOf(buscador.getText()));
            BufferedInputStream ficheroBuffered = new BufferedInputStream(fichero);
            try {
                int dato = ficheroBuffered.read();
                int i = 0;
                String cache = "";

                DatosBidimensionalComp.add(new ArrayList<>());

                while (dato != -1){
                    if ( (char) dato != '|' )  {
                        cache += String.valueOf((char) dato);
                        dato = ficheroBuffered.read();
                    } else {
                        if (contieneSaltoDeLinea(cache)){
                            String[] lineas = cache.split("\n");
                            DatosBidimensionalComp.add(new ArrayList<>());
                            DatosBidimensionalComp.get(i).add(lineas[0]);
                            i++;
                            DatosBidimensionalComp.get(i).add(lineas[1]);
                            cache = "";
                            dato = ficheroBuffered.read();
                        }else {
                            DatosBidimensionalComp.get(i).add(cache);
                            cache = "";
                            dato = ficheroBuffered.read();
                        }
                    }
                }
                DatosBidimensionalComp.get(DatosBidimensionalComp.size()-1).add(cache);

            }catch (IOException e){
                System.out.println("no puede leer el fichero"+ e.getMessage());
            }
        }catch (FileNotFoundException e){
            System.out.println( e.getMessage());
        }
        geneCu.setDisable(false);
        geneCu.setStyle("-fx-background-color: #415a77");
        geneCu1.setDisable(true);
        geneCu1.setStyle("-fx-background-color: transparent");


    }
    @FXML
    public void cuentasGeneral(ActionEvent actionEvent) {
        glosaDeproveedores.setStyle("-fx-background-color: #415a77");
        DatosBidimensionalComp.clear();
        try {
            InputStream fichero = new FileInputStream(String.valueOf(buscador.getText()));
            BufferedInputStream ficheroBuffered = new BufferedInputStream(fichero);
            try {
                int dato = ficheroBuffered.read();
                int i = 0;
                String cache = "";

                DatosBidimensionalComp.add(new ArrayList<>());

                while (dato != -1){
                    if ( (char) dato != '|' )  {
                        cache += String.valueOf((char) dato);
                        dato = ficheroBuffered.read();
                    } else {
                        if (contieneSaltoDeLinea(cache)){
                            String[] lineas = cache.split("\n");
                            DatosBidimensionalComp.add(new ArrayList<>());
                            DatosBidimensionalComp.get(i).add(lineas[0]);
                            i++;
                            DatosBidimensionalComp.get(i).add(lineas[1]);
                            cache = "";
                            dato = ficheroBuffered.read();
                        }else {
                            DatosBidimensionalComp.get(i).add(cache);
                            cache = "";
                            dato = ficheroBuffered.read();
                        }
                    }
                }
                DatosBidimensionalComp.get(DatosBidimensionalComp.size()-1).add(cache);

            }catch (IOException e){
                System.out.println("no puede leer el fichero"+ e.getMessage());
            }
        }catch (FileNotFoundException e){
            System.out.println( e.getMessage());
        }
        for (int i = 0; i < DatosBidimensionalComp.size(); i++) {
            System.out.print(DatosBidimensionalComp.get(i));
        }
        geneCu1.setDisable(false);
        geneCu1.setStyle("-fx-background-color: #415a77");
        geneCu.setDisable(true);
        geneCu.setStyle("-fx-background-color: transparent");
        glosaDeproveedores.setText(number+"("+(DatosBidimensionalComp.size()-1)+")"+"-"+DatosBidimensionalComp.get(1).get(12)+" "+DatosBidimensionalComp.get(1).get(13) );
        number = 1;
    }
    @FXML private  Button geneCu;
    @FXML private  Button geneCu1;
    @FXML
    private TextField cuentasContables;
    @FXML
    private TextField centrodecosto;
    @FXML
    public void pushCompras(ActionEvent actionEvent) {
        for (int i = 1; i < DatosBidimensionalComp.size(); i++) {
            DatosBidimensionalComp.get(i).set(DatosBidimensionalComp.get(i).size()-2,cuentasContables.getText());
            DatosBidimensionalComp.get(i).set(DatosBidimensionalComp.get(i).size()-1,centrodecosto.getText());
            System.out.println(DatosBidimensionalComp.get(i));
        }
    }
    int number = 1;
    public void pushCompras1(ActionEvent actionEvent) {
        DatosBidimensionalComp.get(number).set(DatosBidimensionalComp.get(number).size()-2,cuentasContables.getText());
        DatosBidimensionalComp.get(number).set(DatosBidimensionalComp.get(number).size()-1,centrodecosto.getText());
        System.out.println(DatosBidimensionalComp.get(number));
        number++;
        glosaDeproveedores.setText(number+"("+(DatosBidimensionalComp.size()-1)+")"+"-"+ DatosBidimensionalComp.get(number).get(12)+" "+DatosBidimensionalComp.get(number).get(13) );
        cuentasContables.setText("");
        centrodecosto.setText("");
    }
}