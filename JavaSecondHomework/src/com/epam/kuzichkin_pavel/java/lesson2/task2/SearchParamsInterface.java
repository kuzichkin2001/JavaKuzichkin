package com.epam.kuzichkin_pavel.java.lesson2.task2;

import com.epam.kuzichkin_pavel.java.lesson2.task2.Aeroplane.AeroplaneType;

public interface SearchParamsInterface {
    String getName();

    String getAeroparkName();

    Integer getPassengersCapacity();

    AeroplaneType getAeroplaneType();

    void setName(String name);

    void setAeroparkName(String aeroparkName);

    void setPassengersCapacity(Integer passengersCapacity);

    void setAeroplaneType(AeroplaneType aeroplaneType);
}
