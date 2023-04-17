package me.day05.practice.practice01;

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

        if (userPhoneNumber != user.userPhoneNumber) return false;
        if (userBirthDate != user.userBirthDate) return false;
        if (!userId.equals(user.userId)) return false;
        if (!userPassword.equals(user.userPassword)) return false;
        if (!userEmail.equals(user.userEmail)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(electronicDevices, user.electronicDevices);
    }

    @Override
    public int hashCode() {
        int result = userId.hashCode();
        result = 31 * result + userPassword.hashCode();
        result = 31 * result + userPhoneNumber;
        result = 31 * result + userEmail.hashCode();
        result = 31 * result + userBirthDate;
        result = 31 * result + Arrays.hashCode(electronicDevices);
        return result;
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
