package Practice02;

import Practice01.User;

import java.util.Arrays;

//실습2.  객체 배열 `User[] userList`를 필드로 있는 `Users` 클래스를 작성하시오.
//    - 필드 - User[] userList (생성된 User 객체들을 모두 저장)
//    - 메소드 - 생성자, getter(), setter(), hashCode(), equals(), toString()
public class Users {
    private static User[] userslist;
    private static Users singleton;
    private Users(){
        userslist =new User[10];
    }

    public User[] getUserslist() {
        return userslist;
    }

    public void setUserslist(User[] userslist) {
        this.userslist = userslist;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(userslist);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users u = (Users) o;
        return Arrays.equals(userslist, u.userslist);
    }

    @Override
    public String toString() {
        String s="";
        for(int i=0;i<userslist.length;i++){
            s+=userslist[i];
        }
        return s;
    }

    //2-1 Users 클래스의 객체를 싱글톤으로 생성하는 함수를 작성(Double Checked Locking 방식)

    public Users getInstance(){
         if(singleton==null){
             synchronized (Users.class) {
                 if (singleton == null) {
                     singleton = new Users();
                 }
             }
         }
         return singleton;
    }

    //2-2 회원 아이디 userId를 통해 인자로 주어진 회원번호에 해당하는 회원을 반환하는 함수를 작성
    public User findByUserId(String userId){
        for(int i=0; i<userslist.length;i++){
            if(userslist[i].getUserId()==userId){
                return userslist[i];
            }
        }
        return null;
    }


    //2-3 인자로 주어진 회원 정보를 깊은 복사 (deepCopy - '실제 값'을 새로운 메모리 공간에 복사하는 것) 하는 함수를 작성
    public User copy(User user){
        User copy =new User();
        copy.setUserId(user.getUserId());
        copy.setUserPassword(user.getUserPassword());
        copy.setUserEmail(user.getUserEmail());
        copy.setUserBirthDate(user.getUserBirthDate());
        copy.setUserPhoneNumber(user.getUserPhoneNumber());
        copy.setElectronicDevices(user.getElectronicDevices());
        copy.setRegistertime(user.getRegistertime());

        return copy;
    }
}
