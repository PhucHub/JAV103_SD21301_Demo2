package com.jav103.jav103_sum25_demo2.jdbc;
import com.jav103.jav103_sum25_demo2.utils.EntityManagerUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class JdbcMain {

    public static void main(String[] args) {

        DatabaseConnectionManager dcm = new DatabaseConnectionManager("QLNV_Jav103", "sa", "1234@");

        try (Connection connection = dcm.getConnection()) {

            System.out.println("Connected...");

        } catch (SQLException e) {
            System.out.println("Failed to connect to database");
            e.printStackTrace();
        }

        try (var em = EntityManagerUtils.getEntityManager()) {
            System.out.println("Created tables...");


        }catch (Exception e) {
            System.out.println("Failed to connect to JDBC");
            e.printStackTrace();
        }

    }

}
