<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="header.jsp"%>

<!-- Hero starts -->
      
		  <div class="hero">
			 <div class="container">
				<div class="row">
				   <div class="col-md-12">
					  <!-- Catchy title -->
					  <h3>Welcome to <span class="color">InfyZone</span> online shopping website</h3>
					  <p>An exciting place for the whole family to shop.</p>
				   </div>
				</div>
			  <div class="sep-bor"></div>
			 </div>
		  </div>
      
<!-- Hero ends -->  

      <!-- Items List starts -->

      <div class="shop-items blocky">
        <div class="container">
          
         <div class="row">
            <!-- Item #1 -->
         <c:choose>
         <c:when test="${!empty products}">
            <c:forEach items="${products}" var="product">
            <div class="col-md-3 col-sm-6 col-xs-12">
              <div class="item">
                <!-- Use the below link to put HOT icon -->
                <div class="item-icon"><span>HOT</span></div>
                <!-- Item image -->
                <div class="item-image">
                  <a href="GetProductByProductId?productID=${product.productId}">
                  <img src="${product.productimageurl}" alt="" class="img-responsive"/>
                  </a>
                </div>
                <!-- Item details -->
                <div class="item-details">
                  <!-- Name -->
                  <h5><a href="GetProductByProductId?productID=${product.productId}">${product.productName}</a></h5>
                  <div class="clearfix"></div>
                  <!-- Para. Note more than 2 lines. -->
                  <p>${fn:substring(product.productDescription, 0, 20)}...</p>
                  <hr />
                  <!-- Price -->
                  <div class="item-price pull-left"><fmt:formatNumber value="${product.listPrice}" type="currency"/></div>
                  <!-- Add to cart -->
                  <div class="pull-right"><a href="CartServlet?productID=${product.productId}" class="btn btn-danger btn-sm">Add to Cart</a></div>
                  <div class="clearfix"></div>
                </div>
              </div>
            </div>      
            </c:forEach>
         </c:when>
         <c:otherwise>
         <div class="col-md-12">
         		<h1>Sorry! Product not found</h3>
         </div>
         </c:otherwise>    
         </c:choose>         
          </div>
        </div>
      </div>

      <!-- Items List ends -->

<%@include file="footer.jsp"%>