package me.day05.practice.practice03;

import me.day05.practice.practice01.AuthMethod;
import me.day05.practice.practice01.CompanyName;
import me.day05.practice.practice01.Electronic;

import java.util.Arrays;
import java.util.Objects;

/**
 * Electronic 객체 저장, 관리를 위한 클래스
 *
 * @author YongHo Shin
 * @version 0.1
 * @see Electronic
 * @since 2023-04-12
 */
public class Electronics {
  /**
   * 최초 생성시 최대 10대까지 관리.
   */
  private static final int DEFAULT_CAPACITY = 10;
  /**
   * 관리 기기가 늘어날 경우 더블링 적용
   */
  private static int currentCapacity = DEFAULT_CAPACITY;
  /**
   * 현재 관리중인 기기 수
   */
  private static int currentSize = 0;
  private static final Electronics electronics = new Electronics();
  private Electronic[] electronicList;
  
  private Electronics() {
    electronicList = new Electronic[DEFAULT_CAPACITY];
  }
  
  public static Electronics getInstance() {
    return electronics;
  }
  
  public synchronized void addElectronic(Electronic electronic) {
    if (currentSize < currentCapacity) {
      electronicList[currentSize++] = electronic;
    } else {
      currentCapacity += currentCapacity;
      electronicList = Arrays.copyOf(electronicList, currentCapacity);
      electronicList[currentSize++] = electronic;
    }
  }
  
  public Electronic[] getElectronicList() {
    return electronicList;
  }
  
  public void setElectronicList(Electronic[] electronicList) {
    this.electronicList = electronicList;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Electronics that = (Electronics) o;
    return Arrays.equals(electronicList, that.electronicList);
  }
  
  @Override
  public int hashCode() {
    return Arrays.hashCode(electronicList);
  }
  
  @Override
  public String toString() {
    return "Electronics{" +
        "electronicList=" + Arrays.toString(electronicList) +
        '}';
  }
  
  /**
   * @param productNo 일련번호
   * @return 해당하는 일련번호의 전자기기
   */
  public Electronic findByProductNo(Long productNo) {
    return Arrays.stream(electronicList)
        .filter(Objects::nonNull)
        .filter(electronic -> electronic.getProductNo().equals(productNo))
        .findFirst()
        .orElseThrow(IllegalArgumentException::new);
  }
  
  /**
   * @param companyName 제조사
   * @return 해당 회사에서 생상된 전자기기들을 담고 있는 배열
   */
  public Electronic[] groupByCompanyName(CompanyName companyName) {
    return Arrays.stream(electronicList)
        .filter(Objects::nonNull)
        .filter(electronic -> electronic.getCompanyName() == companyName)
        .toArray(Electronic[]::new);
  }
  
  /**
   * @param authMethod 인증 방법
   * @return 해당 인증 방법을 지원하는 전자기기들을 담고 있는 배열
   */
  public Electronic[] groupByAuthMethod(AuthMethod authMethod) {
    return Arrays.stream(electronicList)
        .filter(Objects::nonNull)
        .filter(electronic -> electronic.supportAuthMethod(authMethod))
        .toArray(Electronic[]::new);
  }
}