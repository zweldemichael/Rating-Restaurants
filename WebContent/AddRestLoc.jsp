<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Add new Restaurant</title>
</head>
<body>
<%-- add new restaurant --%>

<form class="form-horizontal" action="Query" method="post">
	Adding a location restaurant ${addLocRestName} 
	<div class="form-group">
    <label class="control-label col-sm-2" >Restaurant Name</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="restName" placeholder="Restaurant Name">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" >Restaurant Type</label>
    <div class="col-sm-10">
    <select name="RestType">
    <c:forEach items="${restType}" var="item">
    	<option value="${item}">${item}</option>
    </c:forEach>
    </select>
    <%-- <select name="restType">
	 <c:forEach items="${restType}" var="item">
        <option value="${item}">${item}</option>
    </c:forEach>
	</select>--%>
	<p> Or Add new Restaurant type</p>
      <input type="text" class="form-control" name="cuisineType" placeholder="Restaurant Type">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" >URL</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="url" placeholder="www.example.net">
    </div>
  </div>
	  <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default" value="submitNewRest" name="submit"> Submit</button>
    </div>
  </div>
</form>

</body>
</html>