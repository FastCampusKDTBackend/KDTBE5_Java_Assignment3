package me.day05.practice.Practice01;

import java.util.Arrays;
import java.util.Objects;

public class User {

    private String userId;
    private String userPassword;
    private int userPhoneNumber;
    private String userEmail;
    private int userBirthDate;
    private Electronic[] electronicDevices;


    public User(){}// default 생성자

    public User(String userId){
        this.userId = userId;
    }

    public User(String userId, String userPassword, int userPhoneNumber, String userEmail, int userBirthDate, Electronic[] electronicDevices) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userPhoneNumber = userPhoneNumber;
        this.userEmail = userEmail;
        this.userBirthDate = userBirthDate;
        this.electronicDevices = electronicDevices;
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

    public int getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(int userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getUserBirthDate() {
        return userBirthDate;
    }

    public void setUserBirthDate(int userBirthDate) {
        this.userBirthDate = userBirthDate;
    }

    public Electronic[] getElectronicDevices() {
        return electronicDevices;
    }

    public void setElectronicDevices(Electronic[] electronicDevices) {
        this.electronicDevices = electronicDevices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return Objects.equals(userId, user.userId);
    }

    @Override
    public int hashCode() {
        return userId.hashCode();
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userPhoneNumber=" + userPhoneNumber +
                ", userEmail='" + userEmail + '\'' +
                ", userBirthDate=" + userBirthDate +
                ", electronicDevices=" + Arrays.toString(electronicDevices) +
                '}';
    }
}
