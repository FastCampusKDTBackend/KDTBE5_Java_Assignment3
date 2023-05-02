package me.day05.practice;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class Electronic {

    private Defines.AuthMethod[] authMethods;
    private Defines.CompanyName companyName;
    private LocalDate dateOfMade;
    private String productNo;
    private String modelName;
    private static int productNum = 0;
    private StringBuilder sb;

    public Electronic(){ //일련번호 부여
        init();
    }

    private void init(){
        sb = new StringBuilder();
        createSerialNum();
    }

    private void createSerialNum(){
        sb.append(String.format("%02d",LocalDate.now().getYear() % 100));
        sb.append(String.format("%02d" ,LocalDate.now().getMonthValue()));
        sb.append(String.format("%02d", LocalDate.now().getDayOfMonth()));
        sb.append(String.format("%04d", ++productNum));
        productNo = sb.toString();
    }

    @Override
    public String toString() {
        return "Electronic{" +
                "arrAuth=" + Arrays.toString(authMethods) +
                ", companyName=" + companyName +
                ", dateOfMade='" + dateOfMade + '\'' +
                ", productNo='" + productNo + '\'' +
                ", modelName='" + modelName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Electronic that = (Electronic) o;
        return Arrays.equals(authMethods, that.authMethods) && Objects.equals(dateOfMade, that.dateOfMade) && Objects.equals(productNo, that.productNo) && Objects.equals(modelName, that.modelName);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(dateOfMade, productNo, modelName);
        result = 31 * result + Arrays.hashCode(authMethods);
        return result;
    }

    public Defines.CompanyName getCompanyName() {
        return companyName;
    }

    public void setCompanyName(Defines.CompanyName companyName) {
        this.companyName = companyName;
    }

    public Defines.AuthMethod[] getArrAuth() {
        return authMethods;
    }

    public void setArrAuth(Defines.AuthMethod[] authMethods) {
        this.authMethods = authMethods;
    }

    public LocalDate getDateOfMade() {
        return dateOfMade;
    }

    public void setDateOfMade(LocalDate dateOfMade) {
        this.dateOfMade = dateOfMade;
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

    public static int getProductNum() {
        return productNum;
    }

    public static void setProductNum(int productNum) {
        Electronic.productNum = productNum;
    }
}
