/**
 * 
 */

var app = angular.module("AppointmentManagement", []);

// Controller Part
app.controller("AppointmentController", function($scope, $http,$window) {

	
	$scope.appointments = [];
    $scope.appointmentForm = {
        id: -1,
        fullname: "",
        subject: "",
        description: "",
        location: "",
        mobile: "",
        adate: "",
        starttime: "",
        endtime: "",
    };

    // Now load the data from server
    _refreshData();
    
    $scope.showForm = function(){
    	
    }

    // HTTP POST/PUT methods for add/edit employee  
    // Call: http://localhost:8080/employee
    $scope.submitAppointment = function() {

        var method = "";
        var url = "";

        if ($scope.appointmentForm.id ==-1) {
        	method = "POST";
            url = '/addappointment';
        }else{
        	method = "POST";
            url = '/updateappointment';
        }
            
       

        $http({
            method: method,
            url: url,
            data: angular.toJson($scope.appointmentForm),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };

    $scope.createAppointment = function() {
        _clearFormData();
    }

    // HTTP DELETE- delete employee by Id
    // Call: http://localhost:8080/employee/{empId}
    $scope.deleteAppointment = function(appointment) {
        $http({
            method: 'GET',
            url: '/deleteappointment/' + appointment.id
        }).then(_successdelete, _error);
    };

    // In case of edit
    $scope.editAppointment = function(appointment) {
        $scope.appointmentForm.id = appointment.id;
        $scope.appointmentForm.fullname = appointment.fullname;
        $scope.appointmentForm.subject = appointment.subject;
        $scope.appointmentForm.description = appointment.description;
        $scope.appointmentForm.location = appointment.location;
        $scope.appointmentForm.mobile = appointment.mobile;
        $scope.appointmentForm.adate = appointment.adate;
        $scope.appointmentForm.starttime = appointment.starttime;
        $scope.appointmentForm.endtime = appointment.endtime;
       
    };

    // Private Method  
    // HTTP GET- get all employees collection
    // Call: http://localhost:8080/employees
    function _refreshData() {
        $http({
            method: 'GET',
            url: '/listappointment'
        }).then(
            function(res) { // success
                $scope.appointments = res.data;
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
    	$scope.appointmentForm.id = -1;
    	$scope.appointmentForm.fullname = "";
        $scope.appointmentForm.subject =  "";
        $scope.appointmentForm.description =  "";
        $scope.appointmentForm.location = "";
        $scope.appointmentForm.mobile =  "";
        $scope.appointmentForm.adate =  "";
        $scope.appointmentForm.starttime =  "";
        $scope.appointmentForm.endtime =  "";
    };
});