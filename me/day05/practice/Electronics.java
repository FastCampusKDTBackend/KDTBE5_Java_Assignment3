package me.day05.practice;

import me.day05.practice.Electronic.AuthMethod;
import me.day05.practice.Electronic.CompanyName;

import java.util.*;

public class Electronics {

    private static final int DEFAULT_CAPACITY = 10; // Default initial capacity

    private static final Electronic[] EMPTY_ELECTRONIC_LIST = {};

    private static Electronic[] electronicList;

    private static Electronics electronicsInstance;

    private int size;

    private int capacity;

    Electronics(){
        electronicList = EMPTY_ELECTRONIC_LIST;
    }

    // TODO: 1. Electronics 클래스의 객체를 싱글톤으로 생성하는 함수를 작성하시오.
    public static Electronics getInstance() {
        if (electronicsInstance == null) electronicsInstance = new Electronics();
        return electronicsInstance;
    }

    // TODO: 2. 전자제품 일련번호 productNo를 통해 인자로 주어진 일련번호에 해당하는 전자제품을 반환하는 함수를 작성하시오.
    public Optional<Electronic> findByProductNo(String productNo){
        for (Electronic electronic : electronicList)
            if (productNo.equals(electronic.getProductNo()))
                return Optional.of(electronic);

        return Optional.empty();
    }

    // TODO: 3. 전자제품들 중 인자로 주어진 제조 회사를 찾아서 하나의 배열에 반환하는 함수를 작성하시오.
    public Optional<Electronic[]> groupByCompanyName(CompanyName company){
        Electronic[] companyNameGroup = null;

        List<Electronic> temp = new ArrayList<>();

        for (Electronic electronic : electronicList)
            // 테스트용 임시 조건 ( electronic != null )
            if (electronic != null && electronic.getCompanyName().equals(company))
                temp.add(electronic);

        if (!temp.isEmpty()) {
            companyNameGroup = new Electronic[temp.size()];
            for (int i = 0; i < companyNameGroup.length; i++)
                companyNameGroup[i] = temp.get(i);
        }

        return Optional.ofNullable(companyNameGroup);
    }

    public Optional<Electronic> findByCompanyName(CompanyName company){
        for (Electronic electronic : electronicList)
            if (company.equals(electronic.getCompanyName()))
                return Optional.of(electronic);

        return Optional.empty();
    }

    // TODO: 4. 전자제품들 중 인자로 주어진 인증 방법을 찾아서 하나의 배열에 반환하는 함수를 작성하시오.
    public Optional<Electronic[]> groupByAuthMethod(AuthMethod authMethod){
        Electronic[] authMethodNameGroup = null;

        List<Electronic> temp = new ArrayList<>();

        for (Electronic electronic : electronicList)
            // 테스트용 임시 조건 ( electronic != null )
            if (electronic != null && electronic.isContainAuthMethod(authMethod))
                temp.add(electronic);

        if (!temp.isEmpty()) {
            authMethodNameGroup = new Electronic[temp.size()];
            for (int i = 0; i < authMethodNameGroup.length; i++)
                authMethodNameGroup[i] = temp.get(i);
        }

        return Optional.ofNullable(authMethodNameGroup);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(electronicList), size, capacity);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        return Objects.equals(hashCode(), ((Electronics)obj).hashCode());
    }

    @Override
    public String toString() {
        return "Users { " +
                "size=" + size +
                ", capacity=" + capacity +
                ", electronicList= " + Arrays.toString(electronicList) + " }";
    }

    //==================================== TEST CODE ====================================//
    public void add (Electronic electronic) {
        if (electronicList == EMPTY_ELECTRONIC_LIST)
            electronicList = new Electronic[DEFAULT_CAPACITY];
        /* 배열 크기 체크하고 늘리는 로직 구현 할 것 */
        electronicList[size++] = electronic;
    }

    public static void main(String[] args) {
        Electronic iPhone13 = new Electronic("아이폰13", CompanyName.APPLE, new AuthMethod[]{AuthMethod.FACE, AuthMethod.PIN, AuthMethod.PATTERN});
        Electronic iPhone12 = new Electronic("아이폰12", CompanyName.APPLE, new AuthMethod[]{AuthMethod.FACE, AuthMethod.PIN, AuthMethod.PATTERN});
        Electronic galaxyS22 = new Electronic("갤럭시S22", CompanyName.SAMSUNG, new AuthMethod[]{AuthMethod.FINGERPRINT, AuthMethod.PIN, AuthMethod.PATTERN});

        Electronics electronics = getInstance();
        electronics.add(iPhone13);
        electronics.add(iPhone12);
        electronics.add(galaxyS22);

//        System.out.println(electronics);

        Optional<Electronic[]> authMethodGroupPIN = electronics.groupByAuthMethod(AuthMethod.FACE);
        authMethodGroupPIN.ifPresent(value -> System.out.println(Arrays.toString(value)));

        Optional<Electronic[]> companyNameGroupAPPLE = electronics.groupByCompanyName(CompanyName.SAMSUNG);
        companyNameGroupAPPLE.ifPresent(value -> System.out.println(Arrays.toString(value)));

    }
}
