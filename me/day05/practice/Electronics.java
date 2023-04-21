package me.day05.practice;

import me.day05.practice.Electronic.AuthMethod;
import me.day05.practice.Electronic.CompanyName;

import java.util.*;

public class Electronics {

    private static final Electronic[] EMPTY_ELECTRONIC_LIST = {};

    private static Electronic[] electronicList;
    private static Electronics electronicsInstance;

    private int size;
    private int capacity;

    private Electronics(){
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

        List<Electronic> temp = new ArrayList<>();

        for (Electronic electronic : electronicList)
            if (electronic.getCompanyName().equals(company))
                temp.add(electronic);

        Electronic[] companyNameGroup =
                temp.isEmpty() ? null : listToArray(temp);

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

        List<Electronic> temp = new ArrayList<>();

        for (Electronic electronic : electronicList)
            if (electronic.isContainsAuthMethod(authMethod))
                temp.add(electronic);

        Electronic[] authMethodNameGroup =
                temp.isEmpty() ? null : listToArray(temp);

        return Optional.ofNullable(authMethodNameGroup);
    }

    private Electronic[] listToArray(List<Electronic> list){
        Electronic[] array = new Electronic[list.size()];

        for (int i = 0; i < array.length; i++)
            array[i] = list.get(i);

        return array;
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
}
