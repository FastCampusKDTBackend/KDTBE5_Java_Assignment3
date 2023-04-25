package me.day05.practice.NonArrayList;

public enum Company {
    SAMSUNG("SAMSUNG"), LG("LG"), APPLE("APPLE");

    String companyName = null;

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