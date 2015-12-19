<%@ page import="main.java.lab3.DataBase" %>
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
  <script type="text/javascript" src="js/jquery-2.0.3.js"></script>
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
          <li><a href="Actions?action=empView">Emp</a></li>
          <li><a href="Actions?action=deptView">Dept</a></li>
        </ul>
      </li>
      <li class="dropdown-top"><a href="Actions?action=help">Help</a></li>

    </ul>
  </div>
</div>

<div id="center">
  <input type="checkbox" id="addEmp" name="addEmp" value="addEmp">Add new employee<br>
  <div id="vismore">
    <p>Please, specify following params:</p>
    Empno: <input name="paramsEmp" ><br>
    Ename: <input name="paramsEmp" ><br>
    Job: <input name="paramsEmp" ><br>
    MGR: <input name="paramsEmp" ><br>
    Hiredate: <input name="paramsEmp" ><br>
    Sal: <input name="paramsEmp" ><br>
    Comm: <input name="paramsEmp" ><br>
    Deptno: <input name="paramsEmp" ><br>
</div>

</div>

</div>
<footer>
  <p>Mariia Sasiuk<br> 2015 <p>
</footer>

</body>
</html>
