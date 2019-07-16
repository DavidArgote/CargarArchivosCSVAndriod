package com.davidargote.appficherocsv.model;

public class Datos {

    private String name;
    private String state;
    private String stateAbbrv;
    private String fips;

    public Datos() {
    }

    public Datos(String name, String state, String stateAbbrv, String fips) {
        this.name = name;
        this.state = state;
        this.stateAbbrv = stateAbbrv;
        this.fips = fips;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStateAbbrv() {
        return stateAbbrv;
    }

    public void setStateAbbrv(String stateAbbrv) {
        this.stateAbbrv = stateAbbrv;
    }

    public String getFips() {
        return fips;
    }

    public void setFips(String fips) {
        this.fips = fips;
    }

    @Override
    public String toString() {
        return "name = " + name + '\n' + "state = " + state + "state Abbrv = " + stateAbbrv;
    }
}
