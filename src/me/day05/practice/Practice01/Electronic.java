package me.day05.practice.Practice01;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Electronic {
    private static int serialNum = 0;

    private String productNO;
    private String modelName;
    private Company CompanyName;
    private LocalDate dateOfMade;
    private Auth[] authMethod;

    public Electronic(String modelName, Company companyName, Auth[] authMethod) {
        serialNum++;
        productNO = setProductNO();
        this.modelName = modelName;
        CompanyName = companyName;
        this.dateOfMade = LocalDate.now();
        this.authMethod = authMethod;
    }

    public Electronic() {
        serialNum++;
        productNO = setProductNO();
    }

    public String getProductNO() {
        return productNO;
    }

    public String setProductNO() {
        LocalDate localDate = LocalDate.now();
        String serialNO = localDate.format(DateTimeFormatter.ofPattern("yyMMdd"));
        serialNO += String.format("%04d",serialNum);

        return serialNO;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Company getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(Company companyName) {
        CompanyName = companyName;
    }

    public LocalDate getDateOfMade() {
        return dateOfMade;
    }

    public void setDateOfMade(LocalDate dateOfMade) {
        this.dateOfMade = dateOfMade;
    }

    public Auth[] getAuthMethod() {
        return authMethod;
    }

    public void setAuthMethod(Auth[] authMethod) {
        this.authMethod = authMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Electronic that = (Electronic) o;
        return Objects.equals(productNO, that.productNO) && Objects.equals(modelName, that.modelName) && CompanyName == that.CompanyName && Objects.equals(dateOfMade, that.dateOfMade) && authMethod == that.authMethod;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productNO, modelName, CompanyName, dateOfMade, authMethod);
    }

    @Override
    public String toString() {
        return "Electronic{" +
                "productNO='" + productNO + '\'' +
                ", modelName='" + modelName + '\'' +
                ", CompanyName=" + CompanyName +
                ", dateOfMade=" + dateOfMade +
                ", authMethod=" + authMethod +
                '}';
    }

}

