package com.contab.contab;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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
import javax.swing.*;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class HelloController {

    @FXML
    private MenuItem ventasForm;
    @FXML
    private Label buscador;
    @FXML
    private Button close;
    @FXML
    private AnchorPane scenePane;
    Stage stage;
    private double xOffset = 0;
    private double yOffset = 0;

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
        //CREA ARCHIVO LIBRO
        Workbook libro = new XSSFWorkbook();
        //CREA HOJA
        Sheet hoja = libro.createSheet(String.valueOf(ventasForm));
        //CREA FILAS
        Row fila = hoja.createRow(0);
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
        try {
            InputStream fichero = new FileInputStream(String.valueOf(buscador.getText()));
            BufferedInputStream ficheroBuffered = new BufferedInputStream(fichero);
            try {
                int dato = ficheroBuffered.read();
                System.out.print((char) dato);
                String cache = "";
                String Datos[][];
               while (dato != -1){
                   if ( (char) dato != '|' )  {

                   }else {

                   }


               }
            }catch (IOException e){
                System.out.println("no puede leer el fichero"+ e.getMessage());
            }
        }catch (FileNotFoundException e){
            System.out.println( e.getMessage());
        }

    }
}