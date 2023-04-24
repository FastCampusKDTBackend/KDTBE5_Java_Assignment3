package me.day05.practice.NonArrayList;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Objects;

public class Electronic {

    public enum CompanyName {SAMSUNG, LG, APPLE}
    public enum AuthMethod {FINGERPRINT, PATTERN, PIN, FACE};

    private String  productNo;
    private String modelName;
    private CompanyName companyName;
    private LocalDateTime dateOfMade;
    private  AuthMethod[] authMethod;

    public Electronic(String modelName, CompanyName companyName, LocalDateTime dateOfMade, AuthMethod[] authMethod) {
        this.productNo = productNumGenerator();
        this.modelName = modelName;
        this.companyName = companyName;
        this.dateOfMade = dateOfMade;
        this.authMethod = authMethod;
    }

    static int devices = 0;
    public String productNumGenerator() {
        devices++;
        LocalDate now = LocalDate.now();
        String dayOfNo = now.format(DateTimeFormatter.ofPattern("YYMMdd"));
        dayOfNo += String.format("%04d", devices);

        return dayOfNo;
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

    public CompanyName getCompanyName() {
        return companyName;
    }

    public void setCompanyName(CompanyName companyName) {
        this.companyName = companyName;
    }

    public LocalDateTime getDateOfMade() {
        return dateOfMade;
    }

    public void setDateOfMade(LocalDateTime dateOfMade) {
        this.dateOfMade = dateOfMade;
    }

    public AuthMethod[] getAuthMethod() {
        return authMethod;
    }

    public void setAuthMethod(AuthMethod[] authMethod) {
        this.authMethod = authMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Electronic that = (Electronic) o;
        return Objects.equals(productNo, that.productNo);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(productNo, modelName, companyName, dateOfMade);
        result = 31 * result + Arrays.hashCode(authMethod);
        return result;
    }

    @Override
    public String toString() {
        return "Electronic{" +
                "productNo='" + productNo + '\'' +
                ", modelName='" + modelName + '\'' +
                ", companyName=" + companyName +
                ", dateOfMade=" + dateOfMade +
                ", authMethod=" + Arrays.toString(authMethod) +
                '}';
    }
}