package me.day05.practice.Practice03;
import me.day05.practice.Practice01.Auth;
import me.day05.practice.Practice01.Company;
import me.day05.practice.Practice01.Electronic;

import java.util.ArrayList;
import java.util.List;

public class Electronics {
    private static Electronics instance;
    private Electronic[] electronicList;

    private Electronics() {
    }

    public static Electronics getInstance() {
        if (instance == null) {
            instance = new Electronics();
        }
        return instance;
    }
    public Electronic findByProductNo(String productNo) {
        for (Electronic electronic : electronicList) {
            if (electronic.getProductNo().equals(productNo)) {
                return electronic;
            }
        }
        return null;
    }
    public Electronic[] groupByCompanyName(Company company) {
        List<Electronic> products = new ArrayList<>();
        for (Electronic product : electronicList) {
            if (product.getCompanyName().equals(company)) {
                products.add(product);
            }
        }
        return products.toArray(new Electronic[0]);
    }
    public Electronic[] groupByAuthMethod(Auth authMethod) {
        List<Electronic> result = new ArrayList<>();
        for (Electronic electronic : electronicList) {
            if (electronic.getAuthMethods().equals(authMethod)) {
                result.add(electronic);
            }
        }
        return result.toArray(new Electronic[result.size()]);
    }
}