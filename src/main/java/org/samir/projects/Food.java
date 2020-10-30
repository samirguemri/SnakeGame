package org.samir.projects;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Food {

    private int foodX;
    private int foodY;
    private int foodWidth;
    private int foodHeight;

    public Food(int foodX, int foodY, int foodWidth, int foodHeight) {
        this.foodX = foodX;
        this.foodY = foodY;
        this.foodWidth = foodWidth;
        this.foodHeight = foodHeight;
    }

    public int getFoodX() {
        return foodX;
    }

    public void setFoodX(int foodX) {
        this.foodX = foodX;
    }

    public int getFoodY() {
        return foodY;
    }

    public void setFoodY(int foodY) {
        this.foodY = foodY;
    }

    public int getFoodHeight() {
        return foodHeight;
    }

    public void setFoodHeight(int foodHeight) {
        this.foodHeight = foodHeight;
    }

    public int getFoodWidth() {
        return foodWidth;
    }

    public void setFoodWidth(int foodWidth) {
        this.foodWidth = foodWidth;
    }

    public Rectangle getRectangle(Color color) {
        Rectangle rectangle = new Rectangle(foodX,foodY,foodWidth,foodHeight);
        rectangle.setFill(color);
        return rectangle;
    }
}
