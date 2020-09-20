package ru.geekbrains.java2.lesson4.server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatServerGUI extends JFrame implements ActionListener, Thread.UncaughtExceptionHandler {

    private final int POSITION_X = 1000;
    private final int POSITION_Y = 500;
    private final int FRAME_HEIGHT = 60;
    private final int FRAME_WIDTH = 300;

    private JButton startServer = new JButton("Start");
    private JButton stopServer = new JButton("Stop");
    private ChatServer chatServer = new ChatServer();


    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ChatServerGUI();
            }
        });
    }

    private ChatServerGUI(){
        Thread.setDefaultUncaughtExceptionHandler(this);
        setBounds(POSITION_X,POSITION_Y,FRAME_WIDTH, FRAME_HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1,2));
        add(buttonPanel);
        buttonPanel.add(startServer);
        buttonPanel.add(stopServer);
        startServer.addActionListener(this);
        stopServer.addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == startServer){
            chatServer.startServer(333);
        } else if (source == stopServer){
            chatServer.stopServer();
        } else {
            new Throwable("Unknown sourse " + source);
        }
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        e.printStackTrace();
        String msg;
        StackTraceElement[] stc = e.getStackTrace();
        msg = t.getName() + e.getMessage() + e.getClass().getCanonicalName() +
                stc[0];
        JOptionPane.showMessageDialog(this, msg, "Exception",JOptionPane.ERROR_MESSAGE);
        System.exit(1);
    }
}
