package org.babycat.testers.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.babycat.testers.entity.User;

import java.util.List;

/**
 * The Mapper of BasicComponent,
 * */
@Mapper
public interface UserMapper {
    /**
     * gets the all users.
     * */
    List<User> getAllUser();
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

    void setUser(User user);
}
