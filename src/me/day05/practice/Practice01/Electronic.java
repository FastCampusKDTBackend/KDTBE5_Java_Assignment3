package me.day05.practice.Practice01;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Objects;

public class Electronic {
    private static int serialNum = 0;
    private String productNo;
    private String modelName;
    private CompanyName companyName;
    private LocalDate dateOfMade;
    private AuthMethod[] authMethod;

    private Electronic() {
        serialNum++;
        setProductNo();
    }

    public Electronic(String productNo) {
        this.productNo = productNo;
    }

    public Electronic(String modelName, CompanyName companyName, LocalDate dateOfMade, AuthMethod[] authMethod) {
        this();
        this.modelName = modelName;
        this.companyName = companyName;
        this.dateOfMade = dateOfMade;
        this.authMethod = authMethod;
    }

    public String getProductNo() {
        return productNo;
    }

    private String setProductNo() {

        StringBuilder sb = new StringBuilder(10);
        sb.append(LocalDate.now().format(DateTimeFormatter.ofPattern("yyMMdd")));

        if ( (int)Math.log10(serialNum)+1 == 1){
            sb.append("000");
            sb.append(serialNum);
        } else if  ( (int)Math.log10(serialNum)+1 == 2) {
            sb.append("00");
            sb.append(serialNum);
        } else if  ( (int)Math.log10(serialNum)+1 == 3) {
            sb.append("0");
            sb.append(serialNum);
        } else {
            sb.append(serialNum);
        }
        String order = String.format("%04d", serialNum);
        String date = LocalDate.now(ZoneId.systemDefault()).toString().replace("-", "").substring(2);

        productNo = String.valueOf(sb);
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

    public LocalDate getDateOfMade() {
        return dateOfMade;
    }

    public void setDateOfMade(LocalDate dateOfMade) {
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
        return Objects.equals(productNo, that.productNo) && Objects.equals(modelName, that.modelName) && companyName == that.companyName && Objects.equals(dateOfMade, that.dateOfMade) && Objects.equals(authMethod, that.authMethod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productNo, modelName, companyName, dateOfMade, authMethod);
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

    public int authMethodSize(){
        AuthMethod[] values = AuthMethod.values();

        return values.length;
    }
}
