/**
 * 
 */

var app = angular.module("SignupManagement", []);

// Controller Part
app.controller("SignupController", function($scope, $http,$window) {

	
   
    $scope.signupForm = {
        username: "",
        password: "",
        mobile:"",
        fullname:""
    };

    // Now load the data from server
  //  _refreshEmployeeData();

    // HTTP POST/PUT methods for add/edit employee  
    // Call: http://localhost:8080/employee
    $scope.submitSignup = function() {

        var method = "";
        var url = "";

        
            method = "POST";
            url = '/adduser';
       

        $http({
            method: method,
            url: url,
            data: angular.toJson($scope.signupForm),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };


    function _success(res) {
       // _refreshEmployeeData();
      console.log(res);
       if(res.data==true){
    	  alert("User Created Successfull");
    	  _clearFormData();
    	  window.location.href = '/';
       }else{
    	   _clearFormData();
       }
        //
    }

    function _error(res) {
        var data = res.data;
        var status = res.status;
        var header = res.header;
        var config = res.config;
        alert("Error: " + status + ":" + data);
    }

    // Clear the form
    function _clearFormData() {
        $scope.signupForm.username = "";
        $scope.signupForm.password = "";
        $scope.signupForm.fullname = "";
        	 $scope.signupForm.mobile = "";
    };
});