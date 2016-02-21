<%@ page import="application.lab3.model.Department" %>
<%@ page import="java.util.Collection" %>
<%--
  Created by IntelliJ IDEA.
  User: Mari
  Date: 19.12.2015
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" href="style/style.css" type="text/css" media="all" />
</head>
<body>
<header>
  <h1>DeptView Page</h1>
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
      <th><a href="Actions?action=deptView&column=1">Deptno</a></th>
      <th><a href="Actions?action=deptView&column=2">Dname</a></th>
      <th><a href="Actions?action=deptView&column=3">Loc</a></th>
    </tr>
    <% Collection<Department> deps = (Collection<Department>) request.getAttribute("Dept"); %>
    <% for (Department dept : deps){%>
    <tr><td><a href="Actions?action=updDept&id=<%=dept.getDeptno()%>"><%=dept.getDeptno()%></a></td>
      <td><%=dept.getDname()%></td>
      <td><%=dept.getLoc()%></td>
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
