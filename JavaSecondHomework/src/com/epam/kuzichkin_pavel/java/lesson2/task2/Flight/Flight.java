package com.epam.kuzichkin_pavel.java.lesson2.task2.Flight;

import com.epam.kuzichkin_pavel.java.lesson2.task2.AerocompanyExceptions.FlightException;
import com.epam.kuzichkin_pavel.java.lesson2.task2.Aeroplane.Aeroplane;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Flight implements FlightInterface {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
    private LocalDate start;
    private Integer flightTime;
    private Integer flightDistance;
    private Aeroplane attachedAeroplane;

    public Flight() {
        start = LocalDate.now();
        flightTime = 0;
        flightDistance = 0;
        attachedAeroplane = new Aeroplane();
    }

    public Flight(LocalDate flightStart) {
        start = flightStart;
        flightTime = 0;
        flightDistance = 0;
        attachedAeroplane = new Aeroplane();
    }

    public Flight(LocalDate flightStart, Integer flightTime) {
        start = flightStart;
        this.flightTime = flightTime;
        flightDistance = 0;
        attachedAeroplane = new Aeroplane();
    }

    public Flight(LocalDate flightStart, Integer flightTime, Integer flightDistance) throws FlightException {
        start = flightStart;
        if (flightTime < 0 || flightDistance < 0) {
            throw new FlightException("Negative number flight time or flight distance is impossible");
        }
        else {
            this.flightTime = flightTime;
            this.flightDistance = flightDistance;
        }
        attachedAeroplane = new Aeroplane();
    }

    public Flight(LocalDate flightStart, Integer flightTime, Integer flightDistance, Aeroplane attachedAeroplane) {
        start = flightStart;
        this.flightTime = flightTime;
        this.flightDistance = flightDistance;
        this.attachedAeroplane = attachedAeroplane;
    }

    @Override
    public LocalDate getStart() {
        return this.start;
    }

    private void setStart(LocalDate start) {
        this.start = start;
    }

    @Override
    public Integer getFlightTime() {
        return this.flightTime;
    }

    private void setFlightTime(Integer flightTime) {
        this.flightTime = flightTime;
    }

    @Override
    public Integer getFlightDistance() {
        return this.flightDistance;
    }

    private void setFlightDistance(Integer flightDistance) {
        this.flightDistance = flightDistance;
    }

    @Override
    public Aeroplane getAttachedAeroplane() {
        return null;
    }

    public void setAttachedAeroplane(Aeroplane aeroplane) {
        attachedAeroplane = aeroplane;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "start=" + start +
                ", flightTime=" + flightTime +
                ", flightDistance=" + flightDistance +
                ", attachedAeroplane=" + attachedAeroplane +
                '}';
    }
}
