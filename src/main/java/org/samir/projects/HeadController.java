package org.samir.projects;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class HeadController {

    private GameController gameController;

    public void initialize() throws IOException {
        gameController = new GameController();
    }

    @FXML
    public void startGame(ActionEvent actionEvent) {
        gameController.startGame();
    }

    @FXML
    public void playGame(ActionEvent actionEvent){}

    @FXML
    public void stopGame(ActionEvent actionEvent){}

    @FXML
    public void resetGame(ActionEvent actionEvent){}
}
