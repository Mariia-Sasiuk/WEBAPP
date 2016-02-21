<%@ page import="application.lab3.model.Employee" %>
<%@ page import="java.util.Collection" %>
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
          <li><a href="Actions?action=empView&column=1">Emp</a></li>
            <li><a href="Actions?action=deptView&column=1">Dept</a></li>
        </ul>
      </li>
      <li class="dropdown-top"><a href="Actions?action=help">Help</a></li>

    </ul>
  </div>
</div>

<div id="center">
  <table>
    <tr>
      <th><a href="Actions?action=empView&column=1">Empno</a></th>
      <th><a href="Actions?action=empView&column=2">Ename</a></th>
      <th><a href="Actions?action=empView&column=3">Job</a></th>
      <th><a href="Actions?action=empView&column=4">MGR</a></th>
      <th><a href="Actions?action=empView&column=5">Hiredate</a></th>
      <th><a href="Actions?action=empView&column=6">Sal</a></th>
      <th><a href="Actions?action=empView&column=7">Comm</a></th>
      <th><a href="Actions?action=empView&column=8">Deptno</a></th>
        <th>hierarchy</th>
    </tr>
      <% Collection<Employee> emps = (Collection<Employee>) request.getAttribute("Emp"); %>
      <% for (Employee emp : emps){%>
          <tr><td><a href="Actions?action=updEmp&id=<%=emp.getEmpno()%>"><%=emp.getEmpno()%></a></td>
              <td><%=emp.getEname()%></td>
              <td><%=emp.getJob()%></td>
              <td><%=emp.getMgr()%></td>
              <td><%=emp.getHiredate()%></td>
              <td><%=emp.getSal()%></td>
              <td><%=emp.getComm()%></td>
              <td><%=emp.getDeptno()%></td>
              <td><a href="Actions?action=viewBoss&id=<%=emp.getEmpno()%>">boss</a>
                  <%--<a href="Actions?action=viewWorker&id=<%=emp.getEmpno()%>">work</a>--%></td>
                  </tr>
  <%
          }
  %>
    </table>


</div>

</div>
<footer>
  <p>Mariia Sasiuk<br> 2016 <p>
</footer>

</body>
</html>
