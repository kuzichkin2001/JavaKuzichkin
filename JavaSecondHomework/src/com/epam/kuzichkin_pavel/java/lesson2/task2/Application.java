package com.epam.kuzichkin_pavel.java.lesson2.task2;

import com.epam.kuzichkin_pavel.java.lesson2.task2.Aerocompany.Aerocompany;
import com.epam.kuzichkin_pavel.java.lesson2.task2.Aerocompany.AerocompanyInterface;
import com.epam.kuzichkin_pavel.java.lesson2.task2.AerocompanyExceptions.FlightException;
import com.epam.kuzichkin_pavel.java.lesson2.task2.Aeroplane.Aeroplane;
import com.epam.kuzichkin_pavel.java.lesson2.task2.Aeroplane.AeroplaneInterface;
import com.epam.kuzichkin_pavel.java.lesson2.task2.Aeroplane.AeroplaneType;
import com.epam.kuzichkin_pavel.java.lesson2.task2.Flight.Flight;
import com.epam.kuzichkin_pavel.java.lesson2.task2.Flight.FlightInterface;

import java.io.*;
import java.time.LocalDate;

public class Application {
    public static void serializeAeroplane() throws IOException {
        Aeroplane aeroplane = new Aeroplane("Simpupkidze", "BlatnoyAeroport");
        String filename = "aeroplane_file.ser";

        FileOutputStream file = null;
        ObjectOutputStream out = null;

        try {
            file = new FileOutputStream(filename);
            out = new ObjectOutputStream(file);

            out.writeObject(aeroplane);

            System.out.println("Aeroplane has been serialized.");
        }
        catch (IOException e) {
            System.out.println("Aeroplane IOException is thrown");
        }
        finally {
            out.close();
            file.close();
        }
    }

    public static void serializeAerocompany() throws IOException {
        Aerocompany aerocompany = new Aerocompany("KalAirlines", 100, 69);
        String filename = "aerocompany_file.ser";

        FileOutputStream file = null;
        ObjectOutputStream out = null;

        try {
            file = new FileOutputStream(filename);
            out = new ObjectOutputStream(file);

            out.writeObject(aerocompany);

            System.out.println("Aerocompany has been serialized.");
        }
        catch (IOException ioException) {
            System.out.println("Aerocompany IOException is thrown");
        }
        finally {
            out.close();
            file.close();
        }
    }

    public static Aeroplane deserializeAeroplane() throws IOException, ClassNotFoundException {
        Aeroplane aeroplane = null;
        String filename = "aeroplane_file.ser";

        FileInputStream file = null;
        ObjectInputStream in = null;

        try {
            file = new FileInputStream(filename);
            in = new ObjectInputStream(file);

            aeroplane = (Aeroplane)in.readObject();

            return aeroplane;
        } catch (IOException | ClassNotFoundException exp) {
            System.out.println(exp.getMessage());

            return null;
        }
        finally {
            in.close();
            file.close();
        }
    }

    public static Aerocompany deserializeAerocompany() throws IOException, ClassNotFoundException {
        Aerocompany aerocompany = null;
        String filename = "aerocompany_file.ser";

        FileInputStream file = null;
        ObjectInputStream in = null;

        try {
            file = new FileInputStream(filename);
            in = new ObjectInputStream(file);

            aerocompany = (Aerocompany)in.readObject();

            return aerocompany;
        } catch (IOException | ClassNotFoundException exp) {
            System.out.println(exp.getMessage());

            return null;
        }
        finally {
            in.close();
            file.close();
        }
    }

    // Авиакомпания
    public static void main(String[] args) throws Exception {
//        AeroplaneInterface[] aeroplanes = new Aeroplane[5];
//
//        try (BufferedReader buffReader = new BufferedReader(new FileReader("C:\\Users\\Павел\\IdeaProjects\\JavaProgrammingKuzichkin\\JavaSecondHomework\\src\\com\\epam\\kuzichkin_pavel\\java\\lesson2\\task2\\input.txt"))) {
//            String line;
//            for (int i = 0; (line = buffReader.readLine()) != null; ++i) {
//                String[] params = line.split("\s");
//                aeroplanes[i] = new Aeroplane(
//                    params[0],
//                    params[1],
//                    AeroplaneType.values()[Integer.parseInt(params[2])],
//                    Integer.parseInt(params[3])
//                );
//            }
//        }
//        catch (IOException exception) {
//            System.out.println(exception.getMessage());
//        }
//
//        AerocompanyInterface aerocompany = new Aerocompany(
//            "Aeroflot",
//            40,
//            aeroplanes.length,
//            null,
//            aeroplanes
//        );
//
//        FlightInterface[] availableFlights = new FlightInterface[3];
//        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Павел\\IdeaProjects\\JavaProgrammingKuzichkin\\JavaSecondHomework\\src\\com\\epam\\kuzichkin_pavel\\java\\lesson2\\task2\\flights.txt"))) {
//            String line;
//            for (int i = 0; (line = reader.readLine()) != null; ++i) {
//                String[] params = line.split("\s");
//
//                availableFlights[i] = new Flight(
//                    LocalDate.now(),
//                    Integer.parseInt(params[0]),
//                    Integer.parseInt(params[1]),
//                    null
//                );
//            }
//        }
//        catch (IOException exception) {
//            System.out.println(exception.getMessage());
//        }
//
//        Flight test1, test2, test3, test4, test5;
//        try {
//            test1 = new Flight(LocalDate.now(), 2, -20);
//        }
//        catch (FlightException e) {
//            System.out.println(e.getMessage());
//        }
//
//        availableFlights[2].setAttachedAeroplane(new Aeroplane(
//            "Vitaz'",
//            "Simpupkidze",
//            AeroplaneType.HEAVY,
//            60
//        ));
//
//        ((Aerocompany)aerocompany).setAvailableFlights(availableFlights);
//
//
//        /* Filtering the Aeroplanes array */
//        SearchParamsInterface searchParams = new SearchParams();
//
//        searchParams.setAeroplaneType(AeroplaneType.MEDIUM);
//        searchParams.setPassengersCapacity(90);
//
//        AeroplaneInterface[] searchResult = aerocompany.searchAeroplanesWithParams(searchParams);
//
//        for (AeroplaneInterface aeroplane : searchResult) {
//            System.out.println(aeroplane);
//        }
//
//
//        /* Sorting the array of all Aeroplanes */
//        for (FlightInterface flight : aerocompany.getAvailableFlights()) {
//            System.out.println(flight);
//        }
//
//
//        System.out.println("\n=================================================\n");
//
//        ((Aerocompany) aerocompany).sortAllFlights();
//
//        for (FlightInterface flight : aerocompany.getAvailableFlights()) {
//            System.out.println(flight);
//        }

        // #5

        serializeAeroplane();
        serializeAerocompany();

        Aeroplane catchedAeroplane = deserializeAeroplane();
        Aerocompany catchedAerocompany = deserializeAerocompany();

        System.out.println(catchedAeroplane);
        System.out.println(catchedAerocompany);
    }
}
