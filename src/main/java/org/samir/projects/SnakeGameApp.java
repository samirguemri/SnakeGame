package org.samir.projects;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class SnakeGameApp extends Application {

    public static Scene mainScene;

    @Override
    public void start(Stage mainStage) throws IOException {
        mainStage.setTitle("The Snake Game");
        mainStage.setResizable(false);

        Parent mainPanel = loadFXML("mainPane");
        mainScene = new Scene(mainPanel);
        mainStage.setScene(mainScene);

        mainStage.sizeToScene();
        mainStage.show();
    }

    private Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SnakeGameApp.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}