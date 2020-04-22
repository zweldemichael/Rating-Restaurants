<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Query Result</title>
</head>
<body>

<%-- listing locations of restaurnts --%>
<div class="container">            
  <table class="table table-striped">
    <thead>
      <tr>
      <c:forEach items="${restLocCol}" var="item">
          <th>${item}</th>
    </c:forEach>
      </tr>
    </thead>
    <tbody>
    
<c:forEach items="${restDet}" var="item">
    	<tr>
    	<td>
       ${item.cuisine}
       </td>
        <td>
       <c:out value="${item.URL}" />
       </td>
        <td>
       <c:out value="${item.openDate}" />
       </td>
       <td>
       <c:out value="${item.mgrName}" />
       </td>
        <td>
     	<c:out value="${item.phone}" />
       </td>
        <td>
       <c:out value="${item.street}" />
       </td>
        <td>
       <c:out value="${item.openHour}" />
       </td>
        <td>
       <c:out value="${item.closeHour}" />
       </td>
    </tr>
</c:forEach>
    </tbody> 
  </table>
</div>

<%-- listing starter --%>
<form action="Query" method="post">
${restName}
<input value="${restName}" name="restNameFromMitem" type="hidden" > 
<div class="container"> 
<h1>${StarterName}</h1>           
  <table class="table table-striped">
    <thead>
      <tr>
      <%-- <th> Name</th>
      <th>Description</th>
      <th>Price</th>--%>
     
      <c:forEach items="${colName}" var="item">
          <th>${item}</th>
    </c:forEach>
      </tr>
    </thead>
    <tbody>
    
<c:forEach items="${starter}" var="item">
    	<tr>
    	<td>
       ${item.name}
       <input value="${item.name}" name="restToDelete" type="hidden" > 
       </td>
        <td>
       <c:out value="${item.desc}" />
       </td>
        <td>
       $<c:out value="${item.price}" />
       </td>
       
       <td><button type = "submit"  value="delete" name="submit" class="btn btn-danger" > delete </button></td>
     
    </tr>
</c:forEach>
    </tbody> 
  </table>
</div>

<%-- listing main --%>
<div class="container">  
<h1>${MainName}</h1>            
  <table class="table table-striped">
    <thead>
   <%-- <th> Name</th>
      <th>Description</th>
      <th>Price</th> --%>
      <tr>     
      <c:forEach items="${colName}" var="item">
          <th>${item}</th>
    </c:forEach>
    
      </tr>
    </thead>
    <tbody>
    
<c:forEach items="${main}" var="item">
    	<tr>
    	<td>
       ${item.name}
       <input value="${item.name}" name="restToDelete" type="hidden" > 
       </td>
        <td>
       <c:out value="${item.desc}" />
       </td>
        <td>
       $<c:out value="${item.price}" />
       </td>
      <td><button type = "submit"  value="delete" name="submit" class="btn btn-danger" > delete </button></td>
    </tr>
</c:forEach>
    </tbody> 
  </table>
</div>

<%-- listing dessert --%>
<div class="container"> 
<h1>${DessertName}</h1>             
  <table class="table table-striped">
    <thead>
      <tr>
      <%-- <th> Name</th>
      <th>Description</th>
      <th>Price</th> --%>
      
      <c:forEach items="${colName}" var="item">
          <th>${item}</th>
    </c:forEach>
    
      </tr>
    </thead>
    <tbody>
    
<c:forEach items="${dessert}" var="item">
    	<tr>
    	<td>
       ${item.name}
       <input value="${item.name}" name="restToDelete" type="hidden" > 
       </td>
        <td>
       <c:out value="${item.desc}" />
       </td>
        <td>
       $<c:out value="${item.price}" />
       </td>
      <td><button type = "submit"  value="delete" name="submit" class="btn btn-danger" > delete </button></td>
    </tr>
</c:forEach>
    </tbody> 
  </table>
</div>
  </form>
<%-- Listing from Cuisine search --%>
<div class="container">            
  <table class="table table-striped">
    <thead>
      <tr>
      <c:forEach items="${restTypeCol}" var="item">
          <th>${item}</th>
    </c:forEach>
      </tr>
    </thead>
    <tbody>
    
