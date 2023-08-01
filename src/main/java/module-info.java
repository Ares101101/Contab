module com.contab.contab {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens com.contab.contab to javafx.fxml;
    exports com.contab.contab;
}