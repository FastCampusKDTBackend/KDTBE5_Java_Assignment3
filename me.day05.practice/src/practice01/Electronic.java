package practice01;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class Electronic {
//    private static int seqNo = 0; //총 객체수 저장
    private final String productNo; //제품번호 -> GenerateSeqNo 클래스에서 받아오기(자동생성)
    private String modelName; //전자기기 모델명
    private Company companyName; //제조 회사명 -> enum에서 선택
    private LocalDate dateOfMade; //생산일자
    private AuthMethod[] authMethods; //본인 인증 방법 -> 다수의 인증 방법이 존재할 수 있음

    GenerateSeqNo generateSeqNo = GenerateSeqNo.getInstance();

    public Electronic() {
        this.productNo = generateSeqNo.getSeqNo();
    }

    public Electronic(String modelName, Company companyName, LocalDate dateOfMade) {
        this();
        this.modelName = modelName;
        this.dateOfMade = dateOfMade;
        this.companyName = companyName;
    }

    public Electronic(String modelName, Company companyName, LocalDate dateOfMade, AuthMethod[] authMethods) {
        this(modelName, companyName, dateOfMade);
        this.authMethods = authMethods;
    }

//    private String setProductNo() {
//        seqNo++;
//        seqNo = (seqNo > 9999) ? 1 : seqNo; //sequence number가 9999를 초과하면 다시 1로 초기화
//        return LocalDate.now(ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("yyMMdd"))
//                + String.format("%04x", seqNo);
//    }

    public String getProductNo() {
        return productNo;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public LocalDate getDateOfMade() {
        return dateOfMade;
    }

    public void setDateOfMade(LocalDate dateOfMade) {
        this.dateOfMade = dateOfMade;
    }

    public Company getCompanyName() {
        return companyName;
    }

    public void setCompanyName(Company company) {
        this.companyName = company;
    }

    public AuthMethod[] getAuthMethods() {
        return authMethods;
    }

    public void setAuthMethods(AuthMethod[] authMethods) {
        this.authMethods = authMethods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Electronic that = (Electronic) o;
        return Objects.equals(productNo, that.productNo) && Objects.equals(modelName, that.modelName) && Objects.equals(dateOfMade, that.dateOfMade) && companyName == that.companyName && Arrays.equals(authMethods, that.authMethods);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(productNo, modelName, dateOfMade, companyName);
        result = 31 * result + Arrays.hashCode(authMethods);
        return result;
    }

    @Override
    public String toString() {
        return "Electronic{" +
                "productNo='" + productNo + '\'' +
                ", modelName='" + modelName + '\'' +
                ", dateOfMade=" + dateOfMade +
                ", companyName=" + companyName +
                ", authMethods=" + Arrays.toString(authMethods) +
                '}' + "\n";
    }
}
