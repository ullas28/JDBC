package com.bridgelabz;

public class EmployeeData {
   int empid;
   String name, address, department, gender, start;
   long phone_number, basic_pay, deductions, taxablePay, netPay, incomeTax;

    public EmployeeData(int empid, String name, String address, String department, String gender, String start,
                        long phone_number, long basic_pay, long deductions, long taxablePay, long netPay, long incomeTax) {
        this.empid = empid;
        this.name = name;
        this.address = address;
        this.department = department;
        this.gender = gender;
        this.start = start;
        this.phone_number = phone_number;
        this.basic_pay = basic_pay;
        this.deductions = deductions;
        this.taxablePay = taxablePay;
        this.netPay = netPay;
        this.incomeTax = incomeTax;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public long getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(long phone_number) {
        this.phone_number = phone_number;
    }

    public long getBasic_pay() {
        return basic_pay;
    }

    public void setBasic_pay(long basic_pay) {
        this.basic_pay = basic_pay;
    }

    public long getDeductions() {
        return deductions;
    }

    public void setDeductions(long deductions) {
        this.deductions = deductions;
    }

    public long getTaxablePay() {
        return taxablePay;
    }

    public void setTaxablePay(long taxablePay) {
        this.taxablePay = taxablePay;
    }

    public long getNetPay() {
        return netPay;
    }

    public void setNetPay(long netPay) {
        this.netPay = netPay;
    }

    public long getIncomeTax() {
        return incomeTax;
    }

    public void setIncomeTax(long incomeTax) {
        this.incomeTax = incomeTax;
    }

    @Override
    public String toString() {
        return "EmployeeData{" +
                "empid=" + empid +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", department='" + department + '\'' +
                ", gender='" + gender + '\'' +
                ", start='" + start + '\'' +
                ", phone_number=" + phone_number +
                ", basic_pay=" + basic_pay +
                ", deductions=" + deductions +
                ", taxablePay=" + taxablePay +
                ", netPay=" + netPay +
                ", incomeTax=" + incomeTax +
                '}';
    }
}
