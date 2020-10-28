package org.samir.projects;

import java.io.IOException;
import java.util.Random;

import javafx.fxml.FXMLLoader;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class GameController {

    static Random RANDOM = new Random();

    static int HEIGHT = 20;
    static int WIDTH = 20;
    static int UNIT_NUMBER = 25;

    static boolean GAME_OVER = false;
    static int SPEED = 5;
    Direction DIRECTION = Direction.UP;

    private AnimationTimer animationTimer;
    private Snake snake = null;
    private Food food = null;
    private FoodController foodController = null;
    private GraphicsContext bodyGraphicsContext = null;

    public GameController() throws IOException {

        int snakeX = UNIT_NUMBER * RANDOM.nextInt(GameController.WIDTH -1);
        int snakeY = UNIT_NUMBER * RANDOM.nextInt(GameController.HEIGHT -1);
        snake = new Snake(snakeX,snakeY);

        foodController = new FoodController();
        foodController.newFood(this);

        AnchorPane bodyPane = loadBodyFXML("body");
        bodyGraphicsContext = ( (Canvas) bodyPane.getChildren().stream()
                                                    .filter(child -> child.getClass().getName().equals(Canvas.class.getName()))
                                                    .findFirst()
                                                    .get() ).getGraphicsContext2D();

        animationTimer = new AnimationTimer(){
            long lastTick = 0;

            @Override
            public void handle(long now) {
                if (lastTick == 0) {
                    lastTick = now;
                    nextFrame(bodyGraphicsContext);
                    return;
                }
                if (now - lastTick > 1000000000 / SPEED) {
                    lastTick = now;
                    nextFrame(bodyGraphicsContext);
                }
            }
        };

        SnakeGameApp.mainScene.addEventFilter(KeyEvent.KEY_PRESSED, key -> {
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

    private void nextFrame(GraphicsContext graphicsContext){

        int windowCornerSize = UNIT_NUMBER * HEIGHT;

        if (GAME_OVER) {
            graphicsContext.setFill(Color.RED);
            graphicsContext.setFont(new Font("", 50));
            graphicsContext.fillText("GAME OVER", 100, 250);
            return;
        }

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
            FoodController.newFood(this);
        }

        /* Self destroy */
        for (int i = 1; i < snake.size(); i++) {
            if (snake.get(0).getSnakeCellX() == snake.get(i).getSnakeCellX() && snake.get(0).getSnakeCellY() == snake.get(i).getSnakeCellY()) {
                GAME_OVER = true;
            }
        }

        /*
        // background
        graphicsContext.setFill(Color.BLACK);
        graphicsContext.fillRect(0, 0, windowCornerSize, windowCornerSize);
        */

        /* Drawing Score */
        graphicsContext.setFill(Color.WHITE);
        graphicsContext.setFont(new Font("", 30));
        graphicsContext.fillText("Score: " + (SPEED - 5), 10, 30);

        /* Drawing Food */
        graphicsContext.setFill(FoodController.randomColor(5));
        food = FoodController.firstFood(this);
        graphicsContext.fillOval(food.getFoodX() * UNIT_NUMBER, food.getFoodY() * UNIT_NUMBER, 15, 15);

        /* Drawing Snake */
        for (SnakeCell snakeCell : snake) {
            graphicsContext.setFill(Color.LIGHTGREEN);
            graphicsContext.fillRect(snakeCell.getSnakeCellX(), snakeCell.getSnakeCellY(), HEIGHT, WIDTH);
            //graphicsContext.setFill(Color.GREEN);
            //graphicsContext.fillRect(snakeCell.getSnakeCellX(), snakeCell.getSnakeCellY(), cornersize - 2, cornersize - 2);

        }
    }

    public void startGame(){
        animationTimer.start();
    }

    public void playGame(){
    }

    public void stopGame(){
    }

    public void resetGame(){
        //animationTimer.playFromStar();
    }

    public Snake getSnake(){
        return snake;
    }

    public AnimationTimer getAnimationTimer(){
        return animationTimer;
    }

    private AnchorPane loadBodyFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SnakeGameApp.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

}
