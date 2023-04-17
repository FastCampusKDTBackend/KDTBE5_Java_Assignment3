package Practice01;

import java.util.Objects;
import java.util.Arrays;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Electronic {
    private String productNo;
    private String modelName;
    private CompanyName companyName;
    private LocalDate dateOfMade;
    private AuthMethod[] authMethods;
    private static int numProducts = 0;

    public Electronic(String modelName, CompanyName companyName, LocalDate dateOfMade, AuthMethod[] authMethods){
        this.modelName = modelName;
        this.companyName = companyName;
        this.dateOfMade = dateOfMade;
        this.authMethods = authMethods;
        this.productNo = ProductNo();
        numProducts++;
    }

    private String ProductNo(){
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyMMdd"));
        date += String.format("%04d", numProducts+1);
        return date;
    }
    public enum CompanyName{
        SAMSUNG , LG, APPLE
    }
    public enum AuthMethod{
        FINGERPRINT, PATTERN, PIN, FACE
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

    public AuthMethod[] getAuthMethods() {
        return authMethods;
    }

    public void setAuthMethods(AuthMethod[] authMethods) {
        this.authMethods = authMethods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Electronic that = (Electronic) o;
        return Objects.equals(productNo, that.productNo) && Objects.equals(modelName, that.modelName) && companyName == that.companyName && Objects.equals(dateOfMade, that.dateOfMade) && Arrays.equals(authMethods, that.authMethods);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(productNo, modelName, companyName, dateOfMade);
        result = 31 * result + Arrays.hashCode(authMethods);
        return result;
    }

    @Override
    public String toString() {
        return "Electronic{" +
                "productNo='" + productNo + '\'' +
                ", modelName='" + modelName + '\'' +
                ", companyName=" + companyName +
                ", dateOfMade=" + dateOfMade +
                ", authMethods=" + Arrays.toString(authMethods) +
                '}';
    }

}
