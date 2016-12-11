package com.project.petstore.service;

import com.project.petstore.dao.CategoryRepository;
import com.project.petstore.dao.PetRepository;
import com.project.petstore.dao.TagRepository;
import com.project.petstore.data.CategoryModel;
import com.project.petstore.data.PetModel;
import com.project.petstore.data.TagModel;
import com.project.petstore.entity.Category;
import com.project.petstore.entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sriramvcs on 2016-12-11.
 */
@Service
public class PetStoreServiceImpl implements PetStoreService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private PetRepository petRepository;

    @Override
    public List<CategoryModel> getAllCategories() {
        return buildCategoryModelList(categoryRepository.findAll());
    }

    @Override
    public  List<TagModel> getAllTags() {
        return buildTagModelList(tagRepository.findAll());
    }

    @Override
    public List<PetModel> getAllPets() {
        List<PetModel> resultList = new ArrayList<>();
        petRepository.findAll().forEach(item->{
            PetModel obj = new PetModel();
            obj.setId(item.getId());
            obj.setName(item.getName());
            obj.setStatus(item.getStatus());
            obj.setTags(buildTagModelList(item.getTags()));
            obj.setCategory(new CategoryModel(item.getCategory().getId(),item.getCategory().getName()));
            // add photo URLS
            resultList.add(obj);

        });
        return resultList;
    }

    @Override
    public void addPet(PetModel pet) {

    }

    @Override
    public PetModel getPetById(Long id) {
        return null;
    }

    @Override
    public void deletePet(Long id) {

    }



    // factory methods

    private List<TagModel> buildTagModelList(Iterable<Tag> tags) {
        List<TagModel> result = new ArrayList<>();
        tags.forEach(item->{
            result.add(new TagModel(item.getId(),item.getName()));
        });
        return  result;
    }

    private List<CategoryModel> buildCategoryModelList(Iterable<Category> categories) {
        List<CategoryModel> result = new ArrayList<>();
        categories.forEach(item->{
            result.add(new CategoryModel(item.getId(),item.getName()));
        });
        return  result;
    }
}
