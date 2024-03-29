<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@include file="header.jsp"%>
      
      <!-- Page content -->
      
      <div class="contactus ">
            <!-- Google maps -->
            <div class="gmap">
               <!-- Google Maps. Replace the below iframe with your Google Maps embed code -->
               <iframe height="400" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="http://maps.google.co.in/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=Google+India+Bangalore,+Bennigana+Halli,+Bangalore,+Karnataka&amp;aq=0&amp;oq=google+&amp;sll=9.930582,78.12303&amp;sspn=0.192085,0.308647&amp;ie=UTF8&amp;hq=Google&amp;hnear=Bennigana+Halli,+Bangalore,+Bengaluru+Urban,+Karnataka&amp;t=m&amp;ll=12.993518,77.660294&amp;spn=0.012545,0.036006&amp;z=15&amp;output=embed"></iframe>
            </div>
            
            <div class="container">
                        <div class="row">
                           <div class="col-md-6 col-sm-7">
                              <div class="cwell">
                                 <!-- Contact form -->
                                    <h5>Contact Form</h5>
                                    
                                    <form role="form">
                                      <div class="form-group">
                                        <label for="name">Your Name</label>
                                        <input type="text" class="form-control" id="name" placeholder="Enter Name">
                                      </div>                                    
                                      <div class="form-group">
                                        <label for="exampleInputEmail1">Email address</label>
                                        <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Enter email">
                                      </div>
                                      <div class="form-group">
                                        <label for="exampleInputEmail1">Content</label>
                                        <textarea class="form-control" rows="3"></textarea>
                                      </div>                                      
                                      <div class="checkbox">
                                        <label>
                                          <input type="checkbox"> Important?
                                        </label>
                                      </div>
                                      <button type="submit" class="btn btn-info">Send</button>
                                      <button type="reset" class="btn btn-default">Reset</button>
                                    </form>
                                    
                                 </div>
                           </div>
                           <div class="col-md-6 col-sm-5">
                                 <div class="cwell">
                                    <!-- Address section -->
                                       <h5>Address</h5>
                                       <div class="address">
                                           <address>
                                              <!-- Company name -->
                                              <h6>Responsive Web, Inc.</h6>
                                              <!-- Address -->
                                              795 Folsom Ave, Suite 600<br>
                                              San Francisco, CA 94107<br>
                                              <!-- Phone number -->
                                              <abbr title="Phone">P:</abbr> (123) 456-7890.
                                           </address>
                                            
                                           <address>
                                              <!-- Name -->
                                              <h6>Full Name</h6>
                                              <!-- Email -->
                                              <a href="mailto:#">first.last@gmail.com</a>
                                           </address>
                                           
                                       </div>
                                 </div>
                           </div>
                        </div>

         </div>
      </div>
      
<%@include file="footer.jsp"%>      
