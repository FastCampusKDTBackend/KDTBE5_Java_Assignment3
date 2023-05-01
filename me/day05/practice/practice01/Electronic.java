package me.day05.practice.practice01;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Objects;

public class Electronic {

    private static int  objectNo = 0; //등록된제품순서.
    private String productNo; //제품일련번호
    private String modelName; //전자기기 모델명

    private Company companyName; //제조회사명
    private String dateOfMade; //생산일자

    private AuthMethod[] authMethods; //본인인증방법 , 배열로정의



    public Electronic() {
        objectNo++;
    }
    // 기본생성자


    public Electronic( String modelName, Company companyName, String dateOfMade, AuthMethod[] authMethods) {
        objectNo++;
        //this.productNo = LocalDate.now().format(DateTimeFormatter.ofPattern("yyMMdd")) + String.format("%04d", objectNo) ;

        StringBuilder sb = new StringBuilder();
        sb.append(LocalDate.now().format(DateTimeFormatter.ofPattern("yyMMdd")));
        sb.append(String.format("%04d", objectNo));

        // 날짜 형식 검증
        if (!isValidDateFormat(dateOfMade)) {
            dateOfMade = "20000101"; // 기본값으로 지정
        }

        this.productNo = sb.toString();
        this.modelName = modelName;
        this.companyName = companyName;
        this.dateOfMade = dateOfMade;
        this.authMethods = authMethods;


    }
    //5개의 인자를 가지는 생성자

    private boolean isValidDateFormat(String date) {
        // 문자열 길이와 숫자 형식 검증
        if (date.length() != 8 || !date.matches("\\d{8}")) {
            return false;
        }

        // 날짜 형식 검증
        try {
            LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyyMMdd"));
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
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

    public AuthMethod[] getAuthMethod() {
        return authMethods;
    }

    public void setAuthMethod(AuthMethod[] authMethods) {
        this.authMethods = authMethods;
    }

    public static int getObjectNo() {
        return objectNo;
    }

    public static void setObjectNo(int objectNo) {
        Electronic.objectNo = objectNo;
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
        return "{" +
                "productNo='" + productNo + '\'' +
                ", modelName='" + modelName + '\'' +
                ", companyName=" + companyName +
                ", dateOfMade='" + dateOfMade + '\'' +
                ", authMethod=" + Arrays.toString(authMethods) +
                '}';
    }
}
