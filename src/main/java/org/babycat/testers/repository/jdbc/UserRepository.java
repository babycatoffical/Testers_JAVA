package org.babycat.testers.repository.jdbc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.sql.DataSource;
import java.sql.*;

public class UserRepository {
    private static final Logger logger = LogManager.getLogger();
    private static final String name = "test";

    @Qualifier("Datasource")
    private DataSource source;

    public void getUserById(Integer id) {
        try {

            Connection conn = source.getConnection();

            String sql = "SELECT user_name FROM users WHERE id = ?";
            PreparedStatement process = conn.prepareStatement(sql);
            process.setInt(1, id);
            ResultSet resultSet = process.executeQuery();

            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("user_id"));
                System.out.println("Name: " + resultSet.getString("user_name"));
            }

            resultSet.close();
            process.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}