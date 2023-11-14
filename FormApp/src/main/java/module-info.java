module com.example.formapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.formapp to javafx.fxml;
    exports com.example.formapp;
}