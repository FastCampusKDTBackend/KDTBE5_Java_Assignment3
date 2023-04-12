package Assignment.reDay03;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Objects;

public class User {
    private String userId;
    private String userPassword;
    private String userPhoneNumber;
    private String userEmail;
    private String userBirthDate;
    private Electronic[] electronicDevices;
    private LocalDateTime registerTime;

    public User(String userId, String userPassword, String userPhoneNumber, String userEmail, String userBirthDate) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userPhoneNumber = userPhoneNumber;
        this.userEmail = userEmail;
        this.userBirthDate = userBirthDate;
        this.registerTime = LocalDateTime.now(ZoneId.systemDefault());
    }

    public User(String userId, String userPassword, String userPhoneNumber, String userEmail, String userBirthDate, Electronic[] electronicDevices, LocalDateTime registerTime) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userPhoneNumber = userPhoneNumber;
        this.userEmail = userEmail;
        this.userBirthDate = userBirthDate;
        this.electronicDevices = electronicDevices;
        this.registerTime = registerTime;
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

    public Electronic[] getElectronicDevices() {
        return electronicDevices;
    }

    public void setElectronicDevices(Electronic[] electronicDevices) {
        this.electronicDevices = electronicDevices;
    }

    public LocalDateTime getRegisterTime() {
        return registerTime;
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
        int result = Objects.hash(userId, userPassword, userPhoneNumber, userEmail, userBirthDate, registerTime);
        result = 31 * result + Arrays.hashCode(electronicDevices);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userPhoneNumber='" + userPhoneNumber + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userBirthDate='" + userBirthDate + '\'' +
                ", electronicDevices=" + Arrays.toString(electronicDevices) +
                ", registerTime=" + registerTime +
                '}';
    }

    public User copy() {
        return new User(
                this.getUserId(),
                this.getUserPassword(),
                this.getUserPhoneNumber(),
                this.getUserEmail(),
                this.getUserBirthDate(),
                this.getElectronicDevices(),
                this.getRegisterTime());
    }
}
