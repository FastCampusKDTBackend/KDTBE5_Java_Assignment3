package me.day05.practice.Practice03;

import me.day05.practice.Practice01.AuthMethod;
import me.day05.practice.Practice01.Company;
import me.day05.practice.Practice01.Electronic;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Electronics {

    private static Electronics usersInstance;

    private Electronics(){
    }

    private  Electronic[] electronicList;

    private static int modelCount = 0;

    private String productNo;
    private String modelName;
    private Company companyName;
    private LocalDate dateOfMade;
    private ArrayList<AuthMethod> authMethod = new ArrayList<>();


    public Electronics(String modelName, Company companyName, AuthMethod auth) {
        this.productNo = setProductNo();
        this.modelName = modelName;
        this.companyName = companyName;
        this.dateOfMade = setDateOfMade();
        authMethod.add(auth);
    }


    public static int getModelCount() {
        return modelCount;
    }

    public static void setModelCount(int modelCount) {
        Electronics.modelCount = modelCount;
    }

    public String getProductNo() {
        return productNo;
    }


    public String setProductNo() {
        modelCount++;
        LocalDate now = LocalDate.now();
        String productNo = now.format(DateTimeFormatter.ofPattern("YYMMdd"));
        productNo += String.format("%04d", modelCount);
        return productNo;
    }

    private LocalDate setDateOfMade() {
        LocalDate now = LocalDate.now();
        return now;
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

    public LocalDate getDateOfMade() {
        return dateOfMade;
    }

    public void setDateOfMade(LocalDate dateOfMade) {
        this.dateOfMade = dateOfMade;
    }

    public ArrayList<AuthMethod> getAuthMethod() {
        return authMethod;
    }

    public void setAuthMethod(AuthMethod auth) {
        authMethod.add(auth);
    }

    public Electronic[] getElectronicList() {
        return electronicList;
    }

    public void setElectronicList(Electronic[] electronicList) {
        this.electronicList = electronicList;
    }



    //1. 싱글톤
    public static Electronics getInstance() {
        if(usersInstance==null) {
            usersInstance = new Electronics();
        }
        return usersInstance;
    }

    //2. 함수 반환
    public Electronic findByProductNo(String productNo){
        for(Electronic electronic : electronicList) {
            if(electronic.getProductNo().equals(productNo)){
                return electronic;
            }
        }
        return null;
    }


    //3. 제조 회사
    public Electronic[] groupByCompanyName(Company company) {
         List<Electronic> groupCompanyList = new ArrayList<>();
             for (Electronic electronic : electronicList) {
                  if (electronic.getCompanyName().equals(company)) {
                    groupCompanyList.add(electronic);
                   }

             }
             return groupCompanyList.toArray(new Electronic[groupCompanyList.size()]);
    }


    //4. 인증 방법

    public Electronic[] groupByAuthMethod(AuthMethod authMethod) {
        List<Electronic> groupAuthMethod = new ArrayList<>();
        for (Electronic electronic : electronicList) {
            if (electronic.getAuthMethod().equals(authMethod)) {
                groupAuthMethod.add(electronic);
            }

        }
        return groupAuthMethod.toArray(new Electronic[groupAuthMethod.size()]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Electronics that = (Electronics) o;
        return productNo.equals(that.productNo) && modelName.equals(that.modelName) && companyName.equals(that.companyName) && dateOfMade.equals(that.dateOfMade) && authMethod.equals(that.authMethod);
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
                ", companyName='" + companyName + '\'' +
                ", dateOfMade=" + dateOfMade +
                ", authMethod=" + authMethod +
                '}';
    }

}
