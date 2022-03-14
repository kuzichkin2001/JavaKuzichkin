package com.epam.kuzichkin_pavel.java.lesson2.task2.Aeroplane;

public interface AeroplaneInterface {
    String getName();

    String getAeroparkName();

    AeroplaneType getAeroplaneType();

    Integer getPassengersCapacity();

    AeroplaneInterface copy();
}
