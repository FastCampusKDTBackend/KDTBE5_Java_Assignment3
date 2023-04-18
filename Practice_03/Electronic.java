package Practice_03;

import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Electronic {

    public enum Company { SAMSUNG, LG, APPLE }
    public enum AuthMethod { FINGERPRINT, PIN, PATTERN, FACE }

    private static int registrationNo;
    private String productNo;
    private String modelName;
    private Company company;
    private LocalDate dateOfMade;
    private AuthMethod[] authMethods;

    public Electronic(String modelName, Company company, AuthMethod[] authMethods) {
        this.modelName = modelName;
        this.company = company;
        this.authMethods = authMethods;
        this.productNo = generateProductNo();
    }

    private String generateProductNo() {
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyMMdd"));
        registrationNo++;
        registrationNo %= 100000;
        String registrationNoStr = String.format("%04d", registrationNo);
        return date + registrationNoStr;
    }

    public boolean containsAuthMethod(AuthMethod authMethod) {
        return Arrays.asList(authMethods).contains(authMethod);
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public LocalDate getDateOfMade() {
        return dateOfMade;
    }

    public AuthMethod[] getAuthMethods() {
        return authMethods;
    }

    public void setAuthMethods(AuthMethod[] authMethods) {
        this.authMethods = authMethods;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productNo, modelName, company, authMethods);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Electronic that = (Electronic) obj;
        return Objects.equals(this.productNo, that.productNo);
    }

    @Override
    public String toString() {
        return String.format("Electronic { productNo=%s, modelName=%s, company=%s, authMethods=%s }",
                productNo, modelName, company, Arrays.toString(authMethods));
    }
}
