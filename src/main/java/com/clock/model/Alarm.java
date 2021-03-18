package com.clock.model;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.File;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Observable;

public class Alarm extends Observable implements Runnable  {
    int hour;
    int min;
    boolean isAlarmSet = false;
    Clip clip;
    public Alarm(int h, int m, boolean set){
        this.hour = h ;
        this.min = m;
        this.isAlarmSet = set;
    }

    public void update() {
        while (isAlarmSet) {
            Calendar cal = Calendar.getInstance();
            int hours = cal.get(Calendar.HOUR_OF_DAY);
            int minutes = cal.get(Calendar.MINUTE);
            if (hours == this.hour && minutes == this.min) {
                try {

                    URL resource = Alarm.class.getResource("/alarm/alarm-beep.wav");

                    File sound = new File(String.valueOf(Paths.get(resource.toURI()).toFile()));
                    clip = AudioSystem.getClip();
                    clip.open(AudioSystem.getAudioInputStream(sound));
                    clip.start();
                } catch (Exception exc) {
                    exc.printStackTrace(System.out);
                }
                int result = JOptionPane.showConfirmDialog(null,
                        String.format("Alarm is set to %s:%s !", this.hour, this.min),
                        "Alarm",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE);
                isAlarmSet = result == JOptionPane.OK_CANCEL_OPTION || result == JOptionPane.CLOSED_OPTION;
                if(!isAlarmSet && clip.isActive()){
                    clip.stop();
                }
            }
        }
    }

    public void run() {
        try {
             while (isAlarmSet) {
                 update();

             }
        } catch (Exception e) {
        }
    }
}
