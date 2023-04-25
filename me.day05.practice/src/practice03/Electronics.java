package practice03;

import practice01.AuthMethod;
import practice01.Company;
import practice01.Electronic;

import java.util.ArrayList;
import java.util.Arrays;

public class Electronics {

    private static Electronics electronics;
    private Electronic[] electronicList;
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private int capacity;

    public static Electronics getInstance() {
        if (electronics == null) {
            electronics = new Electronics();
        }
        return electronics;
    }

    private Electronics() {
        electronicList = new Electronic[DEFAULT_CAPACITY];
        this.capacity = DEFAULT_CAPACITY;
        this.size = 0;
    }

    public Electronic[] getElectronicList() {
        return electronicList;
    }

    public void setElectronicList(Electronic[] electronicList) {
        this.electronicList = electronicList;
    }

    public Electronic findByProductNo(String productNo) {

        if (productNo.isEmpty()) throw new NullPointerException();

        for (Electronic electronic : electronicList) {
            if (electronic == null) continue;
            if (electronic.getProductNo().equals(productNo)) return electronic;
        }
        return null;
    }

    public Electronic[] groupByCompanyName(Company company) {
        //Company 이름으로 검색 후 해당 조건에 맞는 데이터를 배열에 담아서 return
        ArrayList<Electronic> companyList = new ArrayList<>();

        //electronicList 배열에서 검색 조건인 company 와 일치하는 데이터를 ArrayList 에 add 한다.
        for (Electronic electronic : electronicList) {
            if (electronic == null) continue;
            if (electronic.getCompanyName().equals(company)) {
                companyList.add(electronic);
            }
        }
        //company로 groupBy한 결과가 있으면 결과를 반환, 아니면 null 반환
        if (companyList.isEmpty()) return null;

        //배열로 변환 후 return
        return companyList.toArray(new Electronic[companyList.size()]);
    }

    public Electronic[] groupByAuthMethod(AuthMethod authMethod) {
        //인증방법으로 검색 후 조건에 맞는 데이터를 배열로 만들어 반환
        ArrayList<Electronic> authList = new ArrayList<>();

        //인증방법은 electronicList 배열 내부에 배열형태로 담겨 있다.
        for (Electronic electronic : electronicList) {
            if (electronic == null) continue;

            //인증방법 배열을 순회하여 검색 조건 authMethod 에 맞는 데이터를 ArrayList 에 add 한다.
            for (AuthMethod auth : electronic.getAuthMethods()) {
                if (auth.equals(authMethod)) authList.add(electronic);
            }
        }
        //authMethod로 groupBy한 결과가 있으면 결과를 반환, 아니면 null 반환
        if (authList.isEmpty()) return null;

        //배열로 변환 후 return
        return authList.toArray(new Electronic[authList.size()]);
    }

    public void add(Electronic electronic) {
        if (size < capacity) {
            electronicList[size] = electronic;
            size++;
        } else {
            //배열의 size가 capacity 용량보다 크다면 배열의 capacity를 늘리고 add 메서드를 재귀적 호출한다.
            extendArray();
            add(electronic);
        }
    }

    private void extendArray() {
        capacity *= 2;
        electronicList = Arrays.copyOf(electronicList, capacity);
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
        return "Electronics{" +
                "electronicList=" + Arrays.toString(electronicList) +
                '}';
    }
}
