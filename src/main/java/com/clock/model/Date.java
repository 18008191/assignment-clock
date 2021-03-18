package com.clock.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Observable;

public class Date extends Observable {
    String timeString = "";
    int day = 0, month = 0, year = 0;
    public Date(){
        update();}
    public void update() {
        try {

            Calendar cal = Calendar.getInstance();
            day = cal.get(Calendar.DAY_OF_MONTH);
            month = cal.get(Calendar.MONTH);
            year = cal.get(Calendar.YEAR);
            timeString = String.format("%s.%s.%s",day,month+1,year);
            setChanged();
            notifyObservers();
        } catch (Exception e) {
        }
    }

    public String getDate() {
        return timeString;
    }
}
