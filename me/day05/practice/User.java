package me.day05.practice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

public class User implements Cloneable {
	private String userId;
	private String userPassword;
	private String userPhoneNumber;
	private String email;
	private LocalDate userBirthDate;
	private Electronic[] electronicDevices;
	private LocalDateTime registerTime;

	public User() {
		this.registerTime = LocalDateTime.now();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public LocalDateTime getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(LocalDateTime registerTime) {
		this.registerTime = registerTime;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		User user = (User)o;
		return userId.equals(user.userId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(userId);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return "User{" +
				"userId='" + userId + '\'' +
				", userPassword='" + userPassword + '\'' +
				", userPhoneNumber='" + userPhoneNumber + '\'' +
				", email='" + email + '\'' +
				", userBirthDate=" + userBirthDate +
				", electronicDevices=" + Arrays.toString(electronicDevices) +
				", registerTime=" + registerTime +
				'}';
	}
}
