package com.project.petstore.data;

import com.project.petstore.entity.Category;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by sriramvcs on 2016-12-11.
 */
@Data
public class CategoryModel {

    private Long id;
    private String name;

    public CategoryModel(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
