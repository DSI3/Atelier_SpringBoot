var app=angular.module("MyCat",[]);
app.controller("CatController",function($scope,$http){
$scope.pagesproduits=null;
$scope.motCle="";
$scope.pageCourante=0;
$scope.charger=function(){
$http.get("/produitsParMC?mc="+$scope.motCle+"&page="+$scope.pageCourante).then(function(response){
$scope.pagesproduits=response.data;
$scope.pages=new Array(response.data.totalPages)

console.log($scope.motCle);
	console.log(response.data);
});
};
$scope.gotoPage=function(p){
	$scope.pageCourante=p;
	$scope.charger();
	};
});

