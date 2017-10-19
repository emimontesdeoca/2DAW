/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifp.descuentos.model;

import es.cifp.descuentos.controller.Customer;
import es.cifp.descuentos.controller.Items;
import es.cifp.descuentos.controller.Visit;
import es.cifp.descuentos.descuentosApp;
import static es.cifp.descuentos.view.Utils.roundDouble;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Date;

/**
 *
 * @author emont
 */
public class FilePersistanceReceipt {

    /// Method to save receipt
    public String save(Visit v, Date paymentDate) throws Exception {

        Customer c = new Customer().getCustomerByName(v.getName());
        String loginDate = v.getDate();
        String _paymentDate = paymentDate.toString();

        Double totalProduct = roundDouble(v.getProductExpense());
        Double totalService = roundDouble(v.getServiceExpense());
        Double totalWithoutDiscount = roundDouble(v.getTotalExpenseWithoutDiscount());
        Double totalWithDiscount = roundDouble(v.getTotalExpense());

        String paymentReformatted = paymentDate.toString().replace(':', '-');

        String pathtoreceipt = descuentosApp.tempf + "\\Receipt - " + c.getName() + " - " + paymentReformatted + ".txt";

        /// Instanciar objetos
        FileWriter f = new FileWriter(pathtoreceipt, true);
        BufferedWriter bw = new BufferedWriter(f);

        /// Guardar la linea en el fichero
        bw.append("----------------------------------------");
        bw.newLine();
        bw.append("Receipt from AMAZON.EMI");
        bw.newLine();
        bw.append("----------------------------------------");
        bw.newLine();
        bw.newLine();
        bw.append("----------------------------------------");
        bw.newLine();
        bw.append("Customer information");
        bw.newLine();
        bw.append("----------------------------------------");
        bw.newLine();
        bw.newLine();
        bw.append("Customer name: " + c.getName());
        bw.newLine();
        bw.append("Customer account type: " + c.getMemberType());
        bw.newLine();
        bw.append("Visit time: " + v.getDate());
        bw.newLine();
        bw.newLine();
        bw.append("----------------------------------------");
        bw.newLine();
        bw.append("Cart");
        bw.newLine();
        bw.append("----------------------------------------");
        bw.newLine();
        bw.newLine();
        bw.append("Products:" + totalProduct.toString() + "$");
        bw.newLine();
        bw.append("Services:" + totalService.toString() + "$");
        bw.newLine();
        bw.append("Total without discount:" + totalWithoutDiscount.toString() + "$");
        bw.newLine();
        bw.append("Total with discount:" + totalWithDiscount.toString() + "$");
        bw.newLine();
        bw.newLine();
        bw.append("----------------------------------------");
        bw.newLine();
        bw.append("Payment realized at: " + paymentDate);
        bw.newLine();
        bw.append("----------------------------------------");
        bw.newLine();
        bw.append("Thanks for using our shop!");
        bw.newLine();
        bw.append("----------------------------------------");
        bw.newLine();

        /// Cerrar lector
        bw.close();
        f.close();

        return pathtoreceipt;

    }
}
