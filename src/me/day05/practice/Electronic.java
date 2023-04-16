package me.day05.practice;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Objects;

public class Electronic implements Cloneable {

    private static long AUTO_GEN = 0;

    private String productNo;
    private String modelName;
    private Company company;
    private LocalDate madeDate;
    private AuthMethod[] authMethods;

    public Electronic(String modelName, Company company, AuthMethod[] authMethods) {
        AUTO_GEN++;
        this.modelName = modelName;
        this.company = company;
        this.authMethods = authMethods;
        this.madeDate = LocalDate.now(ZoneId.systemDefault());
        this.productNo = generateProductNo();
    }

    private String generateProductNo() {
        return String.format("%02d", this.madeDate.getYear()) +
                String.format("%02d", this.madeDate.getMonthValue()) +
                String.format("%02d", this.madeDate.getDayOfMonth()) +
                String.format("%04d", AUTO_GEN);
    }

    public String getProductNo() {
        return productNo;
    }

    public boolean hasAuthMethod(AuthMethod authMethod) {
        for (AuthMethod auth : this.authMethods) {
            if (auth == authMethod) {
                return true;
            }
        }
        return false;
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
        return company;
    }

    public void setCompanyName(Company company) {
        this.company = company;
    }

    public LocalDate getMadeDate() {
        return madeDate;
    }

    public void setMadeDate(LocalDate madeDate) {
        this.madeDate = madeDate;
    }

    public AuthMethod[] getAuthMethods() {
        return authMethods;
    }

    public void setAuthMethods(AuthMethod[] authMethods) {
        this.authMethods = authMethods;
    }

    @Override
    public Electronic clone() {
        AuthMethod[] authMethods = Arrays.copyOf(this.authMethods, this.authMethods.length);
        Electronic copied = new Electronic(this.modelName, this.company, authMethods);
        copied.productNo = this.productNo;
        copied.madeDate = this.madeDate;
        return copied;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Electronic e = (Electronic) o;
        // 논리적으로 같은 모델, 같은 회사의 제품이면 같은 제품으로 간주 (물론 일련번호가 다른 같은 모델의 여러 제품이 존재할 수 있음)
        return modelName.equals(e.modelName) && company.equals(e.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modelName, company);
    }

    @Override
    public String toString() {
        return "Electronic{" +
                "productNo=" + productNo +
                ", modelName='" + modelName + '\'' +
                ", companyName=" + company +
                ", madeDate=" + madeDate +
                ", authMethods=" + Arrays.toString(authMethods) +
                '}';
    }
}
