package me.day05.practice.practice03;

import me.day05.practice.practice01.AuthMethod;
import me.day05.practice.practice01.CompanyName;
import me.day05.practice.practice01.Electronic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Electronics {
    private static Electronics instance = null;
    private Electronic[] electronicList;

    private Electronics() {
        electronicList = new Electronic[10];
    }

    public static Electronics getInstance() {
        if (instance==null) {
            instance = new Electronics();
        }
        return instance;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(electronicList);
    }

    @Override
    public String toString() {
        return "electronics{" +
                "electronicList=" + Arrays.toString(electronicList) +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this==o) return true;
        if (o==null || getClass()!=o.getClass()) return false;
        Electronics electronics = (Electronics) o;
        return Arrays.equals(electronicList, electronics.electronicList);
    }

    public Electronic[] getElectronicList() {
        return electronicList;
    }

    public void setElectronicList(Electronic[] electronicList) {
        this.electronicList = electronicList;
    }

    public Electronic findByProductNo(String productNo) {
        for (Electronic electronic : electronicList) {
            if (electronic.getProductNo().equals(productNo)) {
                return electronic;
            }
        }
        return null;
    }

    public Electronic[] groupByCompanyName(CompanyName company) {
        List<Electronic> res = new ArrayList<>();
        for (Electronic e : electronicList) {
            if (e.getCompanyName()==company) res.add(e);
        }
        return res.toArray(new Electronic[0]);
    }

    public Electronic[] groupByAuthMethod(AuthMethod authMethod) {
        List<Electronic> electronicListByAuthMethod = new ArrayList<>();
        for (Electronic e : electronicList) {
            AuthMethod[] authMethods = e.getAuthMethods();
            for (AuthMethod method : authMethods) {
                if (method==authMethod) {
                    electronicListByAuthMethod.add(e);
                    break;
                }
            }
        }
        Electronic[] res = new Electronic[electronicListByAuthMethod.size()];
        return electronicListByAuthMethod.toArray(res);
    }


}
