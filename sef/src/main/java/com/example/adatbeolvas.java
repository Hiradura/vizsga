package com.example;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class adatbeolvas {

    public List<adatbetolt> readFile(String filename) {
        List<adatbetolt> lista = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(filename), StandardCharsets.UTF_8)) {
            if (scanner.hasNextLine()) scanner.nextLine(); // fejléc átugrása

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] fields = line.split(";");

                if (fields.length >= 6) {
                    adatbetolt adat = new adatbetolt();
                    adat.setId(Integer.parseInt(fields[0].trim()));
                    adat.setChefname(fields[1].trim());
                    adat.setDate(LocalDate.parse(fields[2].trim()));
                    adat.setCategory(fields[3].trim());
                    adat.setPrice(Integer.parseInt(fields[4].trim()));
                    adat.setComment(fields[5].trim());

                    lista.add(adat);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}
