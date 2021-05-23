package com.example.covictory.api;

import com.google.gson.annotations.SerializedName;

public class CountryData {
    @SerializedName("updated")
    private String updated;
    private String country;
    private String cases;
    private String todayCases;
    private String todayDeaths;
    private String deaths;
    private String recovered;
    private String todayRecovered;
    private String tests;
    private String active;


    public CountryData(String updated, String country, String cases, String todayCases, String todayDeaths, String deaths, String recovered, String todayRecovered, String tests, String active) {
        this.updated = updated;
        this.country = country;
        this.cases = cases;
        this.todayCases = todayCases;
        this.todayDeaths = todayDeaths;
        this.deaths = deaths;
        this.recovered = recovered;
        this.todayRecovered = todayRecovered;
        this.tests = tests;
        this.active = active;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCases() {
        return cases;
    }

    public void setCases(String cases) {
        this.cases = cases;
    }

    public String getTodayCases() {
        return todayCases;
    }

    public void setTodayCases(String todayCases) {
        this.todayCases = todayCases;
    }

    public String getTodayDeaths() {
        return todayDeaths;
    }

    public void setTodayDeaths(String todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getTodayRecovered() {
        return todayRecovered;
    }

    public void setTodayRecovered(String todayRecovered) {
        this.todayRecovered = todayRecovered;
    }

    public String getTests() {
        return tests;
    }

    public void setTests(String tests) {
        this.tests = tests;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}
