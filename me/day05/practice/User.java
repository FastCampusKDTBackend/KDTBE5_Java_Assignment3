package me.day05.practice;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

public class User {
    private String userId;
    private String userPassword;
    private String userEmail;
    private String userBirthDate;
    private Electronic[] electronicDevices;
    private LocalDateTime registerTime;
    public User(){
        this.registerTime = LocalDateTime.now();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserBirthDate() {
        return userBirthDate;
    }

    public void setUserBirthDate(String userBirthDate) {
        this.userBirthDate = userBirthDate;
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
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userBirthDate='" + userBirthDate + '\'' +
                ", electronicDevices=" + Arrays.toString(electronicDevices) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) && Objects.equals(userPassword, user.userPassword) && Objects.equals(userEmail, user.userEmail) && Objects.equals(userBirthDate, user.userBirthDate) && Arrays.equals(electronicDevices, user.electronicDevices);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(userId, userPassword, userEmail, userBirthDate);
        result = 31 * result + Arrays.hashCode(electronicDevices);
        return result;
    }
}
