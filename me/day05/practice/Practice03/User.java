package ForSubmission.me.day05.practice.Practice03;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class User {
    private String userId;
    private String userPassword;
    private String userPhoneNumber;
    private String userEmail;
    private String userBirthDay;
    private ArrayList<Electronic> electronicDevices = new ArrayList<>();
    private LocalDateTime registerTime;

    public User(String userId, String userPassword, String userPhoneNumber, String userEmail, String userBirthDay) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userPhoneNumber = userPhoneNumber;
        this.userEmail = userEmail;
        this.userBirthDay = userBirthDay;
        this.registerTime = LocalDateTime.now();
    }

    public User(String userId, String userPassword, String userPhoneNumber, String userEmail, String userBirthDay, Electronic electronic) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userPhoneNumber = userPhoneNumber;
        this.userEmail = userEmail;
        this.userBirthDay = userBirthDay;
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

    public String getUserBirthDay() {
        return userBirthDay;
    }

    public void setUserBirthDay(String userBirthDay) {
        this.userBirthDay = userBirthDay;
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
        return Objects.equals(userId, user.userId) && Objects.equals(userPassword, user.userPassword) && Objects.equals(userPhoneNumber, user.userPhoneNumber) && Objects.equals(userEmail, user.userEmail) && Objects.equals(userBirthDay, user.userBirthDay) && Objects.equals(electronicDevices, user.electronicDevices) && Objects.equals(registerTime, user.registerTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userPassword, userPhoneNumber, userEmail, userBirthDay, electronicDevices, registerTime);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userPhoneNumber='" + userPhoneNumber + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userBirthDay='" + userBirthDay + '\'' +
                ", electronicDevices=" + electronicDevices +
                ", registerTime=" + registerTime +
                '}';
    }
}
