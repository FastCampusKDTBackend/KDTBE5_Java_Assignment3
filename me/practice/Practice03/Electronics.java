package KDTBE5_Java_Assignment3.me.practice.Practice03;

import KDTBE5_Java_Assignment3.me.practice.Practice01.AuthMethod;
import KDTBE5_Java_Assignment3.me.practice.Practice01.Company;
import KDTBE5_Java_Assignment3.me.practice.Practice01.Electronic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Electronics {
    private static final Electronics INSTANCE = new Electronics();

    public Electronics() {
    }

    public static Electronics getINSTANCE() {
        return INSTANCE;
    }

    private Electronic[] electronicList;

    public Electronic[] getElectronicList() {
        return electronicList;
    }

    public void setElectronicList(Electronic[] electronicList) {
        this.electronicList = electronicList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Electronics that = (Electronics) o;
        return Objects.equals(INSTANCE, that.INSTANCE) && Arrays.equals(electronicList, that.electronicList);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(INSTANCE);
        result = 31 * result + Arrays.hashCode(electronicList);
        return result;
    }

    @Override
    public String toString() {
        return "Electronics{" +
                "INSTANCE=" + INSTANCE +
                ", electronicList=" + Arrays.toString(electronicList) +
                '}';
    }

    public Electronic findByProductNo(String productNo) throws Exception {
        for (Electronic electronic:this.electronicList
             ) {
            if(electronic.getProductNo().equals(productNo))return electronic;
        }
        throw new Exception("해당 생산번호를 가지는 기기는 없습니다.");
    };

    public Electronic[] groupByCompanyName(Company company){
        List<Electronic> electronics = new ArrayList<Electronic>();
        for (Electronic electronic:this.electronicList
        ) {
            if(electronic.getCompany() == company){
                electronics.add(electronic);
        }
        }
        return electronics.toArray(new Electronic[electronics.size()]);
    };

    public Electronic[] groupByAuthMethod(AuthMethod authMethod){
        List<Electronic> electronics = new ArrayList<Electronic>();
        for (Electronic electronic:this.electronicList
        ) {
            if(Arrays.asList(electronic.getAuthMethod()).indexOf(authMethod)>-1){
                electronics.add(electronic);
            }
        }
        return electronics.toArray(new Electronic[electronics.size()]);
    };
}
