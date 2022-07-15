/**
 * 
 */

var app = angular.module("CustomerManagement", []);

// Controller Part
app.controller("CustomerController", function($scope, $http,$window) {

	
	$scope.customers = [];
    $scope.customerForm = {
        id: -1,      
        fullname: "",
        address: "",
        city: "",
        country: "",
        pincode: "",
        mobile: "",
    };

    // Now load the data from server
    _refreshData();
    
    $scope.showForm = function(){
    	
    }

    // HTTP POST/PUT methods for add/edit employee  
    // Call: http://localhost:8080/employee
    $scope.submitCustomer = function() {

        var method = "";
        var url = "";

        if ($scope.customerForm.id ==-1) {
        	method = "POST";
            url = '/addcustomer';
        }else{
        	method = "POST";
            url = '/updatecustomer';
        }
            
       

        $http({
            method: method,
            url: url,
            data: angular.toJson($scope.customerForm),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };

    $scope.createCustomer = function() {
        _clearFormData();
    }

    // HTTP DELETE- delete employee by Id
    // Call: http://localhost:8080/employee/{empId}
    $scope.deleteCustomer = function(customer) {
        $http({
            method: 'GET',
            url: '/deletecustomer/' + customer.id
        }).then(_successdelete, _error);
    };

    // In case of edit
    $scope.editCustomer = function(customer) {
        $scope.customerForm.id = customer.id;
        $scope.customerForm.fullname = customer.fullname;
        $scope.customerForm.address = customer.address;
        $scope.customerForm.city = customer.city;
        $scope.customerForm.country = customer.country;
        $scope.customerForm.pincode = customer.pincode;
        $scope.customerForm.mobile = customer.mobile;
    };

    // Private Method  
    // HTTP GET- get all employees collection
    // Call: http://localhost:8080/employees
    function _refreshData() {
        $http({
            method: 'GET',
            url: '/listcustomer'
        }).then(
            function(res) { // success
                $scope.customers = res.data;
                angular.element(document).ready(function() {  
                    dTable = $('#example')  
                    dTable.DataTable();  
                });
            },
            function(res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }

    function _successdelete(res) {
        _refreshData();
        console.log(res);
        if(res.data==true){
      	  alert("Data delete successfully");
      	  _refreshData();
        }else{
      	  alert("Data Not deleted Trya Again");
        }
        
      }
    
    
    function _success(res) {
      _refreshData();
      console.log(res);
      if(res.data==true){
    	  alert("Data Save successfully");
    	  _refreshData();
      }else{
    	  alert("Data Not Save Trya Again");
      }
      
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
    	$scope.customerForm.id = -1;
        $scope.customerForm.fullname = "";
        $scope.customerForm.address = "";
        $scope.customerForm.city = "";
        $scope.customerForm.country = "";
        $scope.customerForm.pincode = "";
        $scope.customerForm.mobile = "";
    };
});