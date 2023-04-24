package me.day05.practice.NonArrayList;

import java.util.Arrays;
import java.util.Objects;

public class Electronics {
    private static Electronics electronicsInstance;

    public static Electronics getInstance() {
        if(electronicsInstance == null) {
            electronicsInstance = new Electronics();
        }
        return electronicsInstance;
    }

    private Electronic[] electronicsList;
    private int index = 0;
    //기본 10개로 설정
    private static int listSize = 10;

    private Electronics() {
        electronicsList = new Electronic[listSize];
    }

    public Electronic[] getElectronicsList() {
        return electronicsList;
    }

    public void setElectronicsList(Electronic[] electronicsList) {
        this.electronicsList = electronicsList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Electronics that = (Electronics) o;
        return Arrays.equals(electronicsList, that.electronicsList);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(electronicsList);
    }

    @Override
    public String toString() {
        return "Electronics{" +
                "electronicsList=" + Arrays.toString(electronicsList) +
                ", index=" + index +
                '}';
    }

    public void addDevice(Electronic electronic) {
        electronicsList[index] = electronic;
        index++;
        System.out.println(electronic.getModelName() + "Added");
    }

    public void showDeviceList() {
        for(int i = 0; i < electronicsList.length; i++) {
            if(electronicsList[i] == null) return;
            System.out.println(electronicsList[i]);
        }
    }

    public Electronic findByProductNo(String productNo) {
        for(int i = 0; i < listSize; i++) {
            if(electronicsList[i].getProductNo().equals(productNo)) return electronicsList[i];
        }
        System.out.println("Found Nothing");
        return null;
    }

    public Electronic[] groupByCompanyName(Electronic.CompanyName company) {
        int size = 0;
        int index = 0;

        for(int i = 0; i < electronicsList.length; i++) {
            if (electronicsList[i] == null) break;
            if (electronicsList[i].getCompanyName().equals(company)) size++;
        }
        Electronic[] grouping = new Electronic[size];
        for(int i = 0; i < electronicsList.length; i++) {
            if (electronicsList[i] == null) break;
            if(electronicsList[i].getCompanyName().equals(company)) {
                grouping[index] = electronicsList[i];
                index++;
            }
        }
        return grouping;
    }

    public Electronic[] groupByAuthMethod(Electronic.AuthMethod authMethod) {
        int size = 0;
        int index = 0;
        for(int i = 0; i < electronicsList.length; i++) {
            if (electronicsList[i] == null) break;
            for (int j = 0; j < electronicsList[i].getAuthMethod().length; j++) {
                if(electronicsList[i].getAuthMethod()[j] == null) break;
                if(electronicsList[i].getAuthMethod()[j].equals(authMethod)) size++;
            }
        }
        Electronic[] grouping = new Electronic[size];
        for(int i = 0; i < electronicsList.length; i++) {
            if (electronicsList[i] == null) break;
            for (int j = 0; j < electronicsList[i].getAuthMethod().length; j++) {
                if(electronicsList[i].getAuthMethod()[j] == null) break;
                if(electronicsList[i].getAuthMethod()[j].equals(authMethod)){
                    grouping[index] = electronicsList[i];
                    index++;
                };
            }
        }
        return grouping;
    }

}