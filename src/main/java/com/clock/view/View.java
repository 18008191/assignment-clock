package com.clock.view;

import com.clock.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observer;
import java.util.Observable;

public class View implements Observer {

    ClockPanel analogPanel;
    DigitalClock digitalClock;
    AlarmPanel alarm;

    public int menuOption = 0;
    final JFrame frame = new JFrame();

    public View(Model model) {
        analogPanel = new ClockPanel(model);
        final JMenuBar menuBar = new JMenuBar();
        menuOption = 1;

        JButton analog = new JButton("Analog");
        analog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuOption = 1;
            }});
        JButton digital = new JButton("Digital");
        digital.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuOption = 2 ;

            }
        });


        JButton dateButton = new JButton("Date");
        dateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuOption = 3;
            }});

        alarm = new AlarmPanel(frame);
        menuBar.add(new About().getAbout());
        menuBar.add(analog);
        menuBar.add(digital);
        menuBar.add(dateButton);
        menuBar.add(alarm);
        frame.setJMenuBar(menuBar);
        frame.setTitle("Java com.clock.Clock");
        frame.setPreferredSize(new Dimension(400,400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void update(Observable o, Object arg) {
        switch (menuOption) {
            case 1: {
                JPanel contentPane = (JPanel) frame.getContentPane();

                contentPane.removeAll();
                contentPane.revalidate();

                frame.add(analogPanel);
                analogPanel.repaint();
                break;
            }
            case 2: {
                frame.getContentPane().removeAll();
                frame.repaint();

                digitalClock = new DigitalClock(frame, new DigitalClockModel());
                Thread thread = new Thread(digitalClock);
                thread.start();

                frame.add(digitalClock);
                digitalClock.repaint();
                menuOption = 0;
                break;
            }
            case 3: {
                frame.getContentPane().removeAll();
                frame.repaint();
                DatePanel date = new DatePanel(frame, new Date());
                Thread thread = new Thread(date);
                thread.start();

                frame.add(date);
                date.repaint();
                menuOption = 0;
            }

        }
    }
}
