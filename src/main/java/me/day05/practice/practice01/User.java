package me.day05.practice.practice01;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;

/**
 * 회원 정보
 * - 아이디 : 최초 등록 이후 변경 불가.
 * - 비밀번호
 * - 핸드폰번호
 * - 이메일
 * - 생년월일
 * - 사용 중인 전자 제품들
 * - 회원 정보가 등록된 시스템 시간 : 최초 등록 이후 변경 불가.
 *
 * @author YongHo Shin
 * @version 0.1
 * @since 2023-04-12
 */
public class User {
  private final String userId;
  private String userPassword;
  private String userPhoneNumber;
  private String userEmail;
  private LocalDate userBirthDate;
  private Electronic[] electronicDevices;
  private final LocalDateTime registerTime;
  
  /**
   * 유저 ID, 패스워드 2가지 기본 정보로 생성
   */
  private User(
      String userId,
      String userPassword
  ) {
    this.userId = userId;
    this.userPassword = userPassword;
    this.userPhoneNumber = null;
    this.userEmail = null;
    this.userBirthDate = null;
    this.electronicDevices = null;
    this.registerTime = LocalDateTime.now(ZoneId.systemDefault());
  }
  
  /**
   * 유저 디테일 정보를 포함하여 생성.
   */
  private User(
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
    this.electronicDevices = Arrays.copyOf(electronicDevices, electronicDevices.length);
    this.registerTime = LocalDateTime.now(ZoneId.systemDefault());
  }
  
  /**
   * copyOf 메서드를 위한 생성자.
   */
  private User(
      String userId,
      String userPassword,
      String userPhoneNumber,
      String userEmail,
      LocalDate userBirthDate,
      Electronic[] electronicDevices,
      LocalDateTime registerTime
  ) {
    this.userId = userId;
    this.userPassword = userPassword;
    this.userPhoneNumber = userPhoneNumber;
    this.userEmail = userEmail;
    this.userBirthDate = userBirthDate;
    this.electronicDevices = Arrays.copyOf(electronicDevices, electronicDevices.length);
    this.registerTime = registerTime;
  }
  
  public static User createWithIdAndPassword(String userId, String userPassword) {
    return new User(userId, userPassword);
  }
  
  public static User createWithDetails(
      String userId,
      String userPassword,
      String userPhoneNumber,
      String userEmail,
      LocalDate userBirthDate,
      Electronic[] electronicDevices
  ) {
    return new User(
        userId,
        userPassword,
        userPhoneNumber,
        userEmail,
        userBirthDate,
        electronicDevices
    );
  }
  
  public static User copyOf(
      String userId,
      String userPassword,
      String userPhoneNumber,
      String userEmail,
      LocalDate userBirthDate,
      Electronic[] electronicDevices,
      LocalDateTime registerTime
  ) {
    return new User(
        userId,
        userPassword,
        userPhoneNumber,
        userEmail,
        userBirthDate,
        electronicDevices,
        registerTime
    );
  }
  
  public static User copyOf(User user) {
    return new User(
        user.getUserId(),
        user.getUserPassword(),
        user.getUserPhoneNumber(),
        user.getUserEmail(),
        user.getUserBirthDate(),
        user.getElectronicDevices(),
        user.getRegisterTime()
    );
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
  
  public void setElectronicDevices(Electronic ... electronicDevices) {
    this.electronicDevices  = electronicDevices;
  }
  
  /**
   * 불필요한 연산 없이 최대한 충돌이 발생하지 않도록 구현.
   *
   * @return 유저 ID, 등록일시로 계산한 int value.
   */
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
