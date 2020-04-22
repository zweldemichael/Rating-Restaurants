<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Add Location</title>
</head>
<body>

<%-- adding a location --%>

<form class="form-horizontal" action="Query" method="post">
	Adding a location restaurant ${addLocRestName} 

  <div class="form-group">
    <label class="control-label col-sm-2" >First Open Date</label>
    <div class="col-sm-10">
      <input type="date" class="form-control" name="openDate" placeholder="yyyy-mm-dd" size="10" maxlength="10">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" >Manager Name</label>
    <div class="col-sm-10"> 
      <input type="text" class="form-control" name="mgrName" placeholder="Manager Name">
    </div>
  </div>
 <div class="form-group">
    <label class="control-label col-sm-2" >Phone Number</label>
    <div class="col-sm-10"> 
      <input type="text" class="form-control" name="phoneNo" size="10" maxlength="10" placeholder="1234567890"> 
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" >Street Address</label>
    <div class="col-sm-10"> 
      <input type="text" class="form-control" name="street">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2">Open Hour</label>
    <div class="col-sm-10"> 
      <input type="text" class="form-control" name="openHr" size="4" maxlength="4" placeholder="24 Hour fromat">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" >Close Hour</label>
    <div class="col-sm-10"> 
      <input type="text" class="form-control" name="closeHr"  maxlength="4" placeholder="24 Hour fromat">
    </div>
  </div>
  <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default" value="submitLoc" name="submit"> Submit</button>
    </div>
  </div>
</form>



<%-- Add new Rest. --%>


</body>
</html>