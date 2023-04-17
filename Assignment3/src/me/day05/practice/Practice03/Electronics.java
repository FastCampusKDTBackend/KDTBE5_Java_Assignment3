package me.day05.practice.Practice03;

import me.day05.practice.Practice01.AuthMethod;
import me.day05.practice.Practice01.Company;
import me.day05.practice.Practice01.Electronic;

import java.util.Arrays;
import java.util.Objects;

public class Electronics {

    Electronic[] electronicList;    

    private static Electronics instance;

    private Electronics() {
    }

    private Electronics getInstance() {
        if (!(instance == null)) return instance = new Electronics();
        return instance;
    }

    public Electronic findByProductNo(String productNo) {
        for (Electronic electronic : electronicList) {
            if (electronic.getProductNo().equals(productNo))
                return electronic;
        }
        return null;
    }

    public Electronic[] groupByCompanyName(Company company) {
        Electronic[] companyOfProduct = new Electronic[electronicList.length];

        int j = 0;
        for (int i = 0; i < electronicList.length; i++) {
            if (electronicList[i].getCompanyName().equals(company)){
                companyOfProduct[j] = electronicList[i];
                j++;
            }
        }
        return companyOfProduct;
    }

    public Electronic[] groupByAuthMethod(AuthMethod authMethod) {
        Electronic[] authMethodOfProduct = new Electronic[electronicList.length];

        int j = 0;
        for (int i = 0; i < electronicList.length; i++) {
            if (electronicList[i].getAuthMethod().equals(authMethod)){
                authMethodOfProduct[j] = electronicList[i];
                j++;
            }
        }
        return authMethodOfProduct;
    }

    @Override
    public int hashCode() {
        return Objects.hash(electronicList);
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Electronics)) return false;

        Electronics list = (Electronics) obj;
        return Arrays.equals(this.electronicList, list.electronicList);
    }

    @Override
    public String toString() {
        return "electronicList{" + Arrays.toString(electronicList) + "}";
    }

    public Electronic[] getElectronicList() {
        return electronicList;
    }

    public void setElectronicList(Electronic[] electronicList) {
        this.electronicList = electronicList;
    }
}
