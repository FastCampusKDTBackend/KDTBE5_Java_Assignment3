package practice;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class Electronic {
    private static int sequenceNumber = 0;

    String productNo;
    String modelName;
    Company company;
    LocalDate dateOfMade;
    AuthMethod[] authMethod;

    public Electronic(String modelName, Company company, LocalDate dateOfMade, AuthMethod[] authMethod) {
        LocalDate now = LocalDate.now();
        int nowYear = now.getYear();
        int nowMonth = now.getMonth().getValue();
        int nowDay = now.getDayOfMonth();

        this.productNo = String.format("%d%02d%d%04d", nowYear % 100, nowMonth, nowDay, ++sequenceNumber);
        this.modelName = modelName;
        this.company = company;
        this.dateOfMade = dateOfMade;
        this.authMethod = authMethod;
    }

    public String getProductNo() {
        return productNo;
    }

    public String getModelName() {
        return modelName;
    }

    public Company getCompany() {
        return company;
    }

    public LocalDate getDateOfMade() {
        return dateOfMade;
    }

    public AuthMethod[] getAuthMethod() {
        return authMethod;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setCompanyName(Company company) {
        this.company = company;
    }

    public void setDateOfMade(LocalDate dateOfMade) {
        this.dateOfMade = dateOfMade;
    }

    public void setAuthMethod(AuthMethod[] authMethod) {
        this.authMethod = authMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Electronic that = (Electronic) o;
        return Objects.equals(productNo, that.productNo) && Objects.equals(modelName, that.modelName) && company == that.company && Objects.equals(dateOfMade, that.dateOfMade) && Arrays.equals(authMethod, that.authMethod);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(productNo, modelName, company, dateOfMade);
        result = 31 * result + Arrays.hashCode(authMethod);
        return result;
    }

    @Override
    public String toString() {
        return "Electronic{" +
                "productNo='" + productNo + '\'' +
                ", modelName='" + modelName + '\'' +
                ", companyName=" + company +
                ", dateOfMade=" + dateOfMade +
                ", authMethod=" + Arrays.toString(authMethod) +
                '}';
    }
}
