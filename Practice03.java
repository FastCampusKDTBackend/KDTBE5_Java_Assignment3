package me.day05.practice.practice03;

import me.day05.practice.practice01.AuthMethod;
import me.day05.practice.practice01.Electronic;
import me.day05.practice.practice01.Company;

import java.util.ArrayList;
import java.util.List;

public class Electronics {
    //1.Electronics 클래스의 객체를 싱글톤으로 생성하는 함수를 작성하시오.
    private Electronic[] electronicList;
    private static Electronics electronics;
    public static Electronics getInstance(){
        if(electronics == null)
            electronics = new Electronics();
        return electronics;
    }
    //2.전자제품 일련번호 productNo를 통해 인자로 주어진 일련번호에 해당하는 전자제품을 반환하는 함수를 작성하시오.
    public Electronic findByProductNo(String productNo){
        for(int i =0; i < electronicList.length; i++) {
            if(electronicList[i].getProductNo() == productNo)
                return electronicList[i];
        }
        return null;
    }
    //3.전자제품들 중 인자로 주어진 제조 회사를 찾아서 하나의 배열에 반환하는 함수를 작성하시오.
    public Electronic[] groupByCompanyName(Company company) {
        List<Electronic> electronics = new ArrayList<>();
        for (Electronic electronic : electronicList) {
            if (electronic.getCompanyName() == company) {
                electronics.add(electronic);
            }
        }
        return electronics.toArray(new Electronic[electronics.size()]);
    }
    //4.전자제품들 중 인자로 주어진 인증 방법을 찾아서 하나의 배열에 반환하는 함수를 작성하시오.
    public Electronic[] groupByAuthMethod(AuthMethod authMethod){
        List<Electronic> groupAuthList = new ArrayList<>();
        for(Electronic electronic : electronicList) {
            if(electronic.getAuthMethod().equals(authMethod)) {
                groupAuthList.add(electronic);
            }
        }
        return groupAuthList.toArray((new Electronic[groupAuthList.size()]));
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