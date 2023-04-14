package Practice03;

import Practice01.Electronic;

import java.util.Arrays;

public class Electronics {

    private Electronic[] electronicList;

    //싱글톤
    private static Electronics instance = new Electronics();
    public static Electronics getInstance(){
        if(instance == null){
            instance = new Electronics();
        }
        return instance;
    }

    //전자제품 일련번호 productNo를 통해 인자로 주어진 일련번호에 해당하는 전자제품을 반환하는 함수
    public Electronic findByUserId(String productNo){
        for (Electronic electronic : electronicList){
            if(electronic.getProductNo().equals(productNo)){
                return electronic;
            }
        }
        return null;
    }

    //전자제품들 중 인자로 주어진 제조 회사를 찾아서 하나의 배열에 반환하는 함수를 작성하시오.
    public Electronic[] groupByCompanyName(Electronic.CompanyName company){
        int count=0;
        for(Electronic electronic : electronicList){
            if(electronic.getCompanyName().equals(company)){
                count++;
            }
        }
        Electronic[] sameCompany = new Electronic[count];
        int i=0;
        for(Electronic electronic : electronicList){
            if(electronic.getCompanyName().equals(company)){
                sameCompany[i] = electronic;
                i++;
            }
        }
        return sameCompany;
    }

    //전자제품들 중 인자로 주어진 인증 방법을 찾아서 하나의 배열에 반환하는 함수
    public Electronic[] groupByAuthMethod(Practice01.Electronic.AuthMethod authMethod){
        int count=0;
        for(Electronic electronic : electronicList){
            if(electronic.getAuthMethods().equals(authMethod)){
                count++;
            }
        }
        Electronic[] sameAuthMethod = new Electronic[count];
        int i=0;
        for(Electronic electronic : electronicList){
            if(electronic.getAuthMethods().equals(authMethod)){
                sameAuthMethod[i] = electronic;
                i++;
            }
        }
        return sameAuthMethod;
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
