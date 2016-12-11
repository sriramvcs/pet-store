'use strict';
angular.module('petApp',[])
.controller('petAppController',['$scope','$http',function($scope,$http){
    var self = this;
    self.pet={id:null,name:'',selectedCategory:{},selectedTags:[],status:''};
    self.categories = [{id:1,name:'Dog'},{id:2,name:'Cat'},{id:3,name:'Hamster'},{id:1,name:'Bird'}];
    self.tags = [{id:1,name:'expensive'},{id:2,name:'dirty'},{id:3,name:'stubborn'}];
    self.statuses = ['Available','Not Available'];
    self.petList = [];
    self.submit = function() {
        console.log('Form submitted to the server',self.pet);
    };

    self.reset = function(){
        self.pet={id:null,name:'',selectedCategory:{},selectedTags:[],status:''};
        $scope.petForm.$setPristine(); //reset Form
    }

    self.getAllPets = function() {
        $http({
            method:'GET',
            url : '/pets'
        }).then(function(response){
            self.petList = response.data;
            console.log('loaded all pets in the table ',response);
        }, function(response){
            console.log('Something broke',response);
        });
    }

    self.getAllCategories = function() {
        $http({
            method:'GET',
            url : '/pets/categories'
        }).then(function(response){
            self.categories = response.data;
            console.log('loaded all categories ',response);
        }, function(response){
            console.log('Something broke',response);
        });
    }

    self.getAllTags = function() {
        $http({
            method:'GET',
            url : '/pets/tags'
        }).then(function(response){
            self.tags = response.data;
            console.log('loaded all tags ',response);
        }, function(response){
            console.log('Something broke',response);
        });
    }

    function init() {
        self.getAllPets();
        self.getAllCategories();
        self.getAllTags();
    }
    init();
}]);