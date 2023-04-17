package me.day05.practice.Practice01;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Objects;

public class Electronic {
    private static int sequence = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private String productNo;
    private String modelName;
    private Company companyName;
    private String dateOfMade;
    private AuthMethod[] authMethod;

    Electronic() {
        productNo = Integer.toString(++sequence);
        LocalDateTime localDateTime = LocalDateTime.now();
        dateOfMade = localDateTime.format(DateTimeFormatter.ofPattern("yy-MM-dd HH:mm"));
        authMethod = new AuthMethod[DEFAULT_CAPACITY];
    }

    public Electronic(String modelName, Company companyName, AuthMethod[] authMethod) {
        this();
        this.modelName = modelName;
        this.companyName = companyName;
        this.authMethod = authMethod;
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

    public String getDateOfMade() {
        return dateOfMade;
    }

    public void setDateOfMade(String dateOfMade) {
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
        return Objects.equals(productNo, that.productNo) && Objects.equals(modelName, that.modelName) && companyName == that.companyName && Objects.equals(dateOfMade, that.dateOfMade) && Arrays.equals(authMethod, that.authMethod);
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
                ", dateOfMade='" + dateOfMade + '\'' +
                ", authMethod=" + Arrays.toString(authMethod) +
                '}';
    }
}
