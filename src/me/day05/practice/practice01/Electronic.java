package me.day05.practice01;

import me.day05.practice03.Electronics;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Objects;

public class Electronic {
    private static int createNo = 0;
    private static final int DEFAULT_CAPACITY = 4;
    private String productNo;
    private String modelName;
    private Company companyName;
    private String dateOfMade;
    private AuthMethod[] authMethod;

    public Electronic() {
        createNo++;
        LocalDate madeDate = LocalDate.now();
        this.dateOfMade = madeDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        this.productNo = madeDate.format(DateTimeFormatter.ofPattern("yyMMdd")) + String.format("%04d", createNo);
        this.authMethod = new AuthMethod[DEFAULT_CAPACITY];

        Electronics.getInstance().add(this);
    }

    public Electronic(String modelName, Company companyName) {
        this();

        this.modelName = modelName;
        this.companyName = companyName;
    }

    public Electronic(String modelName, Company companyName, AuthMethod[] authMethod) {
        this();

        this.modelName = modelName;
        this.companyName = companyName;
        this.authMethod = authMethod;
    }

    //region Getter / Setter
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

    public String getDateOfMade() {
        return dateOfMade;
    }

    public AuthMethod[] getAuthMethod() {
        return authMethod;
    }

    public void setAuthMethod(AuthMethod[] authMethod) {
        this.authMethod = authMethod;
    }
    //endregion

    //region hashCode & equals / toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Electronic that = (Electronic) o;
        return productNo.equals(that.productNo) && Objects.equals(modelName, that.modelName) && companyName == that.companyName && dateOfMade.equals(that.dateOfMade) && Arrays.equals(authMethod, that.authMethod);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(productNo, modelName, companyName, dateOfMade);
        result = 31 * result + Arrays.hashCode(authMethod);
        return result;
    }

    @Override
    public String toString() {
        return "productNo : " + productNo + ", modelName = " + modelName + ", companyName : " + companyName + ", dateOfMade : " + dateOfMade +
                ", authMethod (" + getAuthInfo() + ")\n";
    }
    //endregion

    private String getAuthInfo() {
        String authStr = "";
        for (int i = 0; i < authMethod.length; i++) {
            if (authMethod[i] == null) continue;

            authStr += authMethod[i] + ", ";
        }

        if (authStr == "") return null;

        return authStr.substring(0, authStr.length()-2);
    }
}
