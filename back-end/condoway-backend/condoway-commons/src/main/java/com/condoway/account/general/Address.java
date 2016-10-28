package com.condoway.account.general;

/**
 * Created by Carlos on 10/12/2016.
 */
public class Address {
    private String street;
    private String number;

    public Address(String street, String number) {
        this.street = street;
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }
}
