package me.day05.practice.Practice03;

import me.day05.practice.Practice01.Electronic;

import java.util.Arrays;

public class Electronics {

    private static Electronics allElectronics;
    public Electronics getInstance(){
        if(allElectronics==null){
            allElectronics = new Electronics();
        }
        return allElectronics;
    }
    private Electronic[] electronicList;
    private static final int DEFAULT =10;
    private int size;
    private int capacity;
    private Electronics(){
        electronicList = new Electronic[DEFAULT];
        capacity= DEFAULT;
        size = 0;
    }

    public static Electronics getAllElectronics() {
        return allElectronics;
    }

    public static void setAllElectronics(Electronics allElectronics) {
        Electronics.allElectronics = allElectronics;
    }

    public Electronic[] getElectronicList() {
        return electronicList;
    }

    public void setElectronicList(Electronic[] electronicList) {
        this.electronicList = electronicList;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Electronic findByProductionNo(String productNo){

        for(int i=0;i<size;i++){
            if(electronicList[i].getProductNo().equals(productNo)){
                return electronicList[i];
            }
        }
        return null;
    }

    public Electronic[] groupByCompanyName(Electronic.companyName company){

        Electronic[] groupByCompanyNameArray= new Electronic[size];
        int j=0;
        for(int i=0;i<size;i++){
            if(electronicList[i].getCompany().equals(company.name())){
                groupByCompanyNameArray[j++]=electronicList[i];
            }
        }

        return groupByCompanyNameArray;
    }

    public Electronic[] groupByAuthMethod(Electronic.authMethod authMethod){
        Electronic[] groupByAuthMethodArray= new Electronic[size];
        int j=0;
        for(int i=0;i<size;i++){
            if(electronicList[i].getCompany().equals(authMethod.name())){
                groupByAuthMethodArray[j++]=electronicList[i];
            }
        }

        return groupByAuthMethodArray;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Electronics that = (Electronics) o;

        if (size != that.size) return false;
        if (capacity != that.capacity) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(electronicList, that.electronicList);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(electronicList);
        result = 31 * result + size;
        result = 31 * result + capacity;
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
