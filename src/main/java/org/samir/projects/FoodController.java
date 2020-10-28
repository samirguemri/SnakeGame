package org.samir.projects;

import javafx.scene.paint.Color;

public class FoodController {

    public static Food firstFood(GameController gameController) {

        int foodX = GameController.UNIT_NUMBER * GameController.RANDOM.nextInt(GameController.WIDTH -1);
        int foodY = GameController.UNIT_NUMBER * GameController.RANDOM.nextInt(GameController.HEIGHT -1);

        return new Food(foodX,foodY,15,15);
    }

    public static Food newFood(GameController gameController) {

        int foodX;
        int foodY;

        Snake snake = gameController.getSnake();

        start:
        while (true) {
            foodX = GameController.UNIT_NUMBER * GameController.RANDOM.nextInt(GameController.WIDTH -1);
            foodY = GameController.UNIT_NUMBER * GameController.RANDOM.nextInt(GameController.HEIGHT -1);
            for (SnakeCell snakeCell : snake) {
                if (snakeCell.getSnakeCellX() == foodX && snakeCell.getSnakeCellY() == foodY) {
                    continue start;
                }
            }
            GameController.SPEED++;
            break;
        }
        return new Food(foodX,foodY,15,15);
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
