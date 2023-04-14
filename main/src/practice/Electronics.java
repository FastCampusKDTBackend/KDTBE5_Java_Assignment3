package practice;

import java.util.Arrays;

public class Electronics {

    private static Electronics electronics = null;

    private static final int DEFAULT_CAPACITY = 10;
    private Electronic[] electronicList = new Electronic[]{};
    private int size = 0;
    private int capacity = 0;

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

    private void copy(int capacity) {
        electronicList = Arrays.copyOf(electronicList, capacity);
    }


    private Electronics() {
    }
    public static Electronics getInstance() {
        if (electronics == null) {
            electronics = new Electronics();
        }

        return electronics;
    }

    public Electronic findByProductNo(String productNo) {
        for (int i = 0; i < electronicList.length; i++) {
            if (electronicList[i].getProductNo().equals(productNo)) {
                return electronicList[i];
            }
        }

        return null;
    }

    public Electronic[] groupByCompanyName(Company company) {
        Electronic[] groupByCompanyElectronic = new Electronic[size];
        int count = 0;
        for (int i = 0; i < electronicList.length; i++) {
            if (electronicList[i].getCompany().equals(company)) {
                groupByCompanyElectronic[count] = electronicList[i];
            }
        }

        return Arrays.copyOf(groupByCompanyElectronic, count);
    }

    public Electronic[] groupByAuthMethod(AuthMethod authMethod) {
        Electronic[] groupByCompanyElectronic = new Electronic[size];
        int count = 0;
        for (int i = 0; i < electronicList.length; i++) {
            if (electronicList[i].getAuthMethod().equals(authMethod)) {
                groupByCompanyElectronic[count] = electronicList[i];
            }
        }

        return Arrays.copyOf(groupByCompanyElectronic, count);
    }
}
