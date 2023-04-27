package me.day05.practice.practice03;

import me.day05.practice.practice01.Electronic;
import me.day05.practice.practice01.constant.AuthMethod;
import me.day05.practice.practice01.constant.Company;

import java.util.Arrays;
import java.util.Objects;

public class Electronics {
    private static final int DEFAULT_SIZE = 50;
    private static Electronics instance;
    private Electronic[] electronicList;

    private Electronics() {
        this.electronicList = new Electronic[DEFAULT_SIZE];
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
        throw new IllegalArgumentException("찾는 " + productNo + "에 해당하는 제품은 존재하지 않습니다.");
    }

    public Electronic[] groupByCompanyName(Company company) {
        return Arrays.stream(electronicList)
                .filter(Objects::nonNull)
                .filter(electronic -> (electronic.getCompanyName() == company)
                ).toArray(Electronic[]::new);
    }

    public Electronic[] groupByAuthMethod(AuthMethod authMethod) {
        return Arrays.stream(electronicList)
                .filter(Objects::nonNull)
                .filter(electronic ->
                        Arrays.stream(electronic.getAuthMethods())
                                .filter(Objects::nonNull)
                                .anyMatch(method -> (method == authMethod))
                ).toArray(Electronic[]::new);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Electronics that = (Electronics) obj;

        if (that.electronicList.length != this.electronicList.length) return false;
        for (int i = 0; i < electronicList.length; i++) {
            if (!electronicList[i].equals(that.electronicList[i])) {
                return false;
            }
        }
        return true;
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
