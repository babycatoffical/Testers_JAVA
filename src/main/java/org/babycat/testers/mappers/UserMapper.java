package org.babycat.testers.mappers;

import org.babycat.testers.entity.User;
import org.springframework.stereotype.Component;

/**
 * The Mapper of BasicComponent,
 * */
@Component("UserMapper")
public interface UserMapper {
    /**
     * gets the all users.
     * */
    User getAllUser();
    /**
     * gets the user using parameters, the ID.
     * @param id the user id
     * */
    User getUserById(Long id);
    /**
     * gets the username using parameters, the ID.
     * @param id the user id
     * @return returns USERNAME.
     * */
    String getUserNameById(Long id);

    User setUser(User user);
}
