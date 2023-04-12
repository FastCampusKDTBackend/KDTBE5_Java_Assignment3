package ForSubmission.me.day05.practice.Practice03;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

public class Electronic {
    private static int modelCount = 0;

    private String productNo;
    private String modelName;
    private Company companyName;
    private LocalDate dateOfMade;
    private ArrayList<AuthMethod> authMethod = new ArrayList<>();

    public Electronic(String modelName, Company companyName) {
        this.productNo = setProductNo();
        this.modelName = modelName;
        this.companyName = companyName;
        this.dateOfMade = setDateOfMade();
    }

    public Electronic(String modelName, Company companyName, AuthMethod auth) {
        this.productNo = setProductNo();
        this.modelName = modelName;
        this.companyName = companyName;
        this.dateOfMade = setDateOfMade();
        authMethod.add(auth);
    }

    //일련번호를 만드는 메소드
    //int형으로 반환하려 했으나, 2147483647를 초과해서 문자열로 저장하는 방식으로 수정
    private String setProductNo() {

        modelCount++;
        LocalDate now = LocalDate.now();
        String productNo = now.format(DateTimeFormatter.ofPattern("YYMMdd"));
        productNo += String.format("%04d", modelCount);

        return productNo;
    }
    //생산일자를 적용하는 메소드
    private LocalDate setDateOfMade() {
        LocalDate now = LocalDate.now();
        return now;
    }

    public void setAuthMethod(AuthMethod auth) {
        authMethod.add(auth);
    }

    public static int getModelCount() {
        return modelCount;
    }

    public static void setModelCount(int modelCount) {
        Electronic.modelCount = modelCount;
    }

    public String getProductNo() {
        return productNo;
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

    public LocalDate getDateOfMade() {
        return dateOfMade;
    }

    public ArrayList<AuthMethod> getAuthMethod() {
        return authMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Electronic that = (Electronic) o;
        return Objects.equals(productNo, that.productNo) && Objects.equals(modelName, that.modelName) && companyName == that.companyName && Objects.equals(dateOfMade, that.dateOfMade) && Objects.equals(authMethod, that.authMethod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productNo, modelName, companyName, dateOfMade, authMethod);
    }

    @Override
    public String
    toString() {
        return "Electronic{" +
                "productNo='" + productNo + '\'' +
                ", modelName='" + modelName + '\'' +
                ", companyName=" + companyName.getCompanyName() +
                ", dateOfMade=" + dateOfMade +
                ", authMethod=" + authMethod +
                '}';
    }
}
