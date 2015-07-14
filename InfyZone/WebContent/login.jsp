<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@include file="header.jsp"%>

    <!-- Page content -->
      
      <div class="blocky">
         <div class="container">
            <div class="row">
               <div class="col-md-6">
                  <div class="reg-login-info">
                     <h2>Login to Access Amazing Benefits <span class="color">!!!</span></h2>
                     <img src="img/back1.jpg" alt="" class="img-responsive img-thumbnail" />
                     <p>Thousands of products on the website</p>
                  </div>
               </div>
               <div class="col-md-6">
                  <div class="register-login">
                     <div class="cool-block">
                        <div class="cool-block-bor">
                        
                           <h3>Login</h3>
                           <form class="form-horizontal" role="form" method="get" action="Login">
                             <div class="form-group">
                               <label for="inputEmail1" class="col-lg-2 control-label">Email</label>
                               <div class="col-lg-10">
                                 <input type="email" class="form-control" id="inputEmail1" placeholder="Email" name="email">
                               </div>
                             </div>
                             <div class="form-group">
                               <label for="inputPassword1" class="col-lg-2 control-label">Password</label>
                               <div class="col-lg-10">
                                 <input type="password" class="form-control" id="inputPassword1" placeholder="Password" name="password">
                               </div>
                             </div>
                             <div class="form-group">
                               <div class="col-lg-offset-2 col-lg-10">
                                 <div class="checkbox">
                                   <label>
                                     <input type="checkbox" name="remember" value="yes"> Remember me
                                   </label>
                                 </div>
                               </div>
                             </div>
                             <div class="form-group">
                               <div class="col-lg-offset-2 col-lg-10">
                                 <button type="submit" class="btn btn-info">Sign in</button>
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