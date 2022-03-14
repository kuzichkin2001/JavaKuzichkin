package com.epam.kuzichkin_pavel.java.lesson2.task2.Aeroplane;

public class Aeroplane implements AeroplaneInterface {
    private String name;
    private String aeroparkName;
    private AeroplaneType aeroplaneType;
    private Integer passengersCapacity;

    public Aeroplane() {
        name = "";
        aeroparkName = "";
        aeroplaneType = AeroplaneType.LIGHT;
        passengersCapacity = 50;
    }

    public Aeroplane(String name) {
        this.name = name;
        aeroparkName = "";
        aeroplaneType = AeroplaneType.LIGHT;
        passengersCapacity = 50;
    }

    public Aeroplane(String name, String aeroparkName) {
        this.name = name;
        this.aeroparkName = aeroparkName;
        aeroplaneType = AeroplaneType.LIGHT;
        passengersCapacity = 50;
    }

    public Aeroplane(String name, String aeroparkName, AeroplaneType aeroplaneType) {
        this.name = name;
        this.aeroparkName = aeroparkName;
        this.aeroplaneType = aeroplaneType;
        passengersCapacity = 50;
    }

    public Aeroplane(String name, String aeroparkName, AeroplaneType aeroplaneType, Integer passengersCapacity) {
        this.name = name;
        this.aeroparkName = aeroparkName;
        this.aeroplaneType = aeroplaneType;
        this.passengersCapacity = passengersCapacity;
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAeroparkName() {
        return this.aeroparkName;
    }

    private void setAeroparkName(String aeroparkName) {
        this.aeroparkName = aeroparkName;
    }

    @Override
    public AeroplaneType getAeroplaneType() {
        return this.aeroplaneType;
    }

    private void setAeroplaneType(AeroplaneType aeroplaneType) {
        this.aeroplaneType = aeroplaneType;
    }

    @Override
    public Integer getPassengersCapacity() {
        return this.passengersCapacity;
    }

    private void setPassengersCapacity(Integer passengersCapacity) {
        this.passengersCapacity = passengersCapacity;
    }

    @Override
    public Aeroplane copy() {
        return new Aeroplane(this.name, this.aeroparkName, this.aeroplaneType);
    }

    @Override
    public String toString() {
        return "Aeroplane{" +
                "name='" + name + '\'' +
                ", aeroparkName='" + aeroparkName + '\'' +
                ", aeroplaneType=" + aeroplaneType +
                ", passengersCapacity=" + passengersCapacity +
                '}';
    }
}
