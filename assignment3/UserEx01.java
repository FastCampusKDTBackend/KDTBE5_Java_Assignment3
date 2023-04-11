package assignment3;


import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Objects;

public class UserEx01 {

	private String userId;
	private String userPassword;
	private String userPhonenumber;
	private String userEmail;
	private String userBirthDate;

	LocalTime registerTime = LocalTime.now();
	
	ArrayList<String>  electronicDevices = new ArrayList<String> ();
	
	
	@Override
	public String toString() {
		return "UserEx01 [userId=" + userId + ", userPassword=" + userPassword + ", userPhonenumber=" + userPhonenumber
				+ ", userEmail=" + userEmail + ", userBirthDate=" + userBirthDate + ", registerTime=" + registerTime
				+ ", electronicDevices=" + electronicDevices + "]";
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
	public String getUserPhonenumber() {
		return userPhonenumber;
	}
	public void setUserPhonenumber(String userPhonenumber) {
		this.userPhonenumber = userPhonenumber;
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
	public void setElectronicDevices(String electronicDevices) {
		this.electronicDevices.add(electronicDevices);
	}
	public void getRegisterTime() {
		System.out.println(registerTime);
	}
	@Override
	public int hashCode() {
		return Objects.hash(electronicDevices, registerTime, userBirthDate, userEmail, userId, userPassword,
				userPhonenumber);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserEx01 other = (UserEx01) obj;
		return Objects.equals(electronicDevices, other.electronicDevices)
				&& Objects.equals(registerTime, other.registerTime)
				&& Objects.equals(userBirthDate, other.userBirthDate) && Objects.equals(userEmail, other.userEmail)
				&& Objects.equals(userId, other.userId) && Objects.equals(userPassword, other.userPassword)
				&& Objects.equals(userPhonenumber, other.userPhonenumber);
	}

	
	
	
}
