package com.project.petstore.dao;

import com.project.petstore.entity.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sriramvcs on 2016-12-04.
 */
@Repository
public interface PetRepository extends CrudRepository<Pet,Long>{
    public Pet findByName(String name);
}
