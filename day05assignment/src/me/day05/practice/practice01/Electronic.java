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
        String id = String.format("%04d", ++autoIncrementNumber);
        String generatedDate = LocalDate.now().toString().replace("-", "").substring(2);

        return generatedDate + id;
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
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;

        Electronic that = (Electronic) obj;

        return Objects.equals(this.productNo, that.productNo); // Unique한 id 값을 가지고 있기 때문에 이렇게 작성
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
