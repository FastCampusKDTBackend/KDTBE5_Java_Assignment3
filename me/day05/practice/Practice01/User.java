package me.day05.practice.Practice01;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class User {
    private String userId;
    private String userPassword;
    private String userPhoneNumber;
    private String userEmail;
    private int userBirthDate;
    private ArrayList<Electronic> electronicDevices = new ArrayList<>();
    private LocalDateTime registerTime;

    public User(String userId, String userPassword, String userPhoneNumber, String userEmail, int userBirthDay, Electronic electronic) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userPhoneNumber = userPhoneNumber;
        this.userEmail = userEmail;
        this.userBirthDate = userBirthDay;
        this.registerTime = LocalDateTime.now();
        electronicDevices.add(electronic);
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

    public int getUserBirthDate() {
        return userBirthDate;
    }

    public void setUserBirthDate(int userBirthDate) {
        this.userBirthDate = userBirthDate;
    }

    public ArrayList<Electronic> getElectronicDevices() {
        return electronicDevices;
    }

    public void setElectronicDevices(ArrayList<Electronic> electronicDevices) {
        this.electronicDevices = electronicDevices;
    }

     public void addElectronicDevices(Electronic devices) {
        electronicDevices.add(devices);
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
        return userPhoneNumber == user.userPhoneNumber && userBirthDate == user.userBirthDate && userId.equals(user.userId) && userPassword.equals(user.userPassword) && userEmail.equals(user.userEmail) && electronicDevices.equals(user.electronicDevices) && registerTime.equals(user.registerTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userPassword, userPhoneNumber, userEmail, userBirthDate, electronicDevices, registerTime);
    }

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
}
