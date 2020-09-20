package ru.geekbrains.java2.lesson1;

import javax.swing.*;
import java.awt.*;

public class MainCircles extends JFrame {

    private static final int POSITION_X = 400;
    private static final int POSITION_Y = 100;
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;
    private Sprites[] sprites = new Sprites[10];
    private ColorController colorController = new ColorController();

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainCircles();
            }
        });
    }
    public MainCircles(){

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Circles");
        setBounds(POSITION_X, POSITION_Y, WIDTH, HEIGHT);
        GameCanvas canvas = new GameCanvas(this);
        add(canvas, BorderLayout.CENTER);
        setVisible(true);
        makeBall(sprites);
    }
    //make Array
    private void makeBall(Sprites[] sprites){
        for (int i = 0; i < sprites.length; i++){
            sprites[i] = new Ball();
        }
    }
    public void onDraw(GameCanvas canvas, float deltaTime, Graphics g){
        render(canvas,g);
        update(canvas,deltaTime);
        backgroundUpdate(canvas);


    }
    private void render(GameCanvas canvas, Graphics g){
        for (int i = 0; i < sprites.length; i++){
            sprites[i].render(canvas, g);
        }
    }
    private void update(GameCanvas canvas, float deltaTime){
        for (int i = 0; i < sprites.length; i++){
            sprites[i].update(canvas,deltaTime);
        }
    }
    private void backgroundUpdate(GameCanvas canvas){
        colorController.backgroundUpdate(canvas);
    }

}
