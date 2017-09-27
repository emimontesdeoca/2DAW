/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifp.ForVagosApp;

import java.io.FileReader;
import java.io.FileWriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

import java.util.List;

/**
 *
 * @author emont
 */
public class FilePersistence implements Persistence {

    static List<Hotel> hotelList;

    public void open() {

    }

    public void close() {

    }

    public void save(Hotel h) {
        try {
            FileWriter f = new FileWriter(Hotel.filename, true);
            BufferedWriter bw = new BufferedWriter(f);

            String builder = "";

            builder += h.getNombre() + "-";
            builder += h.getLocalidad() + "-";
            builder += h.getEstrellas() + "-";
            builder += h.getPrecioNoche();

            bw.append(builder);
            bw.newLine();

            bw.close();
        } catch (Exception e) {
        }
    }

    public void delete(Hotel h) {
        List<Hotel> newList = list();

        for (Iterator<Hotel> iter = newList.listIterator(); iter.hasNext();) {
            Hotel searchh = iter.next();
            if (searchh.getNombre().equals(h.getNombre())) {
                iter.remove();
                break;
            }
        }

        try {
            FileWriter f = new FileWriter(Hotel.filename);
            BufferedWriter bw = new BufferedWriter(f);
            for (Hotel nh : newList) {

                String builder = "";

                builder += nh.getNombre() + "-";
                builder += nh.getLocalidad() + "-";
                builder += nh.getEstrellas() + "-";
                builder += nh.getPrecioNoche();

                bw.append(builder);
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
        }

    }

    public List<Hotel> list() {

        hotelList = new ArrayList<Hotel>();
        try {
            FileReader f = new FileReader(Hotel.filename);
            BufferedReader br = new BufferedReader(f);

            String line = br.readLine();

            while (line != null) {
                String[] split = line.split("-");
                String hname = split[0];
                String hloc = split[1];
                Integer hestrellas = Integer.parseInt(split[2]);
                Integer hprecionoche = Integer.parseInt(split[3]);

                //Hotel h = new Hotel(hname, hloc, hestrellas, hprecionoche);
                hotelList.add(new Hotel(hname, hloc, hestrellas, hprecionoche));

                line = br.readLine();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return hotelList;
    }

}
