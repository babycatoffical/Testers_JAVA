package org.babycat.testers.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.babycat.testers.entity.User;
import org.babycat.testers.mappers.UserMapper;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LoginRepository {

    private static UserMapper UserMapper;
    private static final String name = "LoginRepo";
    private static final Logger logger = LogManager.getLogger();

    public void SaveUser(User user) {
        try {
            UserMapper.setUser(user);
        }
        catch (Exception e) {
            Error(e);
        }
        finally {
            logger.info("[{}.INFO] Save user complete.",
                    name.toUpperCase());
        }
    }

    /**
     * Get all users from your connected Database.
     * @author babycat_offical
     * @return return Users in List
     * */
    public List<User> GetUser() {
        List<User> Data = UserMapper.getAllUser();
        try {
            if (!(Data == null)) {
                return Data;
            }
            logger.warn("[{}.WARN] Cannot found users in DB.", name.toUpperCase());
            return null;
        } catch (Exception e) {
            Error(e);
        }
        return null;
    }

    /**
     * Gets the user using User's ID
     * @param id The user id
     * @return returns user info
     * @author babycat_offical
     * @since 2026-02-28
     * */
    public User GetUser(Long id) {
        try {
            UserMapper.getUserById(id);
        } catch (Exception e) {
            Error(e);
        }
            return UserMapper.getUserById(id);
    }

    public String GetUserName(Long id) {
        try {
            String name = UserMapper.getUserNameById(id);
            if (!(name == null)) {
                return name;
            }
            return null;
        } catch (Exception e) {
            Error(e);
        }
        return null;
    }

    private static void Error(@NonNull Exception e) {
        logger.error("*\n| [{}.ERROR] We're sorry. an exception was thrown in LoginRepository.\n| Details: {} \n*",
                name.toUpperCase() ,e.getMessage());
    }
}
