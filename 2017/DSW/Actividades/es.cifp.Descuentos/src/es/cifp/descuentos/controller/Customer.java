package es.cifp.descuentos.controller;

import es.cifp.descuentos.model.FilePersistanceCustomers;
import java.util.List;

/**
 * @author Emiliano Montesdeoca del Puerto
 * @clase Desarrollo entorno servidor
 * @curso 2DAW-B 2017-2018
 */
public class Customer {
    /// Customer vars

    private String name;
    private Boolean member = false;
    private String memberType;
    public List<Customer> customerList;
    
    /// Empty constructor
    public Customer() {
    }

    /// Vars contstructor
    public Customer(String name, Boolean member, String memberType) {
        this.name = name;
        this.member = member;
        this.memberType = memberType;
    }

    /// Getter and setters
    public String getName() {
        return this.name;
    }

    public Boolean isMemeber() {
        return this.member;
    }

    public void setMember(Boolean member) {
        this.member = member;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public String getMemberType() {
        return this.memberType;
    }

    public void saveCustomerOnList(Customer c) {
        customerList.add(c);
    }

    public List<Customer> getListCustomers() {
        return customerList;
    }

    /// Get a customer by name
    public Customer getCustomerByName(String name) {

        customerList = new FilePersistanceCustomers().list();

        for (Customer customer : customerList) {
            if ((customer.getName()).equals(name)) {
                return customer;
            }
        }
        return null;
    }

}
