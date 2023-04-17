package me.day05.practice.Practice01;

import java.time.LocalTime;
import java.util.Objects;

public class User {

    private String userId;				
    private String userPassword;		
    private int userPhoneNumber;		
    private String userEmail;			
    private int userBirthDate;			
    private String[] electronicDevices;	
    public LocalTime registerTime;		

    
    public User(){
        registerTime = LocalTime.now();	
    }

    public User(String userId, String userPassword, int userPhoneNumber, String userEmail, int userBirthDate,
                String[] electronicDevices) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userPhoneNumber = userPhoneNumber;
        this.userEmail = userEmail;
        this.userBirthDate = userBirthDate;
        this.electronicDevices = electronicDevices;
        this.registerTime = LocalTime.now();
    }


    @Override
    public int hashCode() {
        return Objects.hash(userId, userPassword, userPhoneNumber, userEmail, userBirthDate, electronicDevices,
                registerTime);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof User))
            return false;

        User user = (User) obj;
        return (this.userId == user.userId) || (this.userPassword == user.userPassword)
                || (this.userPhoneNumber == user.userPhoneNumber) || (this.userEmail == user.userEmail)
                || (this.userBirthDate == user.userBirthDate) || (this.electronicDevices == user.electronicDevices)
                || (this.registerTime == user.registerTime);
    }

    @Override
    public String toString() {
        return "User{userId:" + userId +
                ", userPassword:" + userPassword +
                ", userPhonNumber:" + userPhoneNumber +
                ", userEmail:" + userEmail +
                ", userBirthDat:" + userBirthDate +
                ", electronicDevice:" + electronicDevices +
                ", registerTime:" + registerTime +
                "}";
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

    public String[] getElectronicDevices() {
        return electronicDevices;
    }

    public void setElectronicDevices(String[] electronicDevices) {
        this.electronicDevices = electronicDevices;
    }

    public LocalTime getTime() {
        return this.registerTime;
    }
}
