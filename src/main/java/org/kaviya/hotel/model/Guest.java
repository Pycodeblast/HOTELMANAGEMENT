package org.kaviya.hotel.model;

public class Guest {
    private String id;
    private String name;
    private String address;
    private String phoneno;

    public Guest(String id,String name,String address, String phoneno){
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneno = phoneno;
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String getPhoneno() {
        return phoneno;
    }
}
