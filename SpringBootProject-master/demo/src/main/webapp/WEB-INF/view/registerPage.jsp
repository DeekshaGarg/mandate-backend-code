<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Here</title>
</head>
<body>
<form action="save-Details" method="post">

                <table border="0" cellpadding="10"> 
                     <tr> <td>Employee Name:</td> 
                           <td><input type="text" name="empName" /></td>   
                     </tr>           
                     <tr> <td>Department:</td>
                          <td><input type="text" name="empDept" /></td>   
                      </tr>
                       <tr> <td>Address:</td>               
                            <td><input type="text" name="empAddress" /></td>       
                       </tr> 
                       <tr>
                             <td>Salary:</td>  
                             <td><input type="text" name="salary" /></td>  
                       </tr>                                       
                       <tr>  <td colspan="2"><button type="submit">Save</button> </td>      
                      </tr>      
                 </table>
</form>
</body>
</html>