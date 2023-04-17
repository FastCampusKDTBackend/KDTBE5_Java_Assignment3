package Practice03;

import Practice01.AuthMethod;
import Practice01.Company;
import Practice01.Electronic;
import Practice02.Users;

import java.util.*;
import java.util.Arrays;

public class Electronics {
//- 객체 배열 `Electronic[] electronicList`를 필드로 가지고 있는 `Electronics`클래스를 작성하시오.
//    - 필드 - Electronic[] electronicList (생성된 Electronic 객체들을 모두 저장)
//    - 메소드 - 생성자, getter(), setter(), hashCode(), equals(), toString()
    private static Electronic[] electroniclist;
    private Electronics singleton;
    private Electronics(){

    }

    public Electronic[] getElectroniclist() {
        return electroniclist;
    }

    public void setElectroniclist(Electronic[] electroniclist) {
        this.electroniclist = electroniclist;
    }
    @Override
    public int hashCode() {
        return Arrays.hashCode(electroniclist);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Electronics e = (Electronics) o;
        return Arrays.equals(electroniclist, e.electroniclist);
    }

    @Override
    public String toString() {

        return Arrays.toString(electroniclist);
    }

    //3-1 Electronic 클래스의 객체를 싱글톤으로 생성하는 함수를 작성(Double Checked Locking 방식)

    public Electronics getInstance(){
        if(singleton==null){
            synchronized (Users.class) {
                if (singleton == null) {
                    singleton = new Electronics();
                }
            }
        }
        return singleton;
    }

    //3-2 전자제품 일련번호 productNo를 통해 인자로 주어진 일련번호에 해당하는 전자제품을 반환하는 함수를 작성
    public static Electronic findByProductNo(String productNo){
        for(int i=0; i<electroniclist.length;i++){
            if(electroniclist[i].getProductNo()==productNo){
                return electroniclist[i];
            }
        }
        return null;
    }

    //3-3 전자제품들 중 인자로 주어진 제조 회사를 찾아서 하나의 배열에 반환하는 함수를 작성
    public static List<Electronic> groupByCompanyName(Company company){
        List<Electronic> groupByCompanyNamelist =new ArrayList<>();
        for(int i=0; i<electroniclist.length;i++){
            if(electroniclist[i].getCompanyName().equals(company)){
                groupByCompanyNamelist.add(electroniclist[i]);
            }
        }
        return groupByCompanyNamelist;
    }

    //3-4 전자제품들 중 인자로 주어진 인증 방법을 찾아서 하나의 배열에 반환하는 함수를 작성
    public static List<Electronic> groupByAuthMethod(AuthMethod authMethod){

        List<Electronic>  groupByAuthMethodlist =new ArrayList<>();
        for(int i=0; i<electroniclist.length;i++){
            if(electroniclist[i].getArrAuth().equals(authMethod)){
                groupByAuthMethodlist.add(electroniclist[i]);
            }
        }
        return groupByAuthMethodlist ;
    }
}
