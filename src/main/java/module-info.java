module com.gestorturnos {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.gestorturnos to javafx.fxml;
    exports com.gestorturnos;
}
