package me.day05.practice.Practice03;

import me.day05.practice.Practice01.Auth;
import me.day05.practice.Practice01.Company;
import me.day05.practice.Practice01.Electronic;

import java.util.Arrays;
import java.util.Objects;

/**
 *
 *  - 객체 배열 `Electronic[] electronicList`를 필드로 가지고 있는 `Electronics`클래스를 작성하시오.
 *     - 필드 - Electronic[] electronicList (생성된 Electronic 객체들을 모두 저장)
 *     - 메소드 - 생성자, getter(), setter(), hashCode(), equals(), toString()
 * - `Electronics` 클래스를 통해 아래의 문제를 해결해보세요.
 *     1. `Electronics` 클래스의 객체를 싱글톤으로 생성하는 함수를 작성하시오.
 *
 *         ```java
 *         Electronic getInstance();
 *         ```
 *
 *     2. 전자제품 일련번호 `productNo`를 통해 인자로 주어진 일련번호에 해당하는 전자제품을 반환하는 함수를 작성하시오.
 *
 *         ```java
 *         Electronic findByProductNo(String productNo);
 *         ```
 *
 *     3. 전자제품들 중 인자로 주어진 제조 회사를 찾아서 하나의 배열에 반환하는 함수를 작성하시오.
 *
 *         ```java
 *         Electronic[] groupByCompanyName(Company company);
 *         ```
 *
 *     4. 전자제품들 중 인자로 주어진 인증 방법을 찾아서 하나의 배열에 반환하는 함수를 작성하시오.
 *
 *
 */
public class Electronics {
    private static Electronics instance;
    private static Electronics electronics;
    private static final int DEFAULT_CAPACITY = 10;
    private Electronic[] electronicList;
    private int size = 0;
    private int capacity = 0;

    private Electronics() {
        this.electronicList = new Electronic[DEFAULT_CAPACITY];
    }

    public void add(Electronic electronic) {
        if (size == capacity) {
            increase();
            add(electronic);
        } else {
            electronicList[size++] = electronic;
        }
    }

    private void increase() {
        if (capacity < DEFAULT_CAPACITY) {
            capacity = DEFAULT_CAPACITY;
        } else {
            capacity = size * 2;
        }
        copy();
    }
    private void copy() {
        electronicList = Arrays.copyOf(electronicList, this.capacity);
    }

    public static Electronics getInstance() {
        if (instance == null) {
            instance = new Electronics();
        }
        return instance;
    }

    public Electronic[] getElectronicList() {
        return electronicList;
    }

    public void setElectronicList(Electronic[] electronicList) {
        this.electronicList = electronicList;
    }

    public Electronic findByProductNo(String productNo) {
        for (Electronic electronic : electronicList) {
            if (electronic.getProductNo().equals(productNo)) {
                return electronic;
            }
        }
        return null;
    }

    public Electronic[] groupByCompanyName(Company company) {
        Electronic[] groupByCompanyElectronic = new Electronic[size];
        int count = 0;
        for (int i = 0; i < electronicList.length; i++) {
            if (electronicList[i].getCompanyName().equals(company)) {
                groupByCompanyElectronic[count] = electronicList[i];
            }
        }
        return Arrays.copyOf(groupByCompanyElectronic, count);
    }

    public Electronic[] groupByAuthMethod(Auth authMethod) {
        Electronic[] groupByCompanyElectronic = new Electronic[size];
        int count = 0;
        for (int i = 0; i < electronicList.length; i++) {
            if (electronicList[i].getAuthMethods().equals(authMethod)) {
                groupByCompanyElectronic[count] = electronicList[i];
            }
        }

        return Arrays.copyOf(groupByCompanyElectronic, count);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Electronics that = (Electronics) o;
        return size == that.size && capacity == that.capacity && Arrays.equals(electronicList, that.electronicList);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size, capacity);
        result = 31 * result + Arrays.hashCode(electronicList);
        return result;
    }

    @Override
    public String toString() {
        return "Electronics{" +
                "electronicList=" + Arrays.toString(electronicList) +
                ", size=" + size +
                ", capacity=" + capacity +
                '}';
    }
}
