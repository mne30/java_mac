package ru.geekbrains.java2.lesson1;

import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel {

    private long lastFrameTime;
    private MainCircles gameController;
    private ColorController colorController;

    public GameCanvas(MainCircles gameController){
        this.gameController = gameController;
        lastFrameTime = System.nanoTime();
        colorController = new ColorController();
        setBackground(colorController.getColor());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - lastFrameTime)*0.000000001f;
        gameController.onDraw(this, deltaTime, g);
        lastFrameTime = currentTime;
        try {
            Thread.sleep(17);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        repaint();
    }

    public int getLeft() { return 0; }
    public int getRight() { return getWidth() - 1; }
    public int getTop() { return 0; }
    public int getDown() { return getHeight() - 1; }
}
