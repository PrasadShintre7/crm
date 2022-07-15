/**
 * 
 */

var app = angular.module("ReportManagement", []);

// Controller Part
app.controller("ReportController", function($scope, $http,$window) {

	
	$scope.reports = [];
    $scope.reportForm = {
        
        fromdate: "",
        todate: "",
    };

   
    $scope._refreshData=function() {
        $http({
            method: 'POST',
            url: '/reportappointment',
            data: angular.toJson($scope.reportForm),
        }).then(
            function(res) { // success
                $scope.reports = res.data;
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

  
});