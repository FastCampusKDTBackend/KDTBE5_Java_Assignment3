package practice03;

import Practice01.Electronic;

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

    public Electronics() {
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

        if (productNo == null) return null;

        for (Electronic electronic : electronicList) {
            if (electronic == null) continue;
            if (electronic.getProductNo().equals(productNo)) return electronic;
        }
        return null;
    }

    public Electronic[] groupByCompanyName(Electronic.Company company) {
        ArrayList<Electronic> companyList = new ArrayList<>();

        for (Electronic electronic : electronicList) {
            if (electronic == null) continue;
            if (electronic.getCompanyName().equals(company)) {
                companyList.add(electronic);
            }
        }
        //company로 groupBy한 결과가 있으면 결과를 반환, 아니면 null 반환
        if (!companyList.isEmpty()) return companyList.toArray(new Electronic[companyList.size()]);
        return null;
    }

    public Electronic[] groupByAuthMethod(Electronic.AuthMethod authMethod) {
        ArrayList<Electronic> authList = new ArrayList<>();

        for (Electronic electronic : electronicList) {
            if (electronic == null) continue;

            for (Electronic.AuthMethod auth : electronic.getAuthMethods()) {
                if (auth.equals(authMethod)) authList.add(electronic);
            }
        }
        //authMethod로 groupBy한 결과가 있으면 결과를 반환, 아니면 null 반환
        if (!authList.isEmpty()) return authList.toArray(new Electronic[authList.size()]);
        return null;
    }

    public void add(Electronic electronic) {
        if (size < capacity) {
            electronicList[size] = electronic;
            size++;
        } else {
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
