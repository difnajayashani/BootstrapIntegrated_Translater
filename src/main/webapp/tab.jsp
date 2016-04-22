<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%--
  Created by IntelliJ IDEA.
  User: hsenid
  Date: 4/22/16
  Time: 5:39 PM
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
  <title>Try v1.2 Bootstrap Online</title>
  <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <script src="bootstrap/js/jquery.min.js"></script>
  <script src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
  <h2>Tab Navigation via Data Attributes</h2>
  <ul class="nav nav-tabs">
    <li class="active"><a href="#mydropdown1" data-toggle="tab">HTML</a></li>
    <li><a href="#mydropdown2" data-toggle="tab">CSS</a></li>
    <li class="dropdown">
      <a href="#" data-toggle="dropdown" class="dropdown-toggle">JS Frameworks<span class="caret"></span></a>
      <ul class="dropdown-menu">
        <li><a data-toggle="tab" href="#dropdown1">JavaScript</a></li>
        <li><a data-toggle="tab" href="#dropdown2">JQuery</a></li>
      </ul>
    </li>
  </ul>
  <div class="tab-content">
    <div id="mydropdown1" class="tab-pane fade in active">
      <h3>HTML</h3>
      <p>HTML stands for Hyper Text Markup Language. A markup language is a set of markup tags.
        HTML documents contain HTML tags and plain textHTML documents are also called web pages.</p>
    </div>
    <div id="mydropdown2" class="tab-pane fade">
      <h3>CSS</h3>
      <p>CSS stands for Cascading Style Sheets. Styles define how to display HTML elements.
        External Style Sheets can save a lot of work. External Style Sheets are stored in CSS files.</p>
    </div>
    <div id="dropdown1" class="tab-pane fade">
      <h3>JavaScript</h3>
      <p>JavaScript is the programming language of the Web. JavaScript is the most popular programming language in the world.
        All modern HTML pages are using JavaScript.It is the language for HTML, for the Web, for computers, servers, laptops, tablets, smart phones, and more.
      </p>
    </div>
    <div id="dropdown2" class="tab-pane fade">
      <h3>JQuery</h3>
      <p>jQuery is a JavaScript Library. jQuery greatly simplifies JavaScript programming.
        jQuery is easy to learn. jQuery is a lightweight, "write less, do more", JavaScript library.
        The purpose of jQuery is to make it much easier to use JavaScript on your website.</p>
    </div>
  </div>
</div>
</body>

</html>
