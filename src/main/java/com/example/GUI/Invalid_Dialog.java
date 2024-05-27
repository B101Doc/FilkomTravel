package com.example.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Invalid_Dialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JPanel invalidText;
    private JLabel invText;

    public Invalid_Dialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    public static void main(String[] args) {
        Invalid_Dialog dialog = new Invalid_Dialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
