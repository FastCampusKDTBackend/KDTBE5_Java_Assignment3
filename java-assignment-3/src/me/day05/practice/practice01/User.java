package me.day05.practice.practice01;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;

public class User {

    private String userId;
    private String userPassword;
    private int userPhoneNumber;
    private String userEmail;
    private int userBirthDate;
    private ArrayList<String> electronicDevices;
    private LocalDate registerTime;

    public User(String userId, String userPassword, int userPhoneNumber, String userEmail, int userBirthDate, ArrayList<String> electronicDevices) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userPhoneNumber = userPhoneNumber;
        this.userEmail = userEmail;
        this.userBirthDate = userBirthDate;
        this.electronicDevices = electronicDevices;
        this.registerTime = LocalDate.now();
    }

    // toString
    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userPhoneNumber=" + userPhoneNumber +
                ", userEmail='" + userEmail + '\'' +
                ", userBirthDate=" + userBirthDate +
                ", electronicDevices=" + electronicDevices +
                ", registerTime=" + registerTime +
                '}';
    }

    // hashCode
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + userId.hashCode();
        result = 31 * result + userPassword.hashCode();
        result = 31 * result + Integer.hashCode(userPhoneNumber);
        result = 31 * result + userEmail.hashCode();
        result = 31 * result + Integer.hashCode(userBirthDate);
        result = 31 * result + electronicDevices.hashCode();
        result = 31 * result + registerTime.hashCode();
        return result;
    }

    // equals
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
        if (!electronicDevices.equals(user.electronicDevices)) return false;
        return registerTime.equals(user.registerTime);
    }

    // getter & setter
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

    public ArrayList<String> getElectronicDevices() {
        return electronicDevices;
    }

    public void setElectronicDevices(ArrayList<String> electronicDevices) {
        this.electronicDevices = electronicDevices;
    }

    public LocalDate getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(LocalDate registerTime) {
        this.registerTime = registerTime;
    }
}
