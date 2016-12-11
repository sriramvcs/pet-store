package com.project.petstore.controller;

import com.project.petstore.data.CategoryModel;
import com.project.petstore.data.PetModel;
import com.project.petstore.data.TagModel;
import com.project.petstore.entity.Category;
import com.project.petstore.entity.Pet;
import com.project.petstore.entity.Tag;
import com.project.petstore.service.PetStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sriramvcs on 2016-12-08.
 */
@RestController
public class PetRestController {

    @Autowired
    private PetStoreService petStoreService;

    @RequestMapping(path="/pet", method= RequestMethod.POST)
    public void createPet(@RequestBody PetModel pet) {
        petStoreService.addPet(pet);
    }

    @RequestMapping(path="/pet/{petId}", method= RequestMethod.GET)
    public PetModel getPet(@PathVariable Long id) {

        return petStoreService.getPetById(id);
    }

    @RequestMapping(path="/pets", method= RequestMethod.GET)
    public List<PetModel> getAllPets() {
        return petStoreService.getAllPets();
    }

    @RequestMapping(path="/pet/{petId}", method= RequestMethod.DELETE)
    public void deletePet(@PathVariable Long id) {
        petStoreService.deletePet(id);
    }

    @RequestMapping(path="/pets/categories", method= RequestMethod.GET)
    public List<CategoryModel> getCategories() {
        return petStoreService.getAllCategories();
    }

    @RequestMapping(path="/pets/tags", method= RequestMethod.GET)
    public List<TagModel> getTags() {
        return petStoreService.getAllTags();
    }
}
