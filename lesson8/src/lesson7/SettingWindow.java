package lesson7;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingWindow extends JFrame {

    private static final int WINDOW_WIDTH = 300;
    private static final int WINDOW_HEIGHT = 380;
    private static final int MAX_WIN_LENGTH = 10;
    private static final int MIN_WIN_LENGTH = 3;
    private static final int HUMAN_V_HUMAN = 0;
    private static final int HUMAN_V_AI = 1;
    private static final int MAX_GAME_FIELD_SIZE = 10;
    private static final int MIN_GAME_FIELD_SIZE = 3;
    private static final String PREFIX_FIELD_SIZE = "Размерность поля ";
    private static final String PREFIX_WIN_LENGHT = "Выигрышная длина ";
    private JRadioButton hvh;
    private JRadioButton hva;
    private JSlider filedDizeSlider;
    private JSlider winSizeSlider;
    GameWindow gameWindow;
    Rectangle gameWindowRectangle;

    SettingWindow(GameWindow gameWindow){
        setTitle("Settings");
        this.gameWindow = gameWindow;
        setSize(WINDOW_WIDTH, WINDOW_WIDTH);
        gameWindowRectangle = gameWindow.getBounds();
        float POSITION_X = (int)gameWindowRectangle.getCenterX() - WINDOW_WIDTH/2;
        float POSITION_Y = (int)gameWindowRectangle.getCenterY() - WINDOW_HEIGHT/2;
        setLocation((int)POSITION_X, (int)POSITION_Y);
        setVisible(true);
        setLayout(new GridLayout(10,1));
        gameMode();
        gameFieldControl();




    }
    private void gameMode(){
        add(new JLabel("Choose game mode: "));
        hvh = new JRadioButton("Human vs human", true);
        hva = new JRadioButton("Human vs AI");
        ButtonGroup gameModeGroupe = new ButtonGroup();
        gameModeGroupe.add(hva);
        gameModeGroupe.add(hvh);
        add(hva);
        add(hvh);
    }

    private void gameFieldControl(){
        JLabel fieldSizeLable = new JLabel(PREFIX_FIELD_SIZE);
        add(fieldSizeLable);
        filedDizeSlider = new JSlider(MIN_GAME_FIELD_SIZE,MAX_GAME_FIELD_SIZE,MIN_GAME_FIELD_SIZE);
        filedDizeSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                fieldSizeLable.setText(PREFIX_FIELD_SIZE + filedDizeSlider.getValue());
                winSizeSlider.setMaximum(filedDizeSlider.getValue());
            }
        });
        add(filedDizeSlider);
        JLabel winLenghtLabel = new JLabel(PREFIX_WIN_LENGHT);
        add(winLenghtLabel);
        winSizeSlider = new JSlider(MIN_WIN_LENGTH,MAX_WIN_LENGTH,MIN_WIN_LENGTH);
        add(winSizeSlider);
        winSizeSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                winLenghtLabel.setText(PREFIX_WIN_LENGHT + winSizeSlider.getValue());
            }
        });
        JPanel btnPnl = new JPanel();
        btnPnl.setLayout(new GridLayout(1,2));
        JButton applySettings = new JButton("Apply");
        JButton close = new JButton("Close");
        applySettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int gamemode;
                if(hvh.isSelected()){
                    gamemode = HUMAN_V_HUMAN;
                } else if(hva.isSelected()){
                    gamemode = HUMAN_V_AI;
                } else {
                    throw new RuntimeException("unknown game mode");
                }
                startGame(gamemode, filedDizeSlider.getValue(),filedDizeSlider.getValue(), winSizeSlider.getValue());
                setVisible(false);
            }
        });
        btnPnl.add(applySettings);
        btnPnl.add(close);
        add(btnPnl);
    }
    private void startGame(int gameMode, int fieldSizeX, int fieldSizeY, int winLength){
        gameWindow.startGame(gameMode, fieldSizeX,fieldSizeY,winLength);
    }
    public Rectangle getGameWindowRectange(){
        return gameWindowRectangle;
    }
}
