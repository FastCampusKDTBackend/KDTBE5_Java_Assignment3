package me.day05.practice.Practice01;

import me.day05.practice.AuthMethod;
import me.day05.practice.Company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Electronic {
    private static int productCnt=1;
    private String productNo;
    private String modelName;
    private Company companyName;
    private String dateOfMade;
    private List<AuthMethod> authMethod;

    public Electronic() {
        this.productNo=setProductNo();
        this.authMethod=new ArrayList<AuthMethod>();
    }

    public Electronic(String modelName, Company companyName, String dateOfMade, List<AuthMethod> authMethod) {
        this.productNo=setProductNo();
        this.modelName = modelName;
        this.companyName = companyName;
        this.dateOfMade = dateOfMade;
        this.authMethod = authMethod;
    }

    private String setProductNo(){
        productCnt=(productCnt>9999)?1:productCnt;    // productCnt 9999 넘어가면 1로 초기화
        String day=LocalDate.now().format(DateTimeFormatter.ofPattern("yyMMdd"));
        String regNum=String.format("%04d", (productCnt++));
        return day+regNum;
    }

    public static int getProductCnt() {
        return productCnt;
    }

    public static void setProductCnt(int productCnt) {
        Electronic.productCnt = productCnt;
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

    public List<AuthMethod> getAuthMethod() {
        return authMethod;
    }

    public void setAuthMethod(List<AuthMethod> authMethod) {
        this.authMethod = authMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Electronic that = (Electronic) o;
        return Objects.equals(productNo, that.productNo) && Objects.equals(modelName, that.modelName) && companyName == that.companyName && Objects.equals(dateOfMade, that.dateOfMade) && Objects.equals(authMethod, that.authMethod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productNo, modelName, companyName, dateOfMade, authMethod);
    }

    @Override
    public String toString() {
        return "Electronic{" +
                "productNo='" + productNo + '\'' +
                ", modelName='" + modelName + '\'' +
                ", companyName=" + companyName +
                ", dateOfMade='" + dateOfMade + '\'' +
                ", authMethod=" + authMethod +
                '}';
    }
}
