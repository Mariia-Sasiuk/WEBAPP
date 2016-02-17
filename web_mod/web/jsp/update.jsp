<%@ page import="application.lab3.model.Department" %>
<%@ page import="java.util.Collection" %>
<%--
  Created by IntelliJ IDEA.
  User: Mari
  Date: 07.02.2016
  Time: 3:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" href="style/style.css" type="text/css" media="all" />
</head>
<body>
<header>
  <h1>Update MOD</h1>
</header>
<div id="recovernavig">
  <div id="navigation">

    <ul class="dropdown">
      <li class="dropdown-top"><a href="Actions?action=navigation">Home</a></li>
      <li class="dropdown-top"><a href="Actions?action=edit">Edit</a></li>
      <li class="dropdown-top"><a href="#">Tables</a>
        <ul class="dropdown-inside">
          <li><a href="Actions?action=empView">Emp</a></li>
          <li><a href="Actions?action=deptView&column=1">Dept</a></li>
        </ul>
      </li>
      <li class="dropdown-top"><a href="Actions?action=help">Help</a></li>

    </ul>
  </div>
</div>

<div id="center">
  <form>
      <p>Please, specify following params:</p>
    <% Collection<Department> deps = (Collection<Department>) request.getAttribute("Dept"); %>
    <% for (Department dept : deps){%>
      Deptno:...<input name="deptno" value="<%=dept.getDeptno()%>" readonly><br>
      Dname:....<input name="dname" value="<%=dept.getDname()%>"><br>
      Loc:......<input name="loc" value="<%=dept.getLoc()%>"><br>
    <%
      }
    %>
      <%--<input type="hidden" name="action" value="updDeptParams">--%>
      <button type="submit" name="action" value="updDeptParams">UPDATE</button>
    <button type="submit" name="action" value="delDept">DELETE</button>

  </form>
</div>

</div>
<footer>
  <p>Mariia Sasiuk<br> 2016 <p>
</footer>

</body>
</html>