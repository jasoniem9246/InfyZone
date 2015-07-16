<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@include file="header.jsp"%>

<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script> 

<script type="text/javascript">
//p elements for displaying lat / long and address
	var displayCoords, myAddress; 
	var country, postalCode, state, route, streetNumber, locality, areaLvl1, areaLvl2;
	window.onload = init;

	function init() {
		geocoder = new google.maps.Geocoder();
		console.log("Adding input listener to all input fields");
		// add an input listener to all input fields
		/* var listOfInputsInForm = document.querySelectorAll("input");
		for (var i = 0; i < listOfInputsInForm.length; i++) {
			addInputListener(listOfInputsInForm[i]);
		}

		// restore form content with previously saved values
		restoreFormContent(); */
	}

	function addInputListener(inputField) {
		inputField.oninput = function(event) {
			localStorage.setItem(inputField.id, inputField.value);
		};
	}

	function restoreFormContent() {
		console.log("restoring form content from localStorage");

		// get the list of all input elements in the form
		var listOfInputsInForm = document.querySelectorAll("input");

		// For each input element, 
		//    - get its id (that is also the key for it's saved content 
		//      in the localStorage)
		//    - get the value associated with the id/key in the local
		//      storage
		//    - If the value is not undefined, restore the value
		//      of the input field
		for (var i = 0; i < listOfInputsInForm.length - 4; i++) {
			var fieldToRestore = listOfInputsInForm[i];
			var id = fieldToRestore.id;
			var savedValue = localStorage.getItem(id);

			if (savedValue !== undefined) {
				fieldToRestore.value = savedValue;
			}
		}
	}
	
	// Called when the button is clicked
    function getLocation() {
       if (navigator.geolocation) {
         navigator.geolocation.getCurrentPosition(showPosition);
       } else {
       displayCoords.innerHTML="Geolocation API not supported by your browser.";
     }
	}

 	// Called when a position is available
    function showPosition(position) {  
        // Display the map
        showOnGoogleMap(new google.maps.LatLng(position.coords.latitude, position.coords.longitude));
 
    }
 	
    function showOnGoogleMap(latlng) {
        // Ask google geocoder for a surface address once we get a longitude and 
        // a latitude. In fact the reverse geocoder sends back an array of "guesses"
        // i.e. not only one address object, but several. Each entry in this array
        // has several properties like street, city, etc. We use the "formatted_address"
        // one here, but it might be interesting to get the detailed properties in other
        // applications like a form with street, city, zip code etc.
        geocoder.geocode({'latLng': latlng},reverseGeocoderSuccess);
      
        function reverseGeocoderSuccess(results, status) {
          if (status == google.maps.GeocoderStatus.OK) {
            // For debugging
            console.dir(results);
            
            if (results[1]) {
              // Display address as text in the page
              myAddress = results[0].formatted_address;            
              parseResult(results[0].address_components);
              console.log(myAddress);
              
              document.getElementById("zipCode").value = postalCode;
              document.getElementById("state").value = state;
              document.getElementById("city").value = locality;
              
              
            } else {
              alert('No results found');
            }
          } else {
            alert('Geocoder failed due to: ' + status);
          }
        } // end of reverseGeocoderSuccess
      }  // end of showOnGoogleMap
      
      function parseResult(result) {
    	     for(i in result){
    	         console.log("type = " + result[i].types[0] + " long_name = " +
    	                     result[i].long_name);
    	         if(result[i].types[0] == 'postal_code')
    	             postalCode = result[i].long_name;
    	         if(result[i].types[0] == 'country')
    	             country= result[i].long_name;
    	         if(result[i].types[0] == 'street_number')
    	             streetNumber= result[i].long_name;
    	         if(result[i].types[0] == 'route')
    	             route= result[i].long_name;
    	         if(result[i].types[0] == 'locality')
    	             locality= result[i].long_name;
    	         if(result[i].types[0] == 'state')
    	             state= result[i].long_name;
    	         if(result[i].types[0] == 'administrative_area_level_2')
    	             arealLvl2= result[i].long_name;
    	         if(result[i].types[0] == 'administrative_area_level_1')
    	             areaLvl1= result[i].long_name;
    	     }
    	     
    	    state = myAddress.split(",")[2].split(" ")[1];
    	     // added this for debugging in the console
    	    console.log("postalCode = " + postalCode);
/*     	    console.log("country = " + country);
    	    console.log("streetNumber = " + streetNumber);
    	    console.log("route = " + route); */
    	    console.log("state = " + state);
    	    console.log("locality = " + locality);  
/*     	    console.log("Administrative area level 1 " + areaLvl2);
    	    console.log("Administrative area level 2 " + areaLvl1); */
    	 }
    </script>
     
