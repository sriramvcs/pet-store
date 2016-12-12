package com.project.petstore.service;

import com.project.petstore.dao.CategoryRepository;
import com.project.petstore.dao.PetRepository;
import com.project.petstore.dao.TagRepository;
import com.project.petstore.data.CategoryModel;
import com.project.petstore.data.PetModel;
import com.project.petstore.data.TagModel;
import com.project.petstore.entity.Category;
import com.project.petstore.entity.Pet;
import com.project.petstore.entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
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
            if(item.getTags()!=null || (!item.getTags().isEmpty())){
                obj.setTags(buildTagModelList(item.getTags()));
            }
            if(item.getCategory()!=null) {
                obj.setCategory(new CategoryModel(item.getCategory().getId(),item.getCategory().getName()));
            }
            obj.setPhotoUrls(item.getPhotoUrls());
            obj.setPetId(item.getPetId());
            resultList.add(obj);

        });
        return resultList;
    }

    @Override
    public void addPet(PetModel pet) {
        petRepository.save(buildPetEntity(pet));
    }

    @Override
    public PetModel getPetById(Long petId) {
        Pet entity = petRepository.findByPetId(petId);
        return new PetModel(){{
            this.setPetId(entity.getPetId());
            this.setId(entity.getId());
            this.setName(entity.getName());
            this.setPhotoUrls(entity.getPhotoUrls());
            this.setCategory(new CategoryModel(entity.getCategory().getId(),entity.getCategory().getName()));
            List<TagModel> tags = new ArrayList<>();
            entity.getTags().forEach(item->{
                tags.add(new TagModel(item.getId(),item.getName()));
            });
            this.setTags(tags);
            this.setStatus(entity.getStatus());
        }};
    }

    @Override
    public void deleteByPetId(Long id) {
        petRepository.deleteByPetId(id);
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

    private HashSet<Tag> buildTagEntityList(List<TagModel> tags) {
        HashSet<Tag> resultList = new HashSet<>();
        tags.forEach(item->{
            resultList.add(new Tag(){{
                this.setName(item.getName());
                this.setId(item.getId());
            }});
        });
        return resultList;
    }
    private Pet buildPetEntity(PetModel model) {
        Pet entity = new Pet();
        entity.setName(model.getName());
        entity.setStatus(model.getStatus());
        entity.setPhotoUrls(model.getPhotoUrls());
        entity.setPetId(model.getPetId());
        if(model.getCategory()!=null) {
            entity.setCategory(new Category(){{
                this.setName(model.getCategory().getName());
                this.setId(model.getCategory().getId());
            }});
        }
        if(model.getTags()!=null || (!model.getTags().isEmpty())) {
            entity.setTags(buildTagEntityList(model.getTags()));
        }
        return entity;

    }
}
