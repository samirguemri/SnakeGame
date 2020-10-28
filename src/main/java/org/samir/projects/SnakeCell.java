package org.samir.projects;

public class SnakeCell {

    int snakeCellX;
    int snakeCellY;
    int height;
    int width;

    public SnakeCell(int snakeCellX, int snakeCellY, int height, int width) {
        this.snakeCellX = snakeCellX;
        this.snakeCellY = snakeCellY;
        this.height = height;
        this.width = width;
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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
