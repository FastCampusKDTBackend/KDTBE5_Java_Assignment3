package me.day05.practice;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class User {
    private String userId;
    private String userPassword;
    private String userPhoneNumber;
    private String userEmail;
    private String userBirthDate;
    private Electronic[] electronicDevice;
    private LocalDate registerTime;

    User() {

        setRegisterTime();
    }

    User(String userId, String userPassword, String userPhoneNumber, String userEmail, String userBirthDate, Electronic[] electronicDevice) {
        this();
        this.userId = userId;
        this.userPassword = userPassword;
        this.userPhoneNumber = userPhoneNumber;
        this.userEmail = userEmail;
        this.userBirthDate = userBirthDate;
        this.electronicDevice = electronicDevice;
    }

    private User(String userId, String userPassword, String userPhoneNumber, String userEmail, String userBirthDate, Electronic[] electronicDevice, LocalDate registerTime){
        this.userId = userId;
        this.userPassword = userPassword;
        this.userPhoneNumber = userPhoneNumber;
        this.userEmail = userEmail;
        this.userBirthDate = userBirthDate;
        this.electronicDevice = electronicDevice;
        this.registerTime = registerTime;
    }

    private void setRegisterTime() {
         registerTime = LocalDate.now();
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

    public Electronic[] getElectronicDevice() {
        return electronicDevice;
    }

    public void setElectronicDevice(Electronic[] electronicDevice) {
        this.electronicDevice = electronicDevice;
    }

    public LocalDate getRegisterTime() {
        return registerTime;
    }

//        private void validatePhoneNumberFormat(String userPhoneNumber){}
//        private String formatPhoneNumber(String userPhoneNumber){ validatePhoneNumberFormat(userPhoneNumber) }
//
//        private void validateUserEmailFormat(String userPhoneNumber){}
//        private String formatUserEmail(String userPhoneNumber){ validateUserEmailFormat(String userPhoneNumber) }
//
//        private void validateUserBirthDateFormat(String userBirthDate){}
//        private String formatUserBirthDate(String userBirthDate){ validateUserBirthDateFormat(String userBirthDate) }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userPassword, userEmail, userBirthDate, Arrays.hashCode(electronicDevice), registerTime);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        return Objects.equals(hashCode(), ((User)obj).hashCode());
    }

    @Override
    public String toString() {
        return "User { " +
                "userId=" + userId +
                ", userPassword=" + userPassword +
                ", userPhoneNumber= " + userPhoneNumber +
                ", userEmail=" + userEmail +
                ", userBirthDate=" + userBirthDate +
                ", electronicDevice=" + Arrays.toString(electronicDevice) +
                ", registerTime=" + registerTime + " }";
    }

    @Override
    protected User clone() {
        return new User(userId, userPassword, userPhoneNumber, userEmail, userBirthDate, electronicDevice, registerTime);
    }
}

