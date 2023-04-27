package me.day05.practice;

import java.time.LocalDate;
import java.util.Objects;

public class User {
    private String userId;
    private String userPassword;
    private String userPhoneNumber;
    private String userEmail;
    private LocalDate userBirthDate;
    private Electronics electronicDevices;
    private Long registerTime;

    public User(Builder builder) {
        userId = builder.userId;
        userPassword = builder.userPassword;
        userPhoneNumber = builder.userPhoneNumber;
        userEmail = builder.userEmail;
        userBirthDate = builder.userBirthDate;
        electronicDevices = builder.electronicDevices;
        registerTime = System.currentTimeMillis();
    }
    /*
        assignment 2-3
        Deep coy method
    */
    public User(User user) {
        this.userId = user.userId;
        this.userPassword = user.userPassword;
        this.userPhoneNumber = user.userPhoneNumber;
        this.userEmail = user.userEmail;
        this.userBirthDate = user.userBirthDate;
        this.electronicDevices = user.electronicDevices;
        this.registerTime = user.registerTime;
    }
    public static User copy(User user){
        return new User(user);
    }

    /*
        assignment 1
        getter(), setter(), hashcode(), equals(), toString()
    */
    //add conditions in getter & setter if necessary
    public String getUserId() {
        return userId;
    }
    //Setter for Testing Shallow & DeepCopy
    public void setUserId(String userId){
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

    public LocalDate getUserBirthDate() {
        return userBirthDate;
    }

    public void setUserBirthDate(LocalDate userBirthDate) {
        this.userBirthDate = userBirthDate;
    }

    public Electronics getElectronicDevices() {
        return electronicDevices;
    }

    public void setElectronicDevices(Electronics electronicDevices) {
        this.electronicDevices = electronicDevices;
    }

    public Long getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Long registerTime) {
        this.registerTime = registerTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return userId == user.userId && userPassword.equals(user.userPassword) && Objects.equals(userPhoneNumber, user.userPhoneNumber) && Objects.equals(userBirthDate, user.userBirthDate) && Objects.equals(electronicDevices, user.electronicDevices) && registerTime.equals(user.registerTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userPassword, userPhoneNumber, userBirthDate, electronicDevices, registerTime);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userPassword='" + userPassword + '\'' +
                ", userPhoneNumber='" + userPhoneNumber + '\'' +
                ", userBirthDate=" + userBirthDate +
                ", electronics=" + electronicDevices +
                ", registerTime=" + registerTime +
                '}' + "\n";
    }

    public static class Builder{
        private String userId;
        private String userPassword;
        private String userPhoneNumber;
        private String userEmail;
        private LocalDate userBirthDate;
        private Electronics electronicDevices;

        public Builder userId (String userId) {
            this.userId = userId;
            return this;
        }

        public Builder userPassword (String userPassword){
            this.userPassword = userPassword;
            return this;
        }

        public Builder userPhoneNumber (String userPhoneNumber){
            this.userPhoneNumber = userPhoneNumber;
            return this;
        }
        public Builder userEmail (String userEmail){
            this.userEmail = userEmail;
            return this;
        }

        public Builder userBirthDate (LocalDate userBirthDate){
            this.userBirthDate = userBirthDate;
            return this;
        }
        /*public Builder registerTime (Long registerTime){
            this.registerTime = registerTime;
            return this;
        }*/

        public User build() {
            return new User(this);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "userId='" + userId + '\'' +
                    ", userPassword='" + userPassword + '\'' +
                    ", userBirthDate=" + userBirthDate +
                    ", electronicDevices=" + electronicDevices +
                    '}';
        }
    }
}
