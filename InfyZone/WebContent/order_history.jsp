<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
    
<%@include file="header.jsp"%>


    <!-- Page title -->
      <div class="page-title">
         <div class="container">
            <h2><i class="fa fa-desktop color"></i> My Account <small>Subtext for header</small></h2>
            <hr />
         </div>
      </div>
      <!-- Page title -->
      
      <!-- Page content -->
      
      <div class="account-content">
         <div class="container">
            
            <div class="row">
               <div class="col-md-3">
                  <div class="sidey">
                     <ul class="nav">
                         <li><a href="#">My Account</a></li>
                         <li><a href="ShowOrderHistory">Order History</a></li>                         
                         <li><a href="editprofile.jsp">Edit Profile</a></li>
                     </ul>
                  </div>
               </div>
               <div class="col-md-9">
                  <h3><i class="fa fa-user color"></i> &nbsp;Order History</h3>
                  <!-- Your details -->
                  

                  <table class="table table-striped tcart">
                    <thead>
                      <tr>
                        <th>Order ID</th>
                        <th>Customer ID</th>
                        <th>Order Total</th>
                        <th>Order TimeStamp</th>
                        <th>User ID</th>
                      </tr>
                    </thead>
                    <tbody>
					<c:forEach items="${orders}" var="order">
					<tr>
					<td><a href = "ShowOrderDetail?orderId=${order.orderId}">${order.orderId}</a></td>
					<td>${order.demoCustomer.customerId}</td>
					<td>${order.orderTotal}</td>
					<td>${order.orderTimestamp}</td>
					<td>${order.demoUser.userId}</td>    
                     </tr>  
					</c:forEach>
                  </table>
                   
               </div>
            </div>
            
            <div class="sep-bor"></div>
         </div>
      </div>

<%@include file="footer.jsp"%>

