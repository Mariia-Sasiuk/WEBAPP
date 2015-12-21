<%@ page import="main.java.lab3.model.DataBase" %>
<%@ page import="main.java.lab3.model.Employe" %>
<%--
  Created by IntelliJ IDEA.
  User: Mari
  Date: 13.12.2015
  Time: 22:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" href="style/style.css" type="text/css" media="all" />
</head>
<body>
<header>
  <h1>EmpView Page</h1>
</header>
<div id="recovernavig">
  <div id="navigation">

    <ul class="dropdown">
      <li class="dropdown-top"><a href="Actions?action=navigation">Home</a></li>
      <li class="dropdown-top"><a href="Actions?action=edit">Edit</a></li>
      <li class="dropdown-top"><a href="#">Tables</a>
        <ul class="dropdown-inside">
          <li><a href="Actions?action=empView">Emp</a></li>
            <li><a href="Actions?action=deptView">Dept</a></li>
        </ul>
      </li>
      <li class="dropdown-top"><a href="Actions?action=help">Help</a></li>

    </ul>
  </div>
</div>

<div id="center">
  <table>
    <tr>
      <th>Empno</th>
      <th>Ename</th>
      <th>Job</th>
      <th>MGR</th>
      <th>Hiredate</th>
      <th>Sal</th>
      <th>Comm</th>
      <th>Deptno</th>
    </tr>
  <% for (Employe emp : DataBase.employees){%>
          <tr><td><%=emp.getEmpno()%></td>
                  <td><%=emp.getEname()%></td>
                  <td><%=emp.getJob()%></td>
                  <td><%=emp.getMgr()%></td>
                  <td><%=emp.getHiredate()%></td>
                  <td><%=emp.getSal()%></td>
                  <td><%=emp.getComm()%></td>
                  <td><%=emp.getDeptno()%></td>
                  </tr>
  <%
          }
  %>
    </table>


</div>

</div>
<footer>
  <p>Mariia Sasiuk<br> 2015 <p>
</footer>

</body>
</html>
