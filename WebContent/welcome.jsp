<%@page import="provider.Restaurant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome . jsp</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<center>
<form action="Query" method="post">
<h1> Hi ${username} !! We welcome you </h1>
<input value="${username}" name="uname" type="hidden" > 


<h3>Select restaurant from list</h3> 


<%-- for Q a and b --%>


	<label>Restaurant Name:</label>
	<select name="restName">
	 <c:forEach items="${restList}" var="item">
        <option value="${item}">${item}</option>
    </c:forEach>
	</select> <br>
	<button type = "submit"  value="restList" name="submit" class="btn btn-primary" > list of locations</button>
	<button type = "submit"  value="menuItem" name="submit" class="btn btn-primary"> menu </button> 
	<button type = "submit"  value="rateRest" name="submit" class="btn btn-danger"> Rate Restaurant </button><br> <br> <br> <br>
	<button type = "submit"  value="addLoc" name="submit" class="btn btn-primary"> Add Location </button> 
	<button type = "submit"  value="addItem" name="submit" class="btn btn-primary"> Add Item </button> <br> <br>
	<button type = "submit"  value="newRest" name="submit" class="btn btn-primary"> Add New Restaurant </button>
	<button type = "submit"  value="mostExpsve" name="submit" class="btn btn-primary"> Most Expensive Item </button><br> <br>
	<button type = "submit"  value="delAcc" name="submit" class="btn btn-danger"> Delete Account </button>
	<button type = "submit"  value="delRest" name="submit" class="btn btn-danger"> Delete Restaurant </button>
	</form>	
</center>
<br>

<%-- for Q c--%>
<center>
<form action="Query" method="post">
	<label>Restaurant Type:</label>
	<select name="restType">
	 <c:forEach items="${restTypeList}" var="item">
        <option value="${item}">${item}</option>
    </c:forEach>
	</select>
	<button type = "submit"  value="restType" name="submit" class="btn btn-primary" > search rest type </button> <br> <br> <br> <br>
	
		<button type = "submit"  value="qE" name="submit" class="btn btn-primary" > Q E</button>
			<button type = "submit"  value="qF" name="submit" class="btn btn-primary" > Q F </button>
				<button type = "submit"  value="qG" name="submit" class="btn btn-primary" > Q G </button>
					<button type = "submit"  value="qH" name="submit" class="btn btn-primary" >Q H </button>
						<button type = "submit"  value="qI" name="submit" class="btn btn-primary" > Q I </button>
						<button type = "submit"  value="qK" name="submit" class="btn btn-primary" > Q K </button>
						<button type = "submit"  value="qJ" name="submit" class="btn btn-primary" > Q J </button>
							<button type = "submit"  value="qM" name="submit" class="btn btn-primary" > Q M </button>
								<button type = "submit"  value="qN" name="submit" class="btn btn-primary" > Q N </button>
	</form>	
</center>

</body>
</html>