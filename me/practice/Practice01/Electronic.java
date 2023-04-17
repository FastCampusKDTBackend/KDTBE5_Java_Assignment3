package KDTBE5_Java_Assignment3.me.practice.Practice01;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Objects;

import static java.time.LocalDate.now;

public class Electronic {
    public static int registerNumber = 0;
    private String productNo;
    private Company companyName;
    private String modelName;
    private String dateOfMade;
    private AuthMethod[] authMethod;

    public Electronic(Company companyName, String modelName, String dateOfMade, AuthMethod[] authMethod) {
        this.productNo = setProductNo();
        this.companyName = companyName;
        this.modelName = modelName;
        this.dateOfMade = dateOfMade;
        this.authMethod = authMethod;
    }

    private String setProductNo() {
        String productNo = now().format(DateTimeFormatter.ofPattern("yyMMdd"))+String.format("%04d",++Electronic.registerNumber);
        return productNo;
    }


    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public Company getCompany() {
        return companyName;
    }

    public void setCompany(Company companyName) {
        this.companyName = companyName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
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
        return Objects.equals(productNo, that.productNo) && companyName == that.companyName && Objects.equals(modelName, that.modelName) && Objects.equals(dateOfMade, that.dateOfMade) && Arrays.equals(authMethod, that.authMethod);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(productNo, companyName, modelName, dateOfMade);
        result = 31 * result + Arrays.hashCode(authMethod);
        return result;
    }

    @Override
    public String toString() {
        return "Electronic{" +
                "productNo='" + productNo + '\'' +
                ", companyName=" + companyName +
                ", modelName='" + modelName + '\'' +
                ", dateOfMade='" + dateOfMade + '\'' +
                ", authMethod=" + Arrays.toString(authMethod) +
                '}';
    }
}
