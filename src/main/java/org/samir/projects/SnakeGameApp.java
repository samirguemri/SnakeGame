package org.samir.projects;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class SnakeGameApp extends Application {

    public static Scene mainScene = null;

    @Override
    public void start(Stage primaryStage) throws IOException {
        initUI(primaryStage);
    }

    private void initUI(Stage primaryStage) throws IOException  {

        primaryStage.setTitle("The Snake Game");
        primaryStage.setResizable(false);

        Parent mainPane = loadFXML("mainPane");
        mainScene = new Scene(mainPane);
        primaryStage.setScene(mainScene);

        new GameController();

        primaryStage.sizeToScene();
        primaryStage.show();
    }

    public static Scene setSceneRootPane(Parent rootPane){
        mainScene.setRoot(rootPane);
        return mainScene;
    }

    public static Pane loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SnakeGameApp.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}