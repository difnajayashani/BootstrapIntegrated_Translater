<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<html>


    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Translator Page</title>

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
        
        <script>
        function myFunction(){
       	 	var e = document.getElementById("text_origi").value;
       		var e2 = document.getElementById("text_trans").value;

            document.getElementById("text_origi").value = e2;
        
        	document.getElementById("text_trans").value = e;

        }
        </script>
        

    </head>

    <body class >
    	<div class="container text-center">
         	<h1><strong>Translator Page</strong></h1>
      
         	
        		 <form class="form-horizontal" role="form" method="post" action="MyServletTranslate" >
        		 	<div class="form-group "></div>
          			<div class="form-group ">
						
                   		 <div class="col-sm-5">
                    		<%
                   				out.println("<textarea name=\"original-text\" id=\"text_origi\" rows=\"15\" cols=\"50\">");
                            	String s1= (String)request.getAttribute("original");
                                        if (s1 != null){
                                            out.println(s1);
                                        }

                    			out.println("</textarea>");
                    		%>
                   		</div>

                     	<div class="col-sm-2 ">
                     		<div class="form-group block-center"></div>
                     		<div class="form-group block-center"></div>
                     		<div class="form-group block-center"></div>
                     		<div class="form-group block-center">
                     	 		<input type="submit" class="btn btn-primary  btn-lg center-block" value=Translate  name="submit"/>
                     	     </div> 
                     	     <div class="form-group block-center"></div>
                     	     <div class="form-group block-center"></div>
                     	     <div class="form-group block-center"></div>
                     	     
                     	      <div class="form-group block-center">
                     	      	   	<button type="button" class="btn btn-primary"  onclick="myFunction()">Swap the Text</button>
                     	      </div>
                     	      
                     	     <div class="form-group block-center"></div>
                     	     <div class="form-group block-center"></div>
                     	     <div class="form-group block-center"></div>
                     	     
                     	     <div class="form-group block-center">      
                        	<input type="reset" class="btn btn-primary  btn-lg" value="Reset"/>
                        	</div>
                     	</div>
                     	<div class="col-sm-5">
                     	<textarea name="translated-text" id="text_trans" rows="15" cols="50">

                        	<% String s2= (String)request.getAttribute("translated");
                        		if (s2 != null){
                           		out.println(s2);
                        		}


                        	%>
                    	</textarea></div>
                </div>
                <div class="form-group ">
                	<div class=" col-sm-5">
                   		<select class="form-control" name="original-lang" id="original" style="z-index: 1; width: 200px; padding:0px; position:absolute;">

                            <%

                              String buf_sel1=(String)request.getAttribute("selected_ol");
                              ArrayList<String>  buffer=new ArrayList<String>();
                              buffer= (ArrayList<String>)request.getAttribute("language_list");

                              for(int i=0;i<buffer.size();i++){

                                if( buf_sel1 !=null ){
                                        out.println("<option>" + buf_sel1 + "</option>");
                                        break;
                                }
                                else

                                        out.println("<option>"+buffer.get(i)+"</option>");

                              }


                            %>



                       </select>

                   </div>
                   <div class="col-sm-2"></div>

				   <div class=" col-sm-5">
                   <select class="form-control" name="translate-lang" id="translated" style="z-index: 1; width: 200px; padding:0px; position:absolute;">
                            <%

                              String buf_sel2=(String)request.getAttribute("selected_tl");
                              ArrayList<String>  buffer2=new ArrayList<String>();
                              buffer2= (ArrayList<String>)request.getAttribute("language_list");
                              for(int i=0;i<buffer2.size();i++){
                                    if( buf_sel2 !=null ){
                                       out.println("<option>" + buf_sel2 + "</option>");
                                          break;
                                    }
                                    else

                                        out.println("<option>"+buffer.get(i)+"</option>");
								}
                          
                            %>

                        </select>

                   </div>

                </div>
                 <div class="form-group "></div>
                 <div class="form-group "></div>

                 <div class="form-group ">
                     <div class=" col-sm-5">
            
                     </div>
                     <div class=" col-sm-2"></div>
                     <div class=" col-sm-5"></div>
                 </div>

                 <div class="form-group ">

                    <div id="logout">

                        <a href="http://localhost:8080/Bootstrap_Translater/LogoutServlet">Logout</a>
                    </div>
                 </div>
                 <div class="form-group ">

                       <p  style="color:blue"> Logged in as
                     <%=request.getAttribute("name")%>



                        </p>


                </div>



			
        	</form>

		</div>
  
    <p>&nbsp;</p>
    <p> Powered by Yandex.Translate <a href="http://translate.yandex.com/.">http://translate.yandex.com/.</a></p>

    </body>






</html>