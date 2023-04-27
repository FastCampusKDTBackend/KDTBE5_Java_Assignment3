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
        return Arrays.stream(electronicList)
                .filter(
                        electronic -> electronic.getProductNo().equals(productNo)
                )
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 상품입니다."));
    }

    public Electronic[] groupByCompanyName(Company company) {
        Electronic[] groupByCompanyElectronic = new Electronic[size];

        int count = 0;
        for (int i = 0; i < electronicList.length; i++) {
            if (electronicList[i].getCompany().equals(company)) {
                groupByCompanyElectronic[count++] = electronicList[i];
            }
        }

        return Arrays.copyOf(groupByCompanyElectronic, count);
    }

    public Electronic[] groupByAuthMethod(AuthMethod authMethod) {
        Electronic[] groupByCompanyElectronic = new Electronic[size];
        int count = 0;
        for (Electronic electronic : electronicList) {
            for (AuthMethod getAuthMethod : electronic.getAuthMethods()) {
                if (getAuthMethod.equals(authMethod)) {
                    groupByCompanyElectronic[count++] = electronic;
                }
            }
        }

        return Arrays.copyOf(groupByCompanyElectronic, count);
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
