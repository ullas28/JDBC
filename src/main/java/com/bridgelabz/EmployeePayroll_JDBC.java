package com.bridgelabz;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static java.sql.DriverManager.getConnection;

public class EmployeePayroll_JDBC {
    public Connection connection;
    public Statement statement;
    String dbUrl = "jdbc:mysql://localhost:3306/payroll_service";
    String dbUsername = "root";
    String dbPassword = "Ullas@8105897193";

    public static void main(String[] args) {
        EmployeePayroll_JDBC employeePayroll_jdbc = new EmployeePayroll_JDBC();
        employeePayroll_jdbc.connectDatabase();

    }

    public void connectDatabase() {
        try {
            connection = getConnection(dbUrl, dbUsername, dbPassword);
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new UserException(UserException.ExceptionType.SQLException,"SQL Query Not Excuted Properly.");
        }
    }
}
