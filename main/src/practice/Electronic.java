package practice;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class Electronic implements Cloneable {
    private static int sequenceNumber = 0;

    private String productNo;
    private String modelName;
    private Company company;
    private LocalDate dateOfMade;
    private AuthMethod[] authMethods;

    public Electronic(String modelName, Company company, LocalDate dateOfMade, AuthMethod[] authMethods) {
        LocalDate now = LocalDate.now();
        int nowYear = now.getYear();
        int nowMonth = now.getMonth().getValue();
        int nowDay = now.getDayOfMonth();

        this.productNo = String.format("%d%02d%d%04d", nowYear % 100, nowMonth, nowDay, ++sequenceNumber);
        this.modelName = modelName;
        this.company = company;
        this.dateOfMade = dateOfMade;
        this.authMethods = authMethods;
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

    public AuthMethod[] getAuthMethods() {
        return authMethods;
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

    public void setAuthMethods(AuthMethod[] authMethods) {
        this.authMethods = authMethods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Electronic that = (Electronic) o;
        return Objects.equals(productNo, that.productNo) && Objects.equals(modelName, that.modelName) && company == that.company && Objects.equals(dateOfMade, that.dateOfMade) && Arrays.equals(authMethods, that.authMethods);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(productNo, modelName, company, dateOfMade);
        result = 31 * result + Arrays.hashCode(authMethods);
        return result;
    }

    @Override
    public String toString() {
        return "Electronic{" +
                "productNo='" + productNo + '\'' +
                ", modelName='" + modelName + '\'' +
                ", companyName=" + company +
                ", dateOfMade=" + dateOfMade +
                ", authMethod=" + Arrays.toString(authMethods) +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
