package me.day05.practice.Practice01;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Objects;

public class Electronic {

    public enum companyName {SAMSUNG,LG,APPLE}
    public enum authMethod {FINGERPRINT, PATTERN, PIN, FACE}
    private authMethod[] authMethods;
    private companyName company;
    private String productNo;
    private static int productionCount=1;

    private String modelName;
    private LocalDateTime dateOfMade;

    public Electronic(companyName companyName, authMethod []authMehods, String modelName){

        StringBuffer generateProductNo;
        generateProductNo = new StringBuffer(LocalDate.now().getYear()%100);
        generateProductNo.append(String.format("%02",LocalDate.now().getDayOfMonth()));
        generateProductNo.append(String.format("%02",LocalDate.now().getDayOfMonth()));
        generateProductNo.append(String.format("%04",productionCount++ ));
        this.productNo = String.valueOf(getProductNo());
        this.authMethods = authMehods;
        this.company = companyName;
        this.modelName = modelName;
        this.dateOfMade = LocalDateTime.now(ZoneId.systemDefault());

    }

    public authMethod[] getAuthMethods() {
        return authMethods;
    }

    public void setAuthMethods(authMethod[] authMethods) {
        this.authMethods = authMethods;
    }

    public companyName getCompany() {
        return company;
    }

    public void setCompany(companyName company) {
        this.company = company;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public static int getProductionCount() {
        return productionCount;
    }

    public static void setProductionCount(int productionCount) {
        Electronic.productionCount = productionCount;
    }

    public LocalDateTime getDateOfMade() {
        return dateOfMade;
    }

    public void setDateOfMade(LocalDateTime dateOfMade) {
        this.dateOfMade = dateOfMade;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Electronic that = (Electronic) o;

        if (!Objects.equals(productNo, that.productNo)) return false;
        if (!Objects.equals(dateOfMade, that.dateOfMade)) return false;
        if (!Objects.equals(modelName, that.modelName)) return false;
        if (company != that.company) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(authMethods, that.authMethods);
    }

    @Override
    public int hashCode() {
        int result = productNo != null ? productNo.hashCode() : 0;
        result = 31 * result + (dateOfMade != null ? dateOfMade.hashCode() : 0);
        result = 31 * result + (modelName != null ? modelName.hashCode() : 0);
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(authMethods);
        return result;
    }


    @Override
    public String toString() {
        return "Electronic{" +
                "productNo=" + productNo +
                ", dateOfMade=" + dateOfMade +
                ", modelName='" + modelName + '\'' +
                ", company=" + company +
                ", authMethods=" + Arrays.toString(authMethods) +
                '}';
    }

}
