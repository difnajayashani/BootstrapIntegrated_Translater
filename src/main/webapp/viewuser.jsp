<html xmlns:jsp="http://java.sun.com/JSP/Page">

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

  <title>Online Translater Home </title>

    <!-- CSS -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
    <link href="css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="css/form-elements.css">

    <!--javascript to populate the bootstrap table -->
    <script src="bootstrap_table.js"></script>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.10.1/bootstrap-table.min.css">

    <!-- Latest compiled and minified JavaScript -->
    <script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.10.1/bootstrap-table.min.js"></script>



</head>

<body>

<%--<div class="container">--%>
    <div class="row">
        <div class="col-md-10 col-md-offset-1">

            <div class="panel panel-default panel-table">

        <%--panel heading --%>
        <div class="panel-heading">

                <div class="row">

                  <%--  <jsp:include page="searchuser.jsp">
                        <jsp:param name="title" value="User Search"/>
                    </jsp:include>--%>

                </div>

            <div class="row">
                <div class="col col-xs-6">
                    <h2 class="panel-title"><center>Registered Users</center></h2>
                </div>
                <div class="col col-xs-6 text-right">
                    <a href="adduser.jsp">
                        <button type="button" class="btn btn-sm btn-primary btn-create" >Add New</button>
                    </a>

                </div>
            </div>
        </div>


            <%--modelto appear when removing a user --%>
            <!-- Modal -->
            <div class="modal fade" id="myModal" role="dialog">
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h3 class="modal-title">Delete</h3>
                        </div>
                        <div class="modal-body">
                            <p>Delete the user...?</p>
                        </div>
                        <div class="modal-footer">
                            <%--<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>--%>
                            <button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
                            <button data-dismiss="modal" class="btn red" id="btnYes" onclick="removeRow()">Confirm</button>
                        </div>
                    </div>

                </div>
            </div>




        <%--panel body to insert the table --%>
        <div class="panel-body" id="table">


        </div>

            <%--<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Modal</button>--%>
</div>
   </div>
 </div>
<%--</div>--%>




</body>

</html>
