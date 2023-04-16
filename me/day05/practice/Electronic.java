package day05.practice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Electronic {

    private static int productOrder = 1;
    private String productNo;
    private String modelName;
    private Company companyName;
    private String dateOfMade;
    private AuthMethod[] authMethod;

    public Electronic(String modelName, Company companyName, String dateOfMade, AuthMethod[] authMethod) {
        String currentDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMd"));
        String registerOrder = String.format("%04d", productOrder++);
        this.productNo = currentDate + registerOrder;
        this.modelName = modelName;
        this.companyName = companyName;
        this.dateOfMade = dateOfMade;
        this.authMethod = authMethod;
    }

    public static int getProductOrder() {
        return productOrder;
    }

    public static void setProductOrder(int productOrder) {
        Electronic.productOrder = productOrder;
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

    public Company getCompanyName() {
        return companyName;
    }

    public void setCompanyName(Company companyName) {
        this.companyName = companyName;
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

        if (getProductNo() != null ? !getProductNo().equals(that.getProductNo()) : that.getProductNo() != null)
            return false;
        if (getModelName() != null ? !getModelName().equals(that.getModelName()) : that.getModelName() != null)
            return false;
        if (getCompanyName() != that.getCompanyName()) return false;
        if (getDateOfMade() != null ? !getDateOfMade().equals(that.getDateOfMade()) : that.getDateOfMade() != null)
            return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(getAuthMethod(), that.getAuthMethod());
    }

    @Override
    public int hashCode() {
        int result = getProductNo() != null ? getProductNo().hashCode() : 0;
        result = 31 * result + (getModelName() != null ? getModelName().hashCode() : 0);
        result = 31 * result + (getCompanyName() != null ? getCompanyName().hashCode() : 0);
        result = 31 * result + (getDateOfMade() != null ? getDateOfMade().hashCode() : 0);
        result = 31 * result + Arrays.hashCode(getAuthMethod());
        return result;
    }

    @Override
    public String toString() {
        return "Electronic{" +
                "productNo='" + productNo + '\'' +
                ", modelName='" + modelName + '\'' +
                ", companyName=" + companyName +
                ", dateOfMade='" + dateOfMade + '\'' +
                ", authMethod=" + Arrays.toString(authMethod) +
                '}';
    }
}
