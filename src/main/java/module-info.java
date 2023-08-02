module com.contab.contab {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;
    requires org.apache.poi.poi;
    requires org.apache.poi.ooxml;

    opens com.contab.contab to javafx.fxml;
    exports com.contab.contab;
}