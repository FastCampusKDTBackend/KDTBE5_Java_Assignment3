package me.day05.practice.practice02;

import java.util.Arrays;

import me.day05.practice.practice01.User;

public class Users {
	
	private User[] userList;
	private int size;
	
	// 실습 2-1. Users 클래스의 객체를 싱글톤으로 생성하는 함수를 작성하시오.
	private static Users users;
	
	private Users() {
		size = 0;
		userList = new User[10];
	}
	
	public static Users gerInstance() {
		if(users == null) {
			users = new Users();
		}
		return users;
	}

	public User[] getUserList() {
		return userList;
	}

	public void setUserList(User[] userList) {
		this.userList = userList;
	}
	
	public void addUsers(User user) {
		if(userList.length <= size) {
			userList = Arrays.copyOf(userList, userList.length * 2);
		}
		for(int i = 0; i < userList.length; i++) {
			if(userList[i] == null) {
				userList[i] = user;
				size++;
				return;
			}
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Users) {
			if(((Users) obj).getUserList().length == userList.length) {
				for(int i = 0; i < userList.length; i++) {
					if(userList[i].getUserId() != ((Users)obj).getUserList()[i].getUserId()) {
						return false;
					}
				}
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return userList.hashCode();
	}

	@Override
	public String toString() {
		return "총 유저 수: " + size;
	}

	// 실습 2-2. 회원 아이디 userId를 통해 인자로 주어진 회원번호에 해당하는 회원을 반환하는 함수를 작성하시오.
	public User findByUserId(String userId) {
		for(int i = 0; i < userList.length; i++) {
			if(userList[i].getUserId().equals(userId)) {
				return userList[i]; // User 클래스 toString 재정의 필요.
			}
		}
		System.out.println("찾는 userId 가 없습니다.");
		return null;
	}
	
	// 실습 2-3. 인자로 주어진 회원 정보를 깊은 복사 (deepCopy) 하는 함수를 작성하시오.
	// User 복사가 왜 Users에 있니..?
	public User copy(User user) {
		User copyUser = new User(user.getUserId(), user.getUserPassword());
		copyUser.setUserBirthDate(user.getUserBirthDate());
		copyUser.setUserEmail(user.getUserEmail());
		copyUser.setUserPhoneNumber(user.getUserPhoneNumber());
		copyUser.setRegisterTime(user.getRegisterTime());
		for(int i = 0; i < user.getElectronicDevices().size(); i++) {
			copyUser.addElectronicDevices(user.getElectronicDevices().get(i));
		}
		
		return copyUser;
	}
	
}
