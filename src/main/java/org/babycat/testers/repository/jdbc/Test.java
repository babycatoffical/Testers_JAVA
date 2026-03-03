package org.babycat.testers.repository.jdbc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.sql.DataSource;
import java.sql.*;

public class Test {
    private static final Logger logger = LogManager.getLogger();
    private static final String name = "test";

    public void TestRepo() {

        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "testuser";
        String password = "testpass";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(url, user, password);

            String sql = "SELECT * FROM users";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
            }

            rs.close();
            pstmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private boolean ConnectionTest(DataSource datasource) {
        try {
            Connection conn = datasource.getConnection();
            if (conn != null) {
                conn.close();
                return true;
            }
        } catch (SQLTimeoutException e) {
            logger.error("*\n| [{}.ERROR] Connection timeout. \n| Reason: {} \n*"
                    , name.toUpperCase() ,e.getMessage());
        }
        catch (SQLException e) {
            logger.error("*\n| [{}.ERROR] Failed to connect to the database.\n| Reason: {}",
                    name.toUpperCase(), e.getMessage());
        }
        return false;
    }
}