package me.day05.practice;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Objects;

public class User implements Cloneable{

    private String userId;
    private String userPassword;
    private int userPhoneNumber;
    private String userEmail;
    private LocalDate userBirthDate;
    private Electronic[] electronicDevices;
    private LocalTime registerTime;

    public User(){
        init();
    }

    private void init(){// 시스템 시간 설정
        setRegisterTime();
    }

    private void setRegisterTime(){
        this.registerTime = LocalTime.now();
    }

    public int getRegisterTime() {
        return registerTime.getHour();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId && userPassword == user.userPassword && userPhoneNumber == user.userPhoneNumber && userBirthDate == user.userBirthDate && registerTime == user.registerTime && Objects.equals(userEmail, user.userEmail) && Arrays.equals(electronicDevices, user.electronicDevices);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(userId, userPassword, userPhoneNumber, userEmail, userBirthDate, registerTime);
        result = 31 * result + Arrays.hashCode(electronicDevices);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userPassword=" + userPassword +
                ", userPhoneNumber=" + userPhoneNumber +
                ", userEmail='" + userEmail + '\'' +
                ", userBirthDate=" + userBirthDate +
                ", electronicDevices=" + Arrays.toString(electronicDevices) +
                ", registerTime=" + registerTime +
                '}';
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

    public LocalDate getUserBirthDate() {
        return userBirthDate;
    }

    public void setUserBirthDate(LocalDate userBirthDate) {
        this.userBirthDate = userBirthDate;
    }

    public Electronic[] getElectronicDevices() {
        return electronicDevices;
    }

    public void setElectronicDevices(Electronic[] electronicDevices) throws CloneNotSupportedException {
        this.electronicDevices = new Electronic[electronicDevices.length];
        for(int i =0 ; i < this.electronicDevices.length; i++) {
            this.electronicDevices[i] = (Electronic) (electronicDevices[i].clone());
        }
    }

}
