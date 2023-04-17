package me.day05.practice.Practice03;

import me.day05.practice.Practice01.AuthMethod;
import me.day05.practice.Practice01.Company;
import me.day05.practice.Practice01.Electronic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Electronics {
    private Electronic[] electronicList;
    private static Electronics instance;

    private Electronics() {
    }

    public static Electronics getInstance() {
        if(instance == null)
            instance = new Electronics();
        return instance;
    }

    public Electronic[] getElectronicList() {
        return electronicList;
    }

    public void setElectronicList(Electronic[] electronicList) {
        this.electronicList = electronicList;
    }

    public Electronic findByProductNo(String productNo) {
        for(Electronic electronic : electronicList) {
            if(productNo.equals(electronic.getProductNo()))
                return electronic;
        }
        return null;
    }

    public Electronic[] groupByCompanyName(Company company) {
        List<Electronic> electronics = Arrays.stream(electronicList).filter(list -> list.getCompanyName().equals(company)).toList();
        return electronics.toArray(new Electronic[electronics.size()]);
    }

    public Electronic[] groupByAuthMethod(AuthMethod authMethod) {
        List<Electronic> arr = new ArrayList<>();
        for(Electronic electronic : electronicList) {
            for(AuthMethod auth : electronic.getAuthMethod()) {
                if(auth == authMethod)
                    arr.add(electronic);
            }
        }
        return arr.toArray(new Electronic[arr.size()]);
    }
}
