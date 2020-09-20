package ru.geekbrains.java2.lesson4.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChatClientGUI extends JFrame implements ActionListener, Thread.UncaughtExceptionHandler, KeyListener {

    private final int POSITION_X = 500;
    private final int POSITION_Y = 500;
    private final int FRAME_HEIGHT = 400;
    private final int FRAME_WIDTH = 600;
    private JButton sendMessage = new JButton("Send");
    private JButton logIn = new JButton("Login");
    private JTextArea log = new JTextArea();
    private JTextField userName = new JTextField("username");
    private JTextField serverAdress = new JTextField("adress");
    private JTextField serverPort = new JTextField("port");
    private JTextField messageField = new JTextField();
    private JPasswordField passwordField = new JPasswordField("password");
    private JCheckBox alwaysTop = new JCheckBox("Always on top");
    private JList<String> userList = new JList<>();
    private String[] users = {"user1", "user2", "user3", "user4", "user5"};
    File file = new File("/Users/roman/IdeaProjects/java_mac/out/production/J2lesson4" +
            "/ru/geekbrains/java2/lesson4/logFile.txt");
    private String newLine = System.getProperty("line.separator");




    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ChatClientGUI();
            }
        });
    }
    public ChatClientGUI(){
        setTitle("Chat client");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        userList.setListData(users);
        JScrollPane scrollUserList = new JScrollPane(userList);
        JScrollPane scrollLog = new JScrollPane(log);
        log.setSize(new Dimension(100, 0));
        setBounds(POSITION_X,POSITION_Y,FRAME_WIDTH,FRAME_HEIGHT);
        JPanel topPanel = new JPanel(new GridLayout(2, 3));
        add(topPanel, BorderLayout.NORTH);
        topPanel.add(serverAdress);
        topPanel.add(serverPort);
        topPanel.add(alwaysTop);
        topPanel.add(userName);
        topPanel.add(passwordField);
        topPanel.add(logIn);
        userList.setPreferredSize(new Dimension(200,700));
        add(scrollUserList, BorderLayout.EAST);
        add(scrollLog, BorderLayout.CENTER);
        scrollLog.setBackground(Color.WHITE);
        JPanel bottomPanel = new JPanel(new GridLayout(1, 2));
        bottomPanel.add(messageField);
        messageField.addKeyListener(this);
        bottomPanel.add(sendMessage);
        add(bottomPanel, BorderLayout.SOUTH);
        log.setEditable(false);
        logIn.addActionListener(this);
        sendMessage.addActionListener(this);
        alwaysTop.addActionListener(this);
        setResizable(false);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
       setAlwaysOnTop(alwaysTop.isSelected());
       if(source == sendMessage){
           String writeLog = userName.getText() + " " + convertTime() +
                   newLine + messageField.getText() + newLine;
           log.append(writeLog);
           try {
               updateLogFile(writeLog);
           } catch (IOException s){
               s.printStackTrace();
           }
           messageField.setText(null);
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

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            String writeLog = userName.getText() + " " + convertTime() +
                    newLine + messageField.getText() + newLine;
            log.append(writeLog);
            try {
                updateLogFile(writeLog);
            } catch (IOException s){
                s.printStackTrace();
            }

            messageField.setText(null);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    private void updateLogFile(String s) throws IOException{
        PrintStream printStream = new PrintStream(new FileOutputStream(file, true));
        printStream.println(s);
        printStream.flush();
        printStream.close();
    }
    private String convertTime(){
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        Date date =  new Date(System.currentTimeMillis());
        return (formatter.format(date));

    }
}
