package me.day05.practice.practice03;
import me.day05.practice.practice01.AuthMethod;
import me.day05.practice.practice01.Company;
import me.day05.practice.practice01.Electronic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Electronics {
    private  Electronic[] electronicList;

    //1.Electronics 클래스의 객체를 싱글톤으로 생성하는 함수를 작성하시오.
    private static Electronics instance;
    private Electronics() {};

    public static Electronics getInstance() {
        if(instance == null) {
            instance = new Electronics();
        }
        return instance;
    }

    //2.전자제품 일련번호 productNo를 통해 인자로 주어진 일련번호에 해당하는 전자제품을 반환하는 함수를 작성하시오.
    public Electronic findByProductNo(String productNo) {
        return Arrays.stream(electronicList)
                .filter(electronic -> electronic.getProductNo().equals(productNo))
                .findFirst()
                .orElse(null);
    }


    //3.전자제품들 중 인자로 주어진 제조 회사를 찾아서 하나의 배열에 반환하는 함수를 작성하시오.
    public Electronic[] groupByCompanyName(Company company) {
        List<Electronic> groupCompanyList = new ArrayList<>();
        for (Electronic electronic : electronicList) {
            if (electronic.getCompanyName().equals(company)) {
                groupCompanyList.add(electronic);
            }

        }
        return groupCompanyList.toArray(new Electronic[groupCompanyList.size()]);
    }




    //4. 전자제품들 중 인자로 주어진 인증 방법을 찾아서 하나의 배열에 반환하는 함수를 작성하시오.
    public Electronic[] groupByAuthMethod(AuthMethod authMethod){
        List<Electronic> groupAuthList = new ArrayList<>();
        for (Electronic electronic : electronicList) {
            for (AuthMethod electronicAuthMethod : electronic.getAuthMethod()) {
                if (electronicAuthMethod.equals(authMethod)) {
                    groupAuthList.add(electronic);
                    break;
                }
            }
        }
        return groupAuthList.toArray(new Electronic[0]);
    }



    public Electronic[] getElectronicList() {
        return electronicList;
    }

    public void setElectronicList(Electronic[] electronicList) {
        this.electronicList = electronicList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Electronics that = (Electronics) o;
        return Arrays.equals(electronicList, that.electronicList);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(electronicList);
    }

    @Override
    public String toString() {
        return "{" +
                "electronicList=" + Arrays.toString(electronicList) +
                '}';
    }
}
