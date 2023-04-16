package src.practice03;

import src.practice01.Electronic;
import src.practice01.db.AuthMethod;
import src.practice01.db.Company;

import java.util.Arrays;
import java.util.Objects;

public class Electronics {

    private static Electronics instance;
    private static final int DEFAULT_CAPACITY = 10;
    private Electronic[] electronicList;
    private int size = 0;
    private int capacity = 0;

    private Electronics() {
        this.electronicList = new Electronic[DEFAULT_CAPACITY];
    }

    public void add(Electronic electronic) {
        if (size == capacity) {
            grow();
            add(electronic);
        } else {
            electronicList[size++] = electronic;
        }
    }

    public int size() {
        return size;
    }

    private void grow() {
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

    public Electronic[] groupByAuthMethod(AuthMethod authMethod) {
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
