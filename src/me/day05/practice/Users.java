package me.day05.practice;

import java.time.LocalDate;
import java.util.*;

public class Users {
    private List<User> userList = new ArrayList<>();
    private User[] userArray;
    private int userArraySize;
    static Users instance;

    //set constructor as private for SingleTon
    private Users(){
        this.userList = new ArrayList<>();
        this.userArray = new User[Define.DEFAULT_CAPACITY];
        this.userArraySize = 0;
    }
    /*
        assignment 2-1
        getInstance method
    */
    public static Users getInstance(){
        if(instance == null){
            instance = new Users();
        }
        return instance;
    }


    /*
        assignment 2-2
        find user by user's id
    */
    public User findByUserId(String userId){
        Optional<User> userOpt = userList
                .stream().filter(user -> userId.equals(user.getUserId()))
                .findFirst();
        if (userOpt.isPresent()) {
            return userOpt.get();
        }
        System.out.printf("'%s' Not Found\n",userId);
        return null;
    }

    public User findByUserIdFromArray(String userId){
        for(User user: userArray){
            if(user != null && user.getUserId().equals(userId)){
                return user;
            }
        }

        System.out.printf("'%s' Not Found\n",userId);
        return null;
    }

    //Todo : add validation check of userId, userPassword, userPhoneNumber, userEmail, userBirthDate
    public boolean addUser(String userId, String userPassword, String userPhoneNumber, String userEmail, LocalDate userBirthDate){
        //Use List
        //duplication check
        if(findByUserId(userId) != null){
            System.out.printf("'%s' Already Exists\n",userId);
            return false;
        }

        userList.add(new User.Builder()
                .userId(userId)
                .userPassword(userPassword)
                .userPhoneNumber(userPhoneNumber)
                .userEmail(userEmail)
                .userBirthDate(userBirthDate)
                .build());
        return true;
    }

    public boolean addUserToArray(String userId, String userPassword, String userPhoneNumber, String userEmail, LocalDate userBirthDate){
        //use Array
        //duplication check
        if(userArraySize > 0){
            if(findByUserIdFromArray(userId) != null){
                System.out.printf("'%s' Already Exists\n",userId);
                return false;
            }
        }

        if(userArraySize == userArray.length){
            resize(userArraySize + 10);
        }
        userArray[userArraySize] = (new User.Builder()
                .userId(userId)
                .userPassword(userPassword)
                .userPhoneNumber(userPhoneNumber)
                .userEmail(userEmail)
                .userBirthDate(userBirthDate)
                .build());
        userArraySize++;

        return true;
    }

    private void resize(int newLength){
        userArray = Arrays.copyOf(this.userArray, newLength);
    }

    public void initUsers(){
        String[] userId = {"tester01","tester02","tester03","tester01"};
        String[] userPassword = {"tester01PW","tester02PW","tester03PW","tester01PW"};
        String[] userPhoneNumber = {"010-0000-0001", "010-0000-0002", "010-0000-0003", "010-0000-0001",};
        String[] userEmail = {"tester01@gmail.com", "tester02@gmail.com", "tester03@gmail.com", "tester01@gmail.com"};
        LocalDate[] userBirthDate = {LocalDate.parse("1965-12-14"),LocalDate.parse("1982-07-31"), LocalDate.parse("2019-10-10"), LocalDate.parse("2000-01-01")};
        System.out.println("Use List");
        for(int i = 0 ; i < userId.length ; i++){
            //use List
            addUser(userId[i], userPassword[i],userPhoneNumber[i], userEmail[i], userBirthDate[i]);
        }
        System.out.println("Use Array");
        for (int i = 0 ; i < userId.length ; i++){
            //use Array
            addUserToArray(userId[i], userPassword[i],userPhoneNumber[i], userEmail[i], userBirthDate[i]);
        }
    }

    /*
        assignment 2
        getter(), setter(), hashcode(), equals(), toString()
    */
    public List<User> getUserList() {
        return userList;
    }

    public void setUserArray(User[] userArray) {
        this.userArray = userArray;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public User[] getUserArray() {
        return userArray;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users users)) return false;
        return Objects.equals(userList, users.userList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userList);
    }

    @Override
    public String toString() {
        return "Users{" +
                "userList=" + userList +
                '}';
    }
}
