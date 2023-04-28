package practice1;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class Electronic {
    private static int order = 0;

    private Long productNo;
    private String modelName;
    private Company companyName;
    private LocalDate dateOfMade;
    private AuthMethod[] authMethods;

    public Electronic(String modelName, Company companyName, LocalDate dateOfMade, AuthMethod[] authMethods) {
        this.modelName = modelName;
        this.companyName = companyName;
        this.dateOfMade = dateOfMade;
        this.authMethods = authMethods;
        this.productNo = createProductNo(this.dateOfMade);
    }

    private Long createProductNo(LocalDate dateOfMade) {
        int year = dateOfMade.getYear();
        year -= 2000;
        String month = String.valueOf(dateOfMade.getMonthValue());
        month = addZero(month);
        String day = String.valueOf(dateOfMade.getDayOfMonth());
        day = addZero(day);
        String no = year + month + day + makeOrderString();
        productNo = Long.parseLong(no);
        return productNo;
    }

    private String addZero(String date) {
        if (date.length() == 1) {
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

    public Company getCompanyName() {
        return companyName;
    }

    public void setCompanyName(Company company) {
        this.companyName = company;
    }

    public LocalDate getDateOfMade() {
        return dateOfMade;
    }

    public void setDateOfMade(LocalDate dateOfMade) {
        this.dateOfMade = dateOfMade;
    }

    public AuthMethod[] getAuthMethod() {
        return authMethods;
    }

    public void setAuthMethod(AuthMethod[] authMethods) {
        this.authMethods = authMethods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Electronic that = (Electronic) o;
        return Objects.equals(productNo, that.productNo) && Objects.equals(modelName, that.modelName) && companyName == that.companyName && Objects.equals(dateOfMade, that.dateOfMade) && Arrays.equals(authMethods, that.authMethods);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(productNo, modelName, companyName, dateOfMade);
        result = 31 * result + Arrays.hashCode(authMethods);
        return result;
    }

    @Override
    public String toString() {
        return "Electronic{" +
                "productNo=" + productNo +
                ", modelName='" + modelName + '\'' +
                ", companyName=" + companyName +
                ", dateOfMade=" + dateOfMade +
                ", authMethods=" + Arrays.toString(authMethods) +
                '}';
    }
}

