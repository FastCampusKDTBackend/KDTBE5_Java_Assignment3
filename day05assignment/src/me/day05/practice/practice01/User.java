package me.day05.practice.practice01;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

public class User {
    private String userId;
    private String userPassword;
    private String userPhoneNumber;
    private String userEmail;
    private String userBirthDate;
    private Electronic[] electronicDevices;
    private LocalDateTime registerTime;

    public User() {
        this.electronicDevices = new Electronic[10];
        this.registerTime = LocalDateTime.now();
    }
    public User(String userId,
                String userPassword,
                String userPhoneNumber,
                String userEmail,
                String userBirthDate
    ) {
        this();
        this.userId = userId;
        this.userPassword = userPassword;
        this.userPhoneNumber = userPhoneNumber;
        this.userEmail = userEmail;
        this.userBirthDate = userBirthDate;
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

    public String getUserBirthDate() {
        return userBirthDate;
    }

    public void setUserBirthDate(String userBirthDate) {
        this.userBirthDate = userBirthDate;
    }

    public LocalDateTime getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(LocalDateTime registerTime) {
        this.registerTime = registerTime;
    }

    public Electronic[] getElectronicDevices() {
        return electronicDevices;
    }

    public void setElectronicDevices(Electronic[] electronicDevices) {
        this.electronicDevices = electronicDevices;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;

        User user = (User) obj;

        if (!Objects.equals(userId, user.userId)) return false;
        if (!Objects.equals(userPassword, user.userPassword)) return false;
        if (!Objects.equals(userPhoneNumber, user.userPhoneNumber)) return false;
        if (!Objects.equals(userEmail, user.userEmail)) return false;
        if (!Objects.equals(userBirthDate, user.userBirthDate)) return false;

        return Objects.equals(registerTime, user.registerTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId,
                userPassword,
                userPhoneNumber,
                userEmail,
                userBirthDate,
                registerTime
        );
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + "'" +
                ", userPassword='" + userPassword + "'" +
                ", userPhoneNumber='" + userPhoneNumber + "'" +
                ", userEmail='" + userEmail + "'" +
                ", userBirthDate='" + userBirthDate + "'" +
                ", electronicDevices=" + Arrays.toString(electronicDevices) +
                ", registerTime=" + registerTime +
                '}';
    }
}
