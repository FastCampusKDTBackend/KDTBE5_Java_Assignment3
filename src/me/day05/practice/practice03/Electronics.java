package me.day05.practice03;

import me.day05.practice01.AuthMethod;
import me.day05.practice01.Company;
import me.day05.practice01.Electronic;

import java.util.ArrayList;
import java.util.Arrays;

public class Electronics {
    private static final int DEFAULT_CAPACITY = 10;
    private static Electronics instance;
    private Electronic[] electronicList;

    private int size, capacity;

    private Electronics() {
        this.electronicList = new Electronic[DEFAULT_CAPACITY];
        capacity = DEFAULT_CAPACITY;
        size = 0;
    }

    //실습3-1. Electronics 클래스의 객체를 싱글톤으로 생성하는 함수를 작성하시오.
    public static Electronics getInstance() {
        if (instance == null) {
            instance = new Electronics();
        }

        return instance;
    }
    //

    //region Getter / Setter
    public Electronic[] getElectronicList() {
        return electronicList;
    }

    public void setElectronicList(Electronic[] electronicList) {
        this.electronicList = electronicList;
    }
    //endregion

    //region hashCode & equals / toString
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
        String toStr = "";
        for (int i = 0; i < size; i++) {
            toStr += electronicList[i];
        }

        return toStr;
    }
    //endregion

    //실습3-2. 전자제품 일련번호 productNo를 통해 인자로 주어진 일련번호에 해당하는 전자제품을 반환하는 함수를 작성하시오.
    public Electronic findByProductNo(String productNo) {
        for (Electronic electronic : electronicList) {
            if (electronic.getProductNo().equals(productNo)) return electronic;
        }

        return null;
    }
    //

    //실습3-3. 전자제품들 중 인자로 주어진 제조 회사를 찾아서 하나의 배열에 반환하는 함수를 작성하시오.
    public Electronic[] groupByCompanyName(Company company) {
        ArrayList<Electronic> findList = new ArrayList<>();

        for (Electronic electronic : electronicList) {
            if (electronic == null) continue;

            if (electronic.getCompanyName() == company) findList.add(electronic);
        }

        if (findList.size() == 0) return null;

        return findList.toArray(new Electronic[findList.size()]);
    }
    //

    //실습3-4. 전자제품들 중 인자로 주어진 인증 방법을 찾아서 하나의 배열에 반환하는 함수를 작성하시오.
    public Electronic[] groupByAuthMethod(AuthMethod authMethod) {
        ArrayList<Electronic> findList = new ArrayList<>();

        for (Electronic electronic : electronicList) {
            if (electronic == null) continue;

            for (AuthMethod auth : electronic.getAuthMethod()) {
                if (auth == authMethod) findList.add(electronic);
            }
        }

        if (findList.size() == 0) return null;

        return findList.toArray(new Electronic[findList.size()]);
    }
    //

    public void add(Electronic electronic) {
        if (size < capacity) {
            electronicList[size] = electronic;
            size++;
        } else {
            grow();
            add(electronic);
        }
    }

    private void grow() {
        capacity *= 2;
        electronicList = Arrays.copyOf(electronicList, capacity);
    }
}
