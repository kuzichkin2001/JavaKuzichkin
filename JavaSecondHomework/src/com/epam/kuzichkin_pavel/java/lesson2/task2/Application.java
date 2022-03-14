package com.epam.kuzichkin_pavel.java.lesson2.task2;

import com.epam.kuzichkin_pavel.java.lesson2.task2.Aerocompany.Aerocompany;
import com.epam.kuzichkin_pavel.java.lesson2.task2.Aerocompany.AerocompanyInterface;
import com.epam.kuzichkin_pavel.java.lesson2.task2.Aeroplane.Aeroplane;
import com.epam.kuzichkin_pavel.java.lesson2.task2.Aeroplane.AeroplaneInterface;
import com.epam.kuzichkin_pavel.java.lesson2.task2.Aeroplane.AeroplaneType;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
            throw new Exception(exception);
        }

        AerocompanyInterface aerocompany = new Aerocompany(
            "Aeroflot",
            40,
            aeroplanes.length,
            null,
            aeroplanes
        );

        SearchParamsInterface searchParams = new SearchParams();

        searchParams.setName("3");
        searchParams.setAeroplaneType(AeroplaneType.MEDIUM);
        searchParams.setAeroparkName("Pupkin");

        AeroplaneInterface[] searchResult = aerocompany.searchAeroplanesWithParams(searchParams);

        for (AeroplaneInterface aeroplane : searchResult) {
            System.out.println(aeroplane);
        }
    }
}
