package me.day05.practice.practice01;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

public class User {
    private String userId; //회원아이디
    private String userPassword; //회원 비밀번호
    private String userPhoneNumber; //회원 핸드폰번호.
    private String userEmail; //회원 이메일
    private String userBirthDate; //회원의 생년월일
    private String[] electronicDevices;  //사용중인 전자제품들, 배열로 정의
    private LocalDateTime registerTime; //회원정보가 등록된 시스템시간, 생성시 시스템시간 자동설정.

    public User() {
       this.registerTime = LocalDateTime.now();
    }
    //기본생성자, 객체생성시 시스템시간 자동설정

    public User(String userId, String userPassword, String userPhoneNumber, String userEmail, String userBirthDate, String[] electronicDevices) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userPhoneNumber = userPhoneNumber;
        this.userEmail = userEmail;
        this.userBirthDate = userBirthDate;
        this.electronicDevices = electronicDevices;
        this.registerTime = LocalDateTime.now();




    } //7개의 멤버변수필드를 인자로 가지는 생성자

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserBirthDate() {
        return userBirthDate;
    }

    public void setUserBirthDate(String userBirthDate) {
        this.userBirthDate = userBirthDate;
    }

    public String[] getElectronicDevices() {
        return electronicDevices;
    }

    public void setElectronicDevices(String[] electronicDevices) {
        this.electronicDevices = electronicDevices;
    }

    public LocalDateTime getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(LocalDateTime registerTime) {
        this.registerTime = registerTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) && Objects.equals(userPassword, user.userPassword) && Objects.equals(userPhoneNumber, user.userPhoneNumber) && Objects.equals(userEmail, user.userEmail) && Objects.equals(userBirthDate, user.userBirthDate) && Arrays.equals(electronicDevices, user.electronicDevices) && Objects.equals(registerTime, user.registerTime);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(userId, userPassword, userPhoneNumber, userEmail, userBirthDate, registerTime);
        result = 31 * result + Arrays.hashCode(electronicDevices);
        return result;
    }

    @Override
    public String toString() {
        return "{" +
                "userId='" + userId + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userPhoneNumber='" + userPhoneNumber + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userBirthDate='" + userBirthDate + '\'' +
                ", electronicDevices=" + Arrays.toString(electronicDevices) +
                ", registerTime=" + registerTime +
                '}';
    }
}
