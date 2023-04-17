package me.day05.practice.Practice03;

import me.day05.practice.Practice01.AuthMethod;
import me.day05.practice.Practice01.Company;
import me.day05.practice.Practice01.Electronic;

import java.util.Arrays;
import java.util.Objects;

public class Electronics {

    Electronic[] electronicList;    //생성된 Electronic 객체들을 모두 저장

    //1.Electronics 클래스의 객체를 싱글톤으로 생성하는 함수를 작성하시오.
    private static Electronics instance;

    private Electronics() {
    }

    private Electronics getInstance() {
        if (!(instance == null)) return instance = new Electronics();
        return instance;
    }

    //2.전자제품 일련번호 productNo를 통해 인자로 주어진 일련번호에 해당하는 전자제품을 반환하는 함수를 작성하시오.
    public Electronic findByProductNo(String productNo) {
        for (Electronic electronic : electronicList) {
            if (electronic.getProductNo().equals(productNo))
                return electronic;
        }
        return null;
    }

    //3.전자제품들 중 인자로 주어진 제조 회사를 찾아서 하나의 배열에 반환하는 함수를 작성하시오.
    public Electronic[] groupByCompanyName(Company company) {
        Electronic[] companyOfProduct = new Electronic[electronicList.length];

        int j = 0;
        for (int i = 0; i < electronicList.length; i++) {
            if (electronicList[i].getCompanyName().equals(company)){
                companyOfProduct[j] = electronicList[i];
                j++;
            }
        }
        return companyOfProduct;
    }

    //4.전자제품들 중 인자로 주어진 인증 방법을 찾아서 하나의 배열에 반환하는 함수를 작성하시오.
    public Electronic[] groupByAuthMethod(AuthMethod authMethod) {
        Electronic[] authMethodOfProduct = new Electronic[electronicList.length];

        int j = 0;
        for (int i = 0; i < electronicList.length; i++) {
            if (electronicList[i].getAuthMethod().equals(authMethod)){
                authMethodOfProduct[j] = electronicList[i];
                j++;
            }
        }
        return authMethodOfProduct;
    }

    @Override
    public int hashCode() {
        return Objects.hash(electronicList);
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Electronics)) return false;

        Electronics list = (Electronics) obj;
        return Arrays.equals(this.electronicList, list.electronicList);
    }

    @Override
    public String toString() {
        return "electronicList{" + Arrays.toString(electronicList) + "}";
    }

    //getter&setter
    public Electronic[] getElectronicList() {
        return electronicList;
    }

    public void setElectronicList(Electronic[] electronicList) {
        this.electronicList = electronicList;
    }
}
