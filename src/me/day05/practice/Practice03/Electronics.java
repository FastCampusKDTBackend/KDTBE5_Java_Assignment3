package me.day05.practice.Practice03;

import me.day05.practice.Practice01.AuthMethod;
import me.day05.practice.Practice01.CompanyName;
import me.day05.practice.Practice01.Electronic;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Electronics {

    /*
    * Q. Electronics 클래스의 객체를 싱글톤으로 생성하는 함수를 작성하시오.
    * */


    final int arrSize = 10;
    private static Electronics instance;
    private Electronic[] electronicList = new Electronic[arrSize];

    public Electronics() {
    }

    public static Electronics getInstance() {
        if (instance == null){
            instance = new Electronics();
        }
        return instance;
    }

    public Electronic createElectronic(String modelName, CompanyName companyName, LocalDate dateOfMade, ArrayList<AuthMethod> authMethod){
        Electronic electronic = new Electronic(modelName, companyName, dateOfMade, authMethod);

        for (int i = 0; i < electronicList.length; i++){
            if (electronicList[i] == null){
                electronicList[i] = electronic;
                break;
            }
        }
        return electronic;
    }


    /*
    * Q.전자제품 일련번호 productNo를 통해 인자로 주어진 일련번호에 해당하는 전자제품을 반환하는 함수를 작성하시오.*/
    public Electronic findByProductNo(String productNo){
        Electronic newElectronic = new Electronic(productNo);
        for ( int i = 0; i < electronicList.length; i++){
            if (electronicList[i].getProductNo().equals(productNo)) {
                newElectronic = electronicList[i];
                break;
            }
        }
        return newElectronic;

    }

    /*
    * Q. 전자제품들 중 인자로 주어진 제조 회사를 찾아서 하나의 배열에 반환하는 함수를 작성하시오.*/

    public Electronic[] groupByCompanyName(CompanyName companyName){
        Electronic[] companyArray = new Electronic[arrSize];
        int cnt = 0;
        for ( int i = 0; i < electronicList.length; i++){
            if (electronicList[i] != null && electronicList[i].getCompanyName().equals(companyName)) {
                companyArray[cnt] = electronicList[i];
                cnt++;
            }
        }
        return companyArray;
    }

    /*
    * Q. 전자제품들 중 인자로 주어진 인증 방법을 찾아서 하나의 배열에 반환하는 함수를 작성하시오.*/
    public Electronic[] groupByAuthMethod(AuthMethod authMethod){
        Electronic[] authMethodArray = new Electronic[arrSize];
        int cnt = 0;
        for ( int i = 0; i < electronicList.length; i++){
            if(electronicList[i] != null && electronicList[i].getAuthMethod().contains(authMethod)){
                authMethodArray[cnt] = electronicList[i];
                cnt++;
            }
        }
        return authMethodArray;
    };

    public static void setInstance(Electronics instance) {
        Electronics.instance = instance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Electronics that = (Electronics) o;
        return arrSize == that.arrSize && Arrays.equals(electronicList, that.electronicList);
    }


    @Override
    public int hashCode() {
        int result = Objects.hash(arrSize);
        result = 31 * result + Arrays.hashCode(electronicList);
        return result;
    }

    @Override
    public String toString() {
        return "Electronics{" +
                "arrSize=" + arrSize +
                ", electronicList=" + Arrays.toString(electronicList) +
                '}';
    }

}
