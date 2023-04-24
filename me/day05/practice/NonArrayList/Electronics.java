package me.day05.practice.NonArrayList;

import java.util.Arrays;

public class Electronics {
    private static Electronics electronicsInstance;

    public static Electronics getInstance() {
        if(electronicsInstance == null) {
            electronicsInstance = new Electronics();
        }
        return electronicsInstance;
    }
    private static int listSize = 10;
    private Electronic[] electronicsList;
    private int index = 0;

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
        return "pratice.NonArrayList.Electronics{" +
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

    public Electronic[] groupByCompanyName(Company company) {
        Electronic[] companyGroup = Arrays.stream(electronicsList)
                .filter(device -> device != null && device.getCompanyName().equals(company))
                .toArray(Electronic[]::new);

        return companyGroup;
    }

    public Electronic[] groupByAuthMethod(AuthMethod auth) {
        Electronic[] authGroup = Arrays.stream(electronicsList)
                .filter(device -> device != null && device.hasAuthMethodType(auth))
                .toArray(Electronic[]::new);

        return authGroup;
    }


}
