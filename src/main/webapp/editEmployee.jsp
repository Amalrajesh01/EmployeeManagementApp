<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.besant.packages.model.Employee" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Employee</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 20px;
        background-color: #fff7e6; /* Light orange background */
        display: flex;
        justify-content: center;
        align-items: center;
        min-height: 100vh;
    }

    .form-container {
        text-align: left;
        border: 2px solid #ffa500; /* Orange border */
        padding: 20px 40px;
        border-radius: 10px;
        background-color: #fff; /* White form background */
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        max-width: 500px;
        width: 100%;
    }

    h2 {
        color: #ff6600; /* Deep orange */
        text-align: center;
        margin-bottom: 20px;
    }

    label {
        display: block;
        margin-bottom: 5px;
        font-weight: bold;
        color: #333;
    }

    input {
        width: 100%;
        padding: 10px;
        margin-bottom: 15px;
        border: 1px solid #ccc;
        border-radius: 5px;
        font-size: 14px;
    }

    input[readonly] {
        background-color: #f5f5f5;
        color: #666;
        cursor: not-allowed;
    }

    input:focus {
        border-color: #ffa500; /* Orange border on focus */
        outline: none;
        box-shadow: 0 0 5px 2px rgba(255, 165, 0, 0.3);
    }

    button {
        background-color: #ff6600; /* Deep orange button */
        color: white;
        border: none;
        padding: 12px;
        font-size: 16px;
        border-radius: 5px;
        cursor: pointer;
        width: 100%;
        transition: background-color 0.3s ease, transform 0.2s ease;
    }

    button:hover {
        background-color: #cc5200; /* Darker orange on hover */
        transform: translateY(-2px); /* Slight lift effect */
    }

    button:focus {
        outline: none;
        box-shadow: 0 0 5px 2px rgba(255, 102, 0, 0.6); /* Highlight on focus */
    }

    @media (max-width: 768px) {
        .form-container {
            padding: 15px 20px;
        }

        h2 {
            font-size: 20px;
        }
    }
</style>
</head>
<body>
    <%
    List<Employee> employeeList = (List<Employee>) request.getAttribute("employees");
    for (Employee employee : employeeList) {
    %>
    <div class="form-container">
        <h2>Update Employee</h2>
        <form action="updateEmployee" method="POST">
            <label for="id">ID</label>
            <input type="number" id="id" value="<%= employee.getId() %>" name="id" readonly>
            
            <label for="empId">Employee ID</label>
            <input type="number" id="empId" value="<%= employee.getEmpId() %>" name="empId" readonly>
            
            <label for="empName">Employee Name</label>
            <input type="text" id="empName" value="<%= employee.getEmpName() %>" name="empName" required>
            
            <label for="empEmail">Employee Email</label>
            <input type="email" id="empEmail" value="<%= employee.getEmail() %>" name="empEmail" required>
            
            <label for="empSalary">Employee Salary</label>
            <input type="number" id="empSalary" value="<%= employee.getEmpSalary() %>" name="empSalary" required>
            
            <label for="empAddress">Employee Address</label>
            <input type="text" id="empAddress" value="<%= employee.getEmpAddress() %>" name="empAddress" required>
            
            <label for="empDesignation">Employee Designation</label>
            <input type="text" id="empDesignation" value="<%= employee.getEmpDesignation() %>" name="empDesignation" required>
            
            <label for="empDepartment">Employee Department</label>
            <input type="text" id="empDepartment" value="<%= employee.getEmpDepartment() %>" name="empDepartment" required>
            
            <label for="empPhoneNumber">Employee Phone Number</label>
            <input type="number" id="empPhoneNumber" value="<%= employee.getEmpPhoneNumber() %>" name="empPhoneNumber" required>
            
            <button type="submit">Submit</button>
        </form>
    </div>
    <%
    }
    %>
</body>
</html>
