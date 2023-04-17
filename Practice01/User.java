package Practice01;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Objects;

public class User {

    String userId;
    String userPassword;
    String userPhoneNumber;
    String userEmail;
    String userBirthDate;

    ArrayList<String> electronicDevices =new ArrayList<>();
    LocalTime registertime=LocalTime.now();//현재 시간 출력



    public String toString(){
        return "[User info] Id: " + userId+"PassWord: "+userPassword+"PhoneNumber: "
                +userPhoneNumber+"Email: "+userEmail+"BirthDate: "+userBirthDate+
                "Registertime: "+registertime+"electronicDevices: "+electronicDevices;
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

    public ArrayList<String> getElectronicDevices() {
        return electronicDevices;
    }

    public void setElectronicDevices(ArrayList<String> electronicDevices) {
        this.electronicDevices = electronicDevices;
    }

    public LocalTime getRegistertime() {
        return registertime;
    }

    public void setRegistertime(LocalTime registertime) {
        this.registertime = registertime;
    }

    @Override
    public int hashCode(){
        return Objects.hash(electronicDevices, registertime, userBirthDate, userEmail, userId, userPassword,
                userPhoneNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User u = (User) o;
        return Objects.equals(electronicDevices, u.electronicDevices) &&
                Objects.equals(registertime, u.registertime)&&
                Objects.equals(userBirthDate, u.userBirthDate)&&
                Objects.equals(userEmail, u.userEmail)&&
                Objects.equals(userId, u.userId)&&
                Objects.equals(userPassword, u.userPassword)&&
                Objects.equals(userPhoneNumber, u.userPhoneNumber) ;
    }
}
