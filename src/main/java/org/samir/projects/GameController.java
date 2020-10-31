package org.samir.projects;

import java.io.IOException;
import java.util.Random;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class GameController {

    public static int HEIGHT = 20;
    public static int WIDTH = 20;
    public static int UNIT_NUMBER = 25;
    public static int SPEED = 5;
    public static boolean GAME_OVER = false;
    public static Random RANDOM = new Random();
    public static Direction DIRECTION = Direction.DOWN;
    public static int windowCornerSize = UNIT_NUMBER * HEIGHT;

    private static Scene mainScene = null;
    private static Group layer = null;
    private static AnimationTimer animationTimer = null;

    public static Snake snake = null;
    private static Food food = null;
    private static Text scoreText = null;
    private static Text gameOverText = null;

    public GameController() throws IOException {

        loadScene();
        initializeGame();
        animationTimer = new SnakeAnimationTimer();

    }

    public static void drawFrame(){

        if (GAME_OVER) {
            gameOverText = new Text(100, 250,"GAME OVER");
            gameOverText.setFill(Color.RED);
            gameOverText.setFont(new Font("", 50));
            gameOverText.setId("gameOverText");
            layer.getChildren().add(gameOverText);
            animationTimer.stop();
            return;
        }

        /* Drawing Food */
        if (food == null ) {
            food = FoodController.newFood();
            food.setId("food");
            layer.getChildren().add(food.toRectangle(FoodController.randomColor(5)));
        }

        /* Clear Snake shapes from Layer */
        for (SnakeCell snakeCell : snake) {
            layer.getChildren().remove(snakeCell.getRectangle());
        }

        /* Drawing Snake */
        for (SnakeCell snakeCell : snake) {
            layer.getChildren().add(snakeCell.toRectangle());
        }

        /* Drawing Score*/
        if (scoreText != null)
            layer.getChildren().remove(scoreText);
        scoreText = new Text(10, 30,"Score: " + (SPEED - 6));
        scoreText.setFill(Color.YELLOW);
        scoreText.setFont(new Font("", 30));
        scoreText.setId("scoreText");
        layer.getChildren().add(scoreText);

        /* Self destroy */
        for (int i = 1; i < snake.size(); i++) {
            if (snake.get(0).getSnakeCellX() == snake.get(i).getSnakeCellX() && snake.get(0).getSnakeCellY() == snake.get(i).getSnakeCellY()) {
                GAME_OVER = true;
            }
        }

        /* Moving Snake body forward */
        for (int i = snake.size() - 1; i >= 1; i--) {
            snake.get(i).setSnakeCellX(snake.get(i-1).getSnakeCellX());
            snake.get(i).setSnakeCellY(snake.get(i-1).getSnakeCellY());
        }

        /* Moving Snake head under DIRECTION & GAME_OVER verification */
        int x;
        int y;
        switch (DIRECTION) {
            case UP:
                y = snake.getHead().getSnakeCellY();
                snake.getHead().setSnakeCellY(y - HEIGHT);
                if (y <= 0) {
                    GAME_OVER = true;
                }
                break;
            case DOWN:
                y = snake.getHead().getSnakeCellY();
                snake.getHead().setSnakeCellY(y + HEIGHT);
                if (y + HEIGHT >= windowCornerSize) {
                    GAME_OVER = true;
                }
                break;
            case LEFT:
                x = snake.getHead().getSnakeCellX();
                snake.getHead().setSnakeCellX(x - WIDTH);
                if (x <= 0) {
                    GAME_OVER = true;
                }
                break;
            case RIGHT:
                x = snake.getHead().getSnakeCellX();
                snake.getHead().setSnakeCellX(x + WIDTH);
                if (x + WIDTH >= windowCornerSize) {
                    GAME_OVER = true;
                }
                break;
        }

        /* Eating Food */
        if (food.getFoodX() == snake.getHead().getSnakeCellX() && food.getFoodY() == snake.getHead().getSnakeCellY()) {
            layer.getChildren().remove(food.getRectangle());
            food = null;
            snake.addSnakeCell(snake.getLast());
        }
    }

    public static void loadScene(){
        mainScene = SnakeGameApp.mainScene;
        layer = (Group) mainScene.lookup("#layer");
    }

    private static void initializeGame() {

        SPEED = 5;
        GAME_OVER = false;

        if (scoreText != null) {
            layer.getChildren().remove(scoreText);
            scoreText = null;
        }

        if (gameOverText != null) {
            layer.getChildren().remove(gameOverText);
            gameOverText = null;
        }

        if (food != null) {
            layer.getChildren().remove(food.getRectangle());
            food = null;
        }

        if (snake != null) {
            for (SnakeCell snakeCell : snake) {
                layer.getChildren().remove(snakeCell.getRectangle());
            }
            snake = null;
        }

        /* Create Snake */
        int snakeX = WIDTH * RANDOM.nextInt(10 );
        int snakeY = HEIGHT * RANDOM.nextInt(10 );
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
    }

    public static void startGame(){
        animationTimer.start();
    }

    public static void playGame(){
        animationTimer.start();
    }

    public static void stopGame(){
        animationTimer.stop();
    }

    public static void resetGame(){
        loadScene();
        initializeGame();
        animationTimer = new SnakeAnimationTimer();
    }

}
