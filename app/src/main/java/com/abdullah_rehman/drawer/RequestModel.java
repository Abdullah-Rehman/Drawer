package com.abdullah_rehman.drawer;

/**
 * Created by Abdullah_Rehman on 28-Sep-17.
 */

public class RequestModel {
    String bloodGroup, date, city;

    public RequestModel(){
    }

    public RequestModel(String bloodGroup, String date, String city) {
        this.bloodGroup = bloodGroup;
        this.date = date;
        this.city = city;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
