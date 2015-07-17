<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@include file="header.jsp"%>

      <!-- Page title -->
      <div class="page-title">
         <div class="container">
            <h2><i class="fa fa-shopping-cart color"></i> We received payment Successfully...</h2>
            <hr />
            <h5>Thanks for buying from InfyZone!!!</h5>
            <h5>Your <a href="ShowOrderHistory">Order</a> is confirmed. Use this for further communication.</h5>

            <div class="sep-bor"></div>
            <form class="form-inline" role="form">
              <div class="form-group">
                <input type="email" class="form-control" id="search" placeholder="Type Something...">
              </div>
              <button type="submit" class="btn btn-info">Search</button>
            </form>
                    <div class="link-list">
                      <h4><strong>Take a look around our site</strong></h5>
                      <a href="#">Home</a> <a href="#">About us</a> <a href="#">Support</a> <a href="#">Contact Us</a> <a href="#">Disclaimer</a>
                    </div>

            <div class="sep-bor"></div>
         </div>
      </div>
      <!-- Page title -->

<%@include file="footer.jsp"%>