<%--
  Created by IntelliJ IDEA.
  User: hsenid
  Date: 4/22/16
  Time: 5:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>

  <title>Add New User</title>



  <!-- CSS -->
  <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="bootstrap/css/bootstrap.css" rel="stylesheet">
  <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
  <link href="css/style.css" rel="stylesheet">
  <link rel="stylesheet" href="css/form-elements.css">


<<<<<<< HEAD
=======
  <!-- Javascript -->
  <script src="js/jquery-1.11.1.min.js"></script>
  <script src="js/jquery.backstretch.min.js"></script>
  <script src="js/scripts.js"></script>
  <script src="bootstrap/js/jquery.min.js"></script>
  <script src="bootstrap/js/bootstrap.min.js"></script>



>>>>>>> 0eecb94df5e993ba7be689261b99071a3d61e31b

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
<<<<<<< HEAD

             <form role="form" action="AddUserServlet" method="post" class="registration-form">

=======

             <form role="form" action="" method="post" class="registration-form">

>>>>>>> 0eecb94df5e993ba7be689261b99071a3d61e31b

                <div class="form-group">
                    <label class="control-label col-md-6">First name *</label>
                    <div class="col-md-6">
                        <input type="text" name="form-first-name" placeholder="First name..." class="form-first-name form-control" id="form-first-name" required>


                     </div>
                </div>

                <div class="form-group"></div>

                 <div class="form-group">
                    <label class="control-label col-sm-6" >Last name</label>
                    <div class="col-sm-6">
                        <input type="text" name="form-last-name" placeholder="Last name..." class="form-last-name form-control" id="form-last-name">
                    </div>
                </div>

                 <div class="form-group"></div>

                <div class="form-group">
                    <label class="control-label col-sm-6" >Date of Birth *</label>
                    <div class="col-sm-6">

<<<<<<< HEAD
                   <%-- <jsp:include page="datepick/datepickBasic.jsp">
                            <jsp:param name="title" value="date"/>
                    </jsp:include>--%>
                <input type="text" name="startdate" id="startdate" placeholder="Date of Birth..." class="form-birth-date form-control" size="30" required>
=======
                    <jsp:include page="datepick/datepickBasic.jsp">
                            <jsp:param name="title" value="date"/>
                    </jsp:include>
              <%--<input type="text" id="startdate" placeholder="Date of Birth..." class="form-birth-date form-control" size="30" required>--%>
>>>>>>> 0eecb94df5e993ba7be689261b99071a3d61e31b
                    </div>
                </div>

                <div class="form-group"></div>

                <div class="form-group">
                    <label for="country" class="control-label col-sm-6" >Country *</label>
                    <div class="col-sm-6">
                    <select class="form-control" name="country" id="country" required>
<<<<<<< HEAD
                        <option value="Sri Lanka">Sri Lanka</option>
                        <option value="India">India</option>
                        <option value="Japan">Japan</option>
                        <option value="Australia">Australia</option>
=======
                        <option value="1">Sri Lanka</option>
                        <option value="2">India</option>
                        <option value="3">Japan</option>
                        <option value="4">Australia</option>
>>>>>>> 0eecb94df5e993ba7be689261b99071a3d61e31b
                    </select>

                    </div>
                </div>

          <div class="form-group"></div>

          <div class="form-group">
            <label class="control-label col-sm-6">Email *</label>
            <div class="col-sm-6">
              <input type="text" name="form-email" placeholder="Email..." class="form-email form-control" id="form-email" required>
            </div>
          </div>



          <div class="form-group">
            <label class="control-label col-sm-6">Mobile Number *</label>
            <div class="col-sm-6">
              <input type="text" name="form-mobile" placeholder="Mobile Number..." class="form-mobile form-control" id="form-mobile" required>
            </div>
          </div>

          <div class="form-group"></div>

          <div class="form-group ">
            <label class="control-label col-sm-6" >Username *</label>
            <div class="col-sm-6">
              <input type="text" name="username" placeholder="Username..." class="form-username form-control" id="form-username" required>
            </div>

          </div>


          <div class="form-group"></div>

          <div class="form-group">
            <label class="control-label col-sm-6" >Password *</label>
            <div class="col-sm-6">
              <input type="password" name="password" placeholder="Password..." class="form-password form-control" id="form-password" required>
            </div>

          </div>

          <div class="form-group"></div>

          <div class="form-group">
            <label  class="control-label col-sm-6" >Confirm pw *</label>
            <div class="col-sm-6">
              <input type="password" name="confirm-password" placeholder="Confirm Password..." class="form-password form-control" id="form-password-confirm" required>
            </div>

          </div>
          <div class="form-group"></div>
          <div class="form-group"></div>
          <div class="form-group"></div>

          <div class="form-group">

            <button type="submit" class="btn">Add User</button>

          </div>

<<<<<<< HEAD
                 <div class="form-group">

                     <div class="col-sm-4"></div>

                     <div class="col-sm-4">

                         <p style="color:red">

                             <%

                                 String s= (String)request.getAttribute("success");

                                 if(s!= null){

                                     out.println(s);
                                 }

                             %>
                         </p>


                     </div>

                     <div class="col-sm-4"></div>


                 </div>

=======
>>>>>>> 0eecb94df5e993ba7be689261b99071a3d61e31b
        </form>

      </div>
    </div>
  </center>
  </div>

</body>
</html>
