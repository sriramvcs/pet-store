package com.project.petstore.dao;

import com.project.petstore.entity.Pet;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by sriramvcs on 2016-12-04.
 */
@Repository
public interface PetRepository extends CrudRepository<Pet,Long>{
    public Pet findByName(String name);
    public Pet findByPetId(Long id);

    @Modifying
    @Transactional
    @Query("delete from Pet t where t.petId = ?1")
    public void deleteByPetId(Long id);
}