<c:forEach items="${restType}" var="item">
    	<tr>
    	<td>
       ${item.name}
       </td>
        <td>
       <c:out value="${item.openDate}" />
       </td>
        <td>
       <c:out value="${item.mgrName}" />
       </td>
     
    </tr>
</c:forEach>
    </tbody> 
  </table>
</div>

<%-- Query d listing most expsv item --%>
<div class="container"> 
<h1>${mstExpsvName}</h1>             
  <table class="table table-striped">
    <thead>
      <tr>
    <th>${mstExpsvItemName}</th>
     <th>${mstExpsvPrice}</th>
      <th>${mstExpsvmgrName}</th>
       <th>${mstExpsvOpenHR}</th>
        <th>${mstExpsvURL}</th>
      
      <%-- <c:forEach items="${mstExpsvCol}" var="item">
          <th>${item}</th>
    </c:forEach>
    --%>
    
      </tr>
    </thead>
    <tbody>
<c:forEach items="${mstExpsv}" var="item">
    	<tr>
    	<td>
        <c:out value="${item.mostExpsvItem}" />
       </td>
        <td>
       $<c:out value="${item.mostExpsvItemPrice}" />
       </td>
        <td>
       <c:out value="${item.mgrName}" />
       </td>
      <td>
       <c:out value="${item.openHour}" />
       </td>
       <td>
       <c:out value="${item.URL}" />
       </td>
    </tr>
    </c:forEach>
    </tbody> 
  </table>
</div>
 
 
 <div class="container">             
  <table class="table table-striped">
    <thead>
      <tr>
      <c:forEach items="${a}" var="item">
       <th>${item}</th>
     </c:forEach>
      <%-- <c:forEach items="${mstExpsvCol}" var="item">
          <th>${item}</th>
    </c:forEach>
    --%>
      </tr>
    </thead>
    <tbody>
<c:forEach items="${a}" var="item">
      <tr>
 		<td>
       		${item}
       </td>
      </tr>
      </c:forEach>
    </tbody> 
  </table>
</div>


<%-- Q E--%>
<div class="container">   
       <h1>${Qe}</h1>   
  <table class="table table-striped">
 
    <thead>
      <tr>
     
          <th>${cuisine}</th>
 	<th>${category}</th>
 	 <th>${avgPrice}</th>
      </tr>
    </thead>
    <tbody>
    
<c:forEach items="${e}" var="item">
    	<tr>
    	<td>
      <c:out value="${item.cuisine}" />
       </td>
        <td>
       <c:out value="${item.cateID}" />
       </td>
        <td>
       $<c:out value="${item.avePrice}" />
       </td>
    </tr>
</c:forEach>
    </tbody> 
  </table>
</div>

<%-- Q f--%>
<div class="container">   
        <h1>${Qf}</h1> 
  <table class="table table-striped">
  
    <thead>
      <tr>
     
          <th>${uname}</th>
 	<th>${restName}</th>
 	 <th>${count}</th>
 	  <th>${avgPrice}</th>
      </tr>
    </thead>
    <tbody>
    
<c:forEach items="${f}" var="item">
    	<tr>
    	<td>
      <c:out value="${item.uname}" />
       </td>
        <td>
       <c:out value="${item.restName}" />
       </td>
        <td>
       <c:out value="${item.count}" />
       </td>
        <td>
       $<c:out value="${item.avePrice}" />
       </td>
    </tr>
</c:forEach>
    </tbody> 
  </table>
</div>


<%-- Q h--%>
<div class="container">   
        <h1>${Qh}</h1> 
  <table class="table table-striped">
    <thead>
      <tr>
 	<th>${restName}</th>
 	 <th>${oDate}</th>
      </tr>
    </thead>
    <tbody>
    
<c:forEach items="${h}" var="item">
    	<tr>
        <td>
       <c:out value="${item.restName}" />
       </td>
        <td>
       <c:out value="${item.openDate}" />
       </td>
    </tr>
</c:forEach>
    </tbody> 
  </table>
