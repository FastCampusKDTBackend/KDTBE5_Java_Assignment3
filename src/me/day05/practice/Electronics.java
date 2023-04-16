package me.day05.practice;

import java.util.Arrays;

public enum Electronics {

    INSTANCE;

    private static final int DEFAULT_CAPACITY = 10;
    private Electronic[] electronicList;
    private int size;

    Electronics() {
        this.electronicList = new Electronic[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public static Electronics getInstance() { return INSTANCE; }

    private int findIdxByProductNo(String productNo) {
        for (int i = 0; i < this.size; ++i) {
            Electronic electronic = this.electronicList[i];
            if (electronic.getProductNo().equals(productNo)) {
                return i;
            }
        }
        return -1;
    }

    public Electronic findByProductNo(String productNo) {
        int idx = findIdxByProductNo(productNo);
        if (idx < 0) return null;
        return this.electronicList[idx];
    }

    public void addElectronic(Electronic electronic) {
        if (this.size == this.electronicList.length) {
            resize(this.size << 1);
        }

        this.electronicList[size++] = electronic;
    }

    public Electronic removeElectronicById(String productNo) {
        int idx = findIdxByProductNo(productNo);
        if (idx < 0) {
            return null;
        }

        Electronic ret = this.electronicList[idx];
        for (int i = idx + 1; i < this.size; ++i) {
            this.electronicList[i-1] = this.electronicList[i];
        }
        this.size--;

        return ret;
    }

    private void resize(int newLength) {
        this.electronicList = Arrays.copyOf(this.electronicList, newLength);
    }

    Electronic[] groupByCompanyName(Company company) {
        Electronic[] electronicsOfCompany = new Electronic[this.electronicList.length];
        int cnt = 0;
        for (int i = 0; i < this.size; ++i) {
            Electronic electronic = this.electronicList[i];
            if (electronic.getCompanyName() == company) {
                electronicsOfCompany[cnt++] = electronic;
            }
        }
        return Arrays.copyOf(electronicsOfCompany, cnt);
    }

    Electronic[] groupByAuthMethod(AuthMethod authMethod) {
        Electronic[] electronicsWithAuthMethod = new Electronic[this.electronicList.length];
        int cnt = 0;
        for (int i = 0; i < this.size; ++i) {
            Electronic electronic = this.electronicList[i];
            if (electronic.hasAuthMethod(authMethod)) {
                electronicsWithAuthMethod[cnt++] = electronic;
            }
        }
        return Arrays.copyOf(electronicsWithAuthMethod, cnt);
    }

    public Electronic[] getElectronicList() {
        return this.electronicList;
    }

    public void setElectronicList(Electronic[] electronicList) {
        this.electronicList = electronicList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Electronics{");
        for (Electronic electronic : electronicList) {
            sb.append(electronic).append(", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append("}");
        return sb.toString();
    }
}
