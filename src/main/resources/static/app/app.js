'use strict';
angular.module('petApp',[])
.controller('petAppController',['$scope','$http',function($scope,$http){
    var self = this;
    self.pet={id:null,petId:null,name:'',category:{},tags:[],status:''};
    self.categories = [{id:1,name:'Dog'},{id:2,name:'Cat'},{id:3,name:'Hamster'},{id:1,name:'Bird'}];
    self.tags = [{id:1,name:'expensive'},{id:2,name:'dirty'},{id:3,name:'stubborn'}];
    self.statuses = ['Available','Unavailable'];
    self.petList = [];

    self.submit = function() {
        $http({
           method:'POST',
            url:'/pet',
            data:self.pet
        }).then(function(response){
            // on update bootstrap alert
            // get all the users
            console.log('success',response);
            self.getAllPets();
        }, function(response){
            // failure
            console.log('failure',response);
        });
    };

    self.deletePet = function(petId) {
        $http({
            method:'DELETE',
            url:'/pet/'+petId
        }).then(function(response){
            console.log('success',response);
            self.getAllPets();
        },function(response){
            console.log('failure',response);
        });
    }

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
            console.log('loaded all pets in the table ',self.petList);
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
            console.log('loaded all categories ',self.categories);
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
            console.log('loaded all tags ',self.tags);
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