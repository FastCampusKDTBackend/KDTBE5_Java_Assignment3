package me.day05.practice.Practice01;

import java.time.LocalDate;
import java.util.Arrays;

public class Electronic {
    private static int count = 0;
    private final String productNo;
    private final String modelName;
    private final Company companyName;
    private final LocalDate dateOfMade;
    private final Auth[] authMethods;

    public Electronic(String modelName, Company companyName, LocalDate dateOfMade, Auth[] authMethods) {
        count++;
        this.productNo = LocalDate.now().toString().replace("-", "").substring(2) + String.format("%04d", count);
        this.modelName = modelName;
        this.companyName = companyName;
        this.dateOfMade = dateOfMade;
        this.authMethods = authMethods;
    }

    public String getProductNo() {
        return productNo;
    }

    public String getModelName() {
        return modelName;
    }

    public Company getCompanyName() {
        return companyName;
    }

    public LocalDate getDateOfMade() {
        return dateOfMade;
    }

    public Auth[] getAuthMethods() {
        return authMethods;
    }

    @Override
    public String toString() {
        return "Electronic{" +
                "productNo='" + productNo + '\'' +
                ", modelName='" + modelName + '\'' +
                ", companyName=" + companyName +
                ", dateOfMade=" + dateOfMade +
                ", authMethods=" + Arrays.toString(authMethods) +
                '}';
    }
}