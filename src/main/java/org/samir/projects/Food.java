package org.samir.projects;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Food {

    private String id;
    private int foodX;
    private int foodY;
    private int foodWidth;
    private int foodHeight;
    private Rectangle rectangle;

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

    public String getId() {
        return id;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Rectangle toRectangle(Color color) {
        rectangle = new Rectangle(foodX,foodY,foodWidth,foodHeight);
        rectangle.setId(id);
        rectangle.setFill(color);
        return rectangle;
    }
}
