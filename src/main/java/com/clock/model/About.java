package com.clock.model;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

public class About extends Observable {
    JButton about;
    public About(){
        about = new JButton("About");
        update();
    }

    public JButton getAbout(){
        return about;
    }

    public void update() {
        final JFrame frame = new JFrame();
        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame,"This is a clock written in Java. It has digital and analog version. Alarm and date is available.");
            }
        });
    }
}
