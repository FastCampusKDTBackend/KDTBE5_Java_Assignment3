package me.day05.practice01;

import me.day05.practice02.Users;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

public class User {
    private static final int DEFAULT_CAPACITY = 10;
    private String userId;
    private String userPassword;
    private String userPhoneNumber;
    private String userEmail;
    private String userBirthDate;
    private Electronic[] electronicDevices;
    private LocalDateTime registerTime;

    private int size;

    public User() {
        this.registerTime = LocalDateTime.now();
        this.electronicDevices = new Electronic[DEFAULT_CAPACITY];
        Users.getInstance().add(this);
        this.size = 0;
    }

    public User(String userId, String userPassword) {
        this();

        this.userId = userId;
        this.userPassword = userPassword;
    }

    public User(String userId, String userPassword, String userPhoneNumber, String userEmail, String userBirthDate) {
        this();

        this.userId = userId;
        this.userPassword = userPassword;
        this.userPhoneNumber = userPhoneNumber;
        this.userEmail = userEmail;
        this.userBirthDate = userBirthDate;
    }

    public User(String userId, String userPassword, String userPhoneNumber, String userEmail, String userBirthDate, Electronic[] electronicDevices) {
        this();

        this.userId = userId;
        this.userPassword = userPassword;
        this.userPhoneNumber = userPhoneNumber;
        this.userEmail = userEmail;
        this.userBirthDate = userBirthDate;
        this.electronicDevices = electronicDevices;
    }

    //region Getter / Setter
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
    //endregion

    //region hashCode & equals / toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) && Objects.equals(userPassword, user.userPassword) && Objects.equals(userPhoneNumber, user.userPhoneNumber) && Objects.equals(userEmail, user.userEmail) && Objects.equals(userBirthDate, user.userBirthDate) && Arrays.equals(electronicDevices, user.electronicDevices) && registerTime.equals(user.registerTime);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(userId, userPassword, userPhoneNumber, userEmail, userBirthDate, registerTime);
        result = 31 * result + Arrays.hashCode(electronicDevices);
        return result;
    }

    @Override
    public String toString() {
        return userId + "님의 회원정보 입니다. [ID : " + userId + ", PW : " + userPassword + ", PhoneNumber : " + userPhoneNumber + ", Email : "
                + userEmail + ", BirthDate : " + userBirthDate + ", registerTime : " + registerTime + ",\n\t\t\t\t\t\t\tElectronicDevices : ("
                + getDevicesInfo() + ")]\n";
    }
    //endregion

    public void addElectronic(Electronic electronic) {
        this.electronicDevices[size] = electronic;
        size++;
    }

    private String getDevicesInfo() {
        String deviceStr = "";
        for(Electronic electronic : electronicDevices) {
            if (electronic == null) continue;

            deviceStr += electronic.getProductNo() + "(" + electronic.getModelName() + "), ";
        }

        if (deviceStr == "") return null;

        return deviceStr.substring(0, deviceStr.length()-2);
    }
}
