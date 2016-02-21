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
</head>
<body>
<header>
  <h1>Help Page</h1>
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
<p>bla bla bla</p>
  <%--<%=DataBase.executeSelect()%>--%>


</div>

</div>
<footer>
  <p>Mariia Sasiuk<br> 2016<p>
</footer>

</body>
</html>
