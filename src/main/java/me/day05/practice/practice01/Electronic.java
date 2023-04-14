package me.day05.practice.practice01;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Objects;

/**
 * 전자기기 정보
 * <p>
 * - 일련번호 : 변경 불가. 등록일(yyMMdd) + 등록순서(4자리).
 * - 모델명 : 변경 불가.
 * - 제조사 : 변경 불가.
 * - 생산일자 : 변경 불가.
 * - 본인인증 방법 : 여러 방법 동시 사용 가능.
 *
 * @author YongHo Shin
 * @since v0.1 (2023-04-12)
 *
 */
public class Electronic {
  private static Long totalProduct = 0L;
  private final Long productNo;
  private final String modelName;
  private final CompanyName companyName;
  private final LocalDate dateOfMade;
  private AuthMethod[] authMethod;
  
  public Electronic(
      String modelName,
      CompanyName companyName,
      LocalDate dateOfMade,
      AuthMethod[] authMethod) {
    this.productNo = Long.parseLong(
        LocalDate.now().format(DateTimeFormatter.ofPattern("uuMMdd"))
            + String.format("%04d", ++totalProduct)
    );
    this.modelName = modelName;
    this.companyName = companyName;
    this.dateOfMade = dateOfMade;
    this.authMethod = authMethod;
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
  
  public AuthMethod[] getAuthMethod() {
    return authMethod;
  }
  
  public void setAuthMethod(AuthMethod[] authMethod) {
    this.authMethod = authMethod;
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(productNo, modelName, companyName);
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Electronic that = (Electronic) o;
    return productNo.equals(that.productNo)
        && modelName.equals(that.modelName)
        && companyName == that.companyName;
  }
  
  @Override
  public String toString() {
    return "Electronic{" +
        "productNo='" + productNo + '\'' +
        ", companyName=" + companyName +
        ", dateOfMade=" + dateOfMade +
        ", modelName='" + modelName + '\'' +
        ", authMethod=" + Arrays.toString(authMethod) +
        '}';
  }
}
