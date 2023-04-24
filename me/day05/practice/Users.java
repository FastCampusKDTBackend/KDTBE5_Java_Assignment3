package me.day05.practice;

import java.util.Arrays;

import me.day05.practice.exception.DuplicateUserException;

public class Users {
	private static final int DEFAULT_CAPACITY = 20;
	private static Users users;
	private User[] userList;

	private Users() {
		userList = new User[DEFAULT_CAPACITY];
	}

	public static Users getInstance() {
		if (users == null) {
			Users.users = new Users();
		}
		return Users.users;
	}

	public User findByUserId(String userId) {
		return Arrays.stream(this.userList)
				.filter((user -> user.getUserId().equals(userId)))
				.findFirst()
				.orElse(null);
	}

	public User copy(User user) throws CloneNotSupportedException {
		return (User)(user.clone());
	}

	public User[] getUserList() {
		return userList;
	}

	public void setUserList(User[] userList) {
		this.userList = userList;
	}

	private boolean isDuplicateUser(User user) {
		return Arrays.stream(this.userList)
				.anyMatch(users -> users.getUserId().equals(user.getUserId()));
	}
}
