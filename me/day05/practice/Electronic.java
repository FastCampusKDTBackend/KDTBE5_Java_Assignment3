package me.day05.practice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Objects;

public class Electronic {
    private String productNo;
    private static int count = 0;
    private String modelName;
    private Company companyName;
    private String dateOfMade;
    private AuthMethod[] authMethods;


    public enum Company{
        SAMSUNG, LG, APPLE
    }
    public enum AuthMethod{
        FINGERPRINT, PATTERN, PIN, FACE
    }
    public Electronic(String modelName, Company companyName, String dateOfMade,AuthMethod[] authMethod){
        count++;
        this.productNo = LocalDate.now().format(DateTimeFormatter.ofPattern("YYMMdd")) + String.format("%04d", count);
        this.modelName = modelName;
        this.companyName = companyName;
        this.dateOfMade = dateOfMade;
        this.authMethods = authMethod;
    }

    public static int getCount(){
        return count;
    }

    public String getProductNo() {
        return productNo;
    }

    public String getModelName() {
        return modelName;
    }

    public String getDateOfMade() {
        return dateOfMade;
    }

    public AuthMethod[] getAuthMethods() {
        return authMethods;
    }

    @Override
    public String toString() {
        return "Electronic{" +
                "productNo='" + productNo + '\'' +
                ", modelName='" + modelName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", dateOfMade=" + dateOfMade +
                ", authMethods=" + Arrays.toString(authMethods) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Electronic that = (Electronic) o;
        return Objects.equals(productNo, that.productNo) && Objects.equals(modelName, that.modelName) && Objects.equals(companyName, that.companyName) && Objects.equals(dateOfMade, that.dateOfMade) && Arrays.equals(authMethods, that.authMethods);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(productNo, modelName, companyName, dateOfMade);
        result = 31 * result + Arrays.hashCode(authMethods);
        return result;
    }
}
