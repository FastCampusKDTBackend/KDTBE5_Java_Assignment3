package me.day05.practice.practice01;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

public class Electronic {
    private static int sequence;
    private String productNo;
    private String modelName;
    private CompanyName companyName;
    private LocalDate dateOfMade;
    private AuthMethod[] authMethods;

    public Electronic(String modelName, CompanyName companyName, AuthMethod[] authMethods) {
        this.productNo = String.format("%s%04d", LocalDate.now().toString().replaceAll("-", ""), ++sequence);
        this.modelName = modelName;
        this.companyName = companyName;
        this.dateOfMade = LocalDate.now();
        this.authMethods = authMethods;
    }

    public static int getSequence() {
        return sequence;
    }

    public static void setSequence(int sequence) {
        Electronic.sequence = sequence;
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

    public LocalDate getDateOfMade() {
        return dateOfMade;
    }

    public void setDateOfMade(LocalDate dateOfMade) {
        this.dateOfMade = dateOfMade;
    }

    public AuthMethod[] getAuthMethods() {
        return authMethods;
    }

    public void setAuthMethods(AuthMethod[] authMethods) {
        this.authMethods = authMethods;
    }



    public static void main(String[] args) {
        Electronic e1 = new Electronic("test01", CompanyName.SAMSUNG, new AuthMethod[] {AuthMethod.PATTERN, AuthMethod.FINGERPRINT});
        Electronic e2 = new Electronic("test01", CompanyName.SAMSUNG, new AuthMethod[] {AuthMethod.PATTERN, AuthMethod.FINGERPRINT});
        System.out.println(e1.productNo);
        System.out.println(e2.productNo);
        System.out.println(sequence);
        System.out.println("e1 hashCode : " + e1.hashCode());
        System.out.println("e1 toString : " + e1.toString());
        System.out.println("success");
    }

    @Override
    public String toString() {
        return "Electronic [productNo=" + productNo + ", modelName=" + modelName + ", companyName=" + companyName
                + ", dateOfMade=" + dateOfMade + ", authMethods=" + Arrays.toString(authMethods) + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(productNo, modelName, companyName, dateOfMade, Arrays.hashCode(authMethods));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Electronic)) {
            return false;
        }
        Electronic other = (Electronic) obj;
        return Objects.equals(productNo, other.productNo) && Objects.equals(modelName, other.modelName)
                && companyName == other.companyName && Objects.equals(dateOfMade, other.dateOfMade)
                && Arrays.equals(authMethods, other.authMethods);
    }

}
