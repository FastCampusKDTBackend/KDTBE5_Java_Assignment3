package practice01;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Objects;

public class User {
    private String userId; //회원 아이디
    private String userPassword; //회원 비밀번호
    private String userPhoneNumber; //회원 핸드폰번호
    private String userEmail; //회원 이메일
    private LocalDate userBirthDate; //회원 생년월일
    private final LocalDate registerTime; //회원정보가 등록된 시스템시간
    private Electronic[] electronicDevices; //사용중인 전자제품들

    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private int capacity;

    public User() {
        //객체 생성시 시스템 시간으로 registerTime 자동 생성
        this.registerTime = setRegisterTime();
        this.electronicDevices = new Electronic[DEFAULT_CAPACITY];
        this.capacity = DEFAULT_CAPACITY;
        this.size = 0;
    }

    public User(String userId, String userPassword, String userPhoneNumber, String userEmail, LocalDate userBirthDate) {
        this();
        this.userId = userId;
        this.userPassword = userPassword;
        this.userPhoneNumber = userPhoneNumber;
        this.userEmail = userEmail;
        this.userBirthDate = userBirthDate;
    }

    public User(String userId, String userPassword, String userPhoneNumber, String userEmail, LocalDate userBirthDate, Electronic[] electronicDevices) {
        this(userId, userPassword, userPhoneNumber, userEmail, userBirthDate);
        this.electronicDevices = electronicDevices;
    }

    private LocalDate setRegisterTime() { //객체가 생성될 때 내부에서 한 번만 호출된다.
        return LocalDate.now(ZoneId.systemDefault());
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

    public LocalDate getUserBirthDate() {
        return userBirthDate;
    }

    public void setUserBirthDate(LocalDate userBirthDate) {
        this.userBirthDate = userBirthDate;
    }

    public Electronic[] getElectronicDevices() {
        return electronicDevices;
    }

    public void setElectronicDevices(Electronic[] electronicDevices) {
        this.electronicDevices = electronicDevices;
    }

    public void addElectronicDevices(Electronic electronic) {
        if (size < capacity) {
            this.electronicDevices[size] = electronic;
            size++;
        } else {
            extendDevicesArray();
            addElectronicDevices(electronic);
        }
    }

    private void extendDevicesArray() {
        capacity *= 2;
        electronicDevices = Arrays.copyOf(electronicDevices, capacity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) && Objects.equals(userPassword, user.userPassword) && Objects.equals(userPhoneNumber, user.userPhoneNumber) && Objects.equals(userEmail, user.userEmail) && Objects.equals(userBirthDate, user.userBirthDate) && Arrays.equals(electronicDevices, user.electronicDevices);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(userId, userPassword, userPhoneNumber, userEmail, userBirthDate);
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
                ", userBirthDate=" + userBirthDate +
                ", registerTime=" + registerTime +
                ", electronicDevices=" + Arrays.toString(electronicDevices) +
                '}' + "\n";
    }
}

