package me.day05.practice.Practice01;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Objects;

public class Electronic {
    private String productNo;
    private String modelName;
    private CompanyName companyName;
    private LocalDate dateOfMade;
    private AuthMethod[] authMethod; // 본인인증 방법 — 배열로 정의

    private static int orderNum = 0;

    public Electronic(String modelName, CompanyName companyName, LocalDate dateOfMade, AuthMethod[] authMethod) {
        orderNum++;
        this.productNo = orderProductNo();
        this.modelName = modelName;
        this.companyName = companyName;
        this.dateOfMade = dateOfMade;
        this.authMethod = authMethod;
    }


    //ex. if 2023/03/30(now) then 230330 + 0001 (4자리 등록 순서) ⇒ 2303300001
    private String orderProductNo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");
        String date = LocalDate.now().format(formatter);
        String order_cnt = String.format("%04d", orderNum);
        return date + order_cnt;
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

    public static void setOrderNum(int orderNum) {
        Electronic.orderNum = orderNum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productNo, modelName, companyName, dateOfMade, Arrays.hashCode(authMethod));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Electronic that = (Electronic) obj;
        return Objects.equals(productNo, that.productNo) &&
                Objects.equals(modelName, that.modelName) &&
                companyName == that.companyName &&
                Objects.equals(dateOfMade, that.dateOfMade) &&
                Arrays.equals(authMethod, that.authMethod);
    }

    @Override
    public String toString() {
        return "Electronic{" +
                "productNo='" + productNo + '\'' +
                ", modelName='" + modelName + '\'' +
                ", companyName=" + companyName +
                ", dateOfMade=" + dateOfMade +
                ", authMethod=" + Arrays.toString(authMethod) +
                '}';
    }
}

