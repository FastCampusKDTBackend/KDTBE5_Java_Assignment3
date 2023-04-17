package me.day05.practice.Practice03;

import me.day05.practice.Practice01.Electronic;
import me.day05.practice.Practice01.Electronic.AuthMethod;
import me.day05.practice.Practice01.Electronic.Company;

import java.util.Arrays;

public class Electronics {
	// 문제1. Electronics 클래스의 객체를 싱글톤으로 생성하기 위한 필드, 메서드
	private static Electronics electronics;  // Electronics 클래스의 객체를 싱글톤으로 생성하기 위해 사용하는 변수
    public static Electronics getInstance() {
        // 객체가 생성되어 있지 않으면 객체를 생성하여 변수에 할당
        if (electronics == null) {
            electronics = new Electronics();
        }
        return electronics;
    }
    
    private Electronic[] electronicList; // 생성된 전자제품 객체들을 모두 저장
    private int idx = 0;  // 배열 idx
    
    // 전자제품 리스트의 getter
    public Electronic[] getElectronicList() {
        return electronicList;
    }
    
    // 전자제품 리스트의 setter
    public void setElectronicList(Electronic[] electronicList) {
        this.electronicList = electronicList;
    }

    // 문제2. 전자제품 일련번호를 통해 해당하는 전자제품을 반환하는 메서드
    public Electronic findByProductNo(String productNo) {
        for (int i = 0; i < electronicList.length; i++) {
            if (electronicList[i].getProductNo().equals(productNo)) {
                return electronicList[i];
            }
        }
        return null;
    }

    // 문제3. 제조회사를 기준으로 전자제품들을 그룹화하여 배열에 반환하는 메서드
    public Electronic[] groupByCompanyName(Company company) {
        Electronic[] groupByCompanyElectronic = new Electronic[idx];
        int count = 0;
        for (int i = 0; i < electronicList.length; i++) {
            if (electronicList[i].getCompanyName().equals(company)) {
                groupByCompanyElectronic[count] = electronicList[i];
            }
        }

        return Arrays.copyOf(groupByCompanyElectronic, count);
    }

    // 문제4. 인증 방법을 기준으로 전자제품들을 그룹화하여 배열에 반환하는 메서드
    public Electronic[] groupByAuthMethod(AuthMethod authMethod) {
        Electronic[] groupByCompanyElectronic = new Electronic[idx];
        int count = 0;
        for (int i = 0; i < electronicList.length; i++) {
            if (electronicList[i].getAuthMethod().equals(authMethod)) {
                groupByCompanyElectronic[count] = electronicList[i];
            }
        }

        return Arrays.copyOf(groupByCompanyElectronic, count);
    }


    // 전자제품을 리스트에 추가하는 메서드
    public void add(Electronic electronic) {
    	electronicList[idx] = electronic;
    	idx++;
    }
    

    // hashCode 재정의
    @Override
    public int hashCode() {
        return Arrays.hashCode(electronicList);
    }
    
    // equals 재정의
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Electronics that = (Electronics) o;
        return electronicList.equals(that.electronicList);
    }

    // toString 재정의
    @Override
    public String toString() {
        return "Electronics{" +
                "electronicList=" + electronicList +
                '}';
    }
}
