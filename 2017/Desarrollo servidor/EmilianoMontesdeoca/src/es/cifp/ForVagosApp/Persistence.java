/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifp.ForVagosApp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

public interface Persistence {

    public void open();

    public void close();

    public void save(Hotel l);

    public void delete(Hotel l);

    public List<Hotel> list();

}
