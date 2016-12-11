package com.project.petstore.service;

import com.project.petstore.data.CategoryModel;
import com.project.petstore.data.PetModel;
import com.project.petstore.data.TagModel;

import java.util.List;

/**
 * Created by sriramvcs on 2016-12-11.
 */
public interface PetStoreService {

    List<CategoryModel> getAllCategories();

    List<TagModel> getAllTags();

    List<PetModel> getAllPets();

    void addPet(PetModel pet);

    PetModel getPetById(Long id);

    void deletePet(Long id);
}
