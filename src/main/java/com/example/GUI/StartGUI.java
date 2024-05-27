package com.example.GUI;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StartGUI extends JFrame{
    public JPanel mainPanel;
    private JPanel titlePanel;
    private JButton loginGuestButton;
    private JButton loginMemberButton;
    private JLabel logo;
    private JLabel filkomTravel;
    private JLabel slogan;
    private JLabel adminLogin;



    public StartGUI() {
        loginGuestButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        loginMemberButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openLoginPanel();
            }
        });
        adminLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openLoginPanel();
            }
        });

        adminLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
            }
        });
    }
    private void openLoginPanel(){
        loginPanel loginpanel = new loginPanel();
        loginpanel.setVisible(true);
    }

    public static void main(String[] args) {
        StartGUI start = new StartGUI();
        start.setContentPane(start.mainPanel);
        start.setTitle("Filkom Travel");
        start.setSize(1000, 800);
        start.setVisible(true);
        start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}



