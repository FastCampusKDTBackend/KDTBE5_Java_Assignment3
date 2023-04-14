package Practice01;

import java.util.Arrays;

public class Users {
    private static Users users = null;

    private User[] userList = new User[]{};

    public static Users getInstance() {
        if (users == null) {
            users = new Users();
        }

        return users;
    }

    public User findByUserId(String userId) {
        for (int i = 0; i < userList.length; i++) {
            if (userId.equals(userList[i].getUserId())) {
                return userList[i];
            }
        }

        return null;
    }

    public User Copy(User user) {
        User copyUser = new User();
        copyUser.setUserId(user.getUserId());
        copyUser.setUserEmail(user.getUserEmail());
        copyUser.setUserPassword(user.getUserPassword());
        copyUser.setUserBirthDate(user.getUserBirthDate());
        copyUser.setUserPhoneNumber(user.getUserPhoneNumber());

        return copyUser;
    }
}
