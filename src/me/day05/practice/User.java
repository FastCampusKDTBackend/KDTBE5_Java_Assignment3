package me.day05.practice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;

public class User {

    private String userId;
    private String userPassword;
    private String userPhoneNumber;
    private String userEmail;
    private LocalDate userBirthDay;
    private Electronic[] electronicDevices;
    private LocalDateTime registerTime;

    public User(String userId, String userPassword) {
        this.userId = userId;
        this.userPassword = userPassword;
    }

    public User(String userId, String userPassword, String userPhoneNumber, String userEmail,
                LocalDate userBirthDay, Electronic[] electronicDevices) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userPhoneNumber = userPhoneNumber;
        this.userEmail = userEmail;
        this.userBirthDay = userBirthDay;
        this.electronicDevices = electronicDevices;
        this.registerTime = LocalDateTime.now(ZoneId.systemDefault());
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

    public LocalDate getUserBirthDay() {
        return userBirthDay;
    }

    public void setUserBirthDay(LocalDate userBirthDay) {
        this.userBirthDay = userBirthDay;
    }

    public Electronic[] getElectronicDevices() {
        return electronicDevices;
    }

    public void setElectronicDevices(Electronic[] electronicDevices) {
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
        return userId.equals(user.userId);
    }

    @Override
    public int hashCode() {
        return userId.hashCode();
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userPassword='" + userPassword + '\'' +
                ", userPhoneNumber='" + userPhoneNumber + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userBirthDay=" + userBirthDay +
                ", electronicDevices=" + Arrays.toString(electronicDevices) +
                ", registerTime=" + registerTime +
                '}';
    }
}
