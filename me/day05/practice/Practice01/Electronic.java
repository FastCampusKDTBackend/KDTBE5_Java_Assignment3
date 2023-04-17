package me.day05.practice.Practice01;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

public class Electronic {

    private static int modelCount = 0;

    private String productNo;
    private String modelName;
    private Company companyName;
    private LocalDate dateOfMade;
    private ArrayList<AuthMethod> authMethod = new ArrayList<>();


    public Electronic(String modelName, Company companyName, AuthMethod auth) {
        this.productNo = setProductNo();
        this.modelName = modelName;
        this.companyName = companyName;
        this.dateOfMade = setDateOfMade();
        authMethod.add(auth);
    }


    public static int getModelCount() {
        return modelCount;
    }

    public static void setModelCount(int modelCount) {
        Electronic.modelCount = modelCount;
    }

    public String getProductNo() {
        return productNo;
    }


    public String setProductNo() {
        modelCount++;
        LocalDate now = LocalDate.now();
        String productNo = now.format(DateTimeFormatter.ofPattern("YYMMdd"));
        productNo += String.format("%04d", modelCount);
        return productNo;
    }

    private LocalDate setDateOfMade() {
        LocalDate now = LocalDate.now();
        return now;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Company getCompanyName() {
        return companyName;
    }

    public void setCompanyName(Company companyName) {
        this.companyName = companyName;
    }

    public LocalDate getDateOfMade() {
        return dateOfMade;
    }

    public void setDateOfMade(LocalDate dateOfMade) {
        this.dateOfMade = dateOfMade;
    }

    public ArrayList<AuthMethod> getAuthMethod() {
        return authMethod;
    }

    public void setAuthMethod(AuthMethod auth) {
        authMethod.add(auth);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Electronic that = (Electronic) o;
        return productNo.equals(that.productNo) && modelName.equals(that.modelName) && companyName.equals(that.companyName) && dateOfMade.equals(that.dateOfMade) && authMethod.equals(that.authMethod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productNo, modelName, companyName, dateOfMade, authMethod);
    }

    @Override
    public String toString() {
        return "Electronic{" +
                "productNo='" + productNo + '\'' +
                ", modelName='" + modelName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", dateOfMade=" + dateOfMade +
                ", authMethod=" + authMethod +
                '}';
    }

}
