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
          <li><a href="Actions?action=empView">Emp</a></li>
          <li><a href="Actions?action=deptView">Dept</a></li>
        </ul>
      </li>
      <li class="dropdown-top"><a href="Actions?action=help">Help</a></li>

    </ul>
  </div>
</div>

<div id="center">
  <form action="Actions">
    <input type="checkbox" id="addEmp" name="addEmp" value="addEmp">Add new employee<br>
    <div id="vismoreEmp">
      <p>Please, specify following params:</p>
      <p>Empno:....<input name="empno" ><br></p>
      <p>Ename:....<input name="ename" value="John" ><br></p>
      <p>Job:......<input name="job" ><br></p>
      <p>MGR:......<input name="mgr" ><br></p>
      <p>Hiredate:.<input type="text" name="date" id="datepicker"><br></p>
      <p>Sal:......<input name="sal" ><br></p>
      <p>Comm:.....<input name="comm" ><br></p>
      <p>Deptno:...<input name="deptno" ><br></p>
      <input type="hidden" name="action" value="insEmp">
      <button type="submit" name="addEmp">ADD</button>
    </div>
  </form>
  <form>
    <input type="checkbox" id="addDept" name="addDept" value="addDept">Add new department<br>
    <div id="vismoreDept">
      <p>Please, specify following params:</p>
      Deptno:...<input name="deptno" ><br>
      Dname:....<input name="dname" ><br>
      Loc:......<input name="loc" ><br>
      <input type="hidden" name="action" value="insDept">
      <button type="submit" name="addDept">ADD</button>

    </div>
  </form>
</div>

</div>
<footer>
  <p>Mariia Sasiuk<br> 2016 <p>
</footer>

</body>
</html>