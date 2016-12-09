package com.project.petstore.integrationtests;

import com.project.petstore.dao.CategoryRepository;
import com.project.petstore.dao.PetRepository;
import com.project.petstore.dao.TagRepository;
import com.project.petstore.entity.Category;
import com.project.petstore.entity.Pet;
import com.project.petstore.entity.PhotoUrl;
import com.project.petstore.entity.Tag;
import com.project.petstore.enums.PetStatus;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;

/**
 * Created by sriramvcs on 2016-12-08.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class PetDaotest {

    @Autowired
    private PetRepository petRepository;
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void test1InsertPetEntity() {
        Pet p = new Pet();
        HashSet<Tag> tags = new HashSet<Tag>();
        p.setName("cookie");
        HashSet<PhotoUrl> urls = new HashSet<PhotoUrl>();
        urls.add(new PhotoUrl("1"));
        urls.add(new PhotoUrl("2"));
        p.setPhotoUrls(urls);
        p.setStatus(PetStatus.Available);
        Category cat = categoryRepository.findOne(1l);
        tags.add(tagRepository.findOne(1l));
        p.setCategory(cat);
        p.setTags(tags);
        petRepository.save(p);

        Assert.assertEquals(petRepository.findByName("cookie").getName(),"cookie");
    }

    @Test
    public void test2DeletePetEntity() {
        Pet p = petRepository.findByName("cookie");
        petRepository.delete(p.getId());
        Assert.assertEquals(petRepository.findByName("cookie"),null);
    }
}
