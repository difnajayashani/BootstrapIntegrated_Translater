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

   <!-- Javascript -->
        <script>
           $(function() {
              $( "#datepicker-10" ).datepicker({
                 changeMonth:true,
                 changeYear:true,
                 numberOfMonths:[2,2]
              });
           });
        </script>

</head>


<body>

<!-- Top content -->

     <div class="row">
        <center>
        <div class="form-box">

          <div class="form-top">

            <div class="form-top-left">

              <h3>New User Sign up</h3>
                 <p>Fill in the form below to add a new user:</p>
            </div>

            <div class="form-top-right">
                <i class="fa fa-pencil"></i>
            </div>

          </div>
          <div class="form-bottom">

            <form role="form" action="" method="post" class="registration-form">

              <div class="form-group">
                  <label class="control-label col-sm-4">First name</label>
                   <div class="col-sm-8">
                        <input type="text" name="form-first-name" placeholder="First name..." class="form-first-name form-control" id="form-first-name" required>
                   </div>
              </div>

              <div class="form-group">
                <label class="control-label col-sm-4" >Last name</label>
                <div class="col-sm-8">
                    <input type="text" name="form-last-name" placeholder="Last name..." class="form-last-name form-control" id="form-last-name">
                </div>
              </div>

              <div class="form-group">
                <label class="control-label col-sm-4" >Date of Birth</label>
                <div class="col-sm-8">
                    <input type="text" id="datepicker-10" placeholder="Date of Birth..." class="form-birth-date form-control">
                </div>
              </div>


              <div class="form-group">
                <label class="control-label col-sm-4">Email</label>
                <div class="col-sm-8">
                    <input type="text" name="form-email" placeholder="Email..." class="form-email form-control" id="form-email">
                </div>
              </div>

              <div class="form-group ">
                 <label class="control-label col-sm-4" >Username:</label>
                 <div class="col-sm-8">
                    <input type="text" name="username" placeholder="Username..." class="form-username form-control" id="form-username">
                 </div>

              </div>

              <div class="form-group">
                <label class="control-label col-sm-4" >Password:</label>
                    <div class="col-sm-8">
                        <input type="password" name="password" placeholder="Password..." class="form-password form-control" id="form-password">
                    </div>

              </div>

               <div class="form-group">
                 <label class="control-label col-sm-4" >Confirm Pswd:</label>
                     <div class="col-sm-8">
                         <input type="password" name="confirm-password" placeholder="Confirm Password..." class="form-password form-control" id="form-password">
                     </div>

               </div>

               <div class="form-group">
                   <label class="control-label col-sm-4" >Country</label>
                   <div class="col-sm-8">
                    <select class="form-control" name="country" id="country" >
                         <option value="1">Sri Lanka</option>
                          <option value="2">India</option>
                          <option value="3">Japan</option>
                          <option value="4">Australia</option>
                    </select>

                   </div>
               </div>

              <button type="submit" class="btn">Sign me up!</button>

            </form>

          </div>
        </div>
        </center>
      </div>

</body>
</html>
