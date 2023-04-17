package me.day05.practice.Practice01;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * - `Electronic` 클래스
 *     - 필드
 *         - 제품 일련번호 `productNo`
 *             - 제품 번호는 `Electronic` 클래스의 객체 생성시 자동 생성한다고 가정
 *             - 등록한 날짜
 *                 - 연도 (2자리) + 월 (2자리) + 일 (자리) — [LocalDate](https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html) 클래스 이용
 *             - 등록된 제품 순서
 *                 - 4자리 등록 순서 — static 변수로 총 객체 수 저장
 *             - 예시
 *                 - 현재 작성일 기준 일자는 2023/03/30 이다.
 *                 - 230330 + 0001 (4자리 등록 순서) ⇒ *2303300001*
 *         - 전자기기 모델명 `modelName`
 *         - 제조 회사명 `companyName`
 *             - SAMSUNG, LG, APPLE — Enum형으로 정의
 *             - 하나의 전자 기기에는 다수의 인증 방법이 있을 수도 있음 — 배열로 정의
 *             -
 *      - 메소드
 *          - 생성자, getter(), setter(), hashCode(), equals(), toString()
 */
public class Electronic {
    private String productNo;
    private String modelName;
    private Company companyName;
    private LocalDate dateOfMade;
    private ArrayList<Auth> authMethods = new ArrayList<>();
    private static int serialNum = 0;

    public Electronic() {}

    public Electronic(String productNo, String modelName, Company companyName, LocalDate dateOfMade, Auth auth) {
        LocalDate dt = LocalDate.now();
        serialNum++;
        this.modelName = modelName;
        this.productNo = dt.format(DateTimeFormatter.ofPattern("yyMMdd"));
        this.productNo += String.format("%04d", serialNum);
        this.companyName = companyName;
        authMethods.add(auth);

        this.productNo = productNo;
        this.modelName = modelName;
        this.companyName = companyName;
        this.dateOfMade = dateOfMade;
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

    public LocalDate getDateOfMade() {
        return dateOfMade;
    }

    public void setDateOfMade(LocalDate dateOfMade) {
        this.dateOfMade = dateOfMade;
    }

    public ArrayList<Auth> getAuthMethods() {
        return authMethods;
    }

    public void setAuthMethods(ArrayList<Auth> authMethods) {
        this.authMethods = authMethods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Electronic that = (Electronic) o;
        return Objects.equals(productNo, that.productNo) &&
               Objects.equals(modelName, that.modelName) &&
               companyName == that.companyName &&
               Objects.equals(dateOfMade, that.dateOfMade) &&
               Objects.equals(authMethods, that.authMethods);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productNo, modelName, companyName, dateOfMade, authMethods);
    }

    @Override
    public String toString() {
        return "Electronic{" +
                "productNo='" + productNo + '\'' +
                ", modelName='" + modelName + '\'' +
                ", companyName=" + companyName +
                ", dateOfMade=" + dateOfMade +
                ", authMethods=" + authMethods +
                '}';
    }
}
