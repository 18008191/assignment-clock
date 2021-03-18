package com.clock.view;

import com.clock.model.Alarm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlarmPanel extends JButton{
    JFrame f;
    int hour;
    int min;
    boolean isAlarmSet = false;

    public AlarmPanel(JFrame f) {
        this.setText("Alarm");
        addListener();
        this.f = f;
    }

    JTextField hourTxt;
    JTextField minTxt;

    public void addListener() {
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel myPanel = new JPanel();
                hourTxt = new JTextField(2);
                minTxt = new JTextField(2);
                JLabel h = new JLabel("hour");
                JLabel m = new JLabel("minutes");
                myPanel.add(h);
                myPanel.add(hourTxt);
                myPanel.add(m);
                myPanel.add(minTxt);
                int result =  JOptionPane.showConfirmDialog(null, myPanel);
                isAlarmSet = result == JOptionPane.YES_OPTION;
                 int mi= minTxt.getText() != "" ? Integer.parseInt(minTxt.getText()) : min;
                 int hh= hourTxt.getText() != "" ? Integer.parseInt(hourTxt.getText()) : hour;
                if(isAlarmSet){
                    Thread alarmT = new Thread(new Alarm(hh, mi, true));
                    alarmT.start();
                }

            }
        });
    }
}