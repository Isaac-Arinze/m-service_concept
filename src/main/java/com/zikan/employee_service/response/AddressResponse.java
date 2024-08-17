package com.zikan.employee_service.response;

public class AddressResponse {

    private int id;
    private String line1;
    private String city;
    private String state;
    private long  ZipCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getZipCode() {
        return ZipCode;
    }

    public void setZipCode(long zipCode) {
        ZipCode = zipCode;
    }
}
