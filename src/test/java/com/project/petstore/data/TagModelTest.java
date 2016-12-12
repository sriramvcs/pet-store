package com.project.petstore.data;

import lombok.Data;

/**
 * Created by sriramvcs on 2016-12-11.
 */
@Data
public class TagModelTest {

    private Long id;
    private String name;

    public TagModelTest(long l, String name) {
        this.id = l;
        this.name = name;
    }
}
