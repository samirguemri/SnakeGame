package org.samir.projects;

import java.io.IOException;
import java.util.Random;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class GameController {

    static Random RANDOM = new Random();

    static int HEIGHT = 20;
    static int WIDTH = 20;
    static int UNIT_NUMBER = 25;

    static boolean GAME_OVER = false;
    static int SPEED = 5;
    Direction DIRECTION = Direction.UP;

    static Snake snake = null;
    static Food food = null;

    static Scene mainScene =null;
    private Group layer = null;
    private static AnimationTimer animationTimer;

    public GameController() throws IOException {

        Pane mainPane = SnakeGameApp.loadFXML("mainPane");

        mainScene = SnakeGameApp.setSceneRootPane(mainPane);

        Group layer = (Group) mainScene.lookup("#layer");
        System.out.println("GameController:group"+layer);

        /* Create Snake */
        int snakeX = WIDTH * RANDOM.nextInt(UNIT_NUMBER );
        int snakeY = HEIGHT * RANDOM.nextInt(UNIT_NUMBER );
        snake = new Snake(snakeX,snakeY);

        /* Add KeyPressed event Listener to the mainScene*/
        if (mainScene == null) {
            System.out.println("mainScene is null");
            System.exit(1);
        }
        mainScene.addEventFilter(KeyEvent.KEY_PRESSED, key -> {
            if (key.getCode() == KeyCode.UP) {
                DIRECTION = Direction.UP;
            }
            if (key.getCode() == KeyCode.LEFT) {
                DIRECTION = Direction.LEFT;
            }
            if (key.getCode() == KeyCode.DOWN) {
                DIRECTION = Direction.DOWN;
            }
            if (key.getCode() == KeyCode.RIGHT) {
                DIRECTION = Direction.RIGHT;
            }
        });

        /* Create the AnimationTimer */
        animationTimer = new AnimationTimer(){
            long lastTick = 0;

            @Override
            public void handle(long now) {
                if (lastTick == 0) {

                    /* Create First Food */
                    food = FoodController.firstFood();
                    layer.getChildren().add(food.getRectangle(Color.GREEN));

                    lastTick = now;
                    drawFrame(layer);

                    return;
                }
                if (now - lastTick > 1000000000 / SPEED) {
                    lastTick = now;
                    drawFrame(layer);
                }
            }
        };
    }

    private void drawFrame(Group layer){

        int windowCornerSize = UNIT_NUMBER * HEIGHT;

        if (GAME_OVER) {
            Text text = new Text(100, 250,"GAME OVER");
            text.setFill(Color.RED);
            text.setFont(new Font("", 50));
            layer.getChildren().add(text);
            return;
        }

        /* Drawing Score */
        Text scoreText = new Text(10, 30,"Score: " + (SPEED - 5));
        scoreText.setFill(Color.WHITE);
        scoreText.setFont(new Font("", 30));
        layer.getChildren().add(scoreText);

        /* Moving Snake body forward */
        for (int i = snake.size() - 1; i >= 1; i--) {
            snake.get(i).setSnakeCellX(snake.get(i-1).getSnakeCellX());
            snake.get(i).setSnakeCellY(snake.get(i-1).getSnakeCellY());
        }

        /* Moving Snake head under DIRECTION */
        int x;
        int y;
        switch (DIRECTION) {
            case UP:
                y = snake.getHead().getSnakeCellY();
                snake.getHead().setSnakeCellY(y--);
                if (y < 0) {
                    GAME_OVER = true;
                }
                break;
            case DOWN:
                y = snake.getHead().getSnakeCellY();
                snake.getHead().setSnakeCellY(y++);
                if (y > windowCornerSize) {
                    GAME_OVER = true;
                }
                break;
            case LEFT:
                x = snake.getHead().getSnakeCellX();
                snake.getHead().setSnakeCellX(x--);
                if (x < 0) {
                    GAME_OVER = true;
                }
                break;
            case RIGHT:
                x = snake.getHead().getSnakeCellX();
                snake.getHead().setSnakeCellX(x++);
                if (x > windowCornerSize) {
                    GAME_OVER = true;
                }
                break;
        }

        /* Eating Food */
        if (food.getFoodX() == snake.getHead().getSnakeCellX() && food.getFoodY() == snake.getHead().getSnakeCellY()) {
            snake.addSnakeCell(-1,-1);
            FoodController.newFood();
        }

        /* Self destroy */
        for (int i = 1; i < snake.size(); i++) {
            if (snake.get(0).getSnakeCellX() == snake.get(i).getSnakeCellX() && snake.get(0).getSnakeCellY() == snake.get(i).getSnakeCellY()) {
                GAME_OVER = true;
            }
        }

        /* Drawing Food */
        food = FoodController.newFood();
        layer.getChildren().add(food.getRectangle(FoodController.randomColor(5)));

        /* Drawing Snake */
        for (SnakeCell snakeCell : snake) {
            layer.getChildren().add(snakeCell.getRectangle());
        }
    }

    public static void startGame(){
        System.out.println("GameController.startGame()");
        animationTimer.start();
    }

    public static void playGame(){
    }

    public static void stopGame(){
    }

    public static void resetGame(){
        //animationTimer.playFromStar();
    }

}
