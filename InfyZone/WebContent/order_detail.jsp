<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@include file="header.jsp"%>

      
      <!-- Logo & Navigation ends -->
     
      <!-- Page title -->
      <div class="page-title">
         <div class="container">
            <h2><i class="fa fa-desktop color"></i> View Order Detail <small>Order Number: </small></h2>
            <hr />
         </div>
      </div>
      <!-- Page title -->
      
      <!-- Page content -->
      
      <div class="view-cart blocky">
         <div class="container">
            <div class="row">
               <div class="col-md-12">
               
                  <!-- Table -->
                    <table class="table table-striped">
                      <thead>
                        <tr>
                        
                          <th>Order Item Id</th>
                          <th>Order Id</th>
                          <th>Product Id</th>
                          <th>Price</th>
                          <th>Quantity</th>
                        </tr>
                      </thead>
                      <tbody>
                         <c:forEach items="${items}" var="item">
                        <tr>
                          <!-- Index -->
                          <td>${item.orderItemId}</td>
                          <!-- Product  name -->
                          <td>${item.orderId}</td>
                          <!-- Product image<a href="single-item.html"><img src="img/items/2.png" alt="" class="img-responsive"/></a> -->
                          <td>${item.demoProductInfo}</td>
                          <!-- Quantity with refresh and remove button -->
                          <td>${item.unitPrice } </td>
                          <!-- Unit price -->
                          <td>${item.quantity}</td>
                          <!-- Total cost  <td>$300</td> -->
                         
                        </tr>
                        </c:forEach>
                      </tbody>
                    </table>
                                     
                      <hr />
                     
                     <!-- Button s-->
                    <div class="row">
                      <div class="span4 offset8">
                        <div class="pull-right">
                          <a href="#" class="btn btn-info">Back to Order History</a>
                        </div>
                      </div>
                    </div>

               
               </div>
            </div>
         </div>
      </div>
     

<%@include file="footer.jsp"%>