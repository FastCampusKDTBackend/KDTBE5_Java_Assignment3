package Practice;

import java.util.Arrays;
import java.util.Objects;

public class Electronic {
    private String productNo;
    private String modelName;
    public enum Company{
        C1("SAMSUNG"), C2("APPLE"), C3("LG");

        private String companyName = null;
        Company(String companyName){
            this.companyName = companyName;
        }

        public String getCompanyName(){return companyName;}
    }
    private Company company;
    private String dateOfMade;
    public enum AuthMethod{
        AuthMethod1("FINGERPRINT"),
        AuthMethod2("PATTERN"),
        AuthMethod3("PIN"),
        AuthMethod4("FACE");

        private String authMethodName = null;
        AuthMethod(String authMethodName){
            this.authMethodName = authMethodName;
        }
        public String getAuthMethodName() {
            return authMethodName;
        }
    }
    private AuthMethod[] authMethod;

    public Electronic(){}

    public Electronic(String productNo, String modelName, String dateOfMade, AuthMethod[] authMethod, Company company){
        this.productNo = productNo;
        this.modelName = modelName;
        this.dateOfMade = dateOfMade;
        this.authMethod = authMethod;
        this.company = company;
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

    public Company getCompany() {
        return company;
    }
    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Electronic that = (Electronic) o;
        return productNo == that.productNo && Objects.equals(modelName, that.modelName) && Objects.equals(dateOfMade, that.dateOfMade) && Arrays.equals(authMethod, that.authMethod);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(productNo, modelName, dateOfMade);
        result = 31 * result + Arrays.hashCode(authMethod);
        return result;
    }

    @Override
    public String toString() {
        return "Electronic{" +
                "productNo=" + productNo +
                ", modelName='" + modelName + '\'' +
                ", dateOfMade='" + dateOfMade + '\'' +
                ", authMethod=" + Arrays.toString(authMethod) +
                '}';
    }
}
