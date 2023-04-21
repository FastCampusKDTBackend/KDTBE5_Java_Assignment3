package me.day05.practice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Objects;

public class Electronic {

    enum CompanyName { SAMSUNG, LG, APPLE }
    enum AuthMethod { FINGERPRINT, PIN, PATTERN, FACE }

    private static final int MAX_REGISTRATION_NUMBER = 9999;

    private static int registrationNo;

    private String productNo;
    private String modelName;
    private CompanyName companyName;
    private String dateOfMade;
    private AuthMethod[] authMethod;

    Electronic () {
        registrationNo++;
        setDateOfMade();
        setProductNo();
    }

    Electronic (String modelName, CompanyName companyName, AuthMethod[] authMethod) {
        this();
        this.modelName = modelName;
        this.companyName = companyName;
        this.authMethod = authMethod;
    }

    private void setDateOfMade(){
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyMMdd");
        dateOfMade = timeFormatter.format(LocalDate.now());
    }

    private void setProductNo(){
        if (registrationNo > MAX_REGISTRATION_NUMBER) registrationNo = 1;
        productNo = dateOfMade + String.format("%4d", registrationNo).replace(" ", "0");
    }

    public boolean isContainsAuthMethod(AuthMethod authMethod){
        for (AuthMethod auth : this.authMethod)
            if (authMethod.equals(auth)) return true;
        return false;
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

    public CompanyName getCompanyName() {
        return companyName;
    }

    public void setCompanyName(CompanyName companyName) {
        this.companyName = companyName;
    }

    public String getDateOfMade() {
        return dateOfMade;
    }

    public AuthMethod[] getAuthMethod() {
        return authMethod;
    }

    public void setAuthMethod(AuthMethod[] authMethod) {
        this.authMethod = authMethod;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productNo, modelName, companyName, dateOfMade, Arrays.hashCode(authMethod));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        return Objects.equals(productNo, ((Electronic)obj).productNo);
    }

    @Override
    public String toString() {
        return "Electronic { " +
                "productNo=" + productNo +
                ", modelName=" + modelName +
                ", companyName= " + companyName +
                ", dateOfMade=" + dateOfMade +
                ", authMethod=" + Arrays.toString(authMethod) + " }";
    }
}
