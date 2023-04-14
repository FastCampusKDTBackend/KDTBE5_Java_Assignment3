package me.day05.practice.practice01;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;

/**
 * 회원 정보
 * <p>
 * - 아이디 : 변경 불가.
 * - 비밀번호
 * - 핸드폰번호
 * - 이메일
 * - 생년월일
 * - 사용 중인 전자 제품들
 * - 회원 정보가 등록된 시스템 시간 : 변경 불가.
 *
 * @author YongHo Shin
 * @since v0.1 (2023-04-12)
 */
public class User {
  private final String userId;
  private String userPassword;
  private String userPhoneNumber;
  private String userEmail;
  private LocalDate userBirthDate;
  private Electronic[] electronicDevices;
  private final LocalDateTime registerTime;
  
  public User(
      String userId,
      String userPassword,
      String userPhoneNumber,
      String userEmail,
      LocalDate userBirthDate,
      Electronic[] electronicDevices
  ) {
    this.userId = userId;
    this.userPassword = userPassword;
    this.userPhoneNumber = userPhoneNumber;
    this.userEmail = userEmail;
    this.userBirthDate = userBirthDate;
    this.electronicDevices = electronicDevices;
    this.registerTime = LocalDateTime.now(ZoneId.systemDefault());
  }
  
  public String getUserId() {
    return userId;
  }
  
  public String getUserPassword() {
    return userPassword;
  }
  
  public String getUserPhoneNumber() {
    return userPhoneNumber;
  }
  
  public String getUserEmail() {
    return userEmail;
  }
  
  public LocalDate getUserBirthDate() {
    return userBirthDate;
  }
  
  public Electronic[] getElectronicDevices() {
    return electronicDevices;
  }
  
  public LocalDateTime getRegisterTime() {
    return registerTime;
  }
  
  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }
  
  public void setUserPhoneNumber(String userPhoneNumber) {
    this.userPhoneNumber = userPhoneNumber;
  }
  
  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }
  
  public void setUserBirthDate(LocalDate userBirthDate) {
    this.userBirthDate = userBirthDate;
  }
  
  @Override
  public int hashCode() {
    int result = getUserId().hashCode();
    result = 31 * result + getRegisterTime().hashCode();
    return result;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    
    User user = (User) o;
    
    if (!getUserId().equals(user.getUserId())) return false;
    return getRegisterTime().equals(user.getRegisterTime());
  }
  
  @Override
  public String toString() {
    return "User{" +
        "userId='" + userId + '\'' +
        ", userPassword='" + userPassword + '\'' +
        ", userPhoneNumber='" + userPhoneNumber + '\'' +
        ", userEmail='" + userEmail + '\'' +
        ", userBirthDate=" + userBirthDate +
        ", electronicDevices=" + Arrays.toString(electronicDevices) +
        ", registerTime=" + registerTime +
        '}';
  }
}
