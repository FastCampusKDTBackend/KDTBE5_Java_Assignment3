package Practice;

import java.util.Arrays;

public class Electronics {
    private Electronic[] electronicList;

    //싱글톤
    private static Electronics electronics;
    public static Electronics getInstance(){
        if(electronics == null){
            electronics = new Electronics();
        }
        return electronics;
    }

    //productNo으로 전자제품 찾기
    public Electronic findByProductNo(String productNo){
        for(int i = 0; i < electronicList.length; i++){
            if(electronicList[i].getProductNo().equals(productNo)){
                return electronicList[i];
            }
        }
        return null;
    }

    //제조 회사로 찾아서 하나의 배열로 반환
    public Electronic[] groupByCompanyName(Electronic.Company company){
        Electronic[] ans = new Electronic[electronicList.length];
        for(int i = 0; i < electronicList.length; i++){
            if(electronicList[i].getCompany().equals(company)){
                ans[i] = electronicList[i];
            }
        }
        return ans;
    }

    public Electronic[] groupByAutoMethod(Electronic.AuthMethod authMethod){
        Electronic[] ans = new Electronic[electronicList.length];
        for(int i = 0; i < electronicList.length; i++){
            if(electronicList[i].getAuthMethod()[i].getAuthMethodName() == authMethod.getAuthMethodName()){
                ans[i] = electronicList[i];
            }
        }
        return ans;
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
