<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
	<head>
		<meta charset="utf-8">
		<!-- Title here -->
		<title>InfyZone</title>
		<!-- Description, Keywords and Author -->
		<meta name="description" content="Online Shopping Market. Have fun">
		<meta name="keywords" content="Online Shopping Market">
		<meta name="author" content="Infosys's team">
		
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
		<!-- Styles -->
		<!-- Bootstrap CSS -->
		<link href="css/bootstrap.min.css" rel="stylesheet">
      <!-- Animate css -->
      <link href="css/animate.min.css" rel="stylesheet">
      <!-- Dropdown menu -->
      <link href="css/ddlevelsmenu-base.css" rel="stylesheet">
      <link href="css/ddlevelsmenu-topbar.css" rel="stylesheet">
      <!-- Countdown -->
      <link href="css/jquery.countdown.css" rel="stylesheet">     
		<!-- Font awesome CSS -->
		<link href="css/font-awesome.min.css" rel="stylesheet">		
		<!-- Custom CSS -->
		<link href="css/style.css" rel="stylesheet">
		
		<!-- Favicon -->
		<link rel="shortcut icon" href="#">
	</head>
	
	<body>

      <!-- Shopping cart Modal -->
     <div class="modal fade" id="shoppingcart" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
       <div class="modal-dialog">
         <div class="modal-content">
           <div class="modal-header">
             <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
             <h4 class="modal-title">Shopping Cart</h4>
           </div>
           
           <div class="modal-body">          
            <!-- Items table -->
            <table class="table table-striped">
            <thead>
                <tr>
                  <th>Name</th>
                  <th>Quantity</th>
                  <th>Price</th>
                </tr>
            </thead>
            <tbody>
<%--             <c:if test="${!empty user}">
			<c:forEach items="order.demoOrderItems" var="orderItem">
				<tr>
                  <td><a href="ProductDetail?productID=${orderItem.demoProductInfo.productId}">${orderItem.demoProductInfo.productName}</a></td>
                  <td>${orderItem.quantity}</td>
                  <td>${orderItem.unitPrice}</td>
                </tr>
			</c:forEach>
			</c:if> --%>
			</tbody>
            </table>
           </div>
           
           <div class="modal-footer">
           <form action="ShoppingController" method="post">
             <button type="button" class="btn btn-default" data-dismiss="modal">Continue Shopping</button>
             <button type="submit" class="btn btn-info" name="action" value="confirm">Checkout</button>
           </form>
           </div>
         </div><!-- /.modal-content -->
       </div><!-- /.modal-dialog -->
     </div><!-- /.modal -->
           
      <!-- Logo & Navigation starts -->
      
      <div class="header">
         <div class="container">
            <div class="row">
               <div class="col-md-1 col-sm-1">
                  <!-- Logo -->
                  <div class="logo">
                     <h1><a href="index.jsp">InfyZone</a></h1>
                  </div>
               </div>
				<div class="col-md-4 col-sm-3">
					<!-- Navigation menu -->
					<div class="navi">
						<div id="ddtopmenubar" class="mattblackmenu">
							<ul>
								<li>
									<a href="index.jsp" rel="ddsubmenu1">Home</a>
								</li>
							<c:if test="${!empty user}">
								<li><a href="#" rel="ddsubmenu1">Account</a>
									<ul id="ddsubmenu1" class="ddsubmenustyle">
										<li><a href="ViewCart">View Cart</a></li>
										<li><a href="ShowOrderHistory">Order History</a></li>
										<li><a href="#">Edit Profile</a></li>
									</ul>
								</li>   
							</c:if>                 
								<li><a href="contactus.html">Contact</a></li>
							</ul>
						</div>
					</div>
					<!-- Dropdown NavBar -->
					<div class="navis"></div>                
				</div>
				<div class="col-md-4 col-sm-4" style="margin-top:20px;">
				<form class="form-inline">
						<select name="category" style="height: 31px">
							<c:forEach items="${categories}" var="category">
								<option value="${category}">${category}</option>
							</c:forEach>
						</select> 
						<input   class="form-control" style="width:150px;" placeholder="Search..." name="search"/>
						<button type="submit" name="action" value="search" class="btn btn-default">						
						<span class="glyphicon glyphicon-star" aria-hidden="true">Go</span>
						</button>
				</form>
				</div>
               
               <div class="col-md-3 col-sm-3">
                  <div class="kart-links">
                     <a href="login.jsp">Login</a> 
                     <a href="register.jsp">Signup</a>
                     <a data-toggle="modal" href="#shoppingcart"><i class="fa fa-shopping-cart"></i> 
                     <c:if test="${!empty order.demoOrderItems}">
                     	${fn:length(order.demoOrderItems)} - ${order.orderTotal}
                     </c:if></a>
                  </div>
               </div>
            </div>
         </div>
      </div>
      
      <!-- Logo & Navigation ends -->