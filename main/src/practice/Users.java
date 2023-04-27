package practice;

import java.util.Arrays;

public class Users {
    private static Users users = null;

    private User[] userList = new User[]{};

    private Users() {
    }

    public static Users getInstance() {
        if (users == null) {
            users = new Users();
        }

        return users;
    }

    public User findByUserId(String userId) {
        Arrays.stream(userList)
                .filter(user -> user.getUserId().equals(userId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 id입니다."));
    }

    public User Copy(User user) throws CloneNotSupportedException {
        User copyUser = new User();
        copyUser.setUserId(user.getUserId());
        copyUser.setUserEmail(user.getUserEmail());
        copyUser.setUserPassword(user.getUserPassword());
        copyUser.setUserBirthDate(user.getUserBirthDate());
        copyUser.setUserPhoneNumber(user.getUserPhoneNumber());

        Electronic[] originalUserElectronic = user.getElectronicDevices();
        Electronic[] newElectronic = new Electronic[originalUserElectronic.length];
        for (int i = 0; i < originalUserElectronic.length; i++) {
            newElectronic[i] = (Electronic) originalUserElectronic[i].clone();
        }
        copyUser.setElectronicDevices(newElectronic);
        return copyUser;
    }
}
