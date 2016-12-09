package com.project.petstore.controller;

import com.project.petstore.dao.PetRepository;
import com.project.petstore.entity.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by sriramvcs on 2016-12-08.
 */
@RestController
public class PetRestController {

    @Autowired
    private PetRepository petRepository;

    @RequestMapping(path="/pet/", method= RequestMethod.POST)
    public void createPet(@RequestBody Pet pet) {
        petRepository.save(pet);
    }

    @RequestMapping(path="/pet/{petId}", method= RequestMethod.GET)
    public Pet getPet(@PathVariable Long id) {
        return petRepository.findOne(id);
    }

    @RequestMapping(path="/pet/{petId}", method= RequestMethod.DELETE)
    public void deletePet(@PathVariable Long id) {
        petRepository.delete(id);
    }
}
