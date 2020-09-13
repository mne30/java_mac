package ru.geekbrains.java2.lesson1;

import java.awt.*;


public class Ball extends Sprites{

    private ColorController colorController = new ColorController();
    private Color color;
    private float vX;
    private float vY;

    Ball(){
        color = colorController.getColor();
        vX = (float)(100f + (float)(Math.random() * 200f));
        vY = (float)(100f + (float)(Math.random() * 200f));
        halfHeight = 15f + (float)(Math.random() * 40f);
        halfWidth = halfHeight;

    }

    @Override
    protected void render(GameCanvas canvas, Graphics g) {
        g.setColor(color);
        g.fillOval((int)x,(int)y,(int)getWidth(),(int)getHeight());
    }

    @Override
    protected void update(GameCanvas canvas, float deltaTime) {
        x+= vX * deltaTime;
        y+= vY * deltaTime;
        if (getLeft() < canvas.getLeft()) {
            setLeft(canvas.getLeft());
            vX = -vX;
        }
        if (getRight() > canvas.getRight()) {
            setRight(canvas.getRight());
            vX = -vX;
        }
        if (getTop() < canvas.getTop()) {
            setTop(canvas.getTop());
            vY = -vY;
        }
        if (getBottom() > canvas.getDown()) {
            setBottom(canvas.getDown());
            vY = -vY;
        }
    }
}

