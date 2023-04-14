package Practice01;

import java.time.LocalDateTime;
import java.util.Objects;

public class User {
    private int userId;
    private String userPassword;
    private String userPhoneNumber;
    private String userEmail;
    private String userBirthDate;
    private ElectronicDevices electronicDevices;



    private LocalDateTime localDateTime;

    public User(int userId, String userPassword, String userPhoneNumber, String userEmail, String userBirthDate, ElectronicDevices electronicDevices) {
        this.localDateTime = LocalDateTime.now();
        this.userId = userId;
        this.userPassword = userPassword;
        this.userPhoneNumber = userPhoneNumber;
        this.userEmail = userEmail;
        this.userBirthDate = userBirthDate;
        this.electronicDevices = electronicDevices;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
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

    public ElectronicDevices getElectronicDevices() {
        return electronicDevices;
    }

    public void setElectronicDevices(ElectronicDevices electronicDevices) {
        this.electronicDevices = electronicDevices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId && Objects.equals(userPassword, user.userPassword) && Objects.equals(userPhoneNumber, user.userPhoneNumber) && Objects.equals(userEmail, user.userEmail) && Objects.equals(userBirthDate, user.userBirthDate) && Objects.equals(electronicDevices, user.electronicDevices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userPassword, userPhoneNumber, userEmail, userBirthDate, electronicDevices);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userPassword='" + userPassword + '\'' +
                ", userPhoneNumber='" + userPhoneNumber + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userBirthDate='" + userBirthDate + '\'' +
                ", electronicDevices=" + electronicDevices +
                '}';
    }
}
