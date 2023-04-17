package Practice;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

public class User {
    private String userId;
    private String userPassword;
    private String userPhoneNumber;
    private String userEmail;
    private String userBirthDate;
    private LocalDateTime registerTime;

    private Electronic[] electronicDevices;

    public User(){}

    public User(String userId, String userPassword, String userPhoneNumber, String userEmail, String userBirthDate, LocalDateTime registerTime, Electronic[] electronicDevices) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userPhoneNumber = userPhoneNumber;
        this.userEmail = userEmail;
        this.userBirthDate = userBirthDate;
        this.registerTime = registerTime;
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

    public LocalDateTime getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(LocalDateTime registerTime) {
        this.registerTime = registerTime;
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
        return userPhoneNumber == user.userPhoneNumber && Objects.equals(userId, user.userId) && Objects.equals(userPassword, user.userPassword) && Objects.equals(userEmail, user.userEmail) && Objects.equals(userBirthDate, user.userBirthDate) && Objects.equals(registerTime, user.registerTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userPassword, userPhoneNumber, userEmail, userBirthDate, registerTime);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userPhoneNumber=" + userPhoneNumber +
                ", userEmail='" + userEmail + '\'' +
                ", userBirthDate='" + userBirthDate + '\'' +
                ", registerTime=" + registerTime +
                '}';
    }
}
