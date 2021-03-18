package com.clock.view;

import com.clock.model.Date;

import javax.swing.*;
import java.awt.*;

public class DatePanel extends JPanel implements Runnable {
    JFrame f;
    Date model;
    JLabel label;

    public DatePanel(JFrame frame, Date model) {

        this.model = model;
        this.f = frame;
        label = new JLabel();
        label.setFont(new Font("Serif", Font.PLAIN, 30));
        label.setBounds(150, 150, 200, 100);
        this.setDoubleBuffered(true);
        f.add(label);
        f.setLayout(null);
        f.setVisible(true);
    }

    public void run() {
        try {
            while (true) {
                label.setText(model.getDate());
            }
        } catch (Exception e) {
        }
    }
}
