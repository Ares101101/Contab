package com.contab.contab;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.File;
import javax.swing.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class HelloController {

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
        Workbook libro = new XSSFWorkbook();
    }

}