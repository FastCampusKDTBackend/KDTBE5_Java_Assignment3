package me.day05.practice;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class Electronic {

    enum COMPANYNAME{
        SAMSUNG,
        LG,
        APPLE
    }

    enum AUTHMETHOD{
        지문인증,
        패턴인증,
        핀인증,
        얼굴인증
    }

    private AUTHMETHOD[] arrAuth;
    private COMPANYNAME companyName;
    private String dateOfMade;
    private String productNo;
    private String modelName;
    private static int productNum = 0;

    public Electronic(){ //일련번호 부여
        init();
    }

    private void init(){

        createSerialNum();
    }

    private void createSerialNum(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%02d",LocalDate.now().getYear() % 100));
        sb.append(String.format("%02d" ,LocalDate.now().getMonth().getValue()));
        sb.append(String.format("%02d", LocalDate.now().getDayOfMonth()));
        sb.append(String.format("%04d", ++productNum));
        productNo = sb.toString();

//        String year = String.format("%02d",LocalDate.now().getYear() % 100);
//        String month = String.format("%02d" ,LocalDate.now().getMonth().getValue());
//        String day = String.format( "%02d", LocalDate.now().getDayOfMonth());
//        String num = String.format("%04d", ++productNum);
//        productNo = year + month + day + num;
//
        System.out.println(productNo);
    }

    @Override
    public String toString() {
        return "Electronic{" +
                "arrAuth=" + Arrays.toString(arrAuth) +
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
        return Arrays.equals(arrAuth, that.arrAuth) && Objects.equals(dateOfMade, that.dateOfMade) && Objects.equals(productNo, that.productNo) && Objects.equals(modelName, that.modelName);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(dateOfMade, productNo, modelName);
        result = 31 * result + Arrays.hashCode(arrAuth);
        return result;
    }

    public COMPANYNAME getCompanyName() {
        return companyName;
    }

    public void setCompanyName(COMPANYNAME companyName) {
        this.companyName = companyName;
    }

    public AUTHMETHOD[] getArrAuth() {
        return arrAuth;
    }

    public void setArrAuth(AUTHMETHOD[] arrAuth) {
        this.arrAuth = arrAuth;
    }

    public String getDateOfMade() {
        return dateOfMade;
    }

    public void setDateOfMade(String dateOfMade) {
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
