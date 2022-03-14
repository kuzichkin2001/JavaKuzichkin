package com.epam.kuzichkin_pavel.java.lesson2.task2;

import com.epam.kuzichkin_pavel.java.lesson2.task2.Aeroplane.AeroplaneType;

public class SearchParams implements SearchParamsInterface {
    private String name;
    private String aeroparkName;
    private Integer passengersCapacity;
    private AeroplaneType aeroplaneType;

    public SearchParams() {
        name = "\n";
        aeroparkName = "\n";
        passengersCapacity = 0;
        aeroplaneType = AeroplaneType.DEFAULT;
    }

    public SearchParams(String name) {
        this.name = name;
        aeroparkName = "\n";
        passengersCapacity = 0;
        aeroplaneType = AeroplaneType.DEFAULT;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getAeroparkName() {
        return this.aeroparkName;
    }

    @Override
    public Integer getPassengersCapacity() {
        return this.passengersCapacity;
    }

    @Override
    public AeroplaneType getAeroplaneType() {
        return this.aeroplaneType;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setAeroparkName(String aeroparkName) {
        this.aeroparkName = aeroparkName;
    }

    @Override
    public void setPassengersCapacity(Integer passengersCapacity) {
        this.passengersCapacity = passengersCapacity;
    }

    @Override
    public void setAeroplaneType(AeroplaneType aeroplaneType) {
        this.aeroplaneType = aeroplaneType;
    }

    @Override
    public String toString() {
        return "SearchParams{" +
                "name='" + name + '\'' +
                ", aeroparkName='" + aeroparkName + '\'' +
                ", passengersCapacity=" + passengersCapacity +
                '}';
    }

    public void clear() {
        this.name = "\n";
        this.passengersCapacity = 0;
        this.aeroparkName = "\n";
        this.aeroplaneType = AeroplaneType.DEFAULT;
    }
}
