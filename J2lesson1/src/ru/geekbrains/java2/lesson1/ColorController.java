package ru.geekbrains.java2.lesson1;

import java.awt.*;

public class ColorController {
    private Color color;

    public ColorController(){
        this.color = randomColor();
    }

    public Color randomColor(){
        return new Color((int)(Math.random() * 255),
                (int)(Math.random() * 255),
                (int)(Math.random() * 255));
    }

    public void backgroundUpdate(GameCanvas canvas){
        Color canvasColor = canvas.getBackground();
        int r = canvasColor.getRed();
        int g = canvasColor.getGreen();
        int b = canvasColor.getBlue();
        int max = 255;
        if(b < max){
            b++;
            canvas.setBackground(new Color(r,g,b));
        } else if ( b == max - 1){
            b = 0;
            if (g < max -1){
                g++;
                canvas.setBackground(new Color(r,g,b));
            } else if (g == max -1){
                g = 0;
                if (r < max -1){
                    r++;
                    canvas.setBackground(new Color(r,g,b));
                } else if (r == max -1){
                    canvas.setBackground(randomColor());
                }
            }
        } else {
            canvas.setBackground(randomColor());
        }
    }

    public Color getColor(){
        return color;
    }
}
