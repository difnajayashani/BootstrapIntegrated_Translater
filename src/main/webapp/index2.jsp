<html xmlns:jsp="http://java.sun.com/JSP/Page">

    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
              <meta charset="UTF-8">
        <meta http-equiv="refresh" content="1;url=http://example.com">
        <title>Login Page</title>
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet">
          <link href="css/style.css" rel="stylesheet">
        <script src="bootstrap/js/jquery.min.js"></script>
          <script src="bootstrap/js/bootstrap.min.js"></script>
          

    </head>

    <body class="jumbotron">
        <center>
            <div class="container text-center">
               <h1><strong>Home Page</strong></h1>

                    <form class="form-horizontal" role="form" name="login"  method="post" action="MyServlet" >
                      

                        <h3><span class="text-info">Log in</span> </h3>


                            <div class="form-group ">

                                <label class="control-label col-sm-4" for="email">Username:</label>
                                <div class="col-sm-4"><input  class="form-control" type="text" name="username" ></div>
                                   <div class="col-sm-4"></div>

                            </div>

                            <div class="form-group">

                                <label class="control-label col-sm-4" for="pwd">Password:</label>
                                <div class="col-sm-4"><input type="password" class="form-control" name="password"  placeholder="Enter password"/></div>
                                 <div class="col-sm-4"></div>

                            </div>

                             <div class="form-group ">

                           		 <div class="col-sm-4"></div>
                           		 <div class=" col-sm-4">
                                	 <input type="submit" class="btn btn-primary  btn-lg" value="Login" name="submit">
                                 </div>
                                 <div class="col-sm-4"></div>
                             </div>

                             <div class="form-group">
                                            <div class="col-sm-4"></div>
                                            <div class="col-sm-4">
                                                    <p style="color:red">
                                                   <%
                                                  String s= (String)request.getAttribute("error");
                                                  if(s!= null){
                                                         out.println(s);
                                                  }

                                                   %>
                                                   </p>

                                           </div>
                                            <div class="col-sm-4"></div>
                                           
                             </div>


                  

                    </form>

                </div> 

        </center>
    </body>

</html>
