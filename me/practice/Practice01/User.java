package KDTBE5_Java_Assignment3.me.practice.Practice01;

import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Objects;

import static java.time.LocalDateTime.now;

public class User {
    private String userId;
    private String userPassword;
    private String userEmail;
    private String userBirthDate;
    private Electronic [] electronicDevices;
    private String registerTime;

    public User() {

    }

    public User(String userId, String userPassword, String userEmail, String userBirthDate, Electronic[] electronicDevices) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userBirthDate = userBirthDate;
        this.electronicDevices = electronicDevices;
        this.registerTime = now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
//    public User(String userId, String userPassword, String userEmail, String userBirthDate, Electronic[] electronicDevices,String registerTime) {
//        this.userId = userId;
//        this.userPassword = userPassword;
//        this.userEmail = userEmail;
//        this.userBirthDate = userBirthDate;
//        this.electronicDevices = electronicDevices;
//        this.registerTime = registerTime;
//    }

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

    public String getRegisterTime() {
        return registerTime;
    }

//    @Override
//    public String toString() {
//        return "User{" +
//                "userId='" + userId + '\'' +
//                ", userPassword='" + userPassword + '\'' +
//                ", userEmail='" + userEmail + '\'' +
//                ", userBirthDate='" + userBirthDate + '\'' +
//                ", electronicDevices=" + Arrays.toString(electronicDevices) +
//                ", registerTime='" + registerTime + '\'' +
//                '}';
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) && Objects.equals(userPassword, user.userPassword) && Objects.equals(userEmail, user.userEmail) && Objects.equals(userBirthDate, user.userBirthDate) && Arrays.equals(electronicDevices, user.electronicDevices) && Objects.equals(registerTime, user.registerTime);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(userId, userPassword, userEmail, userBirthDate, registerTime);
        result = 31 * result + Arrays.hashCode(electronicDevices);
        return result;
    }
}
