package org.samir.projects;

import java.util.LinkedList;

public class Snake extends LinkedList<SnakeCell>{

    int snakeCellCornerSize = 20;

    public Snake(int headX, int headY){
        addFirst(new SnakeCell(headX,headY, snakeCellCornerSize, snakeCellCornerSize));
        addLast(new SnakeCell(headX - snakeCellCornerSize,headY - snakeCellCornerSize, snakeCellCornerSize, snakeCellCornerSize));
        System.out.println("Snake Constructor");
    }

    public void addSnakeCell(int headX, int headY){
        addLast(new SnakeCell(headX,headY,snakeCellCornerSize,snakeCellCornerSize));
    }

    public SnakeCell getHead(){
        return getFirst();
    }

}
