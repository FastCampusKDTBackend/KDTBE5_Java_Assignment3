package me.day05.practice.Practice01;

import java.util.Arrays;
import java.util.Objects;

public class Electronic {
    private String productNo;
    private String modelName;
    private Company companyName;
    private String dateOfDate;
    private AuthMethod[] authMethod;

    public Electronic(String productNo, String modelName, Company companyName, String dateOfDate, AuthMethod[] authMethod) {
        this.productNo = productNo;
        this.modelName = modelName;
        this.companyName = companyName;
        this.dateOfDate = dateOfDate;
        this.authMethod = authMethod;
    }

    public String getProductNo() {
        return productNo;
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

    public String getDateOfDate() {
        return dateOfDate;
    }

    public void setDateOfDate(String dateOfDate) {
        this.dateOfDate = dateOfDate;
    }

    public AuthMethod[] getAuthMethod() {
        return authMethod;
    }
    public void setAuthMethod(AuthMethod[] authMethod) {
        this.authMethod = authMethod;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || this.getClass() != object.getClass()) return false;

        Electronic that = (Electronic) object;

        if (!Objects.equals(productNo, that.productNo)) return false;
        if (!Objects.equals(modelName, that.modelName)) return false;
        if (companyName != that.companyName) return false;
        return Objects.equals(dateOfDate, that.dateOfDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productNo, modelName, companyName, dateOfDate);
    }

    @Override
    public String toString() {
        return "Electronic{" +
                "productNo='" + productNo + "'" +
                ", modelName='" + modelName + "'" +
                ", companyName=" + companyName +
                ", dateOfDate='" + dateOfDate + "'" +
                ", authMethod=" + Arrays.toString(authMethod) +
                '}';
    }
}