</script>

<!-- Logo & Navigation ends -->
      <!-- Page title -->
      <div class="page-title">
         <div class="container">
            <h2><i class="fa fa-desktop color"></i> My Account</h2>
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
                  <h3><i class="fa fa-user color"></i> &nbsp;Edit Profile&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button class="btn btn-info" onclick="getLocation()">Where am I ?</button></h3>  
                  <!-- Your details -->
                  <form class="form-horizontal" role="form" method="post" action="SetCustomerInfo">
                    <div class="form-group">
                      <label for="firstname" class="col-md-2 control-label">First Name</label>
                      <div class="col-md-4">
                        <input type="text" class="form-control" id="firstname" name="firstname" placeholder="Firstname">
                      </div>
                    </div>   
                    <div class="form-group">
                      <label for="lastname" class="col-md-2 control-label">Last Name</label>
                      <div class="col-md-4">
                        <input type="text" class="form-control" id="lastname" name="lastname" placeholder="Lastname">
                      </div>
                    </div>         
                    <div class="form-group">
                      <label for="phone1" class="col-md-2 control-label">Phone 1</label>
                      <div class="col-md-4">
                        <input type="text" class="form-control" id="phone1" name="phone1" placeholder="Phone 1">
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="phone2" class="col-md-2 control-label">Phone 2</label>
                      <div class="col-md-4">
                        <input type="text" class="form-control" id="phone2" name="phone2" placeholder="Phone 2">
                      </div>
                    </div>      
                    <div class="form-group">
                        <label for="address1" class="col-md-2 control-label">Address 1</label>
                        <div class="col-md-4">
                           <textarea class="form-control" rows="3" id="address1" name="address1" placeholder="Address 1"></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="address2" class="col-md-2 control-label">Address 2</label>
                        <div class="col-md-4">
                           <textarea class="form-control" id="address2" name="address2" rows="3" placeholder="Address 2"></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                      <label for="city" class="col-md-2 control-label">City</label>
                      <div class="col-md-4">
                        <input type="text" class="form-control" id="city" name="city" placeholder="City">
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="state" class="col-md-2 control-label">State</label>
                      <div class="col-md-4">
                        <input type="text" class="form-control" id="state" name="state" placeholder="State">
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="zipCode" class="col-md-2 control-label">Zip Code</label>
                      <div class="col-md-4">
                        <input type="text" class="form-control" id="zipCode" name="zipCode" placeholder="Zip Code">
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="userName" class="col-md-2 control-label">Username</label>
                      <div class="col-md-4">
                        <input type="text" class="form-control" id="userName" name="userName" placeholder="Username" value="${user.userName}"/>
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="email" class="col-lg-2 control-label">Email</label>
                      <div class="col-md-4">
                         <input type="email" class="form-control" id="email" name="email" placeholder="Email" value="${user.userEmail}"/>
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="password" class="col-md-2 control-label">Password</label>
                      <div class="col-md-4">
                        <input type="password" class="form-control" id="password" name="password" placeholder="Password" value="${user.password}"/>
                      </div>
                    </div>                    
                    <div class="form-group">
                      <div class="col-md-offset-2 col-md-4">
                        <div class="checkbox">
                          <label>
                            <input type="checkbox" name="agree" value="agree"> Accept Terms & Conditions
                          </label>
                        </div>
                      </div>
                    </div>
                    <hr />
                    <div class="form-group">
                      <div class="col-md-offset-2 col-md-10">
                        <button type="submit" class="btn btn-danger" >Save Changes</button>
                        <button type="reset" class="btn btn-default">Reset</button>
                      </div>
                    </div>
                  </form> 
                   
               </div>
            </div>
            
            <div class="sep-bor"></div>
         </div>
      </div>

<%@include file="footer.jsp"%>