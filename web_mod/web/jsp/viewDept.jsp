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
      <th>Deptno</th>
      <th>Dname</th>
      <th>Loc</th>
    </tr>
    <% Collection<Department> deps = (Collection<Department>) request.getAttribute("Dept"); %>
    <% for (Department dept : deps){%>
    <tr><td><%=dept.getDeptno()%></td>
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
