<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Details</title>
</head>
<body>
<table  border="1" cellpadding="10">

    <tr>
        <th width="80">Employee Id</th>
        <th width="120">Name</th>
        <th width="120">Department</th>
        <th width="60">Address</th>
        <th width="60">Salary</th>
    </tr>
   
   <c:forEach items="${empDetails}" var="emp">
        <tr>
            <td><c:out value="${emp.id}"></c:out></td>
            <td><c:out value="${emp.empName}"></c:out></td>
            <td><c:out value="${emp.empDept}"></c:out></td>
            <td><c:out value="${emp.empAddress}"></c:out></td>
            <td><c:out value="${emp.salary}"></c:out></td>
            
               <td>
                    <a th:href="/@{'/delete/' + ${emp.id}}">Delete</a>
                </td>
               
        </tr>
 
    </c:forEach>
    
    </table>
</body>
</html>