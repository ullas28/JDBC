package com.bridgelabz;

import java.sql.*;
import java.util.ArrayList;
import java.util.Enumeration;

import static java.sql.DriverManager.getConnection;

public class EmployeePayroll_JDBC {
    public Connection connection;
    public Statement statement;
    String dbUrl = "jdbc:mysql://localhost:3306/payroll_service";
    String dbUsername = "root";
    String dbPassword = "Ullas@8105897193";

    ArrayList<EmployeeData> employeeDataArrayList = new ArrayList<>();
    public static void main(String[] args) {
        EmployeePayroll_JDBC employeePayroll_jdbc = new EmployeePayroll_JDBC();
        employeePayroll_jdbc.connectDatabase();
        EmployeePayroll_JDBC.listDrivers();

    }

    public void connectDatabase() {
        try {
            System.out.println("Connecnting to database");
            connection = getConnection(dbUrl, dbUsername, dbPassword);
            statement = connection.createStatement();
            System.out.println("Connecnting to database is successful");
        } catch (SQLException e) {
            throw new UserException(UserException.ExceptionType.SQLException,"SQL Query Not Excuted Properly.");
        }
    }

    private static void listDrivers(){
        Enumeration<Driver> driverList = DriverManager.getDrivers();
        while (driverList.hasMoreElements()){
            Driver driverClass = (Driver)driverList.nextElement();
            System.out.println("" + driverClass.getClass().getName());
        }
    }
}
