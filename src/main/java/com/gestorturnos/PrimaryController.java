package com.gestorturnos;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void onGestionarTurnos() throws IOException {
        // cambiar pantalla
        App.setRoot("gestionarTurnos");  
        // (reemplazá "pantallaTurnos" por el nombre real del FXML)
    }

    @FXML
    private void onSalir() {
        System.exit(0); // cierra la aplicación
    }



    /*
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    */
   
}
