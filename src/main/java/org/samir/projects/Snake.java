package org.samir.projects;

import java.util.LinkedList;

public class Snake extends LinkedList<SnakeCell>{

    int snakeCellCornerSize = 20;

    public Snake(int headX, int headY){
        SnakeCell snakeHead = new SnakeCell(headX,headY, snakeCellCornerSize, snakeCellCornerSize);
        snakeHead.setId("snakeCell");
        addFirst(snakeHead);

        SnakeCell snakeTail = new SnakeCell(headX - snakeCellCornerSize,headY, snakeCellCornerSize, snakeCellCornerSize);
        snakeTail.setId("snakeCell");
        addLast(snakeTail);
    }

    public void addSnakeCell(int headX, int headY){
        SnakeCell snakeTail = new SnakeCell(headX,headY, snakeCellCornerSize, snakeCellCornerSize);
        snakeTail.setId("snakeCell");
        addLast(snakeTail);
    }

    public void addSnakeCell(SnakeCell snakeCell){
        addLast(new SnakeCell(snakeCell.getSnakeCellX(),snakeCell.getSnakeCellY(),snakeCellCornerSize,snakeCellCornerSize));
    }

    public SnakeCell getHead(){
        return getFirst();
    }

}
