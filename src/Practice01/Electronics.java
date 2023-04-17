package Practice01;

import java.util.Arrays;
import java.util.Objects;

public class Electronics {
    ////////
    // singleton
    private static Electronics allElectronics;

    public static Electronics getInstance(){
        if(allElectronics == null){
            allElectronics = new Electronics();
        }
        return allElectronics;
    }
    ////////

    private Electronic[] electronicList;

    private static final int DEFAULT = 10;
    private int size;
    private int capacity;

    private Electronics(){
        electronicList = new Electronic[DEFAULT];
        capacity = DEFAULT;
    }

    public Electronics(int initial){
        electronicList = new Electronic[initial];
        capacity = initial;
    }

    public Electronics(Electronic[] electronicList){
        this.electronicList = electronicList;
        capacity = electronicList.length;
        size = electronicList.length;
    }

    public Electronic[] getElectronicList(){return electronicList;}

    public int size() {
        return size;
    }
    private int capacity() {
        return capacity;
    }

    public Electronic get(int index){
        if (index<0 || index >= size) return null;
        return electronicList[index];
    }

    public void set(int index, Electronic electronic){
        if(index<0 || index >=size) return;
        if(electronic == null) return;

        electronicList[index] = electronic;
    }

    public void add(Electronic electronic){
        if(electronic == null) return;

        if(size<capacity){
            electronicList[size] = electronic;
            size++;
        }else{
            grow();
            add(electronic);
        }
    }

    private void grow(){
        capacity *= 2;
        electronicList = Arrays.copyOf(electronicList, capacity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Electronics that = (Electronics) o;
        return size == that.size && capacity == that.capacity && Arrays.equals(electronicList, that.electronicList);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size, capacity);
        result = 31 * result + Arrays.hashCode(electronicList);
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

    public Electronic findByProductNo(String productNo){
        if(productNo == null) return null;
        if(allElectronics == null) return null;

        for (int i = 0; i < allElectronics.size(); i++) {
            if(allElectronics.get(i).getProductNo() == productNo){
                return allElectronics.get(i);
            }
        }
        return null;
    }

    public Electronic[] groupByCompanyName(Company company){
        if(company == null) return null;
        if(allElectronics == null) return null;

        Electronic[] groupByCN = new Electronic[allElectronics.size()];
        int count = 0;
        for (int i = 0; i < allElectronics.size(); i++) {
            if(allElectronics.get(i).getCompanyName() == company){
                groupByCN[count] = allElectronics.get(i);
                count++;
            }
        }
        return groupByCN;
    }



    public Electronic[] groupByAuthMethod(AuthMethod authMethod){
        if(authMethod == null) return null;
        if(allElectronics == null) return null;

        Electronic[] groupByAM = new Electronic[allElectronics.size()];
        int count = 0;
        for (int i = 0; i < allElectronics.size(); i++) {
            for (int j = 0; j < allElectronics.get(i).getAuthMethod().length; j++) {
                if(authMethod == allElectronics.get(i).getAuthMethod()[j]){
                    groupByAM[count] = allElectronics.get(i);
                    count++;
                }
            }
        }
        return groupByAM;
    }
}
