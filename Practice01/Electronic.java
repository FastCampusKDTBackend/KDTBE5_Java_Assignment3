package Practice01;

import java.util.Arrays;
import java.util.Objects;

public class Electronic {
    private String productNo;
    private String modelName;
    private  String dateOfMade;

    private Company companyName;
    private AuthMethod[] arrAuth;


    @Override
    public String toString() {
        return "Electronic{" +
                "productNo='" + productNo + '\'' +
                ", modelName='" + modelName + '\'' +
                ", dateOfMade='" + dateOfMade + '\'' +
                '}';
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
    public Company getCompanyName() {
        return companyName;
    }

    public void setCompanyName(Company companyName) {
        this.companyName = companyName;
    }
    public String getDateOfMade() {
        return dateOfMade;
    }

    public void setDateOfMade(String dateOfMade) {
        this.dateOfMade = dateOfMade;
    }

    public AuthMethod[] getArrAuth() {
        return arrAuth;
    }

    public void setArrAuth(AuthMethod[] arrAuth) {
        this.arrAuth = arrAuth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Electronic e = (Electronic) o;
        return Objects.equals(productNo, e.productNo) &&
                Objects.equals(modelName, e.modelName) &&
                Objects.equals(dateOfMade, e.dateOfMade);
    }

    @Override
    public int hashCode() {
        int result=Objects.hash(productNo, modelName, dateOfMade);
        result=31*result+ Arrays.hashCode(arrAuth);
        return result;
    }
}
