package src.practice01;

import src.practice01.db.AuthMethod;
import src.practice01.db.Company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

public class Electronic {
    private static int serialNumber = 0;

    String productNo;
    String modelName;
    Company companyName;
    LocalDate dateOfMade;
    ArrayList<AuthMethod> authMethods = new ArrayList<>();

    public Electronic (
            String productNo, String modelName,
            Company companyName, LocalDate dateOfMade,
            AuthMethod auth

    ) {
        LocalDate today = LocalDate.now();


        serialNumber++;
        this.modelName = modelName;

        this.productNo = today.format(DateTimeFormatter.ofPattern("yyMMdd"));
        this.productNo += String.format("%04d", serialNumber);
        this.companyName = companyName;
        authMethods.add(auth);
    }

    public static int getSerialNumber() {
        return serialNumber;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
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

    public ArrayList<AuthMethod> getAuthMethods() {
        return authMethods;
    }

    public void setAuthMethods(ArrayList<AuthMethod> authMethods) {
        this.authMethods = authMethods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Electronic that = (Electronic) o;
        return Objects.equals(productNo, that.productNo) &&
                Objects.equals(modelName, that.modelName) && companyName == that.companyName &&
                Objects.equals(dateOfMade, that.dateOfMade) &&
                Objects.equals(authMethods, that.authMethods);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productNo, modelName, companyName, dateOfMade, authMethods);
    }

    @Override
    public String toString() {
        return "Electronic{" +
                "productNo='" + productNo + '\'' +
                ", modelName='" + modelName + '\'' +
                ", companyName=" + companyName +
                ", dateOfMade=" + dateOfMade +
                ", authMethods=" + authMethods +
                '}';
    }
}
