package com.demo.jav103_sum25_demo1.jdbc;

import com.demo.jav103_sum25_demo1.utils.EntityManagerUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class JdbcMain {

    public static void main(String[] args) {

        DatabaseConnectionManager dcm = new DatabaseConnectionManager("JAV103_SD21301", "sa", "1234");

        try (Connection connection = dcm.getConnection()) {

            System.out.println("Connected...");

        } catch (SQLException e) {
            System.out.println("Failed to connect to database");
            e.printStackTrace();
        }

        try (var em = EntityManagerUtils.getEntityManager()) {
            System.out.println("Created tablesss...");


        }catch (Exception e) {
            System.out.println("Failed to connect to database");
            e.printStackTrace();
        }

    }

}
