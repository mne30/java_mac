package ru.geekbrains.java2.lesson1;

import java.awt.*;

public class Sprites {
    protected float x = 0f;
    protected float y = 0f;
    protected float halfWidth;
    protected float halfHeight;

    protected void render(GameCanvas canvas, Graphics g){};
    protected void update(GameCanvas canvas, float deltaTime){};
    protected float getLeft() {
        return x - halfWidth;
    }
    protected void setLeft(float left) {
        x = left + halfWidth;
    }
    protected float getRight() {
        return x + halfWidth;
    }
    protected void setRight(float right) {
        x = right - halfWidth;
    }
    protected float getTop() {
        return y - halfHeight;
    }
    protected void setTop(float top) {
        y = top + halfHeight;
    }
    protected float getBottom() {
        return y + halfHeight;
    }
    protected void setBottom(float bottom) {
        y = bottom - halfHeight;
    }

    protected float getWidth(){
        return 2f*halfWidth;
    }
    protected float getHeight(){
        return 2f*halfHeight;
    }
}
