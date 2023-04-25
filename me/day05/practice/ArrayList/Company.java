package me.day05.practice.ArrayList;

public enum Company {
    SAMSUNG("SAMSUNG Electronics"), LG("LG Electronics"), APPLE("APPLE");

    private String companyName;

    Company(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}