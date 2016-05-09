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

    <title>Add New User</title>



    <!-- CSS -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
    <link href="css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="css/form-elements.css">


    <!--javascript for user validation and city load-->
    <script src="js/adduser.js"></script>


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

                <form role="form" id="adduser_form" action="AddUserServlet" method="post" class="registration-form" >


                    <div class="form-group">
                        <label class="control-label col-md-6">First name *</label>
                        <div class="col-md-6">
                            <input type="text" name="form-first-name" placeholder="First name..."
                                   class="form-first-name form-control" id="form-first-name" required>


                        </div>
                    </div>

                    <div class="form-group"></div>

                    <div class="form-group">
                        <label class="control-label col-sm-6" >Last name</label>
                        <div class="col-sm-6">
                            <input type="text" name="form-last-name" placeholder="Last name..."
                                   class="form-last-name form-control" id="form-last-name">
                        </div>
                    </div>

                    <div class="form-group"></div>

                    <div class="form-group">

                        <%@include file="datepicker.jsp" %>

                    </div>

                    <div class="form-group"></div>

                    <div class="form-group">
                        <label for="country" class="control-label col-sm-6" >Country *</label>
                        <div class="col-sm-6">
                            <select class="form-control" name="country" id="country" required>
                                <option>--Select--</option>
                                <option value="Sri Lanka">Sri Lanka</option>
                                <option value="India">India</option>
                                <option value="Japan">Japan</option>
                                <option value="Australia">Australia</option>
                            </select>

                        </div>
                    </div>


                    <div class="form-group"></div>

                    <div class="form-group">
                        <label for="form-city" class="control-label col-sm-6">City*</label>
                        <div class="col-sm-6">
                            <select class="form-control" id="form-city" name="form-city" required>
                                <option>--Select--</option>
                            </select>
                        </div>

                    </div>


                    <div class="form-group"></div>

                    <div class="form-group">
                        <label class="control-label col-sm-6">Email(eg:xxx@gmail.com)*</label>
                        <div class="col-sm-6">
                            <input type="text" name="form-email" placeholder="Email..." class="form-email form-control"
                                   id="form-email" pattern="^[_a-zA-Z0-9-]+(\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\.
                                   [a-zA-Z0-9-]+)*\.(([0-9]{1,3})|([a-zA-Z]{2,3}))$" required>
                        </div>
                    </div>



                    <div class="form-group">
                        <label class="control-label col-sm-6">Mobile (94xxxxxxxxx)*</label>
                        <div class="col-sm-6">
                            <input type="text" name="form-mobile" placeholder="94xxxxxxxxx"
                                   class="form-mobile form-control" id="form-mobile" pattern="^\(?(\+94)\)?([0-9]{9})$"
                                   required>
                        </div>
                    </div>

                    <div class="form-group"></div>

                    <div class="form-group ">
                        <label class="control-label col-sm-6" >Username *</label>
                        <div class="col-sm-6">
                            <input type="text" name="username" placeholder="Username..." class="user_name form-control"
                                   id="form-username" required/>


                        </div>

                    </div>


                    <div class="form-group">
                        <center>
                            <span class="status"></span>
                        </center>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-6" >Password *</label>
                        <div class="col-sm-6">
                            <input type="password" name="password" placeholder="Password..."
                                   class="form-password form-control"  id="form-password"
                                   onchange=" validatePassword(password)" required></span>
                        </div>

                    </div>

                    <div class="form-group"></div>

                    <div class="form-group">
                        <label  class="control-label col-sm-6" >Confirm pw *</label>
                        <div class="col-sm-6">
                            <input type="password" name="cnpassword" placeholder="Confirm Password..."
                                   class="form-password form-control" id="form-password-confirm"
                                   onchange=" passwordsEqual(cnpassword,password)" required>
                        </div>

                    </div>
                    <div class="form-group"></div>
                    <div class="form-group"></div>
                    <div class="form-group"></div>

                    <div class="form-group">

                        <button type="submit" class="btn" id="addbtn">Add User</button>

                    </div>



                </form>

            </div>
        </div>
    </center>
</div>

</body>
</html>
