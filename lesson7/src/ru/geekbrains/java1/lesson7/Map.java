package ru.geekbrains.java1.lesson7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Map extends JPanel {

    private static final char CHAR_HUMAN = 'X';
    private static final char CHAR_AI = 'O';
    private static final char CHAR_EMPTY = ' ';
    private int colsSize;
    private int rowsSize;
    private int gameMode;
    private Random random = new Random();
    private int fieldSizeX;
    private int fieldSizeY;
    private int winLength;
    GameWindow gameWindow;
    char[][] gamefield;
    boolean gameOver = true;


    public Map(GameWindow gameWindow){
        this.gameWindow = gameWindow;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                update(e);
            }
        });
    }
    private void update(MouseEvent e){
        int clickX = e.getX() / colsSize;
        int clickY = e.getY() / rowsSize;
        if(!checkValid(clickX,clickY) && !checkEmpty(clickX,clickY))
            return;
        gamefield[clickX][clickY] = CHAR_HUMAN;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private void render(Graphics g){
        if(gameOver)
            return;
        colsSize = this.getWidth() / fieldSizeX;
        rowsSize = this.getHeight() / fieldSizeY;
        for(int i = 0; i <= fieldSizeY; i++){
            int y = rowsSize * i;
            g.drawLine(0, y, colsSize * fieldSizeX, y);
        }
        for(int i = 0; i <= fieldSizeX; i++){
            int x = colsSize * i;
            g.drawLine(x, 0, x,rowsSize * fieldSizeY);
        }

        for(int i = 0; i < gamefield.length; i++){
            for(int z = 0; z < gamefield[i].length; z++){
                int x = i * rowsSize + 2;
                int y = z * colsSize + 2;
                if(gamefield[i][z] == CHAR_HUMAN){
                    g.drawOval(x, y, colsSize, rowsSize);
                    System.out.println(x + " " + y + " ");
                } else if(gamefield[i][z] == CHAR_AI){

                } else {

                }

            }
        }
    }



    public void drawMap(int gameMode, int fieldSizeX, int fieldSizeY, int winLength){
        this.fieldSizeX = fieldSizeX;
        this.fieldSizeY = fieldSizeY;
        this.winLength = winLength;
        this.gameMode = gameMode;
        gamefield = new char[fieldSizeX][fieldSizeY];
        gameOver = false;
        repaint();
    }

    private boolean checkValid(int x, int y){
        if(x > fieldSizeX || y > fieldSizeY)
            return false;
        return true;
    }
    private boolean checkEmpty(int x, int y){
        if(gamefield[x][y] == CHAR_EMPTY)
            return true;
        return false;
    }


}

