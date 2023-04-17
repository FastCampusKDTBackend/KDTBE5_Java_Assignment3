package me.day05.practice.Practice02;

import me.day05.practice.Practice01.User;
import me.day05.practice.Practice01.Electronic;

import java.util.Arrays;

public class Users {
	// 문제1. 싱글톤 패턴을 적용하기 위한 필드와 메소드
    private static Users users; 
    public static Users getInstance() {
        if (users == null) {
            users = new Users();
        }
        return users;
    }
    
    private User[] userList;  // 생성된 User 객체들을 모두 저장
    private int idx = 0;  // 배열 idx
    
    // userList의 getter
    public User[] getUserList() {
        return userList;
    }
    
    // userList의 setter
    public void setUserList(User[] userList) {
        this.userList = userList;
    }
    
    // 문제 2.회원 아이디 userId를 통해 인자로 주어진 회원번호에 해당하는 회원을 반환하는 함수를 작성
    public User findByUserId(String userId) {
        for (User userInfo : userList) {
            if (userInfo.getUserId().equals(userId)) {
                return userInfo;
            }
        }
        return null;
    }
    
    // 문제3. 인자로 주어진 회원 정보를 깊은 복사 (deepCopy) 하는 함수를 작성
    public User copy(User user) {
    	if (user == null) return null;
    	int size = user.getElectronicDevices().length;
    	User copiedUser = new User(user.getUserId(), user.getUserPassword(), user.getUserPhoneNumber(), user.getUserEmail(), user.getUserBirthDate(), user.getElectronicDevices());

        //user가 사용중인 전자제품의 리스트 깊은 복사
        Electronic[] usingDevices = new Electronic[size];
        for (int i = 0; i < size; i++) {
            usingDevices[i] = user.getElectronicDevices()[i];
        }
        copiedUser.setElectronicDevices(usingDevices);
        return copiedUser;
    }

    
    // userList 배열에 User 객체 추가
    public void add(User user) {
        userList[idx] = user;
        idx++;
    }
    

    // hashCode 메소드 재정의
    @Override
    public int hashCode() {
        return Arrays.hashCode(userList);
    }
    
    // equals 메소드 재정의
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Users users = (Users) o;
        return Arrays.equals(userList, users.userList);
    }
    
    // toString 메소드 재정의
    @Override
    public String toString() {
        return "Users{" +
                "userList=" + Arrays.toString(userList) +
                '}';
    }

}


