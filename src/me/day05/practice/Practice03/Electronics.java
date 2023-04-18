package me.day05.practice.Practice03;

import me.day05.practice.Practice01.AuthMethod;
import me.day05.practice.Practice01.CompanyName;
import me.day05.practice.Practice01.Electronic;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Electronics {
    private static Electronic[] electronicList;
    private Electronics() {
    }

    private static Electronics instance;

    //3-1 Electronics 클래스의 객체를 싱글톤으로 생성하는 함수를 작성
    public static Electronics getInstance() {
        if (instance == null) {
            instance = new Electronics();
        }
        return instance;
    }

    public static Electronic[] getElectronicList() {
        return electronicList;
    }

    public static void setElectronicList(Electronic[] electronicList) {
        Electronics.electronicList = electronicList;
    }

    //3-2 productNo를 통해 인자로 주어진 일련번호에 해당하는 전자제품을 반환하는 함수를 작성
    public Electronic findByProductNo(String productNo) {
        for (Electronic electronic : electronicList) {
            if (electronic.getProductNo().equals(productNo)) {
                return electronic;
            }
        }
        throw new IllegalArgumentException("Not found");
    }

    //3-3 제조 회사를 찾아서 하나의 배열에 반환하는 함수를 작성
    public Electronic[] groupByCompanyName(CompanyName company) {
        List<Electronic> electronics = new ArrayList<>();
        for (Electronic electronic : electronicList) {
            if (electronic.getCompanyName().equals(company)) {
                electronics.add(electronic);
            }
        }

        return electronics.toArray(new Electronic[electronics.size()]);
    }


    //3-4 주어진 인증 방법을 찾아서 하나의 배열에 반환하는 함수를 작성
    public Electronic[] groupByAuthMethod(AuthMethod authMethod){
        List<Electronic> groupAuthList = new ArrayList<>();
        for (Electronic electronic : electronicList) {
            if (electronic.getAuthMethod().equals(authMethod)) {
                groupAuthList.add(electronic);
            }
        }
        return groupAuthList.toArray((new Electronic[groupAuthList.size()]));
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Electronics electronics = (Electronics) obj;
        return Arrays.equals(electronicList, electronics.electronicList);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(electronicList);
    }

    @Override
    public String toString() {
        return "{" + "userList=" + Arrays.toString(electronicList) + "}";
    }
}