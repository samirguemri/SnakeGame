package org.samir.projects;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;

public class BodyController {

    @FXML
    private AnchorPane bodyPane;
    @FXML
    private Group layerId;

    private GameController gameController;

    public AnchorPane getBodyPane() {
        return bodyPane;
    }

    public Group getLayer() {
        return layerId;
    }

    public GameController getGameController() {
        return gameController;
    }
}
