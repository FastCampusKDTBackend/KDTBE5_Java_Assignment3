package Practice01;

import java.lang.reflect.Member;
import java.util.Arrays;
import java.util.Objects;

public class Users {
    //////////////
    //singleton
    private static Users allUsers;

    public static Users getInstance(){
        if(allUsers == null){
            allUsers = new Users();
        }
        return allUsers;
    }
    //////////////

    private User[] userList;

    private static final int DEFAULT = 10;
    private int size;
    private int capacity;

    private Users(){
        userList = new User[DEFAULT];
        capacity = DEFAULT;
    }

    public Users(int initial){
        userList = new User[initial];
        capacity = initial;
    }

    public Users(User[] userList){
        this.userList = userList;
        capacity = userList.length;
        size = userList.length;
    }

    public User[] getUserList(){
        return userList;
    }

    public void init() {
        for (int i = 0; i < 10; i++) {
            allUsers.add(new User(
                    Character.toString('a'+i),
                    Character.toString('a'+i) +"1234"
            ));
        }
    }


    public User findByUserId(String userId){
        if(userId == null) return null;
        if(allUsers == null) return null;


        for (int i = 0; i < allUsers.size(); i++) {
            if (allUsers.get(i).getUserId() == userId){
                return allUsers.get(i);
            }
        }
        return null;
    }

    public User copy(User user){
        if(user == null) return null;
        User copyUser = new User(user.getUserId(), user.getUserPassword(), user.getUserPhoneNumber(), user.getUserEmail(), user.getUserBirthDate(), user.getElectronicDevices());
        return copyUser;
    }



    public int size() {
        return size;
    }

    private int capacity() {
        return capacity;
    }

    public User get(int index){
        if (index<0 || index >= size) return null;
        return userList[index];
    }

    public void set(int index, User user){
        if(index<0 || index >=size) return;
        if(user == null) return;

        userList[index] = user;
    }

    public void add(User user){
        if(user == null) return;

        if(size<capacity){
            userList[size] = user;
            size++;
        }else{
            grow();
            add(user);
        }
    }

    private void grow(){
        capacity *= 2;
        userList = Arrays.copyOf(userList, capacity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return size == users.size && capacity == users.capacity && Arrays.equals(userList, users.userList);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size, capacity);
        result = 31 * result + Arrays.hashCode(userList);
        return result;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userList=" + Arrays.toString(userList) +
                ", size=" + size +
                ", capacity=" + capacity +
                '}';
    }
}
