package org.babycat.testers.repository;

import org.babycat.testers.entity.User;
import org.babycat.testers.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class LoginRepository {

    @Qualifier("UserMapper")
    private static UserMapper UserMapper;

    public static void SaveUser(User user) {
        UserMapper.setUser(user);
    }

    /**
     * Gets all users. but you can select anyone.
     * @author babycat_offical
     * */
    public static User GetUser() {
        try {
            User Data = UserMapper.getAllUser();
            if (!(Data == null)) {
                return Data;
            }
            return null;
        } catch (Exception e) {
            System.err.println("*\n| [REPOSITORY.ERROR] We're sorry. an exception was thrown in LoginRepository."
            + "\n| Details: " + e.getMessage() + "\n*");
        }
        return null;
    }

    public static void GetUser(Long id) {
        UserMapper.getUserById(id);
    }

    public static void GetUserName(Long id) {
        UserMapper.getUserNameById(id);
    }
}
