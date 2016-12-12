package com.project.petstore.data;

import lombok.Data;

/**
 * Created by sriramvcs on 2016-12-11.
 */
@Data
public class CategoryModelTest {
    private Long id;
    private String name;

    public CategoryModelTest(long l, String name) {
        this.id = l;
        this.name = name;
    }
}
