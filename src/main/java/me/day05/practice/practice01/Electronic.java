package me.day05.practice.practice01;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

/**
 * 전자기기 정보
 * - 일련번호 : 변경 불가. 등록일(yyMMdd) + 등록순서(4자리).
 * - 생산일자 : 변경 불가.
 * - 모델명
 * - 제조사
 * - 본인인증 방법 : 여러 방법 동시 사용 가능.
 *
 * @author YongHo Shin
 * @version 0.2
 * @since 2023-04-12
 */
public class Electronic {
  private static Long seqNum = 0L;
  private final Long productNo;
  private final LocalDate dateOfMade;
  private String modelName;
  private CompanyName companyName;
  private AuthMethod[] authMethods;
  
  private Electronic(
      String modelName,
      CompanyName companyName,
      AuthMethod[] authMethods) {
    this.productNo = generateProductNo();
    this.modelName = modelName;
    this.companyName = companyName;
    this.dateOfMade = LocalDate.now(ZoneId.systemDefault());
    this.authMethods = Arrays.copyOf(authMethods, authMethods.length);
  }
  
  private Electronic(
      Long productNo,
      LocalDate dateOfMade,
      String modelName,
      CompanyName companyName,
      AuthMethod[] authMethods
  ) {
    this.productNo = productNo;
    this.dateOfMade = dateOfMade;
    this.modelName = modelName;
    this.companyName = companyName;
    this.authMethods = Arrays.copyOf(authMethods, authMethods.length);
  }
  
  public static Electronic createWithDetails(
      String modelName,
      CompanyName companyName,
      AuthMethod[] authMethod) {
    return new Electronic(
        modelName,
        companyName,
        authMethod
    );
  }
  
  public static Electronic copyOf(Electronic electronic) {
    return new Electronic(
        electronic.getProductNo(),
        electronic.getDateOfMade(),
        electronic.getModelName(),
        electronic.getCompanyName(),
        electronic.getAuthMethods()
    );
  }
  
  /**
   * 동시에 여러 제품을 등록할 때 Race Condition 방지 필요
   *
   * @return 등록일련번호
   */
  private static synchronized long generateProductNo() {
    return Long.parseLong(
        LocalDate.now(ZoneId.systemDefault())
            .format(DateTimeFormatter.ofPattern("uuMMdd"))
            + String.format("%04d", ++seqNum)
    );
  }
  
  public Long getProductNo() {
    return productNo;
  }
  
  public String getModelName() {
    return modelName;
  }
  
  public CompanyName getCompanyName() {
    return companyName;
  }
  
  public LocalDate getDateOfMade() {
    return dateOfMade;
  }
  
  public AuthMethod[] getAuthMethods() {
    return authMethods;
  }
  
  public void setModelName(String modelName) {
    this.modelName = modelName;
  }
  
  public void setCompanyName(CompanyName companyName) {
    this.companyName = companyName;
  }
  
  public void setAuthMethods(AuthMethod[] authMethods) {
    this.authMethods = authMethods;
  }
  
  /**
   * @param authMethod 인증 방법
   * @return 해당 인증 방법 지원 여부
   */
  public boolean supportAuthMethod(AuthMethod authMethod) {
    return Arrays.stream(authMethods)
        .anyMatch(registeredMethod->registeredMethod==authMethod);
  }
  
  /**
   * @return 등록번호, 제조회사, 생산일에 기반하여 계산된 고유 정수값
   */
  @Override
  public int hashCode() {
    int result = getDateOfMade().hashCode();
    result = 31 * result + getProductNo().hashCode();
    result = 31 * result + (getCompanyName() != null ? getCompanyName().hashCode() : 0);
    return result;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    
    Electronic that = (Electronic) o;
    
    if (!getDateOfMade().equals(that.getDateOfMade())) return false;
    if (!getProductNo().equals(that.getProductNo())) return false;
    return getCompanyName() == that.getCompanyName();
  }
  
  @Override
  public String toString() {
    return "Electronic{" +
        "productNo='" + productNo + '\'' +
        ", companyName=" + companyName +
        ", dateOfMade=" + dateOfMade +
        ", modelName='" + modelName + '\'' +
        ", authMethod=" + Arrays.toString(authMethods) +
        '}';
  }
}
