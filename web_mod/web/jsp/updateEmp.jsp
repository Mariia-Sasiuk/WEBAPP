<%@ page import="application.lab3.model.Employee" %>
<%@ page import="java.util.Collection" %>
<%--
  Created by IntelliJ IDEA.
  User: Mari
  Date: 12.12.2015
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" href="style/style.css" type="text/css" media="all" />
  <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css"/>
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
  <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>
  <script src="http://wisdomweb.ru/editor/localization.js"></script>
  <script src="js/script.js"></script>
</head>
<body>
<header>
  <h1>Edit MOD</h1>
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
  <form>
      <p>Please, specify following params:</p>
      <% Collection<Employee> emps = (Collection<Employee>) request.getAttribute("Emp"); %>
      <% for (Employee emp : emps){%>
      <p>Empno:....<input name="empno" value="<%=emp.getEmpno()%>" readonly><br></p>
      <p>Ename:....<input name="ename" value="<%=emp.getEname()%>" ><br></p>
      <p>Job:......<input name="job" value="<%=emp.getJob()%>"><br></p>
      <p>MGR:......<input name="mgr" value="<%=emp.getMgr()%>"><br></p>
      <p>Hiredate:.<input type="text" name="date" id="datepicker" value="<%=emp.getHiredate()%>"><br></p>
      <p>Sal:......<input name="sal" value="<%=emp.getSal()%>"><br></p>
      <p>Comm:.....<input name="comm" value="<%=emp.getComm()%>"><br></p>
      <p>Deptno:...<input name="deptno" value="<%=emp.getDeptno()%>"><br></p>
    <%
      }
    %>
    <button type="submit" name="action" value="updEmpParams">UPDATE</button>
    <button type="submit" name="action" value="delEmp">DELETE</button>

  </form>
</div>

</div>
<footer>
  <p>Mariia Sasiuk<br> 2016 <p>
</footer>

</body>
</html>