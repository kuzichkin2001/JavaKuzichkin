package com.epam.kuzichkin_pavel.java.lesson2.task2.Flight;

import com.epam.kuzichkin_pavel.java.lesson2.task2.Aeroplane.Aeroplane;
import com.epam.kuzichkin_pavel.java.lesson2.task2.Aeroplane.AeroplaneInterface;

import java.time.LocalDate;

public interface FlightInterface {
    LocalDate getStart();

    Integer getFlightTime();

    Integer getFlightDistance();

    AeroplaneInterface getAttachedAeroplane();

    void setAttachedAeroplane(Aeroplane aeroplane);
}
