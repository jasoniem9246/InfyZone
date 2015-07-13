<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
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
                         <li><a href="account.html">My Account</a></li>
                         <li><a href="orderhistory.html">Order History</a></li>                         
                         <li><a href="editprofile.html">Edit Profile</a></li>
                     </ul>
                  </div>
               </div>
               <div class="col-md-9">
                  <h3><i class="fa fa-user color"></i> &nbsp;Order History</h3>
                  <!-- Your details -->
                  

                  <table class="table table-striped tcart">
                    <thead>
                      <tr>
                        <th>Date</th>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Status</th>
                      </tr>
                    </thead>
                    <tbody>
					<c:forEach items="orders" var=order>
					<tr>
                        <td>14-08-12</td>
                        <td>1523</td>
                        <td>Galaxy SIII</td>
                        <td>$430</td>
                        <td>Completed</td>
                     </tr>  
					</c:forEach>
                  </table>
                   
               </div>
            </div>
            
            <div class="sep-bor"></div>
         </div>
      </div>

<%@include file="footer.jsp"%>