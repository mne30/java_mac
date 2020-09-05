package ru.geekbrains.java1.lesson7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {

    private static final int WINDOW_WIDTH = 450;
    private static final int WINDOW_HEIGHT = 470;
    GameWindow gameWindow = this;
    SettingWindow settingWindow;
    Map map;

    GameWindow(){
        setTitle("TikTakToe");
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        JPanel btnpanel = new JPanel(new GridLayout(1,2));
        add(btnpanel, BorderLayout.SOUTH);
        map = new Map(this);
        add(map);
        JButton exit = new JButton("exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        JButton settings = new JButton("settings");
        settings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingWindow = new SettingWindow(gameWindow);
            }
        });
        btnpanel.add(settings);
        btnpanel.add(exit);
        repaint();
        setVisible(true);
    }
    public void startGame(int gameMode, int fieldSizeX, int fieldSizeY, int winLength){
        fieldSizeX = fieldSizeY; //Заглушка
        System.out.format("gamemode: %d, fieldSize: %d, winlenght: %d", gameMode, fieldSizeX,winLength);
        map.drawMap(gameMode,fieldSizeX,fieldSizeY,winLength);
    }

}
