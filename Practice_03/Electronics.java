package Practice_03;

import java.util.*;
import Practice_03.Electronic.*;

public class Electronics {
    private static Electronics instance;
    private static Electronic[] electronicList;

    private Electronics() {
    }

    public static Electronics getInstance() {
        if (instance == null) {
            instance = new Electronics();
        }
        return instance;
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
        List<Electronic> electronics = new ArrayList<>();
        for (Electronic electronic : electronicList) {
            if (electronic.getCompany() == company) {
                electronics.add(electronic);
            }
        }
        return electronics.toArray(new Electronic[electronics.size()]);
    }

    public Electronic[] groupByAuthMethod(AuthMethod authMethod) {
        List<Electronic> groupAuthList = new ArrayList<>();
        for (Electronic electronic : electronicList) {
            if (Arrays.equals(electronic.getAuthMethods(), new AuthMethod[] {authMethod})) {
                groupAuthList.add(electronic);
            }
        }
        return groupAuthList.toArray(new Electronic[groupAuthList.size()]);
    }

    public static Electronic[] getElectronicList() {
        return electronicList;
    }

    public static void setElectronicList(Electronic[] electronicList) {
        Electronics.electronicList = electronicList;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Electronics{}";
    }
}
