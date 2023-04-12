package me.day05.practice;

import java.util.Arrays;

public class Electronics {
    private Electronic[] electronicList;

    public static Electronics getInstance(){
        if(instance == null)
            instance = new Electronics();
        return instance;
    }private static Electronics instance;

    public Electronic findByProductNo(String productNo){
        for(int i =0; i < electronicList.length; i++) {
            if(electronicList[i].getProductNo() == productNo)
                return electronicList[i];
        }
        return null;
    }

    public Electronic[] groupByCompanyName(Electronic.COMPANYNAME company){
        Electronic[] tmp = new Electronic[electronicList.length];
        for(int i =0; i< electronicList.length; i++){
            if(electronicList[i].getCompanyName() == company)
                tmp[i].setCompanyName(electronicList[i].getCompanyName());
        }
        return tmp;
    }

    Electronic[] groupByAuthMethod(Electronic.AUTHMETHOD authMethod){
        Electronic[] tmp = new Electronic[electronicList.length];

        for(int i=0; i < electronicList.length; i++){
            Electronic.AUTHMETHOD[] arrAuth = new Electronic.AUTHMETHOD[electronicList[i].getArrAuth().length];
            for(int j=0; j < arrAuth.length; j++){
                if(electronicList[i].getArrAuth()[j] == authMethod)
                    arrAuth[j] = authMethod;
            }
            tmp[i].setArrAuth(arrAuth);
        }
        return tmp;
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
