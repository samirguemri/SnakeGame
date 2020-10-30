package org.samir.projects;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;


public class HeadController {


    @FXML
    public void startGame(ActionEvent actionEvent) {
        GameController.startGame();
    }

    @FXML
    public void playGame(ActionEvent actionEvent){}

    @FXML
    public void stopGame(ActionEvent actionEvent){}

    @FXML
    public void resetGame(ActionEvent actionEvent){}
}
