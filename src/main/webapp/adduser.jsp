<%--
  Created by IntelliJ IDEA.
  User: hsenid
  Date: 4/22/16
  Time: 5:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

  <title>Add New User</title>

  <!-- CSS -->
  <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="bootstrap/css/bootstrap.css" rel="stylesheet">
  <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
  <link href="css/style.css" rel="stylesheet">
  <link rel="stylesheet" href="css/form-elements.css">


  <!-- Javascript -->
  <script src="js/jquery-1.11.1.min.js"></script>
  <script src="js/jquery.backstretch.min.js"></script>
  <script src="js/scripts.js"></script>
  <script src="bootstrap/js/jquery.min.js"></script>
  <script src="bootstrap/js/bootstrap.min.js"></script>

</head>


<body>

<!-- Top content -->
<div class="top-content">

  <div class="inner-bg">

    <div class="container">
      <div class="row">
        <jsp:include page="header.jsp">
          <jsp:param name="title" value="My website"/>
        </jsp:include>
      </div>

      <div class="row">
        <center>
        <div class="form-box">

          <div class="form-top">

            <div class="form-top-left">

              <h3>Sign up now</h3>
                 <p>Fill in the form below to get instant access:</p>
            </div>

            <div class="form-top-right">
                <i class="fa fa-pencil"></i>
            </div>

          </div>
          <div class="form-bottom">

            <form role="form" action="" method="post" class="registration-form">

              <div class="form-group">
                  <label class="sr-only" for="form-first-name">First name</label>
                  <input type="text" name="form-first-name" placeholder="First name..." class="form-first-name form-control" id="form-first-name">
              </div>

              <div class="form-group">
                <label class="sr-only" for="form-last-name">Last name</label>
                <input type="text" name="form-last-name" placeholder="Last name..." class="form-last-name form-control" id="form-last-name">
              </div>

              <div class="form-group">
                <label class="sr-only" for="form-email">Email</label>
                <input type="text" name="form-email" placeholder="Email..." class="form-email form-control" id="form-email">
              </div>

              <div class="form-group">
                <label class="sr-only" for="form-about-yourself">About yourself</label>
                <textarea name="form-about-yourself" placeholder="About yourself..."
                          class="form-about-yourself form-control" id="form-about-yourself"></textarea>
              </div>

              <button type="submit" class="btn">Sign me up!</button>

            </form>

          </div>
        </div>
        </center>
      </div>
    </div>

  </div>
</div>





</body>
</html>
