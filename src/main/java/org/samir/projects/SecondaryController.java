package org.samir.projects;

import java.io.IOException;
import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        SnakeGameApp.setRoot("primary");
    }
}