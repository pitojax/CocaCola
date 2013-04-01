/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.command;

import java.util.Date;

/**
 *
 * @author KSC
 */
public class Dcinformation {

    private String name;
    private String location;
    private String email;
    private int dcowner;
    private int telephone;
    private String start_date_of_contract;
    private String expiry_date_of_contract;

    public int getDcowner() {
        return dcowner;
    }

    public void setDcowner(int dcowner) {
        this.dcowner = dcowner;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getExpiry_date_of_contract() {
        return expiry_date_of_contract;
    }

    public void setExpiry_date_of_contract(String expiry_date_of_contract) {
        this.expiry_date_of_contract = expiry_date_of_contract;
    }

    public String getStart_date_of_contract() {
        return start_date_of_contract;
    }

    public void setStart_date_of_contract(String start_date_of_contract) {
        this.start_date_of_contract = start_date_of_contract;
    }

   
    
}
