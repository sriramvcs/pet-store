package com.project.petstore.unittests;

import com.project.petstore.dao.PetRepository;
import com.project.petstore.data.CategoryModel;
import com.project.petstore.data.PetModel;
import com.project.petstore.entity.Category;
import com.project.petstore.entity.Pet;
import com.project.petstore.entity.Tag;
import com.project.petstore.enums.PetStatus;
import com.project.petstore.service.PetStoreService;
import com.project.petstore.service.PetStoreServiceImpl;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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
    public void test1_Add_Get_Pet() {


        PetModel pModel = new PetModel();
        pModel.setName("cookie");
        pModel.setPetId(1000l);
        pModel.setStatus(PetStatus.Available);
        pModel.setCategory(new CategoryModel(1l,"Dog"));

        petService.addPet(pModel);

        Mockito.when(petRepository.findByPetId(1000l)).thenReturn(buildPet(1000l));
        PetModel res = petService.getPetById(1000l);

        Assert.assertEquals(res.getName(),"cookie");
        Assert.assertEquals(res.getPetId(),(Long)1000l);
        Assert.assertEquals(res.getStatus(),PetStatus.Available);
        Assert.assertEquals(res.getPhotoUrls(),"1,2,3,4");
        Assert.assertEquals(res.getTags().size(),1);
        Assert.assertEquals(res.getTags().get(0).getName(),"Clean");
        Assert.assertEquals(res.getCategory().getName(),"Dog");
    }


    @Test
    public void test2_Get_All_Pets() {
        List<Pet> petEntityList = new ArrayList<>();
        petEntityList.add(buildPet(1000l));
        petEntityList.add(buildPet(1001l));
        Mockito.when(petRepository.findAll()).thenReturn(petEntityList);

        List<PetModel> resultsList = petService.getAllPets();

        Assert.assertEquals(resultsList.size(),2);
        Assert.assertEquals(resultsList.get(0).getPetId(),(Long)1000l);
        Assert.assertEquals(resultsList.get(1).getPetId(),(Long)1001l);
        resultsList.forEach(res->{
            Assert.assertEquals(res.getName(),"cookie");
            Assert.assertEquals(res.getStatus(),PetStatus.Available);
            Assert.assertEquals(res.getPhotoUrls(),"1,2,3,4");
            Assert.assertEquals(res.getTags().size(),1);
            Assert.assertEquals(res.getTags().get(0).getName(),"Clean");
            Assert.assertEquals(res.getCategory().getName(),"Dog");
        });
    }


    private Pet buildPet(Long petId) {
        Pet p = new Pet();
        p.setName("cookie");
        p.setPetId(petId);
        p.setStatus(PetStatus.Available);

        Category cat = new Category();
        cat.setId(1l);
        cat.setName("Dog");
        p.setCategory(cat);

        Tag tag1 = new Tag();
        tag1.setId(1l);
        tag1.setName("Clean");
        HashSet<Tag> tags = new HashSet<>();
        tags.add(tag1);
        p.setTags(tags);

        p.setPhotoUrls("1,2,3,4");
        return p;
    }

}
