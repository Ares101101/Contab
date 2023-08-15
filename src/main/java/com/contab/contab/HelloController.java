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
import java.util.LinkedList;
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
    public static void fechaV(ArrayList<ArrayList<String>> arrayLists, Sheet hoja){

        for (int i = 1; i < arrayLists.size(); i++) {
            Row fila = hoja.createRow(i+3);

            for (int j = 0; j <arrayLists.get(i).size() ; j++) {
                Cell celda = fila.createCell(j);
                int numcel = j-4;
                if(celda.getColumnIndex() == 1){
                        celda.setCellValue("05");
                }if(celda.getColumnIndex() == 2){
                    celda.setCellValue(arrayLists.get(i).get(0).substring(5,7));
                }
                else if ( celda.getColumnIndex() > 3 && numcel<=arrayLists.get(i).size()) {
                    celda.setCellValue(arrayLists.get(i).get(numcel));
                }


            }
        }
    }
    public static void excelGenet(ArrayList<ArrayList<String>> arrayLists) {
        //CREA ARCHIVO LIBRO
        Workbook libro = new XSSFWorkbook();
        //CREA HOJA
        Sheet hoja = libro.createSheet(String.valueOf(ventasForm));

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
        subWindowStage.initStyle(StageStyle.UNDECORATED);
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