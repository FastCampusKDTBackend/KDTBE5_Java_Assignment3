package ForSubmission.me.day05.practice.Practice03;

import java.util.ArrayList;
import java.util.Objects;

public class Electronics {
    private static Electronics electronicsInstance;
    private ArrayList<Electronic> electronicList = new ArrayList<>();

    private Electronics(){}

    public static Electronics getElectronicsInstance() {
        if(electronicsInstance == null) {
            electronicsInstance = new Electronics();
        }
        return electronicsInstance;
    }

    public ArrayList<Electronic> getElectronicList() {
        return electronicList;
    }

    public void setElectronicList(ArrayList<Electronic> electronicList) {
        this.electronicList = electronicList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Electronics that = (Electronics) o;
        return Objects.equals(electronicList, that.electronicList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(electronicList);
    }

    @Override
    public String toString() {
        return "Electronics{" +
                "electronicList=" + electronicList +
                '}';
    }

    public Electronic findByProductNo(String productNo) throws NullPointerException{
        for (int i = 0; i < electronicList.size(); i++) {
            if(electronicList.get(i).getProductNo().equals(productNo)) {
                return electronicList.get(i);
            }
        }
        System.out.println("Found Nothing");
        return null;
    }

    public ArrayList<Electronic> groupByCompanyName (Company company) {
        ArrayList<Electronic> companyGroupList = new ArrayList<>();

        for(int i = 0; i < electronicList.size(); i++) {
            if(electronicList.get(i).getCompanyName().equals(company)) {
                companyGroupList.add(electronicList.get(i));
            }
        }
        return companyGroupList;
    }

    public ArrayList<Electronic> groupByAuthMethod(AuthMethod authMethod) {
        ArrayList<Electronic> authMethodGroupList = new ArrayList<>();

        for(int i = 0; i < electronicList.size(); i++) {
            if(electronicList.get(i).getAuthMethod().contains(authMethod)) {
                authMethodGroupList.add(electronicList.get(i));
            }
        }

        return authMethodGroupList;
    }

    public void addDevice(Electronic electronic) {
        electronicList.add(electronic);
    }
}
