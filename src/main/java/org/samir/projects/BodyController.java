package org.samir.projects;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;

public class BodyController {

    @FXML
    private AnchorPane bodyPane;
    @FXML
    private Group layer;

    private GameController gameController;

    public AnchorPane getBodyPane() {
        return bodyPane;
    }

    public Group getLayer() {
        return layer;
    }

    public GameController getGameController() {
        return gameController;
    }
}
