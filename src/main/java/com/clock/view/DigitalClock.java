package com.clock.view;

import com.clock.model.DigitalClockModel;

import javax.swing.*;
import java.awt.*;
public class DigitalClock extends JPanel implements Runnable {
    JFrame f;
    DigitalClockModel model;
    JLabel label;
    Thread t = null;
   public DigitalClock(JFrame frame, DigitalClockModel model) {

       this.model = model;
       this.f = frame;
        label = new JLabel();
       t = new Thread(model);
       t.start();
       this.setDoubleBuffered(true);
       label.setFont(new Font("Serif", Font.PLAIN, 30));
        label.setBounds(150, 150, 200, 100);

        f.add(label);
        f.setLayout(null);
        f.setVisible(true);
    }

    public void run() {
        try {
            while (true) {
                label.setText(model.getTime());
                t.sleep(1000);  // interval given in milliseconds
            }
        } catch (Exception e) {
        }
    }

}