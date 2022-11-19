package com.bridgelabz;

import java.sql.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Scanner;

import static java.sql.DriverManager.getConnection;

public class EmployeePayroll_JDBC {
    public Connection connection;
    public Statement statement;
    public PreparedStatement preparedStatement;

    public ResultSet resultSet;
    String dbUrl = "jdbc:mysql://localhost:3306/payroll_service";
    String dbUsername = "root";
    String dbPassword = "Ullas@8105897193";

    ArrayList<EmployeeData> employeeDataArrayList = new ArrayList<>();
    public static void main(String[] args) {
        EmployeePayroll_JDBC employeePayroll_jdbc = new EmployeePayroll_JDBC();
        employeePayroll_jdbc.connectDatabase();
        EmployeePayroll_JDBC.listDrivers();
        employeePayroll_jdbc.accessEmployeeData();
        employeePayroll_jdbc.updateEmployeeData();

    }

    public void connectDatabase() {
        try {
            connection = getConnection(dbUrl, dbUsername, dbPassword);
            preparedStatement = connection.prepareStatement("select * from payroll_service.employee_payroll");
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

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new UserException(UserException.ExceptionType.SQLException,"The Database Connection Not Closed Properly.");
        }
    }

    public void accessEmployeeData() {
        connectDatabase();
        try {
            statement = connection.prepareStatement("select * from payroll_service.employee_payroll");
            resultSet = statement.executeQuery("select * from payroll_service.employee_payroll");

            while(resultSet.next()) {
                EmployeeData employeeData = new EmployeeData();
                employeeData.empid = resultSet.getInt(1);
                employeeData.name = resultSet.getString(2);
                employeeData.phone_number = resultSet.getLong(3);
                employeeData.address =resultSet.getString(4);
                employeeData.department = resultSet.getString(5);
                employeeData.gender = resultSet.getString(6);
                employeeData.basic_pay = resultSet.getLong(7);
                employeeData.deductions = resultSet.getLong(8);
                employeeData.taxablePay = resultSet.getLong(9);
                employeeData.netPay = resultSet.getLong(10);
                employeeData.incomeTax = resultSet.getLong(11);
                employeeData.start = resultSet.getString(12);
                employeeDataArrayList.add(employeeData);
                System.out.println(employeeData);
            }
        } catch (SQLException e) {
            throw new UserException(UserException.ExceptionType.SQLException,"The SQL Query is Not Properly Executed");
        } finally {
            closeConnection();
        }
    }

    public void updateEmployeeData() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the Salary : ");
            long basic_pay = sc.nextLong();
            System.out.println("Enter the Employee Name : ");
            String employeeName = sc.next();

            connectDatabase();
            preparedStatement = connection.prepareStatement("update employee_payroll set basic_pay = ? where name= ?");
            preparedStatement.setLong(1, basic_pay);
            preparedStatement.setString(2, employeeName);
            int rows = preparedStatement.executeUpdate();
            System.out.println(rows + " Rows Updated.");
            employeeDataArrayList.stream().forEach(x -> {
                if ((x.getName().equalsIgnoreCase(employeeName))) {
                    x.setBasic_pay(basic_pay);
                } else {
                    x.setBasic_pay(x.getBasic_pay());
                }
            });
            showEmployeeDataList();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

        public void showEmployeeDataList(){
            try {
                for (EmployeeData employeeData : employeeDataArrayList) {
                    System.out.println(employeeData.toString());
                }
            } catch (NullPointerException e) {
                throw new UserException(UserException.ExceptionType.NullList,"Employee Data List is Empty.");
            }
        }
    }

