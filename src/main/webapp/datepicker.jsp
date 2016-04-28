
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link rel="stylesheet" href="https://formden.com/static/cdn/bootstrap-iso.css"/>


<div class="bootstrap-iso form-group">
  <label class="col-md-6 control-label requiredField" for="date">
    Date of Birth:
       <span class="asteriskField">
        *
       </span>
  </label>

  <div class="col-md-6">
    <input class="form-control" id="date" name="date" type="text" required/>
  </div>
</div>

<%--
<!-- Include jQuery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>

<!-- Include Date Range Picker -->
<script type="text/javascript"
        src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
--%>

<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" media="all" href="datepicker/daterangepicker.css" />

<script type="text/javascript" src="datepicker/moment.js"></script>
<script type="text/javascript" src="datepicker/daterangepicker.js"></script>

<script>
$('#date').daterangepicker({


"singleDatePicker": true,
"showDropdowns": true,
"startDate": "04/22/2016"

});

</script>
<%--
<script>
$(function() {
$('#date').datepick();

});
</script>--%>
