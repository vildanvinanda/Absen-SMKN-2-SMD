package com.example.belajarretrofit.Model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Event
{
    public static ArrayList<Event> eventsList = new ArrayList<>();

    public static ArrayList<Event> eventsForDate(LocalDate date)
    {
        ArrayList<Event> events = new ArrayList<>();

        for(Event event : eventsList)
        {
            if(event.getDate().equals(date))
                events.add(event);
        }

        return events;
    }


    private String kegiatan, jam, tempat, hari;
    private LocalDate date;
    private LocalTime time;

    public Event(String kegiatan, String jam, String tempat, String hari, LocalDate date, LocalTime time) {
        this.kegiatan = kegiatan;
        this.jam = jam;
        this.tempat = tempat;
        this.hari = hari;
        this.date = date;
        this.time = time;
    }

    public static ArrayList<Event> getEventsList() {
        return eventsList;
    }

    public static void setEventsList(ArrayList<Event> eventsList) {
        Event.eventsList = eventsList;
    }

    public String getKegiatan() {
        return kegiatan;
    }

    public void setKegiatan(String kegiatan) {
        this.kegiatan = kegiatan;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public String getTempat() {
        return tempat;
    }

    public void setTempat(String tempat) {
        this.tempat = tempat;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }


    public LocalDate getDate()
    {
        return date;
    }

    public void setDate(LocalDate date)
    {
        this.date = date;
    }

    public LocalTime getTime()
    {
        return time;
    }

    public void setTime(LocalTime time)
    {
        this.time = time;
    }
}
