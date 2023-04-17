package me.day05.practice.Practice03;


import me.day05.practice.Practice01.Auth;
import me.day05.practice.Practice01.Company;
import me.day05.practice.Practice01.Electronic;

import java.util.ArrayList;
import java.util.Objects;

public class Electronics {
    private ArrayList<Electronic> electronicList = new ArrayList<>();

    public Electronics(ArrayList<Electronic> electronicList) {
        this.electronicList = electronicList;
    }

    public Electronics() {}
    public ArrayList<Electronic> getElectronicList() {
        return electronicList;
    }

    public void setElectronicList(ArrayList<Electronic> electronicList) {
        this.electronicList = electronicList;
    }

    public static void setInstance(Electronics instance) {
        Electronics.instance = instance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Electronics that = (Electronics) o;
        return Objects.equals(electronicList, that.electronicList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(electronicList);
    }

    @Override
    public String toString() {
        return "Electronics{" +
                "electronicList=" + electronicList +
                '}';
    }

    // Electric 클래스의 객체를 싱글톤으로 생성하는 함수를 작성하시오.
    private static Electronics instance;
    public static Electronics getInstance() {
        if (instance == null) {
            instance = new Electronics();
        }
        return instance;
    }

    //전자제품 일련번호 productNo를 통해 인자로 주어진 일련번호에 해당하는 전자제품을 반환하는 함수를 작성하시오.
    public Electronic findByUserId(String productNo){
        for (Electronic electronic : electronicList){
            if(electronic.setProductNO().equals(productNo)){
                return electronic;
            }
        }
        return null;
    }
    // 전자제품들 중 인자로 주어진 제조 회사를 찾아서 하나의 배열에 반환하는 함수를 작성하시오.
    public ArrayList<Electronic> groupByCompanyName(Company company) {
        ArrayList<Electronic> companyName = new ArrayList<>();

        for(int i = 0; i < electronicList.size(); i++) {
            if(electronicList.get(i).getCompanyName().equals(company)) {
                companyName.add(electronicList.get(i));
            }
        }
        return companyName;
    }
    //전자제품들 중 인자로 주어진 인증 방법을 찾아서 하나의 배열에 반환하는 함수를 작성하시오.
    public ArrayList<Electronic> groupByAuthMethod(Auth[] authMethod) {
        ArrayList<Electronic> authMethodGroupList = new ArrayList<>();

        for(int i = 0; i < electronicList.size(); i++) {
            if(electronicList.get(i).getAuthMethod().equals(authMethod)) {
                authMethodGroupList.add(electronicList.get(i));
            }
        }
        return authMethodGroupList;
    }
}

