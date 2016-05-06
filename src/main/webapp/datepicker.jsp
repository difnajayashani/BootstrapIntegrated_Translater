
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Javascript for the date picker -->

<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" media="all" href="datepicker/daterangepicker.css" />
<link rel="stylesheet" href="https://formden.com/static/cdn/bootstrap-iso.css"/>
<script type="text/javascript" src="datepicker/moment.js"></script>
<script type="text/javascript" src="datepicker/daterangepicker.js"></script>


<div class="bootstrap-iso form-group">
  <label class="col-md-6 control-label requiredField" for="date">
    Date of Birth *:

  </label>

  <div class="col-md-6">
    <input class="form-control" id="date" name="date" type="text" required/>
  </div>
</div>


<script>
$('#date').daterangepicker({


"singleDatePicker": true,
"showDropdowns": true,
"startDate": "04/22/2016"

});

</script>

