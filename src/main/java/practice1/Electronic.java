package practice1;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class Electronic {
    private Long productNo;
    private String modelName;
    private CompanyName companyName;
    private LocalDate dateOfMade;
    private AuthMethod[] authMethod;
    private static int order = 0;

    public Electronic(String modelName, CompanyName companyName, LocalDate dateOfMade, AuthMethod[] authMethod) {
        this.modelName = modelName;
        this.companyName = companyName;
        this.dateOfMade = dateOfMade;
        this.authMethod = authMethod;
        createProductNo(this.dateOfMade);
    }

    private void createProductNo(LocalDate dateOfMade) {
        int year = dateOfMade.getYear();
        year -= 2000;
        String month = String.valueOf(dateOfMade.getMonthValue());
        month=addZero(month);
        String day = String.valueOf(dateOfMade.getDayOfMonth());
        day=addZero(day);
        System.out.println("year: " + year + " month: " + month + " day: " + day);
        String no = year + month + day + makeOrderString();
        productNo = Long.parseLong(no);
    }

    private String addZero(String date){
        if(date.length()==1){
            date = "0" + date;
        }
        return date;
    }

    private String makeOrderString() {
        if (order < 9) {
            return "000" + (++order);
        }
        if (order < 99) {
            return "00" + (++order);
        }
        if (order < 999) {
            return "0" + (++order);
        }
        throw new IllegalArgumentException("등록순서는 네자리 수까지 가능합니다.");
    }

    public Long getProductNo() {
        return productNo;
    }

    public void setProductNo(Long productNo) {
        this.productNo = productNo;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public CompanyName getCompanyName() {
        return companyName;
    }

    public void setCompanyName(CompanyName companyName) {
        this.companyName = companyName;
    }

    public LocalDate getDateOfMade() {
        return dateOfMade;
    }

    public void setDateOfMade(LocalDate dateOfMade) {
        this.dateOfMade = dateOfMade;
    }

    public AuthMethod[] getAuthMethod() {
        return authMethod;
    }

    public void setAuthMethod(AuthMethod[] authMethod) {
        this.authMethod = authMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Electronic that = (Electronic) o;
        return Objects.equals(productNo, that.productNo) && Objects.equals(modelName, that.modelName) && companyName == that.companyName && Objects.equals(dateOfMade, that.dateOfMade) && Arrays.equals(authMethod, that.authMethod);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(productNo, modelName, companyName, dateOfMade);
        result = 31 * result + Arrays.hashCode(authMethod);
        return result;
    }

    @Override
    public String toString() {
        return "Electronic{" +
                "productNo=" + productNo +
                ", modelName='" + modelName + '\'' +
                ", companyName=" + companyName +
                ", dateOfMade=" + dateOfMade +
                ", authMethod=" + Arrays.toString(authMethod) +
                '}';
    }
}

