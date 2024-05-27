package com.example.GUI;

import javax.swing.*;

public class loginPanel extends JFrame {
    private JPanel loginPanel;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JPanel logoBox;
    private JPanel loginBox;
    private JPanel usernameBox;
    private JPanel passwordBox;


    public static void main(String[] args) {
        loginPanel login = new loginPanel();
        login.setContentPane(login.loginPanel);
        login.setTitle("Filkom Travel");
        login.setSize(1000, 800);
        login.setVisible(true);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
