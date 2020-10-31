package org.samir.projects;

import javafx.animation.AnimationTimer;

public class SnakeAnimationTimer extends AnimationTimer {
    long lastTick = 0;

    public SnakeAnimationTimer(){

    }

    @Override
    public void handle(long now) {
        doHandle(now);
    }

    private void doHandle(long now) {
        if (lastTick == 0) {
            lastTick = now;
            GameController.drawFrame();

            return;
        }
        long frequency = 999999999;
        if (now - lastTick > frequency / GameController.SPEED) {
            lastTick = now;
            GameController.drawFrame();
        }
    }
}
