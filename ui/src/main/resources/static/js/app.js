var fruitManagerModule = angular.module('fruitManagerApp', ['ngAnimate']);

fruitManagerModule.controller('fruitManagerController', function ($scope,$http) {
	
	var urlBase="";
	
	$http.defaults.headers.post["Content-Type"] = "application/json";

    function findAllFruits() {
        //get all fruits and display initially
        $http.get(urlBase + '/fruits/').
            success(function (data) {
                if (data._embedded != undefined) {
                    $scope.fruits = data._embedded.fruits;
                } else {
                    $scope.fruits = [];
                }
                // for (var i = 0; i < $scope.fruits.length; i++) {
                //         $scope.selection.push($scope.fruits[i].fruitId);
                // }
                //$scope.fruitName="";
                //$scope.fruitDescription="";

            });
    }

    findAllFruits();

	//add a new fruit
	$scope.addfruit = function addFruit() {
		if($scope.fruitName=="" || $scope.fruitDescription=="" ){
			alert("Insufficient Data! Please provide values for fruit name, description");
		}
		else{
		 $http.post(urlBase + '/fruits', {
             fruitName: $scope.fruitName,
             fruitDescription: $scope.fruitDescription
         }).
		  success(function(data, status, headers) {
			 alert("Fruit added");
             var newFruitUri = headers()["location"];
             console.log("Might be good to GET " + newFruitUri + " and append the fruit.");
             // Refetching EVERYTHING every time can get expensive over time
             // Better solution would be to $http.get(headers()["location"]) and add it to the list
             findAllFruits();
		    });
		}
	};
		
	
	
});

//Angularjs Directive for confirm dialog box
fruitManagerModule.directive('ngConfirmClick', [
	function(){
         return {
             link: function (scope, element, attr) {
                 var msg = attr.ngConfirmClick || "Are you sure?";
                 var clickAction = attr.confirmedClick;
                 element.bind('click',function (event) {
                     if ( window.confirm(msg) ) {
                         scope.$eval(clickAction);
                     }
                 });
             }
         };
 }]);