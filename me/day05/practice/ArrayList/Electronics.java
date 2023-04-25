package me.day05.practice.ArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Electronics {
    private static Electronics electronicsInstance;
    private List<Electronic> electronicList = new ArrayList<>();

    private Electronics() {
    }

    public static Electronics getElectronicsInstance() {
        if (electronicsInstance == null) {
            electronicsInstance = new Electronics();
        }
        return electronicsInstance;
    }

    public List<Electronic> getElectronicList() {
        return electronicList;
    }

    public void setElectronicList(List<Electronic> electronicList) {
        this.electronicList = electronicList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Electronics that = (Electronics) o;
        return Objects.equals(electronicList, that.electronicList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(electronicList);
    }

    @Override
    public String toString() {
        return "Electronics{" +
                "electronicList=" + electronicList +
                '}';
    }

    public Electronic findByProductNo(String productNo) throws NullPointerException {
        Electronic target = electronicList.stream().filter(electronic -> electronic.getProductNo().equals(productNo))
                .findFirst()
                .orElse(null);
        if (target == null) {
            System.out.println("Found Nothing");
            throw new NullPointerException();
        }
        return target;
    }

    public List<Electronic> groupByCompanyName(Company company) {
        return (List<Electronic>) electronicList.stream()
                .filter(electronic -> electronic.getCompanyName().equals(company))
                .toList();
    }

    public List<Electronic> groupByAuthMethod(AuthMethod authMethod) {
        return electronicList.stream()
                .filter(electronic -> electronic.getAuthMethod().contains(authMethod))
                .toList();
    }

    public void addDevice(Electronic electronic) {
        electronicList.add(electronic);
    }
}
