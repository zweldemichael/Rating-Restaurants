<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<form  action="Query" method="post">
<input value="${name}" name="uname" type="hidden" > 
<input value="${restName}" name="rateRest" type="hidden" > 
 <div class="form-group">
    <label >Price</label>
    <input type="text" class="form-control" name="price" placeholder="1 to 5">
  </div>
  <div class="form-group">
   <label >Food</label>
    <input type="text" class="form-control" name="food" placeholder="1 to 5">
  </div>
   <div class="form-group">
   <label >Mood</label>
    <input type="text" class="form-control" name="mood" placeholder="1 to 5">
  </div>
   <div class="form-group">
   <label >Staff</label>
    <input type="text" class="form-control" name="staff" placeholder="1 to 5">
  </div>
<label class="control-label col-sm-2" >Comments</label>
    <div class="col-sm-10"> 
      <textarea name="comments" class="form-control" rows="4" cols="30" placeholder="write comments here"></textarea>
    </div>
   
  
  <button type="submit" class="btn btn-default" value="submitRestRating" name="submit" >Submit</button>


</form>

</body>
</html>