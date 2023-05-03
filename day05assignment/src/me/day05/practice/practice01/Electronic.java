package me.day05.practice.practice01;

import me.day05.practice.practice01.constant.AuthMethod;
import me.day05.practice.practice01.constant.Company;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class Electronic {
    private static int autoIncrementNumber = 0;
    private String productNo;
    private String modelName;
    private Company companyName;
    private String dateOfDate;
    private AuthMethod[] authMethods;

    public Electronic(String productNo,
                      String modelName,
                      Company companyName,
                      String dateOfDate
    ) {
        this.productNo = this.generateProductNo();
        this.modelName = modelName;
        this.companyName = companyName;
        this.dateOfDate = dateOfDate;
        this.authMethods = new AuthMethod[10];
    }

    private String generateProductNo() {
        StringBuilder builder = new StringBuilder();
        String id = String.format("%04d", ++autoIncrementNumber);
        String generatedDate = LocalDate.now().toString().replace("-", "").substring(2);
        builder.append(generatedDate).append(id);
        return builder.toString();
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

    public AuthMethod[] getAuthMethods() {
        return authMethods;
    }

    public void setAuthMethods(AuthMethod[] authMethods) {
        this.authMethods = authMethods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Electronic that = (Electronic) o;

        if (!Objects.equals(productNo, that.productNo)) return false;
        if (!Objects.equals(modelName, that.modelName)) return false;
        if (companyName != that.companyName) return false;
        if (!Objects.equals(dateOfDate, that.dateOfDate)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(authMethods, that.authMethods);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productNo,
                modelName,
                companyName,
                dateOfDate
        );
    }

    @Override
    public String toString() {
        return "Electronic{" +
                "productNo='" + productNo + "'" +
                ", modelName='" + modelName + "'" +
                ", companyName=" + companyName +
                ", dateOfDate='" + dateOfDate + "'" +
                ", authMethod=" + Arrays.toString(authMethods) +
                '}';
    }
}
