package me.day05.practice.practice01;

import java.time.LocalDate;
import java.util.ArrayList;

public class User {

	private String userId;  						 // 1. 회원 ID
	private String userPassword;				     // 2. 회원 비밀번호
	private String userPhoneNumber;    	             // 3. 회원 핸드폰번호
	private String userEmail;   				     // 4. 회원 이메일
	private String userBirthDate;  					 // 5. 회원 생년월일
	private ArrayList<Electronic> electronicDevices; // 6. 사용 중인 전자제품
	private LocalDate registerTime;		  		     // 7. 회원 정보가 등록된 시스템 시간
	
	public User(String userId, String userPassword) {
		if(userId != this.userId) {
			this.userId = userId;
		} else {
			System.out.println("이미 있는 ID입니다.");
			return;
		}
		this.userPassword = userPassword;
		registerTime = LocalDate.now();
		
		electronicDevices = new ArrayList<>();
	}
	// 1. 회원 ID
	public String getUserId() {
		return userId;
	}
	// 2. 회원 비밀번호
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	// 3. 회원 핸드폰번호
	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}
	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}
	// 4. 회원 이메일
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	// 5. 회원 생년월일
	public String getUserBirthDate() {
		return userBirthDate;
	}
	public void setUserBirthDate(String userBirthDate) {
		this.userBirthDate = userBirthDate;
	}
	// 6. 사용 중인 전자제품
	public ArrayList<Electronic> getElectronicDevices() {
		return electronicDevices;
	}
	public void addElectronicDevices(Electronic electronic) {
		this.electronicDevices.add(electronic);
	}
	// 7. 회원 정보가 등록된 시스템 시간
	public LocalDate getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(LocalDate registerTime) {
		this.registerTime = registerTime;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof User) {
			if(((User) obj).getUserId() == this.getUserId()) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return System.identityHashCode(this);
	}
	
	@Override
	public String toString() {
		return userId + ", " + userBirthDate + ", " + userEmail + ", 사용중인 제품 수 " + electronicDevices.size();
	}
	
}
