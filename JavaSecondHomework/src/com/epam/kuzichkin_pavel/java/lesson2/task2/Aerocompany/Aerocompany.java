package com.epam.kuzichkin_pavel.java.lesson2.task2.Aerocompany;

import com.epam.kuzichkin_pavel.java.lesson2.task2.Aeroplane.Aeroplane;
import com.epam.kuzichkin_pavel.java.lesson2.task2.Aeroplane.AeroplaneInterface;
import com.epam.kuzichkin_pavel.java.lesson2.task2.Flight.Flight;
import com.epam.kuzichkin_pavel.java.lesson2.task2.Flight.FlightInterface;
import com.epam.kuzichkin_pavel.java.lesson2.task2.SearchParams;
import com.epam.kuzichkin_pavel.java.lesson2.task2.SearchParamsInterface;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Aerocompany implements AerocompanyInterface, Serializable {
    private String name;
    private Integer aeroplanesCapacity;
    private Integer currentAeroplanesCount;
    private FlightInterface[] availableFlights;
    private AeroplaneInterface[] availableAeroplanes;

    public Aerocompany() {
        name = "";
        aeroplanesCapacity = 0;
        currentAeroplanesCount = 0;
        availableFlights = new Flight[0];
        availableAeroplanes = new Aeroplane[0];
    }

    public Aerocompany(String name, Integer aeroplanesCapacity) {
        this.name = name;
        this.aeroplanesCapacity = aeroplanesCapacity;
        currentAeroplanesCount = 0;
        availableFlights = new Flight[0];
        availableAeroplanes = new Aeroplane[0];
    }

    public Aerocompany(String name, Integer aeroplanesCapacity, Integer currentAeroplanesCount) {
        this.name = name;
        this.aeroplanesCapacity = aeroplanesCapacity;
        this.currentAeroplanesCount = currentAeroplanesCount;
        availableFlights = new Flight[currentAeroplanesCount];
        availableAeroplanes = new Aeroplane[currentAeroplanesCount];
    }

    public Aerocompany(
            String name,
            Integer aeroplanesCapacity,
            Integer currentAeroplanesCount,
            FlightInterface[] availableFlights
    ) {
        this.name = name;
        this.aeroplanesCapacity = aeroplanesCapacity;
        this.currentAeroplanesCount = currentAeroplanesCount;
        this.availableFlights = availableFlights;
        availableAeroplanes = new Aeroplane[currentAeroplanesCount];
    }

    public Aerocompany(
            String name,
            Integer aeroplanesCapacity,
            Integer currentAeroplanesCount,
            FlightInterface[] availableFlights,
            AeroplaneInterface[] availableAeroplanes
    ) {
        this.name = name;
        this.aeroplanesCapacity = aeroplanesCapacity;
        this.currentAeroplanesCount = currentAeroplanesCount;
        this.availableFlights = availableFlights;
        this.availableAeroplanes = availableAeroplanes;
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer getAeroplanesCapacity() {
        return this.aeroplanesCapacity;
    }

    private void setAeroplanesCapacity(Integer aeroplanesCapacity) {
        this.aeroplanesCapacity = aeroplanesCapacity;
    }

    @Override
    public Integer getCurrentAeroplanesCount() {
        return this.currentAeroplanesCount;
    }

    private void setCurrentAeroplanesCount(Integer currentAeroplanesCount) {
        this.currentAeroplanesCount = currentAeroplanesCount;
    }

    @Override
    public FlightInterface[] getAvailableFlights() {
        return this.availableFlights;
    }

    public void setAvailableFlights(FlightInterface[] availableFlights) {
        this.availableFlights = availableFlights;
    }

    @Override
    public AeroplaneInterface[] getAvailableAeroplanes() {
        return this.availableAeroplanes;
    }

    private void setAvailableAeroplanes(Aeroplane[] availableAeroplanes) {
        this.availableAeroplanes = availableAeroplanes;
    }

    /*
    * Method supposed to sort array of all Flights.
    * Under the hood it uses insertionSort.
    *
    * @return {void}
    * */
    public void sortAllFlights() {
        int length = this.availableFlights.length;

        for (int i = 1; i < length; ++i) {
            int j = i - 1;
            Flight arg = (Flight)this.availableFlights[i];

            while (j >= 0 && this.availableFlights[j].getFlightDistance() > arg.getFlightDistance()) {
                this.availableFlights[j + 1] = this.availableFlights[j];
                j--;
            }

            this.availableFlights[j + 1] = arg;
        }
    }

    private Boolean filterAirplanes(AeroplaneInterface aeroplane, SearchParamsInterface searchParams) {
        return aeroplane.getAeroplaneType().equals(searchParams.getAeroplaneType()) &&
                aeroplane.getPassengersCapacity() < searchParams.getPassengersCapacity();
    }

    @Override
    public AeroplaneInterface[] searchAeroplanesWithParams(SearchParamsInterface searchParams) {
        List<AeroplaneInterface> result = Arrays.stream(this.availableAeroplanes)
                     .filter(aeroplane -> filterAirplanes(aeroplane, searchParams))
                     .toList();

        return result.toArray(new AeroplaneInterface[result.size()]);
    }

    @Override
    public String toString() {
        return "Aerocompany{" +
                "name='" + name + '\'' +
                ", aeroplanesCapacity=" + aeroplanesCapacity +
                ", currentAeroplanesCount=" + currentAeroplanesCount +
                '}';
    }
}
