package org.samir.projects;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        SnakeGameApp.setRoot("secondary");
    }
}
