/**
 * 
 */

var app = angular.module("LoginManagement", []); //defines application

// Controller Part
app.controller("LoginController", function($scope, $http,$window) {

	
   
    $scope.loginForm = {
        username: "",
        password: ""
    };

    // Now load the data from server
  //  _refreshEmployeeData();

    // HTTP POST/PUT methods for add/edit employee  
    // Call: http://localhost:8080/employee
    $scope.submitLogin = function() {

        var method = "";
        var url = "";

        
            method = "POST";
            url = '/login';
       

        $http({
            method: method,
            url: url,
            data: angular.toJson($scope.loginForm),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };

//    $scope.createEmployee = function() {
//        _clearFormData();
//    }

    // HTTP DELETE- delete employee by Id
    // Call: http://localhost:8080/employee/{empId}
//    $scope.deleteEmployee = function(employee) {
//        $http({
//            method: 'DELETE',
//            url: '/employee/' + employee.empId
//        }).then(_success, _error);
//    };

    // In case of edit
//    $scope.editEmployee = function(employee) {
//        $scope.employeeForm.empId = employee.empId;
//        $scope.employeeForm.empNo = employee.empNo;
//        $scope.employeeForm.empName = employee.empName;
//    };

    // Private Method  
    // HTTP GET- get all employees collection
    // Call: http://localhost:8080/employees
//    function _refreshEmployeeData() {
//        $http({
//            method: 'GET',
//            url: '/employees'
//        }).then(
//            function(res) { // success
//                $scope.employees = res.data;
//            },
//            function(res) { // error
//                console.log("Error: " + res.status + " : " + res.data);
//            }
//        );
//    }

    function _success(res) {
       // _refreshEmployeeData();
      console.log(res);
       if(res.data==true){
    	  
    	   window.location.href = '/home';
       }else{
    	   alert("invalid User");
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
        $scope.loginForm.username = "";
        $scope.loginForm.password = ""
    };
});