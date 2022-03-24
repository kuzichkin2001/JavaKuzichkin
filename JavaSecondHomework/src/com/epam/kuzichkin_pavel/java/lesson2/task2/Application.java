package com.epam.kuzichkin_pavel.java.lesson2.task2;

import com.epam.kuzichkin_pavel.java.lesson2.task2.Aerocompany.Aerocompany;
import com.epam.kuzichkin_pavel.java.lesson2.task2.Aerocompany.AerocompanyInterface;
import com.epam.kuzichkin_pavel.java.lesson2.task2.Aeroplane.Aeroplane;
import com.epam.kuzichkin_pavel.java.lesson2.task2.Aeroplane.AeroplaneInterface;
import com.epam.kuzichkin_pavel.java.lesson2.task2.Aeroplane.AeroplaneType;
import com.epam.kuzichkin_pavel.java.lesson2.task2.Flight.Flight;
import com.epam.kuzichkin_pavel.java.lesson2.task2.Flight.FlightInterface;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

public class Application {

    // Авиакомпания
    public static void main(String[] args) throws Exception {
        AeroplaneInterface[] aeroplanes = new Aeroplane[5];

        try (BufferedReader buffReader = new BufferedReader(new FileReader("C:\\Users\\Павел\\IdeaProjects\\JavaProgrammingKuzichkin\\JavaSecondHomework\\src\\com\\epam\\kuzichkin_pavel\\java\\lesson2\\task2\\input.txt"))) {
            String line;
            for (int i = 0; (line = buffReader.readLine()) != null; ++i) {
                String[] params = line.split("\s");
                aeroplanes[i] = new Aeroplane(
                    params[0],
                    params[1],
                    AeroplaneType.values()[Integer.parseInt(params[2])],
                    Integer.parseInt(params[3])
                );
            }
        }
        catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

        AerocompanyInterface aerocompany = new Aerocompany(
            "Aeroflot",
            40,
            aeroplanes.length,
            null,
            aeroplanes
        );

        FlightInterface[] availableFlights = new FlightInterface[3];
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Павел\\IdeaProjects\\JavaProgrammingKuzichkin\\JavaSecondHomework\\src\\com\\epam\\kuzichkin_pavel\\java\\lesson2\\task2\\flights.txt"))) {
            String line;
            for (int i = 0; (line = reader.readLine()) != null; ++i) {
                String[] params = line.split("\s");

                availableFlights[i] = new Flight(
                    LocalDate.now(),
                    Integer.parseInt(params[0]),
                    Integer.parseInt(params[1]),
                    null
                );
            }
        }
        catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

        availableFlights[2].setAttachedAeroplane(new Aeroplane(
            "Vitaz'",
            "Simpupkidze",
            AeroplaneType.HEAVY,
            60
        ));

        ((Aerocompany)aerocompany).setAvailableFlights(availableFlights);


        /* Filtering the Aeroplanes array */
        SearchParamsInterface searchParams = new SearchParams();

        searchParams.setAeroplaneType(AeroplaneType.MEDIUM);
        searchParams.setPassengersCapacity(90);

        AeroplaneInterface[] searchResult = aerocompany.searchAeroplanesWithParams(searchParams);

        for (AeroplaneInterface aeroplane : searchResult) {
            System.out.println(aeroplane);
        }


        /* Sorting the array of all Aeroplanes */
        for (FlightInterface flight : aerocompany.getAvailableFlights()) {
            System.out.println(flight);
        }


        System.out.println("\n=================================================\n");

        ((Aerocompany) aerocompany).sortAllFlights();

        for (FlightInterface flight : aerocompany.getAvailableFlights()) {
            System.out.println(flight);
        }
    }
}
