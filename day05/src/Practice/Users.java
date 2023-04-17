package Practice;

import java.util.Arrays;

public class Users {
    private User[] userList;
    private static Users users;

    private Users(){}

    private Users(User[] userList) {
        this.userList = userList;
    }

    //싱글톤
    public static Users getInstance(){
        if(users == null){
            users = new Users();
        }
        return users;
    }

    //userID로 회원 찾기
    public User findByUserId(String userID){
        for(int i = 0; i < userList.length; i++){
            if(userList[i].getUserId().equals(userID)){
                return userList[i];
            }
        }
        return null;
    }

    //deepcopy
    public User copy(User user){
        User copy = new User();
        if(user == null){
            return copy;
        }

        copy = user;
        copy.setUserId(user.getUserId());
        copy.setRegisterTime(user.getRegisterTime());
        copy.setUserBirthDate(user.getUserBirthDate());
        copy.setUserEmail(user.getUserEmail());
        copy.setUserPassword(user.getUserPassword());
        copy.setUserId(user.getUserId());

        return copy;
    }

    public User[] getUserList() {
        return userList;
    }

    public void setUserList(User[] userList) {
        this.userList = userList;
    }

    public static Users getUsers() {
        return users;
    }

    public static void setUsers(Users users) {
        Users.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Arrays.equals(userList, users.userList);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(userList);
    }

    @Override
    public String toString() {
        return "Users{" +
                "userList=" + Arrays.toString(userList) +
                '}';
    }
}
