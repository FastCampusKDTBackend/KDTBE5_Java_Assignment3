package assignment3;

public class UserEx02 {

	private static UserEx02 instance;
	private static UserEx02[] userList;
	
	private UserEx02() {}
	//getInstance
	public static UserEx02 getInstance() {
		if(instance == null) {
			instance = new UserEx02();
		}
		return instance;
	}


	//findByUserId
	public UserEx02 findByUserId(String userId) {
		for(UserEx02 user : userList) {
			if(UserEx02.getUserList().equals(userId)) {
				return user;
			}
		}
		return null;
	}
	//딥카피
	public UserEx02 Copy(UserEx02 user) {
		UserEx02 newUser = new UserEx02();
		//newUser.setUser/Id/Password/Name/etc/(user.getXX())
		return newUser;
	}

	
	// get set 메소드
	public static UserEx02[] getUserList() {
		return userList;
	}
	public static void setUserList(UserEx02[] userList) {
		UserEx02.userList = userList;
	}

	


}
