<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
	<title></title>

		<link href="jquery.datepick.css" rel="stylesheet">
	<script src="jquery.min.js"></script>
		<script src="jquery.plugin.js"></script>
		<script src="jquery.datepick.js"></script>

<script>
$(function() {
	$('#popupDatepicker').datepick();
	$('#inlineDatepicker').datepick({onSelect: showDate});
});

</script>

</head>
<body>



<input type="text" id="popupDatepicker" placeholder="Date of Birth..." class="form-birth-date form-control" size="30" required>

</body>
</html>
