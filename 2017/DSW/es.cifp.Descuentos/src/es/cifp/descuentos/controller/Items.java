package es.cifp.descuentos.controller;

import es.cifp.descuentos.model.FilePersistanceItems;
import java.util.Iterator;
import java.util.List;

/**
 * @author Emiliano Montesdeoca del Puerto
 * @asignatura: Desarrollo de entorno servidor
 * @clase: 2DAW-B
 */
public class Items {

    private String name;
    private Double value;

    public static List<Items> itemList;

    public Items() {
    }

    public Items(String name, Double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public List<Items> getAllItems() {
        return new FilePersistanceItems().list();
    }

    public Items getItemByName(String name) {
        Items i = new Items();
        itemList = new FilePersistanceItems().list();
        for (Items items : itemList) {
            String a = items.getName();
            if (a.equals(name)) {
                return items;
            }
        }

        return i;
    }

}
