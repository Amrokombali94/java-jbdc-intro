package com.devmountain;

import java.sql.*;

public class JdbcIntro {

    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/culinarydb",
                    "postgres",
                    "Mazinkombali1994$");

            if (connection.isValid(500)) {
                System.out.println("Got a connection using DriverManager!");

                PreparedStatement stm = connection.prepareStatement("SELECT * FROM foods");
//                Statement statement = connection.createStatement();
                ResultSet resultSet = stm.executeQuery();
//                stm.setInt(2,10);

                while (resultSet.next()) {
                    System.out.println(resultSet.getString(1) + " scores " + resultSet.getString(2) + "/10");

                }
            }

        } catch (Exception e) {
            System.out.println("Not able to connect & execute because: " + e.getMessage());
        }

    }


}
