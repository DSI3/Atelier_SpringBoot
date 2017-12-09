angular.module("catalogue",[])
.controller("Catcontroller",function($scope,$http,$location){
$scope.categories=[];
$scope.produits=[];
$scope.selectedCategorie=null;
$scope.pages=new Array();
$scope.pageCourante=0;
$scope.chargerCategories=function(){
$http.get("/allCat").then(function(response){
$scope.categories=response.data;
});
};
$scope.chargerProduits=function(){
	$http.get("/produitsParCat?page="+$scope.pageCourante+"&idCategorie	="+$scope.selectedCategorie).then(function(response){
	$scope.produits=response.data;
	$scope.pages=new Array(response.data.totalPages);
	});
	};
	$scope.chargerCategories();
	$scope.gotoURL=function(){
	$scope.pageCourante=0;
	$location.path("/"+$scope.selectedCategorie);
	};
	$scope.gotoPage=function(page){
	$scope.pageCourante=page;
	$location.path("/"+$scope.selectedCategorie+"/"+page);
	};
	$scope.$watch(
			function(){return $location.path();},
			function(newPath){
			//console.log(newPath);
			var tabPath=newPath.split("/");
			$scope.pageCourante=0;
			if(tabPath.length==2){
			$scope.selectedCategorie=tabPath[1];
			$scope.chargerProduits();
			}
			else if(tabPath.length==3){
			$scope.selectedCategorie=tabPath[1];
			$scope.pageCourante=tabPath[2];
			$scope.chargerProduits();
			};
			});
			});