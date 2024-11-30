<%@ page import="com.besant.packages.model.Employee" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Employees</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 20px;
        background-color: #fff7e6; /* Light orange background */
    }

    h1 {
        text-align: center;
        color: #ff6600; /* Deep orange */
        margin-bottom: 20px;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        background-color: #fff; /* White table background */
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        margin: auto;
    }

    th, td {
        padding: 10px 15px;
        text-align: left;
        border: 1px solid #ccc;
    }

    th {
        background-color: #ffa500; /* Orange table header */
        color: #fff;
    }

    tr:nth-child(even) {
        background-color: #f9f9f9; /* Alternate row background */
    }

    tr:hover {
        background-color: #ffedcc; /* Highlight row on hover */
    }

    button {
        background-color: #ff6600; /* Deep orange buttons */
        color: white;
        border: none;
        padding: 8px 12px;
        font-size: 14px;
        border-radius: 5px;
        cursor: pointer;
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

    form {
        margin: 0;
    }
</style>
</head>
<body>
    <h1>All Employees</h1>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Employee ID</th>
                <th>Employee Name</th>
                <th>Employee Email</th>
                <th>Employee Salary</th>
                <th colspan="2">Actions</th>
            </tr>
        </thead>
        <tbody>
        <%
        List<Employee> employeeList = (List<Employee>) request.getAttribute("employees");
        if (employeeList != null && !employeeList.isEmpty()) {
            for (Employee employee : employeeList) {
        %>
            <tr>
                <td><%= employee.getId() %></td>
                <td><%= employee.getEmpId() %></td>
                <td><%= employee.getEmpName() %></td>
                <td><%= employee.getEmail() %></td>
                <td><%= employee.getEmpSalary() %></td>
                <td>
                    <form action="deleteEmployeeData" method="POST">
                        <input type="hidden" value="<%= employee.getId() %>" name="id">
                        <button type="submit">Delete</button>
                    </form>
                </td>
                <td>
                    <form action="editEmployeeData" method="GET">
                        <input type="hidden" value="<%= employee.getId() %>" name="id">
                        <button type="submit">Edit</button>
                    </form>
                </td>
            </tr>
        <%
            }
        } else {
        %>
            <tr>
                <td colspan="7" style="text-align: center; color: #666;">No employees found.</td>
            </tr>
        <%
        }
        %>
        </tbody>
    </table>
</body>
</html>
