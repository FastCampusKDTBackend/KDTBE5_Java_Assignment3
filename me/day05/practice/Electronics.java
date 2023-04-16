package day05.practice;

import java.util.Arrays;

public class Electronics {

    private static Electronics electronics;
    private Electronic[] electronicList;

    public Electronics getInstance() {
        if(electronics == null) electronics = new Electronics();
        return electronics;
    }

    public Electronic findByProductNo(String productNo) {
        for(int i = 0; i < electronicList.length; i++) {
            if(electronicList[i].getProductNo().equals(productNo)){
                return electronicList[i];
            }
        }
        return null;
    }

    public Electronic[] groupByCompanyName(Company company) {
        Electronic[] groupByCompanyNameList = new Electronic[electronicList.length];
        int index = 0;
        for(int i = 0; i < groupByCompanyNameList.length; i++) {
            if(electronicList[i].getCompanyName().equals(company)){
                groupByCompanyNameList[index++] = electronicList[i];
            }
        }
        return groupByCompanyNameList;
    }

    public Electronic[] groupByAuthMethod(AuthMethod authMethod) {
        Electronic[] groupByAuthMethodList = new Electronic[electronicList.length];
        int index = 0;
        for(int i = 0; i < groupByAuthMethodList.length; i++) {
            if(electronicList[i].getAuthMethod().equals(authMethod)){
                groupByAuthMethodList[index++] = electronicList[i];
            }
        }
        return groupByAuthMethodList;
    }

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

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(getElectronicList(), that.getElectronicList());
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(getElectronicList());
    }

    @Override
    public String toString() {
        return "Electronics{" +
                "electronicList=" + Arrays.toString(electronicList) +
                '}';
    }
}
