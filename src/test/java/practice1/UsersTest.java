package practice1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class UsersTest {
    static Users users;
    static User user;

    @BeforeAll
    static void setUp() {
        user = new User("test1", "password1", "010-6255-7191"
                , "brotherstone97@gmail.com", LocalDate.of(1997, 11, 14));
        users = Users.getInstance();
        users.setUserList(new User[]{user});
    }

    @Test
    void findByUserId() {
        User newUser = users.findByUserId("test1");
        assertThat(newUser.getUserId()).isEqualTo("test1");
    }

    @Test
    void findNonExistentUserId() {
        assertThatThrownBy(()->{
            User newUser = users.findByUserId("test2");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}