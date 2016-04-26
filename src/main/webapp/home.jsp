<html xmlns:jsp="http://java.sun.com/JSP/Page">

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

  <title>Online Translater Home </title>

  <!-- CSS -->
  <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="bootstrap/css/bootstrap.css" rel="stylesheet">
  <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
  <link rel="stylesheet" href="css/form-elements.css">


</head>
<body>

    <!-- Nav Bar -->

        <jsp:include page="navbar.jsp">
          <jsp:param name="navbar" value="nav-bar-user"/>
        </jsp:include>


    <!-- Top content -->
    <div class="top-content">

      <div class="inner-bg">

        <div class="container center">
          <div class="row">
            <h1><strong> Online Translater </strong> User Page</h1>
            <jsp:include page="header.jsp">
              <jsp:param name="title" value="My website"/>
            </jsp:include>

          </div>


      </div>
    </div>




    <!-- Footer -->
    <footer>

      <jsp:include page="footer.jsp" />
    </footer>
</body>
</html>
