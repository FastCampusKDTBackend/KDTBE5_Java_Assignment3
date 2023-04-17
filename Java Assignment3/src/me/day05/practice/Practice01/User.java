package me.day05.practice.Practice01;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Objects;

public class User {
	private String userId;  // 회원 아이디
	private String userPassword;  // 회원 비번
	private String userPhoneNumber;  // 회원 폰번호
	private String userEmail;  // 회원 이메일
	private LocalDate userBirthDate;  // 회원 생년월일
	private static final int DEFAULT_CAPACITY = 10;  // 사용 중인 전자제품들 배열idx지정
	private Electronic[] electronicDevices = new Electronic[DEFAULT_CAPACITY];  // 사용 중인 전자제품들. 하나의 사용자는 여러 개의 사용중인 전자제품이 있을 수 있음.
	private final LocalDate registerTime;  // 회원 정보가 등록된 시스템 시간. 객체 생성시 시스템 시간으로 자동 설정

	   
	// 생성자( 아이디, 비번, 폰번호, 이메일, 생년월일, 전자제품들, 시스템시간 )
	public User(String userId, String userPassword, String userPhoneNumber, String userEmail, LocalDate userBirthDate) {
	    this.userId = userId;
	    this.userPassword = userPassword;
	    this.userPhoneNumber = userPhoneNumber;
	    this.userEmail = userEmail;
	    this.userBirthDate = userBirthDate;
	    this.registerTime = LocalDate.now(ZoneId.systemDefault());  // 회원 정보가 등록된 시스템 시간. 객체 생성시 시스템 시간으로 자동 설정
	}
	
	public User(String userId, String userPassword, String userPhoneNumber, String userEmail, LocalDate userBirthDate, Electronic[] electronicDevices) {
	    this.userId = userId;
	    this.userPassword = userPassword;
	    this.userPhoneNumber = userPhoneNumber;
	    this.userEmail = userEmail;
	    this.userBirthDate = userBirthDate;
	    this.electronicDevices = electronicDevices;
	    this.registerTime = LocalDate.now(ZoneId.systemDefault());  // 회원 정보가 등록된 시스템 시간. 객체 생성시 시스템 시간으로 자동 설정
	}
    
	// getter&setter
    // Id get
    public String getUserId() {
        return userId;
    }

    // Id set
    public void setUserId(String userId) {
        this.userId = userId;
    }

    // PW get
    public String getUserPassword() {
        return userPassword;
    }

    // PW set
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    // PhoneNum get
    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    // PhoneNum get set
    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    // eMail get
    public String getUserEmail() {
        return userEmail;
    }

    // eMail set
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    // BD get
    public LocalDate getUserBirthDate() {
        return userBirthDate;
    }
    
    // BD set
    public void setUserBirthDate(LocalDate userBirthDate) {
        this.userBirthDate = userBirthDate;
    }

    // 사용 중 전자제품 get
    public Electronic[] getElectronicDevices() {
        return electronicDevices;
    }

    // 사용 중 전자제품 set
    public void setElectronicDevices(Electronic[] electronicDevices) {
        this.electronicDevices = electronicDevices;
    }

	
	// hashCode
    @Override
    public int hashCode() {
    	var prime = 31;
		var result = 1;
		result = prime * result + Objects.hash(userId, userPassword, userPhoneNumber, userEmail, userBirthDate, Arrays.hashCode(electronicDevices));
		return result;
    }
	
	// equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return registerTime.equals(user.registerTime) &&
                Objects.equals(userId, user.userId) &&
                Objects.equals(userPassword, user.userPassword) &&
                Objects.equals(userPhoneNumber, user.userPhoneNumber) &&
                Objects.equals(userEmail, user.userEmail) &&
                Objects.equals(userBirthDate, user.userBirthDate) &&
                Arrays.equals(electronicDevices, user.electronicDevices);
    }
    
	// toString
    @Override
    public String toString() {
    	return "User{" +
                "userId='" + userId + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userPhoneNumber='" + userPhoneNumber + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userBirthDate=" + userBirthDate +
                ", electronicDevices=" + Arrays.toString(electronicDevices) +
                '}';
    }
	
}
