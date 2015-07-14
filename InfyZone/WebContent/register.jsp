<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@include file="header.jsp"%>

      <!-- Page content -->
      
      <div class="blocky">
         <div class="container">
            <div class="row">
               <div class="col-md-12">
               <h2>Register to Access Amazing Benefits <span class="color">!!!</span></h2>
                  <div class="register-login">
                     <div class="cool-block">
                        <div class="cool-block-bor">
                        
                           <h3>Register</h3>
                           <form class="form-horizontal" role="form" method="post" action="RegisterUser">
                             <div class="form-group">
                               <label for="inputName" class="col-lg-3 control-label">First Name</label>
                               <div class="col-lg-9">
                                 <input type="text" class="form-control" id="firstname" placeholder="Firstname" name="firstname">
                               </div>
                             </div>  
                             <div class="form-group">
                               <label for="inputName" class="col-lg-3 control-label">Last Name</label>
                               <div class="col-lg-9">
                                 <input type="text" class="form-control" id="lastname" placeholder="LastName" name="lastname">
                               </div>
                             </div>                         
                             <div class="form-group">
                               <label for="inputEmail1" class="col-lg-3 control-label">Email</label>
                               <div class="col-lg-9">
                                 <input type="email" class="form-control" id="inputEmail1" placeholder="Email" name="registerEmail">
                               </div>
                             </div>
                             <div class="form-group">
                               <label for="inputPassword1" class="col-lg-3 control-label">Password</label>
                               <div class="col-lg-9">
                                 <input type="password" class="form-control" id="inputPassword1" placeholder="Password" name="password">
                               </div>
                             </div>
                             <div class="form-group">
                               <div class="col-lg-offset-3 col-lg-10">
                                 <button type="submit" class="btn btn-info" name="register" value="register">Register</button>
                                 <button type="reset" class="btn btn-default">Reset</button>
                               </div>
                             </div>
                           </form>
                           
                        </div>
                     </div>   
                  </div>
               </div>
            </div>
            <div class="sep-bor"></div>
         </div>
      </div>
      
      
<%@include file="footer.jsp"%>