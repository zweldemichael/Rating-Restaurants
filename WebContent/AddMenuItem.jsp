<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Add Menu item</title>
</head>
<body>

<%-- adding menu item  --%>

<form class="form-horizontal" action="Query" method="post">
	Adding a location restaurant ${addLocRestName} 
  <div class="form-group">
    <label class="control-label col-sm-2" >Name of menu item</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="itemName" placeholder="Menu item name">
    </div>
  </div>
    <div class="form-group">
    <label class="control-label col-sm-2">Select item type</label>
    <div class="col-sm-10">   
    <label class="radio-inline"><input type="radio" name="itemFB" value="Food" >Food</label>
     <label class="radio-inline"><input type="radio" name="itemFB" value="Beverage" >Beverage</label>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" >Short description</label>
    <div class="col-sm-10"> 
      <textarea name="itemDesc" class="form-control" rows="4" cols="30" placeholder="Description"></textarea>
    </div>
  </div>
 <div class="form-group">
    <label class="control-label col-sm-2" >Price</label>
    <div class="col-sm-10"> 
      <input type="text" class="form-control" name="itemPrice" placeholder="ex. 10.89"> 
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" >Choose Category</label>
    <div class="col-sm-10"> 
      <select name="itemCat" class="form-control">
        <option value="Starter">Starter</option>
        <option value="Main">Main</option>
        <option value="Dessert">Dessert</option>
        </select>
    </div>
  </div>

  <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default" value="submitMitem" name="submit"> Submit</button>
    </div>
  </div>
</form>



</body>
</html>