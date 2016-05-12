<%--
  Created by IntelliJ IDEA.
  User: hsenid
  Date: 4/26/16
  Time: 9:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title></title>

  <!-- CSS -->
  <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="bootstrap/css/bootstrap.css" rel="stylesheet">
  <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
  <link href="css/style.css" rel="stylesheet">
  <link rel="stylesheet" href="css/form-elements.css">

  <!-- Javascript -->
  <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
  <script src="bootstrap/js/jquery.min.js"></script>
  <script src="bootstrap/js/bootstrap.min.js"></script>




  <!--javascript to populate the bootstrap table -->
  <script src="bootstrap_table.js"></script>

  <!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.10.1/bootstrap-table.min.css">

  <!-- Latest compiled and minified JavaScript -->
  <script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.10.1/bootstrap-table.min.js"></script>



</head>
<body>

  <!-- Nav bar declared -->
  <nav class="navbar navbar-default navbar-fixed-top ">
     <div class="container-fluid">
      <div class="navbar-header">
        <a class="navbar-brand" href="#">Online Translater Website</a>
      </div>

      <ul class="nav navbar-nav nav-tabs">
        <li class="active"><a href="#mydropdown1" data-toggle="tab">Translater</a></li>

        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">User Management <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a data-toggle="tab" href="#dropdown1">Add User</a></li>
            <li><a data-toggle="tab" href="#dropdown2">View Users</a></li>

           </ul>
        </li>

      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-log-out"></span> Log Out</a></li>
      </ul>

     </div>

  </nav>

  <!-- Top content -->
  <div class="top-content">

    <div class="inner-bg">

      <div class="container center">

        <div class="row">
          <h1><strong> Online Translater </strong> User Page</h1>
         <%-- <jsp:include page="header.jsp">
            <jsp:param name="title" value="My website"/>
          </jsp:include>--%>

        </div>

      </div>

      <!-- Nav bar tabs content -->
      <div class="row">
        <div class="tab-content">
          <div id="mydropdown1" class="tab-pane fade in active">
            <h3><strong>Translate Your Text</strong></h3>
              <jsp:include page="translater.jsp">
                <jsp:param name="title" value="My translater"/>
              </jsp:include>

          </div>

          <div id="dropdown1" class="tab-pane fade">
            <%--<h3><strong>Add a New User</strong></h3>--%>


              <jsp:include page="adduser.jsp">
                  <jsp:param name="title" value="Add User"/>
              </jsp:include>

          </div>

          <div id="dropdown2" class="tab-pane fade">
            <%--<h3><strong>View Users</strong></h3>--%>


              <jsp:include page="viewuser.jsp">
                  <jsp:param name="title" value="Add User"/>
              </jsp:include>
          </div>
        </div>
      </div>

    </div>
</div>

  <!-- Footer -->
  <footer>

    <jsp:include page="footer.jsp" />
  </footer>
</body>
</html>
