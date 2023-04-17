package me.day05.practice.Practice01;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * - `User` 클래스
 *     - 필드
 *         - 회원 아이디 `userId`
 *         - 회원 비밀번호 `userPassword`
 *         - 회원 핸드폰번호 `userPhoneNumber`
 *         - 회원 이메일 `userEmail`
 *         - 회원 생년월일 `userBirthDate`
 *         - 사용 중인 전자 제품들 `electronicDevices`
 *             - 하나의 사용자는 여러 개의 사용 중인 전자 제품이 있을 수 있음 — 배열로 정의
 *         - 회원 정보가 등록된 시스템 시간 `registerTime`
 *             - 객체 생성시 시스템 시간으로 자동 설정됨
 *     - 메소드
 *         - 생성자, getter(), setter(), hashCode(), equals(), toString()
 *
 */
public class User {

    private String userId;
    private String userPassword;
    private String userPhoneNumber;
    private String userEmail;
    private LocalDate userBirthDate;
    private LocalDate registerTime;
    private ArrayList<Electronic> electronicDevices;

    public User() {}

    public User(String userId, String userPassword, String userPhoneNumber, String userEmail, LocalDate userBirthDate) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userPhoneNumber = userPhoneNumber;
        this.userEmail = userEmail;
        this.userBirthDate = userBirthDate;
        registerTime = setRegisterTime();
    }

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

    public LocalDate getUserBirthDate() {
        return userBirthDate;
    }

    public void setUserBirthDate(LocalDate userBirthDate) {
        this.userBirthDate = userBirthDate;
    }

    public LocalDate getRegisterTime() {
        return registerTime;
    }

    public LocalDate setRegisterTime() {
        return LocalDate.now(ZoneId.systemDefault());
    }

    public ArrayList<Electronic> getElectronicDevices() {
        return electronicDevices;
    }

    public void setElectronicDevices(ArrayList<Electronic> electronicDevices) {
        this.electronicDevices = electronicDevices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) &&
               Objects.equals(userPassword, user.userPassword) &&
               Objects.equals(userPhoneNumber, user.userPhoneNumber) &&
               Objects.equals(userEmail, user.userEmail) &&
               Objects.equals(userBirthDate, user.userBirthDate) &&
               Objects.equals(registerTime, user.registerTime) &&
               Objects.equals(electronicDevices, user.electronicDevices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userPassword, userPhoneNumber, userEmail, userBirthDate, registerTime, electronicDevices);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userPhoneNumber='" + userPhoneNumber + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userBirthDate=" + userBirthDate +
                ", registerTime=" + registerTime +
                ", electronicDevices=" + electronicDevices +
                '}';
    }
}
