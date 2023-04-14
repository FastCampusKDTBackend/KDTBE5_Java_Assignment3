package me.day05.practice.Practice03;

import me.day05.practice.AuthMethod;
import me.day05.practice.Company;

import java.util.Arrays;
import java.util.Optional;

public class Electronics {
    private static Electronics instance;
    private static Electronic[] electronicList;

    private Electronics() {
    }

    public static Electronics getInstance() {
        if(instance==null) {
            instance = new Electronics();
        }
        return instance;
    }

    public Optional<Electronic> findByProductNo(String productNo){
        return Arrays.stream(electronicList).filter(x->x.getProductNo()==productNo).findFirst();
    }

    public Electronic[] groupByCompanyName(Company company){
        return (Electronic[]) Arrays.stream(electronicList).filter(x->x.getCompanyName()==company).toArray();
    }

    public Electronic[] groupByAuthMethod(AuthMethod authMethod){
        return (Electronic[]) Arrays.stream(electronicList).filter(x->x.getAuthMethod().contains(authMethod)).toArray();
    }

    public static Electronic[] getElectronicList() {
        return electronicList;
    }

    public static void setElectronicList(Electronic[] electronicList) {
        Electronics.electronicList = electronicList;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Electronics{}";
    }
}
