package com.epam.kuzichkin_pavel.java.lesson2.task2.Aerocompany;

import com.epam.kuzichkin_pavel.java.lesson2.task2.Aeroplane.AeroplaneInterface;
import com.epam.kuzichkin_pavel.java.lesson2.task2.Flight.FlightInterface;
import com.epam.kuzichkin_pavel.java.lesson2.task2.SearchParams;
import com.epam.kuzichkin_pavel.java.lesson2.task2.SearchParamsInterface;

public interface AerocompanyInterface {
    String getName();

    Integer getAeroplanesCapacity();

    Integer getCurrentAeroplanesCount();

    FlightInterface[] getAvailableFlights();

    AeroplaneInterface[] getAvailableAeroplanes();

    AeroplaneInterface[] searchAeroplanesWithParams(SearchParamsInterface searchParams);
}
