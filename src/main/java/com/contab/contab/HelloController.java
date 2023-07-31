package com.contab.contab;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HelloController {


    @FXML
    private Circle close;
    Stage subWindowStage = new Stage();
    @FXML
    protected void ventasFor() throws IOException {
            FXMLLoader subWindowLoader = new FXMLLoader(getClass().getResource("subventana.fxml"));
            AnchorPane subWindowRoot = subWindowLoader.load();
            Scene subWindowScene = new Scene(subWindowRoot);


            subWindowStage.initStyle(StageStyle.UNDECORATED);
            subWindowStage.setScene(subWindowScene);
            subWindowStage.show();

    }
    @FXML
    protected void closeButtom (){
        close.setOnMouseClicked(event -> {
            // Lógica de cierre o acción personalizada
            subWindowStage.close(); // Cierra la ventana principal al hacer clic en el objeto circular
        });
    }

}