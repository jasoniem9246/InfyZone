<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
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
                          <th>#</th>
                          <th>Name</th>
                          <th>Image</th>
                          <th>Quantity</th>
                          <th>Unit Price</th>
                          <th>Total</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <!-- Index -->
                          <td>1</td>
                          <!-- Product  name -->
                          <td><a href="single-item.html">HTC One</a></td>
                          <!-- Product image -->
                          <td><a href="single-item.html"><img src="img/items/2.png" alt="" class="img-responsive"/></a></td>
                          <!-- Quantity with refresh and remove button -->
                          <td>                     
                          </td>
                          <!-- Unit price -->
                          <td>$150</td>
                          <!-- Total cost -->
                          <td>$300</td>
                        </tr>
                        
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