package com.project.petstore.unittests;

import com.project.petstore.dao.PetRepository;
import com.project.petstore.entity.Category;
import com.project.petstore.entity.Pet;
import com.project.petstore.service.PetStoreService;
import com.project.petstore.service.PetStoreServiceImpl;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by sriramvcs on 2016-12-04.
 */
@RunWith(MockitoJUnitRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PetServiceTests {

    @Mock
    private PetRepository petRepository;

    @InjectMocks
    private PetStoreServiceImpl petService;

    @Test
    public void test1AddPet() {

    }

    @Test
    public void test2GetPet(Long id) {

    }

    @Test
    public void test3GetAllPets() {

    }

    @Test
    public void test4DeletePet(Long id) {

    }


}
