package org.samir.projects;

import javafx.scene.paint.Color;

public class FoodController {

    public static Food firstFood() {

        int foodX = GameController.WIDTH * GameController.RANDOM.nextInt(GameController.UNIT_NUMBER );
        int foodY = GameController.HEIGHT * GameController.RANDOM.nextInt(GameController.UNIT_NUMBER );

        return new Food(foodX,foodY,20,20);
    }

    public static Food newFood() {

        int foodX;
        int foodY;

        Snake snake = GameController.snake;

        start:
        while (true) {
            foodX = GameController.WIDTH * GameController.RANDOM.nextInt(GameController.UNIT_NUMBER );
            foodY = GameController.HEIGHT * GameController.RANDOM.nextInt(GameController.UNIT_NUMBER );
            for (SnakeCell snakeCell : snake) {
                if (snakeCell.getSnakeCellX() == foodX && snakeCell.getSnakeCellY() == foodY) {
                    continue start;
                }
            }
            GameController.SPEED++;
            break;
        }
        return new Food(foodX,foodY,20,20);
    }

    public static Color randomColor(int randomColorNumber){
        Color randomColor = Color.WHITE;
        switch (randomColorNumber) {
            case 1:
                randomColor = Color.PURPLE;
                break;
            case 2:
                randomColor = Color.LIGHTBLUE;
                break;
            case 3:
                randomColor = Color.YELLOW;
                break;
            case 4:
                randomColor = Color.PINK;
                break;
            case 5:
                randomColor = Color.ORANGE;
                break;
        }
        return randomColor;
    }
}
