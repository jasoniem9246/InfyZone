<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="header.jsp"%>

      
      <!-- Logo & Navigation ends -->
     
      <!-- Page title -->
      <div class="page-title">
         <div class="container">
            <h2><i class="fa fa-desktop color"></i> View Cart </h2>
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
                          <th>#</th>
                          <th>Name</th>
                          <th>Image</th>
                          <th>Quantity</th>
                          <th>Unit Price</th>
                          <th>Total</th>
                        </tr>
                      </thead>
                      <tbody>
						<c:choose>
							<c:when test="${!empty order}">
								<c:forEach items="${order.demoOrderItems}" var="item" varStatus="index">
									<tr>
										<!-- Index -->
										<td>${index.count}</td>
										<!-- Product  name -->
										<td><a
											href="GetProductByProductID?productId=${item.demoProductInfo.productId}">${item.demoProductInfo.productName}</a></td>
										<!-- Product image -->
										<td><a
											href="GetProductByProductID?productId=${item.demoProductInfo.productId}">
												<img src="${item.demoProductInfo.productimageurl}" alt=""
												class="img-responsive" />
										</a></td>
										<!-- Quantity with refresh and remove button -->
										<td>
											<div class="input-group">
												<form action="CartServlet" method="post" style="width:120px;">
													<input type="text" class="form-control" name="quantity" value="${item.quantity}" style="width: 60px;"> 
													<input type="hidden" name="productID" value="${item.demoProductInfo.productId}">
													<span class="input-group-btn" style="float: right;">
														<button class="btn btn-info" type="submit" name="action" value="update">
															<i class="fa fa-refresh"></i>
														</button>
														<button class="btn btn-danger" type="submit" name="delete">
															<i class="fa fa-times"></i>
														</button>
													</span>
												</form>
											</div>
										</td>
										<!-- Unit price -->
										<td><fmt:formatNumber value="${item.unitPrice}"
												type="currency" /></td>
										<!-- Total cost -->
										<td><fmt:formatNumber
												value="${item.unitPrice * item.quantity}" type="currency" /></td>
									</tr>

								</c:forEach>
							</c:when>
							<c:otherwise>
								<h3>Cart is empty</h3>
							</c:otherwise>
						</c:choose>

					</tbody>
                    </table>
                                     
                      <hr />
                     
                     <!-- Button s-->
                    <div class="row">
                      <div class="span4 offset8">
                        <div class="pull-right">
                        <form action="CartServlet" method="post">
                        	<a href="MainController" class="btn btn-info">Continue Shopping</a>
                        	<button class="btn btn-danger" type="submit" name="action" value="checkout">CheckOut</button> 
                        </form>
                        </div>
                      </div>
                    </div>

               
               </div>
            </div>
         </div>
      </div>
     

<%@include file="footer.jsp"%>