</div>

<%-- Q g--%>
<div class="container">   
        <h1>${Qg}</h1> 
  <table class="table table-striped">
    <thead>
      <tr>
 	<th>${restNameG}</th>
 	 <th>${phone}</th>
 	 <th>${cuisineG}</th>
      </tr>
    </thead>
    <tbody>
    
<c:forEach items="${g}" var="item">
    	<tr>
        <td>
       <c:out value="${item.restName}" />
       </td>
        <td>
       <c:out value="${item.phone}" />
       </td>
        <td>
       <c:out value="${item.cuisine}" />
       </td>
    </tr>
</c:forEach>
    </tbody> 
  </table>
</div>

<%-- Q I--%>
<div class="container">   
        <h1>${QI}</h1> 
  <table class="table table-striped">
    <thead>
      <tr>
 	<th>${restNameI}</th>
 	 <th>${unameI}</th>
      </tr>
    </thead>
    <tbody>
    
<c:forEach items="${I}" var="item">
    	<tr>
        <td>
       <c:out value="${item.restName}" />
       </td>
        <td>
       <c:out value="${item.uname}" />
       </td>
    </tr>
</c:forEach>
    </tbody> 
  </table>
</div>

<%-- Q M--%>
<div class="container">   
        <h1>${QM}</h1> 
  <table class="table table-striped">
    <thead>
      <tr>
 	<th>${unameM}</th>
 	 <th>${repM}</th>
 	  <th>${commentM}</th>
      </tr>
    </thead>
    <tbody>
    
<c:forEach items="${M}" var="item">
    	<tr>
        <td>
       <c:out value="${item.uname}" />
       </td>
        <td>
       <c:out value="${item.rep}" />
       </td>
        <td>
       <c:out value="${item.comments}" />
       </td>
    </tr>
</c:forEach>
    </tbody> 
  </table>
</div>

<%-- Q N--%>
<div class="container">   
        <h1>${QN}</h1> 
  <table class="table table-striped">
    <thead>
      <tr>
 	<th>${unameN}</th>
 	 <th>${emailN}</th>
 	  <th>${totalN}</th>
      </tr>
    </thead>
    <tbody>
    
<c:forEach items="${N}" var="item">
    	<tr>
        <td>
       <c:out value="${item.uname}" />
       </td>
        <td>
       <c:out value="${item.email}" />
       </td>
        <td>
       <c:out value="${item.total}" />
       </td>
    </tr>
</c:forEach>
    </tbody> 
  </table>
</div>

<%-- Q K--%>
<div class="container">   
        <h1>${QK}</h1> 
  <table class="table table-striped">
    <thead>
      <tr>
 	<th>${unameK}</th>
 	 <th>${joinK}</th>
 	  <th>${repK}</th>
 	   <th>${restK}</th>
 	  <th>${postK}</th>
      </tr>
    </thead>
    <tbody>
    
<c:forEach items="${K}" var="item">
    	<tr>
        <td>
       <c:out value="${item.uname}" />
       </td>
        <td>
       <c:out value="${item.joinDate}" />
       </td>
        <td>
       <c:out value="${item.rep}" />
       </td>
        <td>
       <c:out value="${item.restName}" />
       </td>
        <td>
       <c:out value="${item.postDate}" />
       </td>
    </tr>
</c:forEach>
    </tbody> 
  </table>
</div>

<%-- Q J--%>
<div class="container">   
        <h1>${QJ}</h1> 
  <table class="table table-striped">
    <thead>
      <tr>
 	<th>${desJ}</th>
 	 <th>${unameJ}</th>
 	  <th>${restJ}</th>
 	   <th>${avgJ}</th>
      </tr>
    </thead>
    <tbody>
    
<c:forEach items="${J}" var="item">
    	<tr>
        <td>
       <c:out value="${item.desc}" />
       </td>
        <td>
       <c:out value="${item.uname}" />
       </td>
        <td>
       <c:out value="${item.restName}" />
       </td>
        <td>
       <c:out value="${item.avePrice}" />
    </tr>
</c:forEach>
    </tbody> 
  </table>
</div>

</html>