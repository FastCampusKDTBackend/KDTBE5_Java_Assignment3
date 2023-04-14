package me.day05.practice.Practice02;

import me.day05.practice.Practice01.Electronic;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class User implements Cloneable{
    private String userId;
    private String userPassword;
    private String userPhoneNumber;
    private String userEmail;
    private String userBirthDate;
    private ArrayList<Electronic> electronicDevices ;
    private LocalDateTime registerTime;

    public User() {
        this.electronicDevices= new ArrayList<Electronic>();
        this.registerTime=LocalDateTime.now();
    }

    public User(String userId, String userPassword, String userPhoneNumber, String userEmail, String userBirthDate, ArrayList<Electronic> electronicDevices) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userPhoneNumber = userPhoneNumber;
        this.userEmail = userEmail;
        this.userBirthDate = userBirthDate;
        this.electronicDevices = electronicDevices;
        this.registerTime=LocalDateTime.now();
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

    public ArrayList<Electronic> getElectronicDevices() {
        return electronicDevices;
    }

    public void setElectronicDevices(ArrayList<Electronic> electronicDevices) {
        this.electronicDevices = electronicDevices;
    }

    public LocalDateTime  getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(LocalDateTime  registerTime) {
        this.registerTime = registerTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) && Objects.equals(userPassword, user.userPassword) && Objects.equals(userPhoneNumber, user.userPhoneNumber) && Objects.equals(userEmail, user.userEmail) && Objects.equals(userBirthDate, user.userBirthDate) && Objects.equals(electronicDevices, user.electronicDevices) && Objects.equals(registerTime, user.registerTime);
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
                ", userPhoneNumber='" + userPhoneNumber + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userBirthDate='" + userBirthDate + '\'' +
                ", electronicDevices=" + electronicDevices +
                ", registerTime=" + registerTime +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
