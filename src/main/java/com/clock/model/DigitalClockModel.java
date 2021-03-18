package com.clock.model;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Observable;

public class DigitalClockModel  extends Observable implements Runnable {
    String timeString = "";
    int hours = 0, minutes = 0, seconds = 0;
    public DigitalClockModel(){
    update();}
    public void update() {
        try {
                Calendar cal = Calendar.getInstance();
                hours = cal.get(Calendar.HOUR_OF_DAY);
                if (hours > 12) hours -= 12;
                minutes = cal.get(Calendar.MINUTE);
                seconds = cal.get(Calendar.SECOND);

                SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss");
                Date date = cal.getTime();
                timeString = formatter.format(date);
               setChanged();
               notifyObservers();
        } catch (Exception e) {
        }
    }

    public String getTime() {
        return timeString;
    }

    @Override
    public void run() {
        try{
            while (true){
                update();
            }
        }catch (Exception e){}
    }
}
