package org.samir.projects;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SnakeCell {

    int snakeCellX;
    int snakeCellY;
    int snakeCellWidth;
    int snakeCellHeight;

    public SnakeCell(int snakeCellX, int snakeCellY, int snakeCellWidth, int snakeCellHeight) {
        this.snakeCellX = snakeCellX;
        this.snakeCellY = snakeCellY;
        this.snakeCellWidth = snakeCellWidth;
        this.snakeCellHeight = snakeCellHeight;
    }

    public int getSnakeCellX() {
        return snakeCellX;
    }

    public void setSnakeCellX(int snakeCellX) {
        this.snakeCellX = snakeCellX;
    }

    public int getSnakeCellY() {
        return snakeCellY;
    }

    public void setSnakeCellY(int snakeCellY) {
        this.snakeCellY = snakeCellY;
    }

    public int getSnakeCellHeight() {
        return snakeCellHeight;
    }

    public void setSnakeCellHeight(int snakeCellHeight) {
        this.snakeCellHeight = snakeCellHeight;
    }

    public int getSnakeCellWidth() {
        return snakeCellWidth;
    }

    public void setSnakeCellWidth(int snakeCellWidth) {
        this.snakeCellWidth = snakeCellWidth;
    }

    public Rectangle getRectangle() {
        Rectangle rectangle = new Rectangle(snakeCellX, snakeCellY, snakeCellWidth, snakeCellHeight);
        rectangle.setFill(Color.BLACK);
        return rectangle;
    }

}
