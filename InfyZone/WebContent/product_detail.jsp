<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@include file="header.jsp"%>

      <!-- Page content -->
      
      <div class="shop-items" style="margin:0px auto; width:80%">
         <div class="container">
            
            <div class="row">
               
               <div class="col-md-11">
               
                  <!-- Breadcrumb -->
                 <ul class="breadcrumb">
                   <li><a href="index.html">Home</a> <span class="divider"></span></li>
                   <li class="active">${product.productName}</li>
                 </ul>
               
                  <div class="single-item">
                      <div class="row">
                        <div class="col-md-4 col-xs-5">

                          <div class="item-image">
                              <img src="${product.productImageURL}" alt="" />
                          </div>
                              

                        </div>
                        <div class="col-md-5 col-xs-7">
                          <!-- Title -->
                            <h4>${product.productName}</h4>
                            <h5><strong>Price : ${product.listPrice}</strong></h5>
                            <p><strong>Shipping</strong> : Free</p>
                            <p><strong>Category</strong> : ${product.category}</p>
                            <p><strong>Availability</strong> : ${product.productAvail}</p><br />
                                                             
                                     <!-- Quantity and add to cart button -->
                                    
                                    <div class="input-group">
                                       <form method="post" action="ShoppingCart">
                                       <input type="text" class="form-control" name="quantity" placeholder="2">
                                       <span class="input-group-btn">
                                         <button class="btn btn-info" type="submit" >Go!</button>
                                       </span>
                                       </form>
                                     </div><!-- /input-group -->


                                    <!-- Share button -->
                            
                        </div>
                      </div>
                    </div>

            <br />
                    
                    <!-- Description, specs and review -->

                    <ul id="myTab" class="nav nav-tabs">
                      <!-- Use uniqe name for "href" in below anchor tags -->
                      <li class="active"><a href="#tab1" data-toggle="tab">Description</a></li>
<!--                       <li><a href="#tab2" data-toggle="tab">Specs</a></li>
                      <li><a href="#tab3" data-toggle="tab">Review (5)</a></li> -->
                    </ul>

                    <!-- Tab Content -->
                    <div id="myTabContent" class="tab-content">
                      <!-- Description -->
                      <div class="tab-pane fade in active" id="tab1">
                        <h5><strong>${product.productName}</strong></h5>
                        <p>
                        	${product.productDescription}
                        </p>
                      </div>

         			 </div>
         		</div>
         	</div>
        </div>
      </div>

<%@include file="footer.jsp"%>