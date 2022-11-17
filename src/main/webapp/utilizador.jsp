<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import= "model.JavaBeans" %>
    <%@ page import="java.util.ArrayList" %>
    <% 
    ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("utilizador");
   
    %>
<!DOCTYPE html>
<html>
<head>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
</head>
<body>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.topnav {
  overflow: hidden;
  background-color: #333;
}

.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
  background-color: #04AA6D;
  color: white;
}

.topnav-right {
  float: right;
}
</style>
</head>
<body>

<div class="topnav">
  <a class="active" href="#home">Home</a>
  <div class="topnav-right">
    <a href="novo.html">New User</a>
    <a href="#about">Sair</a>
  </div>
</div>

</body>
</html>
<h2>Lista de utilizadores</h2>

<table>
  <tr>
    <th>Name</th>
    <th>Email</th>
    <th>Phone</th>
    <th>User</th>
  </tr>
  <tr>
	  <%  for(int i=0; i<lista.size(); i++){%>
	  	<tr>
	  		<td><%=lista.get(i).getName()%></td>
	  		<td><%=lista.get(i).getEmail()%></td>
	  		<td><%=lista.get(i).getPhone()%></td>
	  		<td><%=lista.get(i).getUser()%></td>
	  	</tr>
	  <%}%>
</table>

</body>
</html>
