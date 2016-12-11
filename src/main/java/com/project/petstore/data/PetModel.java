package com.project.petstore.data;

import com.project.petstore.entity.Category;
import com.project.petstore.enums.PetStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sriramvcs on 2016-12-11.
 */
@Getter
@Setter
public class PetModel {

    private Long id;
    private String name;
    private CategoryModel category;
    private List<TagModel> tags = new ArrayList<>();
    private PetStatus status;
    // TODO add photo URLS
}
