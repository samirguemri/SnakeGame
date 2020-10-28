package org.samir.projects;

public class Food {

    private int foodX;
    private int foodY;
    private int foodHeight;
    private int foodWidth;

    public Food(int foodX, int foodY, int foodHeight, int foodWidth) {
        this.foodX = foodX;
        this.foodY = foodY;
        this.foodHeight = foodHeight;
        this.foodWidth = foodWidth;
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
}
